package inheritance;

public class CargoCar extends TrainCar {
    private int cargoWeight;

    public CargoCar(int emptyWeight, int cargoWeight) {
        super(emptyWeight);
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getTotalWeight() {
        return super.getDeadWeight() + this.cargoWeight;
    }
}
