
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class NumberCheck extends Application {

    static Vaibhav obj = new Vaibhav();
   
    public static void RunCode(TextArea textArea) {
       
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Enter a Number");
    dialog.setHeaderText("Check The Number");
    dialog.setContentText("Please enter a number:");
    dialog.setX(1350);
    dialog.setY(400);

    Optional<String> result = dialog.showAndWait();

    result.ifPresent(numberStr -> {
        try {
            int number = Integer.parseInt(numberStr);
            StringBuilder sb = new StringBuilder();
            sb.append("\n\n\n");
            if(isPrime(number)){
                sb.append("        "+number+" is Prime Number\n");
            }
            if(isArmstrong(number)){
                sb.append("        "+number+" is Armstrong Number\n");
            }
            if(isEven(number)){
                sb.append("        "+number+" is Even Number\n");
            }
            if(isOdd(number)){
                sb.append("        "+number+" is Odd Number\n");
            }
            if(isPerfect(number)){
                sb.append("        "+number+" is Perfect Number\n");
            }
            

            String str = sb.toString();
            //showAlert(str);
            textArea.setText(str);
            
        } catch (NumberFormatException e) {
            showAlert("        "+"Please enter a valid number.");

        }
    });
}
static void showAlert(String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("WARNING !!!");
        alert.setContentText(content);
    alert.setX(1350);
        alert.setY(150);

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

    private boolean isComposite(int number) {
        
        if(isPrime(number)){
            return false;
        }else
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
        
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
