
package persicion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 20120
 */
public class Persicion {

    private static void readAndSplitDocument(String filename, List<String> list) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                for (int i = 0; i < parts.length; i++) {
                    list.add(parts[i]);
                }
            }
        }
    }

    private static void writeToDocument(String filename, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(content);
        writer.close();
        System.out.println("Content written to " + filename + " successfully.");
    }

    private static String arrayToString(String[] array) {
        StringBuilder result = new StringBuilder("[");
        for (String element : array) {
            result.append(element).append(", ");
        }
        if (array.length > 0) {
            result.setLength(result.length() - 2);
        }
        result.append("]");
        return result.toString();
    }

    // Method to calculate precision
    public static double calculatePrecision(List<String> releventDocuments) {
        int relevantAndRetrievedCount = 0;
        for (int i = 0; i < releventDocuments.size(); i++) {
            if (releventDocuments.get(i).equals("-")) {
                i++;
            } else {
                relevantAndRetrievedCount += 1;
            }
        }
        return (double) relevantAndRetrievedCount / 4;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
        public static boolean searchArray(List<String> arr, String target) {
        for (String num : arr) {
            if (num.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean booleanSearch(List<String> queryWords, List<String> documentWords, String DocumentName) {
//        String[] queryWords = query.split(" ");//make array [] split 
//        
//        String[] documentWords = document.split(" "); //make array [] split 
        boolean flag = false;
        for (int i = 0; i < queryWords.size(); i++) {
         
            if (queryWords.get(i).equals("or") || queryWords.get(i).equals("OR") || queryWords.get(i).equals("AND") ||
                    queryWords.get(i).equals("and")) {

                for (int j = 0; j < documentWords.size(); j++) {
                    
                    String q1 = queryWords.get(i-1);
                    String q2 = queryWords.get(i+1);
                    String d = documentWords.get(j);
                    if (queryWords.get(i).equals("or") ||queryWords.get(i).equals("OR")) {
                        if (d.equals(q2) || d.equals(q1)) {
                            
//                            System.out.println("Query found in " + DocumentName);
                            flag = true;
                            break;
                            
                         
                        }
                    } else if (queryWords.get(i).equals("AND") || queryWords.get(i).equals("and")) {
                        if (searchArray(documentWords, q1) && searchArray(documentWords, q2)) {
//                            System.out.println("Query found in " + DocumentName);
                            flag = true;
                            break;
                        } else {
                            break;
                        }
                    }
                }

            } else if (queryWords.get(i).equals("NOT") || queryWords.get(i).equals("not")) {
                String s = queryWords.get(i+1);
                
               if (!(documentWords).contains(s)) {
//                    System.out.println(DocumentName);
                    flag=true;
                    break;
                }
                break;
            }
        }
        if(flag){
        System.out.println(DocumentName);
        }
   return flag;
   
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //statistical model
        static void reverseArray(List<Double> intArray) 
    {    
           Collections.reverse(intArray);
           for(int j=0; j<intArray.size();j++){
               if(j==0 || j==1){
       System.out.println("the document with total probability equal: \n " + intArray.get(j) +" is the "+(j+1)+"st"); }
               else if(j==2 )System.out.println("the document with total probability equal: \n" + intArray.get(j) +" is the "+(j+1)+"nd");
               else System.out.println("the document with total probability equal: \n" + intArray.get(j) +" is the "+(j+1)+"th");
    }
    }
    public static int countStringAppearance(List<String> arr, String target) {
        int count = 0;
        for (String str : arr) {
            if (str.equals(target)) {
                count++;
            }
        }
        return count;
    }
   public static double statisticalSearch(List<String> queryWords, List<String> documentWords,String documentName) {
       System.out.println("------"+documentName+"--------");
//        String[] queryWords = query.split(" "); //make array [] split 
//        String[] documentWords = document.split(" "); //make array [] split 
        double c=0.0;
        double l=0;
        double propability=0.0;
        for (int i= 0 ; i <queryWords.size() ;i++) { 
            
                  c=countStringAppearance(documentWords, queryWords.get(i));
                  l=documentWords.size();
                  double propability1=c/l;
                  System.out.println( queryWords.get(i)+" "+l+" "+c+ " its propability is : "+propability1);
                  propability=propability1+propability;
//                 System.out.println(c +" "+documentWords[i]+" "+(documentWords.length+1)+ " "+queryWords[i]);
                 
             }
        System.out.println("propability total: "+propability);
     return propability;
   }
  //////////////////////////////////////////////////////////////////////////////////////////////////////
    //recall

    public static double calculateRecall(List<String> releventDocuments) {
        System.out.println("enter number of all relevent documents ");
        Scanner s = new Scanner(System.in);
        double no = s.nextDouble();
        int relevantAndRetrievedCount = 0;
        for (int i = 0; i < releventDocuments.size(); i++) {
            if (releventDocuments.get(i).equals("-")) {
                i++;
            } else {
                relevantAndRetrievedCount += 1;
            }
        }
        return (double) relevantAndRetrievedCount / no;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // Method to calculate F-measure
    public static double calculateFMeasure(double precision, double recall) {
        if (precision == 0 || recall == 0) {
            return 0;
        }
        return (2 * precision * recall) / (precision + recall);
    }

    public static String seeValidity2(List<String> query, List<String> doc, String docname) {
        boolean f = seeValidity(query, doc);
        if (f) {
            return docname;
        } else {
            return "-";
        }

    }

    public static int count(List<String> releventDocuments) {

        int count = 0;

        for (int i = 0; i < releventDocuments.size(); i++) {
            if (releventDocuments.get(i).equals("-")); else {
                count = count + (i + 1);
            }
        }
        return count;
    }

    public static double calculateRankPower(List<String> releventDocuments) {
        double c = count(releventDocuments);
        double relevantAndRetrievedCount = 0;
        for (int i = 0; i < releventDocuments.size(); i++) {
            if (releventDocuments.get(i).equals("-")) {
                i++;
            } else {
                relevantAndRetrievedCount += 1;
            }
        }
        return c / Math.pow(relevantAndRetrievedCount, 2);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////

    public static boolean seeValidity(List<String> query, List<String> doc) {
        boolean flag = false;
        for (int i = 0; i < query.size(); i++) {
            if (doc.contains(query.get(i))) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void print(List<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
        System.out.println();
    }
        public static List q(String arr) {
           String[] parts = arr.split(" ");
            List<String> list= new ArrayList<>();
                for (int i = 0; i < parts.length; i++) {
                    list.add(parts[i]);
                }
                return list;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        String q1=s.nextLine();
//        String[] q = q1.split(" ");
//        String[] q = {"A", "V"};
        String[] query = {"A", "AND", "B"};
        try {
            writeToDocument("document_1.txt", "A B C D T");
            writeToDocument("document_2.txt", "A B A D");
            writeToDocument("document_3.txt", "A B V");
            writeToDocument("document_4.txt", "A B A D V");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        try {
            readAndSplitDocument("document_1.txt", list1);
            readAndSplitDocument("document_2.txt", list2);
            readAndSplitDocument("document_3.txt", list3);
            readAndSplitDocument("document_4.txt", list4);
            print(list1);
            print(list2);
            print(list3);
            print(list4);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        /////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
System.out.println("--------------------precision , recall ,F-measure and rank power-----------------------------");
System.out.println("enter your query for p ,r f and rank:");
        String q1=s.nextLine();
        String[] q = q1.split(" ");
//        System.out.println(seeValidity2(Arrays.asList(q), list1, "doc1"));
//        System.out.println(seeValidity2(Arrays.asList(q), list2, "doc2"));
//        System.out.println(seeValidity2(Arrays.asList(q), list3, "doc3"));
//        System.out.println(seeValidity2(Arrays.asList(q), list4, "doc4"));
        List<String> relevantandRetrivedDocuments = Arrays.asList(seeValidity2(Arrays.asList(q), list1, "doc1"),
                seeValidity2(Arrays.asList(q), list2, " doc2"), seeValidity2(Arrays.asList(q), list3, " doc3"),
                seeValidity2(Arrays.asList(q), list4, " doc4"));
        double precision = calculatePrecision(relevantandRetrivedDocuments);
        double recall = calculateRecall(relevantandRetrivedDocuments);
        double fMeasure = calculateFMeasure(precision, recall);
        double rankPower = calculateRankPower(relevantandRetrivedDocuments);
        System.out.println("Precision: " + precision);
        System.out.println("Recall: " + recall);
        System.out.println("F-measure: " + fMeasure);
        System.out.println("Rank Power: " + rankPower);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //boolean search
         System.out.println("--------------------boolean search-----------------------------");
         System.out.println("enter your query for boolean search:");
        String q2=s.nextLine();
        List<String> query2 = new ArrayList<>();
        query2=q(q2);
//        query2.add("A");
//        query2.add("AND");
//        query2.add("D");
        System.out.println("here we go on the boolean search:");
        System.out.println("enter your query:");
        
        booleanSearch(query2, list1, "document one");
        booleanSearch(query2, list2, "document two");
        booleanSearch(query2, list3, "document three");
        booleanSearch(query2, list3, "document four");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //statistical model
         System.out.println("--------------------statistical model-----------------------------");
             String a=s.nextLine();
        List<String> query3 = new ArrayList<>();
        query3=q(a);
       double d1= statisticalSearch(query3,list1,"document1");
       double d2= statisticalSearch(query3,list2,"document2");  
       double d3= statisticalSearch(query3,list3,"document3");
//       double d4= statisticalSearch(query,list4,"document4");
//       double [] arr={d1,d2,d3};
        List<Double> arr = new ArrayList<>();
        arr.add(d1);
        arr.add(d2);
        arr.add(d3);
        
       Collections.sort(arr);
       System.out.println("________________________________________________________"); 
       System.out.println("Ranking documents"); 
       reverseArray(arr);
        
    }

}
