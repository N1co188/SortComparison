public class MergeSort {

    // Hauptmethode für Mergesort
    public static void mergeSort(int[] array, int links, int rechts) {
        if (links < rechts) {
            // Finde die Mitte
            int mitte = (links + rechts) / 2;

            // Sortiere linke und rechte Hälfte
            mergeSort(array, links, mitte);
            mergeSort(array, mitte + 1, rechts);

            // Füge die sortierten Hälften zusammen
            merge(array, links, mitte, rechts);
        }
    }

    // Methode zum Zusammenfügen zweier sortierter Hälften
    public static void merge(int[] array, int links, int mitte, int rechts) {
        // Größen der temporären Arrays
        int n1 = mitte - links + 1;
        int n2 = rechts - mitte;

        // Temporäre Arrays erstellen
        int[] linkeHaelfte = new int[n1];
        int[] rechteHaelfte = new int[n2];

        // Daten in temporäre Arrays kopieren
        for (int i = 0; i < n1; i++) {
            linkeHaelfte[i] = array[links + i];
        }
        for (int j = 0; j < n2; j++) {
            rechteHaelfte[j] = array[mitte + 1 + j];
        }

        // Zusammenfügen der temporären Arrays
        int i = 0, j = 0, k = links;

        while (i < n1 && j < n2) {
            if (linkeHaelfte[i] <= rechteHaelfte[j]) {
                array[k] = linkeHaelfte[i];
                i++;
            } else {
                array[k] = rechteHaelfte[j];
                j++;
            }
            k++;
        }

        // Restliche Elemente der linken Hälfte kopieren
        while (i < n1) {
            array[k] = linkeHaelfte[i];
            i++;
            k++;
        }

        // Restliche Elemente der rechten Hälfte kopieren
        while (j < n2) {
            array[k] = rechteHaelfte[j];
            j++;
            k++;
        }
    }

    // Hilfsmethode zum Ausgeben des Arrays
    public static void printArray(int[] array) {
        for (int zahl : array) {
            System. out.print(zahl + " ");
        }
        System. out.println();
    }

    // Main-Methode zum Testen
    public static void main(String[] args) {
        int[] zahlen = {38, 27, 43, 3, 9, 82, 10};

        System.out.print("Unsortiert: ");
        printArray(zahlen);

        mergeSort(zahlen, 0, zahlen.length - 1);

        System.out.print("Sortiert:   ");
        printArray(zahlen);
    }
}