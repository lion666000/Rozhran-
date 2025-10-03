import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DomaciAsistent asistent = new DomaciAsistent(scanner);

        while (true) {
            System.out.println("\n***************************************");
            System.out.println("--- Domácí Asistent Menu ---");
            System.out.println("1. Přidat nové zařízení");
            System.out.println("2. Odebrat zařízení");
            System.out.println("3. Vypisovat zařízení");
            System.out.println("4. Zapnout všechna zařízení");
            System.out.println("5. Vypnout všechna zařízení");
            System.out.println("6. Přehrát na všech službách");
            System.out.println("7. Ovládání termostatu");
            System.out.println("8. Vypisovat všechno běžící");
            System.out.println("9. Změnit název zařízení");
            System.out.println("10. Vypsat statisktiku spouštění");
            System.out.println("11. Konec");
            System.out.println("***************************************");
            System.out.print("Vyberte možnost: ");



            int volba = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (volba) {
                case 1:
                    System.out.println("_______________________________________");
                    asistent.pridejZarizeni();
                    System.out.println("_______________________________________");
                    break;
                case 2:
                    System.out.println("_______________________________________");
                    asistent.odeberZarizeni();
                    System.out.println("_______________________________________");
                    break;
                case 3:
                    System.out.println("_______________________________________");
                    asistent.vypisZarizeni();
                    System.out.println("_______________________________________");
                    break;
                case 4:
                    System.out.println("_______________________________________");
                    asistent.zapniVse();
                    System.out.println("_______________________________________");
                    break;
                case 5:
                    System.out.println("_______________________________________");
                    asistent.vypniVse();
                    System.out.println("_______________________________________");
                    break;
                case 6:
                    System.out.println("_______________________________________");
                    asistent.prehratNaVsechSluzbach();
                    System.out.println("_______________________________________");
                    break;
                case 7:
                    System.out.println("_______________________________________");
                    asistent.ovladaniTermostatu();
                    System.out.println("_______________________________________");
                    break;
                case 8:
                    System.out.println("_______________________________________");
                    asistent.vypsatVseBezici();
                    System.out.println("_______________________________________");
                    break;
                case 9:
                    System.out.println("_______________________________________");
                    asistent.zmenaNazvu();
                    System.out.println("_______________________________________");
                    break;
                case 10:
                    System.out.println("_______________________________________");
                    asistent.statistikaSpousteni();
                    System.out.println("_______________________________________");
                    break;
                case 11:
                    System.out.println("Konec programu.");
                    return;
                default:
                    System.out.println("Neplatná volba, zkuste to znovu.");
            }
        }
    }
}