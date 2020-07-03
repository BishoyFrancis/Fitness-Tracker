package sample;

public class Running {
    final double CaloriesBurntPerMinute = 5;
    final private double HeartRateIncrease = 0.003;
    private int Time;


    public double getHeartRateIncrease() {
        return HeartRateIncrease;
    }

    public Running(int time) {
        Time = time;
    }

    public double getCaloriesBurntPerMinute() {
        return CaloriesBurntPerMinute;
    }

    public int getTime() {
        return Time;
    }
}
