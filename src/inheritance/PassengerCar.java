package inheritance;

public class PassengerCar extends TrainCar {
    private int passengerCount;

    public PassengerCar(int emptyWeight, int passengerCount) {
        super(emptyWeight);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
