public class YouTube implements IStreamingService {
    private boolean prehravani;
    private int pocetSpusteni = 0;

    @Override
    public void prehrat(String nazevTitulu) {
        pocetSpusteni++;
        prehravani = true;
        System.out.println("Přehrávání na YouTube: " + nazevTitulu);
    }

    @Override
    public void stop() {
        prehravani = false;
        System.out.println("YouTube přehrávání ukončeno.");
    }

    public int getPocetSpusteni() {
        return pocetSpusteni;
    }

    @Override
    public boolean prehrava() {
        return prehravani;
    }

    public String toString(){
        return "YouTube";
    }
}
