package sample;

public class Strength_Training {
    final double CaloriesBurntPerMinute = 5;
    final private double HeartRateIncrease = 0.006;
    private int Time;

    public Strength_Training(int time) {
        Time = time;
    }

    public double getCaloriesBurntPerMinute() {
        return CaloriesBurntPerMinute;
    }

    public double getHeartRateIncrease() {
        return HeartRateIncrease;
    }
}
