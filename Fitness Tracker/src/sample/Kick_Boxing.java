package sample;

public class Kick_Boxing {
    final double CaloriesBurntPerMinute = 3;
    final private double HeartRateIncrease = 0.005;
    private int Time;

    public Kick_Boxing(int time) {
        Time = time;
    }

    public double getCaloriesBurntPerMinute() {
        return CaloriesBurntPerMinute;
    }

    public double getHeartRateIncrease() {
        return HeartRateIncrease;
    }
}
