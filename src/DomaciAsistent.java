import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Třída DomaciAsistent spravuje seznam chytrých zařízení a streamovacích služeb.
 * Umožňuje přidávat zařízení a služby, zapínat a vypínat všechna zařízení,
 * a přehrávat obsah na všech streamovacích službách.
 */
public class DomaciAsistent {
    private List<ISmartDevice> zarizeni = new ArrayList<>();
    private List<IStreamingService> sluzby = new ArrayList<>();
    private Scanner scanner;

    public DomaciAsistent(Scanner scanner){
        this.scanner = scanner;
        sluzby.add(new Netflix());
        sluzby.add(new Spotify());
        sluzby.add(new YouTube());
    }

    /**
     * Přidá chytré zařízení do seznamu spravovaných zařízení.
     *
     */
    public void pridejZarizeni() {
        System.out.println("Vyberte typ zařízení:");
        System.out.println("1. SmartLight");
        System.out.println("2. SmartThermostat");
        int typ = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Zadejte název zařízení: ");
        String nazev = scanner.nextLine();

        switch (typ) {
            case 1:
                zarizeni.add(new SmartLight(nazev));
                break;
            case 2:
                System.out.print("Zadejte počáteční teplotu: ");
                double teplota = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                zarizeni.add(new SmartThermostat(nazev, teplota));
                break;
            default:
                System.out.println("Neplatný typ zařízení.");
        }
    }

    /**
     * Odebere chytré zařízení ze seznamu spravovaných zařízení.
     */
    public void odeberZarizeni() {
        System.out.println("Seznam spravovaných zařízení:");
        for (ISmartDevice z : zarizeni) {
            System.out.println(z.toString());
        }

        System.out.print("Název zařízení, které chcete odebrat: ");
        String nazevProOdebrani = scanner.nextLine();


        zarizeni.removeIf(z -> z.getNazev().equals(nazevProOdebrani));
//        for (ISmartDevice z : zarizeni) {
//            if (nazevProOdebrani.equals(z.getNazev())) {
//                zarizeni.remove(z);
//            }
//        }
    }

    /**
     * Vypíše všechna spravovaná chytrá zařízení.
     */
    public void vypisZarizeni() {
        System.out.println("Seznam spravovaných zařízení:");
        for (ISmartDevice z : zarizeni) {
            System.out.println(z.toString());
        }
    }

        /**
     * Zapne všechna spravovaná chytrá zařízení.
     */
    public void zapniVse() {
        for (ISmartDevice z : zarizeni) {
            z.zapni();
        }
    }

    /**
     * Vypne všechna spravovaná chytrá zařízení.
     */
    public void vypniVse() {
        for (ISmartDevice z : zarizeni) {
            z.vypni();
        }
    }

    /**
     * Přehrává zadaný obsah na všech spravovaných streamovacích službách.
     */
    public void prehratNaVsechSluzbach() {
        System.out.print("Zadejte název obsahu, který chcete přehrát: ");
        String nazev = scanner.nextLine();
        for (IStreamingService s : sluzby) {
            s.prehrat(nazev);
        }
    }

    /**
     * Ovládá chytrý termostat podle zadaného názvu a umožňuje nastavit novou teplotu.
     * Pokud termostat s daným názvem není nalezen, zobrazí chybovou zprávu.
     */
    public void ovladaniTermostatu() {
        System.out.println("Seznam termostatů:");
        for (ISmartDevice z : zarizeni) {
            if (z instanceof SmartThermostat) {
                System.out.println(z.toString());
            }
        }

        System.out.println("Zadejte název termostatu, který chcete ovládat:");
        String nazev = scanner.nextLine();
        for (ISmartDevice z : zarizeni) {
            if ((z instanceof SmartThermostat) && (z.stav().equals(nazev))) {
                System.out.print("Zadejte novou teplotu: ");
                double teplota = scanner.nextDouble();
                scanner.nextLine();
                ((SmartThermostat) z).nastavTeplotu(teplota);
                return;
            }
        }
        System.out.println("Termostat s názvem " + nazev + " nebyl nalezen.");
    }


    public void vypsatVseBezici() {
        System.out.println("Seznam běžících zařízení:");
        for (ISmartDevice z : zarizeni) {
            if (z.stav().equals("zapnuto")) {
                System.out.println(z.toString());
            }
        }

        System.out.println("Všechny zapnuté služby:");
        for (IStreamingService s : sluzby) {
            if (s.prehrava() == true){
                System.out.println(s.toString());
            }
        }

    }

    public void zmenaNazvu() {
        System.out.println("Seznam spravovaných zařízení:");
        for (ISmartDevice z : zarizeni) {
            System.out.println(z.toString());
        }

        System.out.print("Název zařízení, u kterého chcete změnit název: ");
        String nazevProZmenu = scanner.nextLine();

        System.out.print("Nový název: ");
        String novyNazev = scanner.nextLine();


        for (ISmartDevice z : zarizeni) {
            if (nazevProZmenu.equals(z.getNazev())) {
                z.setNazev(novyNazev);
                System.out.println("Zařízení s novým názvem: ");
                System.out.println(z.toString());
            }
        }

    }

    public void statistikaSpousteni(){
        int nejviceSpousteneZarizeni = 0;
        int nejviceSpoustenaSluzba = 0;
        int celkovyPocetspusteniZarizeni = 0;
        int celkovyPocetspusteniSluzeb = 0;

        //-----------------------------------------------------------------------------------------

        for (ISmartDevice z : zarizeni) {
            if (z.getPocetSpusteni() > nejviceSpousteneZarizeni) {
                nejviceSpousteneZarizeni = z.getPocetSpusteni();
            }
        }

        if (nejviceSpousteneZarizeni > 0) {
            for (ISmartDevice z : zarizeni) {
                if (z.getPocetSpusteni() == nejviceSpousteneZarizeni) {
                    System.out.println("Nejvíce spouštěné zařízení:");
                    System.out.println("  " + z.toString());
                }
            }
        }
        else {
            System.out.println("Nebylo spuštěné žádné zařízení");
        }

        //-----------------------------------------------------------------------------------------

        for (IStreamingService s : sluzby) {
            if (s.getPocetSpusteni() > nejviceSpoustenaSluzba) {
                nejviceSpoustenaSluzba = s.getPocetSpusteni();
            }
        }

        if (nejviceSpoustenaSluzba > 0) {
            for (IStreamingService s : sluzby) {
                if (s.getPocetSpusteni() == nejviceSpoustenaSluzba) {
                    System.out.println("Nejvíce spouštěná služba:");
                    System.out.println("  " + s.toString());
                }
            }
        }
        else {
            System.out.println("Nebyla spuštěna žádná služba");
        }

        //-----------------------------------------------------------------------------------------

        for (ISmartDevice z : zarizeni) {
            celkovyPocetspusteniZarizeni = celkovyPocetspusteniZarizeni + z.getPocetSpusteni();
        }

        System.out.println("Celkový počet spuštění zařízení: " + celkovyPocetspusteniZarizeni);

        //-----------------------------------------------------------------------------------------

        for (IStreamingService s : sluzby) {
            celkovyPocetspusteniSluzeb = celkovyPocetspusteniSluzeb + s.getPocetSpusteni();
        }

        System.out.println("Celkový počet spuštění služeb: " + celkovyPocetspusteniSluzeb);

        //-----------------------------------------------------------------------------------------
    }



}

