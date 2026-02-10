public class QuickSort {

    // Haupt-QuickSort Methode
    public static void quickSort(int[] array, int links, int rechts) {
        if (links < rechts) {
            int pivotIndex = partition(array, links, rechts);
            quickSort(array, links, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, rechts);
        }
    }

    // Partition Methode
    public static int partition(int[] array, int links, int rechts) {
        int pivot = array[rechts];
        int i = links - 1;

        for (int j = links; j < rechts; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[rechts];
        array[rechts] = temp;

        return i + 1;
    }
}