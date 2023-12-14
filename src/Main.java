

public class Main {
    public static void main(String[] args) {


        //Program för att hämta, visa och sortera data från fil.
        //Programmet kan hämta data från .CSV, .XML, .JSON.

        //I GUI kan den visa endast CSV och JSON filer.
        //XML visas i terminal(för tillfället).

        //Sortering fungerar bra med CSV-filer.
        //Fungerar även med JSON, men indenteringen är inte korrekt(för tillfället).

        // LaunchPage -> öppnar GUI, med Jframe och lägger till buttons.
        // Där finns JFileChooser för att hämta fil. Både för sort/visa.

        //Beroende på fil så skapas en instans av en klass, klasser - JSON-/CSV-/XML-file
        //Där hämtas datan och läggs till i en ArrayList.

        //Då öppnas ett nytt fönster med 'NewWindow'
        //Som visar upp datan hämtat från filen.

        new LaunchPage();




    }
}