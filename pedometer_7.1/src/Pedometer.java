public class Pedometer {
    private int stepRatio;
    public Pedometer(){
        stepRatio = 2000;
    }
    public Pedometer(int stepRatio)
    {
        this.stepRatio = stepRatio;
    }
    public int getStepRatio() {
        return stepRatio;
    }

    public void setStepRatio(int stepRatio) {
        this.stepRatio = stepRatio;
    }
    public double stepsToMiles(int steps)
    {
        return (double)steps/stepRatio;
    }
}
