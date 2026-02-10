public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 4, 6, 3};  // Beispiel-Array (unsortiert)
        
        System.out.println("Vor dem Sortieren: ");
        printArray(array);
        
        bubbleSort(array);  // Sortierung aufrufen
        
        System.out.println("Nach dem Sortieren: ");
        printArray(array);  // Ausgabe: 1 2 3 4 5 6
    }
    
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
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}