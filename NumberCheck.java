
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NumberCheck extends Application {
    public void CreateWindow(){
        //Create The popup window
        BorderPane bp = new BorderPane();
        Button checkNumButton = MainProject.createGlowButton("Check Number", Color.ORANGE);
         checkNumButton.setOnAction(e -> NumberCheck.RunCode());
         VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(checkNumButton);
        BorderPane.setAlignment(buttonBox,Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(700,5000,1000,500));
        bp.setCenter(buttonBox); 
        bp.setRight(buttonBox);
    }
  /*   private Button createGlowButton(String text, Color glowColor) {
        Button button = new Button(text);
        button.setStyle("-fx-base: " + toHex(glowColor) + ";");
        button.setEffect(new DropShadow());

        button.setOnMouseEntered(e -> {
            Glow glow = new Glow(0.7);
            glow.setInput(button.getEffect());
            button.setEffect(glow);
        });
        button.setOnMouseExited(e -> {
            button.setEffect(new DropShadow());
        });

        return button;
    }
    */
    public static void RunCode() {
       
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Enter a Number");
    dialog.setHeaderText("Check The Number");
    dialog.setContentText("Please enter a number:");

    Optional<String> result = dialog.showAndWait();

    result.ifPresent(numberStr -> {
        try {
            int number = Integer.parseInt(numberStr);
            StringBuilder sb = new StringBuilder();
            if(isPrime(number)){
                sb.append(number+" is Prime Number\n");
            }
            if(isArmstrong(number)){
                sb.append(number+" is Armstrong Number\n");
            }
            if(isEven(number)){
                sb.append(number+" is Even Number\n");
            }
            if(isOdd(number)){
                sb.append(number+" is Odd Number\n");
            }
            if(isPerfect(number)){
                sb.append(number+" is Perfect Number\n");
            }
            

            String str = sb.toString();
            showAlert(str);
            
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid number.");
        }
    });
}
static void showAlert(String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }
    // Function to check if a number is prime
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to check if a number is Armstrong
    static boolean isArmstrong(int number) {
        int originalNumber = number;
        int result = 0;
        int n = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            result += Math.pow(digit, n);
            number /= 10;
        }

        return result == originalNumber;
    }

    // Function to check if a number is even
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
    static boolean isOdd(int number){
        return number % 2 != 0;
    }

    // Function to check if a number is perfect
    static boolean isPerfect(int number) {
        if (number <= 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }
        return sum == number;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
