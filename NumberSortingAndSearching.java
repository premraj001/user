import java.util.Arrays;

public class NumberSortingAndSearching {
    // Insertion sort in ascending order
    public static void insertionSortAscending(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Place key at its correct position
            arr[j + 1] = key;

            // Print the array after each pass
            System.out.println(Arrays.toString(arr));
        }
    }

    // Selection sort in descending order
    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // Find the index of the maximum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the maximum element with the first element in the unsorted part
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            // Print the array after each pass
            System.out.println(Arrays.toString(arr));
        }
    }

    // Binary search for a target element
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Element found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found
    }

    // Main method for testing sorting and searching algorithms
    public static void main(String[] args) {
        int[] numbers = {6, 3, 8, 1, 9, 2};

        // Insertion Sort (Ascending Order)
        System.out.println("Insertion Sort (Ascending Order):");
        int[] insertionSorted = Arrays.copyOf(numbers, numbers.length);
        insertionSortAscending(insertionSorted);

        // Selection Sort (Descending Order)
        System.out.println("\nSelection Sort (Descending Order):");
        int[] selectionSorted = Arrays.copyOf(numbers, numbers.length);
        selectionSortDescending(selectionSorted);

        // Binary Search
        int searchTarget = 8;
        System.out.println("\nBinary Search for '" + searchTarget + "':");
        int index = binarySearch(numbers, searchTarget);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}

