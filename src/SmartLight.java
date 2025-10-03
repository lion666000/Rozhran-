/**
 * Třída SmartLight implementuje rozhraní ISmartDevice a poskytuje
 * konkrétní implementace metod pro zapnutí, vypnutí a zjištění stavu chytrého světla.
 */
class SmartLight implements ISmartDevice {
    private String nazev;
    private boolean zapnuto;
    private int pocetSpusteni = 0;

    /**
     * Vytvoří nové chytré světlo s daným názvem.
     *
     * @param nazev Název chytrého světla.
     */
    public SmartLight(String nazev) {
        this.nazev = nazev;
        this.zapnuto = false;
    }

    /**
     * Zapne chytré světlo.
     */
    @Override
    public void zapni() {
        pocetSpusteni++;
        zapnuto = true;
        System.out.println(nazev + " je zapnuto.");
    }

    /**
     * Vypne chytré světlo.
     */
    @Override
    public void vypni() {
        zapnuto = false;
        System.out.println(nazev + " je vypnuto.");
    }

    /**
     * Vrátí aktuální stav chytrého světla.
     *
     * @return Řetězec reprezentující aktuální stav světla.
     */
    @Override
    public String stav() {
        if (zapnuto) {
            return "zapnuto";
        } else {
            return "vypnuto";
        }
    }

    public String getNazev() {
        return nazev;
    }

    public int getPocetSpusteni() {
        return pocetSpusteni;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isZapnuto() {
        return zapnuto;
    }

    public String toString() {
        return "Název: " + nazev + " ,Stav: " + stav();
    }

}
