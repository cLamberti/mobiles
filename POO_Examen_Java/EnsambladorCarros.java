public class EnsambladorCarros {

    public static void main(String[] args) {

        Motor[] motores = { new Motor5000(), new Motor6000() };
        RelacionesDiferenciales[] relaciones = { new Relacion47(), new Relacion49() };
        Suspension[] suspensiones = { new SuspensionARB(), new SuspensionTJM() };

        int totalCarros = 0;
        int combinacion = 1;
        int totalCombinaciones = motores.length * relaciones.length * suspensiones.length;

        System.out.println("+================================================+");
        System.out.println("|     ENSAMBLADOR DE CARROS 4x4 - AUTOCROSS      |");
        System.out.println("+================================================+");
        System.out.println();

        for (Motor motor : motores) {
            for (RelacionesDiferenciales relacion : relaciones) {
                for (Suspension suspension : suspensiones) {

                    System.out.println("+------------------------------------------------+");
                    System.out.printf( "|  COMBINACION %d de %d%n", combinacion, totalCombinaciones);
                    System.out.println("+------------------------------------------------+");

                    System.out.println("|  [DIESEL]");
                    // Polimorfismo: variable de tipo base Carro
                    Carro diesel = new CarroDiesel(motor, relacion, suspension);
                    diesel.tipoCarroOffRoad();

                    System.out.println("+------------------------------------------------+");

                    System.out.println("|  [GASOLINA]");
                    Carro gasolina = new CarroGasolina(motor, relacion, suspension);
                    gasolina.tipoCarroOffRoad();

                    System.out.println("+------------------------------------------------+");
                    System.out.println();

                    totalCarros += 2;
                    combinacion++;
                }
            }
        }

        System.out.println("+================================================+");
        System.out.printf( "|  Combinaciones generadas : %-20d|%n", totalCombinaciones);
        System.out.printf( "|  Total de carros         : %-20d|%n", totalCarros);
        System.out.println("+================================================+");
    }
}
