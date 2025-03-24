# Information Retrieval System

This project is a simple implementation of an Information Retrieval (IR) system that allows searching through a set of documents. It uses **Boolean Search** and **Probabilistic Models** to retrieve relevant documents based on user input queries. The system also calculates evaluation metrics such as **Precision**, **Recall**, **F-measure**, and **Rank Power** to assess the performance of the search.

## Features
- **Boolean Search**: Allows searching with logical operations like `AND`, `OR`, `NOT` between keywords.
- **Probabilistic Model**: Calculates word occurrence probabilities in documents.
- **Precision**: Measures the proportion of relevant documents retrieved out of all retrieved documents.
- **Recall**: Measures the proportion of relevant documents retrieved out of all relevant documents.
- **F-measure**: Harmonic mean of precision and recall.
- **Rank Power**: Measures the strength of the rank based on retrieval accuracy.

## Usage
1. Prepare a set of documents (text files) to be used for the search.
2. Input your search query in the system.
3. Choose between **Boolean Search** and **Probabilistic Model** for querying.
4. The system will display the **Precision**, **Recall**, **F-measure**, and **Rank Power** based on your search query.

## How to Run the Program
1. Prepare text files for the documents (e.g., `document_1.txt`, `document_2.txt`, ...).
2. Compile and run the Java program.
3. Enter the queries in the required format (e.g., `A AND B`, `A OR B`, etc.).
4. The search results will be displayed along with the evaluation metrics: Precision, Recall, F-measure, and Rank Power.

## Example Queries
- **Boolean Search**:
  If you input the query:
The program will retrieve documents that contain both "A" and "B".

- **Probabilistic Search**:
The system will calculate the probability of relevance of the query terms and retrieve documents based on that probability.

## Requirements
- **Java 8 or higher**.

## Running Instructions
1. Clone or download the project.
2. Compile the Java files:
3. Run the program:
4. Enter your search queries.

## Notes
- Ensure that your document files are stored in the correct folder for proper retrieval.
- The program expects simple text files for the documents.

## Author
- Your Name
