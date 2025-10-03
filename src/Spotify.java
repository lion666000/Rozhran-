/**
 * Třída Spotify implementuje rozhraní IStreamingService a poskytuje
 * konkrétní implementace metod pro přehrávání, pauzu a zastavení obsahu.
 */
public class Spotify implements IStreamingService {
    private boolean prehravani;
    private int pocetSpusteni = 0;

    /**
     * Přehrává zadaný titul na Spotify.
     *
     * @param nazevTitulu Název titulu, který má být přehrán.
     */
    @Override
    public void prehrat(String nazevTitulu) {
        pocetSpusteni++;
        prehravani = true;
        System.out.println("Přehrávání na Spotify: " + nazevTitulu);
    }

    /**
     * Zastaví aktuálně přehrávaný obsah na Spotify.
     */
    @Override
    public void stop() {
        prehravani = false;
        System.out.println("Spotify přehrávání ukončeno.");
    }

    public int getPocetSpusteni() {
        return pocetSpusteni;
    }

    @Override
    public boolean prehrava() {
        return prehravani;
    }

    public String toString(){
        return "Spotify";
    }
}