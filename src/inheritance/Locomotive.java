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
        String s = "";
        for (TrainCar car : cars) {
            if (car instanceof CargoCar) {
                s += String.format("Vogn: Carg | Vognens vekt: %s | Lastens vekt: %s\n", car.getTotalWeight(), ((CargoCar) car).getCargoWeight());
            }
            else if (car instanceof PassengerCar) {
                s += String.format("Vogn: Pass | Vognens vekt: %s | Antall passasjerer: %s\n", car.getTotalWeight(), ((PassengerCar) car).getPassengerCount());
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Locomotive myTrain = new Locomotive();

        TrainCar cargo1 = new CargoCar(1000, 100);
        TrainCar cargo2 = new CargoCar(1000, 200);

        TrainCar pass1 = new PassengerCar(100,50);
        TrainCar pass2 = new PassengerCar(100,100);

        myTrain.addTrainCar(cargo1);
        myTrain.addTrainCar(cargo2);
        myTrain.addTrainCar(pass1);
        myTrain.addTrainCar(pass2);

        System.out.println(myTrain);
    }
}
