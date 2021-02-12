package DefiningClasses.Ex04RawData;

public class Car {
    //    model, engine, cargo
//    collection of exactly 4 tires
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public boolean hasTirePressureLessThanOne(){
        for (Tire tire : tires) {
            if(tire.getPressure() <1){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
