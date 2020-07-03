package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private TextField textfield;
    @FXML
    private Label emptylabel;
    int TIME;
    int TotalRunning = 0;
    int TotalSwimming = 0;
    int TotalKickBoxing = 0;
    int TotalStrengthTraining = 0;
    double RunningHeartRate = 0;
    double SwimmingHeartRate = 0;
    double KickBoxingHeartRate = 0;
    double StrengthTrainingHeartRate = 0;
    int CaloriesBurnt = 0;
    double HeartRate = 80;
    int clicks = 0;
    ArrayList<Double> HeartRateBuffer = new ArrayList<>();

    public int TimeValidation() {
        if (textfield.getText() == null || textfield.getText().trim().isEmpty()) {
            System.out.println("Time Field Is Empty!");
            emptylabel.setText("Enter a value!");
            TIME = 0;
        } else {
            TIME = 0;
            String str = textfield.getText();
            try {
                TIME = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                emptylabel.setText("Enter a Valid value!");
            }
            if (TIME == 0) {
                System.out.println("Enter a Valid Value!");
                emptylabel.setText("Enter a Valid value!");
            } else {
                emptylabel.setText("Activity Recorded Successfully!");
            }
            return TIME;
        }
        return TIME;
    }

    public void runningbutton() {
        if (TimeValidation() != 0) {
            System.out.println("YOU HAVE BEEN RUNNING FOR " + TIME + " Minutes");
        }
        Running newObj = new Running(TimeValidation());
        CaloriesBurnt += TIME * newObj.getCaloriesBurntPerMinute();
        HeartRate = HeartRate + (HeartRate * TIME * newObj.getHeartRateIncrease());
        HeartRateBuffer.add(HeartRate);
        //System.out.println("Total Calories burnt = " + CaloriesBurnt);
        //System.out.println("Total Heart Rate = " + HeartRate);
        TotalRunning += TIME * newObj.getCaloriesBurntPerMinute();
        System.out.println("Total Calories For Running :" + TotalRunning);
        //System.out.println(HeartRateBuffer.get(clicks));
        clicks++;
        //System.out.println(clicks);
        RunningHeartRate = RunningHeartRate + (HeartRate - HeartRateBuffer.get(clicks - 1));
        System.out.println("Heart Rate Increase of Running = " + RunningHeartRate);
    }

    public void swimmingbutton() {
        if (TimeValidation() != 0) {
            System.out.println("YOU HAVE BEEN SWIMMING FOR " + TIME + " Minutes");
        }
        Swimming newObj = new Swimming(TimeValidation());
        CaloriesBurnt += TIME * newObj.getCaloriesBurntPerMinute();
        HeartRate = HeartRate + (HeartRate * TIME * newObj.getHeartRateIncrease());
        HeartRateBuffer.add(HeartRate);
        //System.out.println("Total Calories burnt = " + CaloriesBurnt);
        //System.out.println("Total Heart Rate = " + HeartRate);
        TotalSwimming += TIME * newObj.getCaloriesBurntPerMinute();
        System.out.println("Total Calories For Swimming :" + TotalSwimming);
        // System.out.println(HeartRateBuffer.get(clicks));
        clicks++;
        // System.out.println(clicks);
        SwimmingHeartRate = SwimmingHeartRate + (HeartRate - HeartRateBuffer.get(clicks - 1));
        System.out.println("Heart Rate Increase of Swimming= " + SwimmingHeartRate);
    }

    public void kickboxingbutton() {
        if (TimeValidation() != 0) {
            System.out.println("YOU HAVE BEEN KICK BOXING FOR " + TIME + " Minutes");
        }
        Kick_Boxing newObj = new Kick_Boxing(TimeValidation());
        CaloriesBurnt += TIME * newObj.getCaloriesBurntPerMinute();
        HeartRate = HeartRate + (HeartRate * TIME * newObj.getHeartRateIncrease());
        HeartRateBuffer.add(HeartRate);
        //System.out.println("Total Calories burnt = " + CaloriesBurnt);
        //System.out.println("Total Heart Rate = " + HeartRate);
        TotalKickBoxing += TIME * newObj.getCaloriesBurntPerMinute();
        System.out.println("Total Calories For Kick Boxing :" + TotalKickBoxing);
        //System.out.println(HeartRateBuffer.get(clicks));
        clicks++;
        KickBoxingHeartRate = KickBoxingHeartRate + (HeartRate - HeartRateBuffer.get(clicks - 1));
        System.out.println("Heart Rate Increase of Kick Boxing = " + KickBoxingHeartRate);
    }

    public void strengthtrainingbutton() {
        if (TimeValidation() != 0) {
            System.out.println("YOU HAVE BEEN STRENGTH TRAINING FOR " + TIME + " Minutes");
            Strength_Training newObj = new Strength_Training(TimeValidation());
            CaloriesBurnt += TIME * newObj.getCaloriesBurntPerMinute();
            HeartRate = HeartRate + (HeartRate * TIME * newObj.getHeartRateIncrease());
            HeartRateBuffer.add(HeartRate);
            //System.out.println("Total Calories burnt = " + CaloriesBurnt);
            //System.out.println("Total Heart Rate = " + HeartRate);
            TotalStrengthTraining += TIME * newObj.getCaloriesBurntPerMinute();
            System.out.println("Total Calories For Strength Training :" + TotalStrengthTraining);
            //System.out.println(HeartRateBuffer.get(clicks));
            clicks++;
            //System.out.println(clicks);
            StrengthTrainingHeartRate = StrengthTrainingHeartRate + (HeartRate - HeartRateBuffer.get(clicks - 1));
            System.out.println("Heart Rate Increase of Strength Training= " + StrengthTrainingHeartRate);
        }
    }

    public void timeinput() {
        if (TimeValidation() != 0) {
            System.out.println(TIME);
        }
    }

    public void resetbutton() {
        HeartRate = 80;
        CaloriesBurnt = 0;
        System.out.println("Calories Burnt = " + CaloriesBurnt);
        System.out.println("Heart Rate = " + HeartRate);
        System.out.println("Reset Done");
        emptylabel.setText("Reset Done!");
        TotalRunning = 0;
        TotalSwimming = 0;
        TotalKickBoxing = 0;
        TotalStrengthTraining = 0;
        RunningHeartRate = 0;
        SwimmingHeartRate = 0;
        KickBoxingHeartRate = 0;
        StrengthTrainingHeartRate = 0;
        HeartRateBuffer.add(80.0);
        clicks = 0;
    }

    public void showresults() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample2.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("RESULTS");
            Scene scene2 = new Scene(root1);
            stage.setScene(scene2);
            stage.setResizable(false); //Resize window = false;
            //Font.loadFont(Controller2.class.getResource("C:\\Users\\Bishoy\\IdeaProjects\\Project1\\src\\sample\\Orbitron-VariableFont_wght.ttf").toExternalForm(),12);
            scene2.getStylesheets().add(String.valueOf(getClass().getResource("sample2.css")));
            stage.show();
            Controller2 controller2 = fxmlLoader.getController();
            controller2.MyFunction(CaloriesBurnt, HeartRate, TotalRunning, TotalSwimming, TotalKickBoxing, TotalStrengthTraining, RunningHeartRate, SwimmingHeartRate, KickBoxingHeartRate, StrengthTrainingHeartRate);
        } catch (Exception e) {
            System.out.println("Error Loading Window");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HeartRateBuffer.add(80.0);
    }
}