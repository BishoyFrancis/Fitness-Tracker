package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.util.*;
import java.net.URL;
import java.text.DecimalFormat;


public class Controller2 implements Initializable {
    @FXML
    private Label calorieslabel;
    @FXML
    private Label heartratelabel;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;

    double TotalCalories;
    double TotalHeartRate;
    int TotalRunning;
    int TotalSwimming;
    int TotalKickBoxing;
    int TotalStrengthTraining;
    double RunningHeartRate;
    double SwimmingHeartRate;
    double KickBoxingHeartRate;
    double StrengthTrainingHeartRate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void MyFunction(int CaloriesBurnt, double HertRate, int totalRunning, int totalSwimming, int totalKickBoxing, int totalStrengthTraining, double runningHeartRate, double swimmingHeartRate, double kickBoxingHeartRate, double strengthTrainingHeartRate) {
        TotalCalories = CaloriesBurnt;
        TotalHeartRate = HertRate;
        DecimalFormat df = new DecimalFormat("###.###");
        calorieslabel.setText(Integer.toString((int) TotalCalories));
        heartratelabel.setText(Double.toString(Double.parseDouble(df.format(TotalHeartRate))));
        //calories of each activity
        TotalRunning = totalRunning;
        TotalSwimming = totalSwimming;
        TotalKickBoxing = totalKickBoxing;
        TotalStrengthTraining = totalStrengthTraining;
        //rate of each activity
        RunningHeartRate = runningHeartRate;
        SwimmingHeartRate = swimmingHeartRate;
        KickBoxingHeartRate = kickBoxingHeartRate;
        StrengthTrainingHeartRate = strengthTrainingHeartRate;

        class Activity {
            String Name;
            int Calories;
            double HeartBeats;

            public Activity(String name, int caloriesRunning, double heartBeats) {
                this.Name = name;
                this.Calories = caloriesRunning;
                this.HeartBeats = heartBeats;
            }

        }
        class Sortbycal implements Comparator<Activity>
        {
            public int compare(Activity a, Activity b)
            {
                return b.Calories - a.Calories;
            }
        }
        List<Activity> Activities = new ArrayList<>();
        Activities.add(new Activity("Running", TotalRunning, RunningHeartRate));
        Activities.add(new Activity("Swimming", TotalSwimming, SwimmingHeartRate));
        Activities.add(new Activity("Kick Boxing", TotalKickBoxing, KickBoxingHeartRate));
        Activities.add(new Activity("Strength Training", TotalStrengthTraining, StrengthTrainingHeartRate));
        Collections.sort(Activities, new Sortbycal());
        for (int i=0; i<Activities.size(); i++)
            System.out.println(Activities.get(i).Name + " : " + "Total Calories :" + Activities.get(i).Calories + " Total HeartRate :" +
                    " " + Activities.get(i).HeartBeats );
        label1.setText("1. " + Activities.get(0).Name + ":\nCalories Burnt: " + Activities.get(0).Calories + " Calories\nHeart Rate Increase: " + (Double.toString(Double.parseDouble(df.format(Activities.get(0).HeartBeats)))) + " Beat/Minute" );
        label2.setText("2. " +Activities.get(1).Name + ":\nCalories Burnt: " + Activities.get(1).Calories + " Calories\nHeart Rate Increase: " + (Double.toString(Double.parseDouble(df.format(Activities.get(1).HeartBeats)))) + " Beat/Minute" );
        label3.setText("3. " +Activities.get(2).Name + ":\nCalories Burnt: " + Activities.get(2).Calories + " Calories\nHeart Rate Increase: " + (Double.toString(Double.parseDouble(df.format(Activities.get(2).HeartBeats)))) + " Beat/Minute" );
        label4.setText("4. " +Activities.get(3).Name + ":\nCalories Burnt: " + Activities.get(3).Calories + " Calories\nHeart Rate Increase: " + (Double.toString(Double.parseDouble(df.format(Activities.get(3).HeartBeats)))) + " Beat/Minute" );
    }
}

