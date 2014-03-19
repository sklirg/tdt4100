package inheritance;

import java.util.ArrayList;

public class Locomotive {
    private ArrayList<TrainCar> cars = new ArrayList<TrainCar>();

    public void addTrainCar(TrainCar car) {
        cars.add(car);
    }

    public boolean contains(TrainCar carToCheck) {
        for (TrainCar car : cars) {
            if (carToCheck == car)
                return true;
        }
        return false;
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (TrainCar car : cars) {
            totalWeight += car.getTotalWeight();
        }
        return totalWeight;
    }

    public int getPassengerCount() {
        int count = 0;
        for (TrainCar car : cars) {
            if (car instanceof PassengerCar) {
                count += ((PassengerCar) car).getPassengerCount();
            }
        }
        return count;
    }

    public int getCargoWeight() {
        int cargoWeight = 0;
        for (TrainCar car : cars) {
            if (car instanceof CargoCar) {
                cargoWeight += ((CargoCar) car).getCargoWeight();
            }
        }
        return cargoWeight;
    }

    @Override
    public String toString() {
        return "trololol";
    }
}
