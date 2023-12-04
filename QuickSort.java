import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // Example usage
        int[] array = {8, 3, 1, 5, 2, 6, 4, 7};
        
        System.out.println("Original array: " + Arrays.toString(array));
        
        quickSort(array, 0, array.length - 1);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array, and get the index of the pivot element
            int pivotIndex = partition(array, low, high);

            // Recursively sort the two halves
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = array[high];

        // Index of the smaller element
        int i = low - 1;

        // Traverse the array and move elements smaller than the pivot to the left
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Move the pivot element to its correct position
        swap(array, i + 1, high);

        // Return the index of the pivot element
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
