public class CarroDiesel extends Carro {

    // Composicion: el carro contiene sus componentes como campos
    private final Motor motor;                        // Inmutabilidad: campos final
    private final RelacionesDiferenciales relaciones;
    private final Suspension suspension;

    private final String tipoCombustible = "Carro de Diesel";

    // Inyeccion de dependencias por constructor
    public CarroDiesel(Motor motor, RelacionesDiferenciales relaciones, Suspension suspension) {
        this.motor = motor;
        this.relaciones = relaciones;
        this.suspension = suspension;
    }

    // Sobrescritura del metodo abstracto de Carro
    @Override
    public void tipoCarroOffRoad() {
        System.out.println("|    > " + tipoCombustible);
        System.out.println("|    > " + motor.tipo());
        System.out.println("|    > " + relaciones.tipo());
        System.out.println("|    > " + suspension.tipo());
    }
}
