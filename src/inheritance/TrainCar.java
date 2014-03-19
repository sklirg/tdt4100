package inheritance;

public class TrainCar {
    private int emptyWeight, deadWeight;

    TrainCar(int weight){
        this.emptyWeight = weight;
    }

    public int getTotalWeight() {
        return this.emptyWeight + this.deadWeight;
    }

    public int getDeadWeight() {
        return deadWeight;
    }

    public void setDeadWeight(int deadWeight) {
        this.deadWeight = deadWeight;
    }
}
