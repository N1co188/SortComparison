public class InsertionSort {

    // Hauptmethode für Insertion Sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Verschiebe Elemente, die größer als key sind, nach rechts
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Hilfsmethode zum Ausgeben des Arrays
    public static void printArray(int[] array) {
        for (int zahl : array) {
            System.out.print(zahl + " ");
        }
        System.out.println();
    }

    // Main-Methode zum Testen
    public static void main(String[] args) {
        int[] zahlen = {38, 27, 43, 3, 9, 82, 10};

        System.out.print("Unsortiert: ");
        printArray(zahlen);

        insertionSort(zahlen);

        System.out.print("Sortiert:   ");
        printArray(zahlen);
    }
}
