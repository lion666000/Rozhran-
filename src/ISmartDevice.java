/**
 * Rozhraní pro chytré zařízení, které definuje základní operace.
 */
public interface ISmartDevice {
    public String getNazev();

    public void setNazev(String nazev);
    /**
     * Zapne chytré zařízení.
     */
    public void zapni();

    /**
     * Vypne chytré zařízení.
     */
    public void vypni();

    /**
     * Vrátí aktuální stav chytrého zařízení.
     *
     * @return Řetězec reprezentující aktuální stav zařízení.
     */
    public String stav();

    public int getPocetSpusteni();
}
