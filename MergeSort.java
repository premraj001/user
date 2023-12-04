import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // Example usage
        int[] array = {8, 3, 1, 5, 2, 6, 4, 7};

        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int length = array.length;

        // Base case: if the array has 1 or 0 elements, it's already sorted
        if (length <= 1) {
            return;
        }

        // Calculate the middle index
        int mid = length / 2;

        // Create subarrays for the left and right halves
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, length);

        // Recursively sort the left and right subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted left and right subarrays
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;

        int i = 0, j = 0, k = 0;

        // Compare elements from the left and right subarrays and merge them
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements from the left subarray, if any
        while (i < leftLength) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from the right subarray, if any
        while (j < rightLength) {
            array[k++] = right[j++];
        }
    }
}
