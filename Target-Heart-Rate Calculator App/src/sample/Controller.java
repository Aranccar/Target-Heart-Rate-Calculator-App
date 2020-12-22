package sample;

import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField age;


    @FXML
    private TextField result;

    @FXML
    private Button calculate;


    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{
            BigDecimal ageN = new BigDecimal(age.getText());
            if(ageN.compareTo(new BigDecimal(0))<=0){
                throw  new NumberFormatException();
            }
            BigDecimal maximumHeartRate = new BigDecimal(200).subtract(ageN);
            BigDecimal heartRateLower = maximumHeartRate.multiply(new BigDecimal(0.50)).round(new MathContext(4));
            BigDecimal heartRateUpper = maximumHeartRate.multiply(new BigDecimal(0.85)).round(new MathContext(4));


            String ans = String.format("%s bpm - %s bpm",heartRateLower.toString(),heartRateUpper.toString());
            result.setText(ans);

        }
        catch (NumberFormatException ex){
            age.setText("Enter your Age");
            age.selectAll();
            age.requestFocus();
        }

    }

}
