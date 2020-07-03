package sample;

public class Swimming {
    final double CaloriesBurntPerMinute = 4;
    final private double HeartRateIncrease = 0.002;
    private int Time;

    public Swimming(int time) {
        Time = time;
    }

    public double getCaloriesBurntPerMinute() {
        return CaloriesBurntPerMinute;
    }

    public double getHeartRateIncrease() {
        return HeartRateIncrease;
    }
}
