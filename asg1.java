import java.util.Arrays;

public class asg1 {
    public static void main(String[] args) {
        int[] set1 = {1, 2, 3, 4, 5};
        int[] set2 = {3, 4, 5, 6, 7};

        System.out.println("Set 1: " + Arrays.toString(set1));
        System.out.println("Set 2: " + Arrays.toString(set2));

        int[] unionResult = union(set1, set2);
        int[] intersectionResult = intersection(set1, set2);
        int[] differenceResult = difference(set1, set2);

        System.out.println("Union: " + Arrays.toString(unionResult));
        System.out.println("Intersection: " + Arrays.toString(intersectionResult));
        System.out.println("Difference (Set1 - Set2): " + Arrays.toString(differenceResult));
    }

    // Union of two sets
    static int[] union(int[] set1, int[] set2) {
        int[] result = new int[set1.length + set2.length];
        int i = 0;

        for (int key : set1) {
            result[i++] = key;
        }

        for (int key : set2) {
            if (!contains(result, key)) {
                result[i++] = key;
            }
        }

        return Arrays.copyOf(result, i);
    }

    // Intersection of two sets
    static int[] intersection(int[] set1, int[] set2) {
        int[] result = new int[Math.min(set1.length, set2.length)];
        int i = 0;

        for (int value : set1) {
            if (contains(set2, value)) {
                result[i++] = value;
            }
        }

        return Arrays.copyOf(result, i);
    }

    // Difference of two sets (Set1 - Set2)
    static int[] difference(int[] set1, int[] set2) {
        int[] result = new int[set1.length];
        int i = 0;

        for (int value : set1) {
            if (!contains(set2, value)) {
                result[i++] = value;
            }
        }

        return Arrays.copyOf(result, i);
    }

    // Check if an array contains a specific value
    static boolean contains(int[] array, int value) {
        for (int key : array) {
            if (key == value) {
                return true;
            }
        }
        return false;
    }
}
