import java.util.Scanner;

// Class to represent individual non-zero elements in a sparse matrix
class Element {
    int row, col, value;

    public Element(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

// Class to represent a sparse matrix
class SparseMatrix {
    int rows, cols, numElements;
    Element[] elements;

    public SparseMatrix(int rows, int cols, int numElements) {
        this.rows = rows;
        this.cols = cols;
        this.numElements = numElements;
        this.elements = new Element[numElements];
    }

    // Method to add a non-zero element to the sparse matrix
    public void addElement(int index, int row, int col, int value) {
        if (index >= 0 && index < numElements) {
            elements[index] = new Element(row, col, value);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to perform addition of two sparse matrices
    public static SparseMatrix addMatrices(SparseMatrix matrix1, SparseMatrix matrix2) {
    if (matrix1.rows != matrix2.rows || matrix1.cols != matrix2.cols) {
        System.out.println("Matrices cannot be added. Dimensions mismatch.");
        return null;
    }

    SparseMatrix resultMatrix = new SparseMatrix(matrix1.rows, matrix1.cols, matrix1.numElements + matrix2.numElements);

    int index1 = 0, index2 = 0, indexResult = 0;

    while (index1 < matrix1.numElements && index2 < matrix2.numElements) {
        Element element1 = matrix1.elements[index1];
        Element element2 = matrix2.elements[index2];

        if (element1.row < element2.row || (element1.row == element2.row && element1.col < element2.col)) {
            // Copy element from matrix1
            resultMatrix.addElement(indexResult++, element1.row, element1.col, element1.value);
            index1++;
        } else if (element1.row > element2.row || (element1.row == element2.row && element1.col > element2.col)) {
            // Copy element from matrix2
            resultMatrix.addElement(indexResult++, element2.row, element2.col, element2.value);
            index2++;
        } else {
            // Add elements from both matrices
            resultMatrix.addElement(indexResult++, element1.row, element1.col, element1.value + element2.value);
            index1++;
            index2++;
        }
    }

    // Copy remaining elements from matrix1, if any
    while (index1 < matrix1.numElements) {
        Element element1 = matrix1.elements[index1];
        resultMatrix.addElement(indexResult++, element1.row, element1.col, element1.value);
        index1++;
    }

    // Copy remaining elements from matrix2, if any
    while (index2 < matrix2.numElements) {
        Element element2 = matrix2.elements[index2];
        resultMatrix.addElement(indexResult++, element2.row, element2.col, element2.value);
        index2++;
    }

    return resultMatrix;
}

    // Method to display the sparse matrix as a conventional matrix
    public void display() {
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < numElements && elements[index].row == i && elements[index].col == j) {
                    System.out.print(elements[index++].value + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}

// Main class for the program
public class SparseMatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first matrix
        System.out.print("Enter the number of rows in the matrix: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns in the matrix: ");
        int cols = scanner.nextInt();

        System.out.print("Enter the number of non-zero elements in the matrix: ");
        int numElements = scanner.nextInt();

        SparseMatrix matrix1 = new SparseMatrix(rows, cols, numElements);

        System.out.println("Enter the non-zero elements of the matrix1:");
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter row, column, and value (space-separated) for element " + (i + 1) + ": ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int value = scanner.nextInt();
            matrix1.addElement(i, row, col, value);
        }

        // Display the conventional representation of matrix1
        System.out.println("Matrix1 (conventional):");
        matrix1.display();

        // Input for the second matrix
        System.out.println("\nEnter the number of non-zero elements in the matrix2:");
        numElements = scanner.nextInt();

        SparseMatrix matrix2 = new SparseMatrix(rows, cols, numElements);

        System.out.println("Enter the non-zero elements of the matrix2:");
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter row, column, and value (space-separated) for element " + (i + 1) + ": ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int value = scanner.nextInt();
            matrix2.addElement(i, row, col, value);
        }

        // Display the conventional representation of matrix2
        System.out.println("Matrix2 (conventional):");
        matrix2.display();

        // Perform addition of the two matrices and display the result
        SparseMatrix sumMatrix = SparseMatrix.addMatrices(matrix1, matrix2);

        if (sumMatrix != null) {
            System.out.println("\nSum of Matrix1 and Matrix2 (conventional):");
            sumMatrix.display();
        }
    }
}
