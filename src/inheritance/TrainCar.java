package inheritance;

public class TrainCar {
    private int deadWeight;

    TrainCar(int weight){
        this.deadWeight = weight;
    }

    public int getTotalWeight() {
        return this.deadWeight;
    }

    public int getDeadWeight() {
        return deadWeight;
    }

    public void setDeadWeight(int deadWeight) {
        this.deadWeight = deadWeight;
    }
}
