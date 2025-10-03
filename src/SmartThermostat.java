/**
 * Třída SmartThermostat implementuje rozhraní ISmartDevice a poskytuje
 * konkrétní implementace metod pro zapnutí, vypnutí a zjištění stavu chytrého termostatu.
 * Navíc umožňuje nastavit teplotu.
 */
class SmartThermostat implements ISmartDevice {
    private String nazev;
    private boolean zapnuto;
    private double teplota;
    private int pocetSpusteni = 0;

    /**
     * Vytvoří nový chytrý termostat s daným názvem a počáteční teplotou.
     *
     * @param nazev Název chytrého termostatu.
     * @param teplota Počáteční teplota termostatu.
     */
    public SmartThermostat(String nazev, double teplota) {
        this.nazev = nazev;
        this.teplota = teplota;
        this.zapnuto = false;
    }

    /**
     * Zapne chytrý termostat a nastaví teplotu.
     */
    @Override
    public void zapni() {
        pocetSpusteni++;
        zapnuto = true;
        System.out.println(nazev + " je zapnutý, teplota nastavena na " + teplota + "°C.");
    }

    /**
     * Vypne chytrý termostat.
     */
    @Override
    public void vypni() {
        zapnuto = false;
        System.out.println(nazev + " je vypnutý.");
    }

    /**
     * Vrátí aktuální stav chytrého termostatu.
     *
     * @return Řetězec reprezentující aktuální stav termostatu.
     */
    @Override
    public String stav() {
        if (zapnuto) {
            return "zapnuto";
        } else {
            return "vypnuto";
        }
    }

    /**
     * Nastaví novou teplotu na chytrém termostatu.
     *
     * @param novaTeplota Nová teplota, která má být nastavena.
     */
    public void nastavTeplotu(double novaTeplota) {
        this.teplota = novaTeplota;
        System.out.println("Teplota nastavena na " + teplota + "°C.");
    }

    public String getNazev() {
        return nazev;
    }

    public int getPocetSpusteni() {
        return pocetSpusteni;
    }

    public boolean isZapnuto() {
        return zapnuto;
    }

    public double getTeplota() {
        return teplota;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String toString() {
        return "Název: " + nazev + " ,Stav: " + stav();
    }

}
