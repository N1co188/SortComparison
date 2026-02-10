import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // ==================== BUBBLE SORT ====================
    // Original aus BubbleSort.java
    public static void bubbleSort(int[] array) {
        boolean run = true;
        for (int i = 0; i < array.length && run; i++) {
            run = false;
            for (int y = 0; y < array.length - 1; y++) {
                if (array[y] > array[y + 1]) {
                    // Tauschen mit Hilfsvariablen
                    int bigger = array[y];
                    int smaller = array[y + 1];
                    array[y] = smaller;
                    array[y + 1] = bigger;
                    run = true;
                }
            }
        }
    }

    // ==================== INSERTION SORT ====================
    // Original aus InsertionSort.java
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

    // ==================== QUICK SORT ====================
    // Original aus QuickSort.java

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

    // ==================== MERGE SORT ====================
    // Original aus MergeSort.java

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

    // ==================== HILFS-METHODEN ====================

    // Erzeugt ein zufälliges Array
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    // Testet einen Sortieralgorithmus und gibt die Zeit zurück (in Millisekunden)
    public static double testSort(int[] array, String sortType) {
        int[] copy = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();

        switch (sortType) {
            case "bubble":
                bubbleSort(copy);
                break;
            case "insertion":
                insertionSort(copy);
                break;
            case "quick":
                quickSort(copy, 0, copy.length - 1);
                break;
            case "merge":
                mergeSort(copy, 0, copy.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // Millisekunden

        return duration;
    }

    // Erstellt einen Balken für die visuelle Darstellung
    public static String createBar(long time, long maxTime) {
        int maxBarLength = 40;
        int barLength = (int) ((double) time / maxTime * maxBarLength);
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < barLength; i++) {
            bar.append("█");
        }
        return bar.toString();
    }

    // Gibt den schnellsten Algorithmus zurück
    public static String getFastest(long[] times, String[] names) {
        long minTime = times[0];
        int minIndex = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] < minTime) {
                minTime = times[i];
                minIndex = i;
            }
        }
        return names[minIndex];
    }

    // ==================== MAIN ====================
    public static void main(String[] args) {
        // Drei verschiedene Array-Größen
        int[] sizes = {5000, 25000, 50000};
        String[] sortNames = {"Bubble", "Insertion", "Quick", "Merge"};

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("         SORTIERALGORITHMEN-VERGLEICH (Zeiten in Millisekunden)     ");
        System.out.println("======================================================================");
        System.out.println();

        System.out.println("+-------------+---------------+---------------+---------------+---------------+");
        System.out.println("| Array-Size  | Bubble Sort   | Insertion     | Quick Sort    | Merge Sort    |");
        System.out.println("+-------------+---------------+---------------+---------------+---------------+");

        for (int size : sizes) {
            // Erzeuge ein zufälliges Array
            int[] testArray = generateRandomArray(size);

            // Teste alle Sortieralgorithmen
            double bubbleTime = testSort(testArray, "bubble");
            double insertionTime = testSort(testArray, "insertion");
            double quickTime = testSort(testArray, "quick");
            double mergeTime = testSort(testArray, "merge");

            // Ausgabe in einer Zeile
            System.out.println(String.format("| %11d | %9.2f ms | %9.2f ms | %9.2f ms | %9.2f ms |",
                size, bubbleTime, insertionTime, quickTime, mergeTime));
        }

        System.out.println("+-------------+---------------+---------------+---------------+---------------+");
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("                   Test erfolgreich abgeschlossen!                   ");
        System.out.println("======================================================================");
        System.out.println();
    }
}
