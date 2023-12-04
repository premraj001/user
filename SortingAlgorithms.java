import java.util.Arrays;

public class SortingAlgorithms {
    // Quick sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        // Recursive quick sort
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            System.out.println(Arrays.toString(arr));
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function for quick sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i + 1] and arr[high] (move pivot to its correct position)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Merge sort implementation
    public static void mergeSort(int[] arr, int left, int right) {
        // Recursive merge sort
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    // Merge function for merge sort
    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArr, if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArr, if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

// Main method for testing the sorting algorithms
public static void main(String[] args) {
    // Array to be sorted
    int[] numbers = {6, 3, 8, 1, 9, 2};

    System.out.println("Quick Sort:");
    int[] quickSortArray = Arrays.copyOf(numbers, numbers.length);
    quickSort(quickSortArray, 0, quickSortArray.length - 1);

    System.out.println("\nMerge Sort:");
    int[] mergeSortArray = Arrays.copyOf(numbers, numbers.length);
    mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);

    // Print the sorted array after merge sort
    System.out.println(Arrays.toString(mergeSortArray));
}

}
