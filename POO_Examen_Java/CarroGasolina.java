public class CarroGasolina extends Carro {

    // Composicion
    private final Motor motor;                        // Inmutabilidad: campos final
    private final RelacionesDiferenciales relaciones;
    private final Suspension suspension;

    private final String tipoCombustible = "Carro de Gasolina";

    // Inyeccion de dependencias por constructor
    public CarroGasolina(Motor motor, RelacionesDiferenciales relaciones, Suspension suspension) {
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
