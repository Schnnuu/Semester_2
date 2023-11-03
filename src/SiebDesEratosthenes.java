import java.lang.reflect.Array;
import java.util.Arrays;

public class SiebDesEratosthenes {
    public static int[] deleteMultiple(int x, int[] array) throws IllegalArgumentException, NullPointerException {
        if (x <= 0) throw new IllegalArgumentException("Ungültiger Wert für x. x muss eine positive ganze Zahl sein.");
        if (array == null) throw new NullPointerException("Array kann nicht NULL sein");
        if(x> Arrays.stream(array).max().getAsInt()) throw new IllegalArgumentException("Die gewählte Zahl ist grösser als jede Zahl im Array");

        // Erstellen eines temporären Arrays für die Ergebnisse
        int[] zwischenArray = new int[array.length];
        int arrayPosition = 0;

        for (int num : array) {
            // Überprüfe, ob die Zahl ein Vielfaches von x ist (außer x selbst)
            if (num == x || num % x != 0) {
                zwischenArray[arrayPosition] = num;
                arrayPosition++;
            }
        }

        // Erstellt ein neues Array mit der richtigen Länge und kopiert die Ergebnisse in das neue Array
        int[] neuesArray = new int[arrayPosition];
        System.arraycopy(zwischenArray, 0, neuesArray, 0, arrayPosition);

        return neuesArray;
    }
    public static int[] eratoSieve(int max) throws IllegalArgumentException{
        if (max <= 0) throw new IllegalArgumentException("Das Zahl muss größer als 0 sein ");

        int zaehler = 2;
        int[] maxArray = new int[max +1];
        //Erstellt uns ein Array mit allen ganzzahligen Zahlen ab 2 bis zum gewählten max
        for (int j = 2; j <= max; j++){
            maxArray[j] = j;
        }
        //Ruft die Methode deleteMultiple rekursiv auf und löscht alle Zahlen, die nicht Prim sind bis zum Maxwert
        for (int i = zaehler; i <= maxArray.length; i++){
            int[] ergebnis = deleteMultiple(zaehler,maxArray);
            maxArray = ergebnis;
            zaehler++;
        }
        return maxArray;
    }
}
