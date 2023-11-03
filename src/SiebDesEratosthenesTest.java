import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class SiebDesEratosthenesTest {
    private int[] testArrayNormal = new int[]{13, 2, 3, 4, 6, 7, 41, 22};
    private int[] testArrayErgebnisNormalfall = new int[] {13, 2, 3,7,41};


    @Test
    public void deleteMultipleNormalfall() {
        //Wir testen, ob die Methode bei einer normalen Eingabe, das richtige Ergebnis ausgibt
        int x = 2;
        int[] testNormalfall = SiebDesEratosthenes.deleteMultiple(x, testArrayNormal);
        assertArrayEquals(testNormalfall,testArrayErgebnisNormalfall);
    }
    @Test
    public void deleteMultipleGrenzfallXNull(){
        //Wir testen, ob die Methode bei einer invaliden Eingabe von x, das ursprüngliche Array wieder ausgibt
        int x = 0;
        assertThrows(IllegalArgumentException.class, () ->{SiebDesEratosthenes.deleteMultiple(x,testArrayNormal);});
    }
    @Test
    public void deleteMultipleArrayNull(){
        //Wir testen, wie die Methode reagiert, wenn wir ein null Array eingeben
        int[] testArrayNull = null;
        int x = 2;
        assertThrows(NullPointerException.class, () -> {SiebDesEratosthenes.deleteMultiple(x,testArrayNull);} );
    }
    @Test
    public void deleteMultipleXAusserhalbArray(){
        int x = 43;
        assertThrows(IllegalArgumentException.class, () ->{SiebDesEratosthenes.deleteMultiple(x,testArrayNormal);});
    }
    @Test
    public void deleteMultipleKeineMultipleVorhanden(){
        int x = 2;
        int[] testArrayKeinMultipleVorhanden = new int[]{13,3,5,7,9};
        int[] testArrayKeinMultipleVorhandenErwartetesErgebnis = new int[]{13,3,5,7,9};
        int[] testArrayKeinMultipleVorhandenErgebnis = SiebDesEratosthenes.deleteMultiple(x,testArrayKeinMultipleVorhanden);
        assertArrayEquals(testArrayKeinMultipleVorhandenErgebnis,testArrayKeinMultipleVorhandenErwartetesErgebnis);
    }
    @Test
    public void deleteMultipleGrenzzwertMaxWert(){
        
    }

    @Test
    public void eratoSieveNormalfall() {

    }
}