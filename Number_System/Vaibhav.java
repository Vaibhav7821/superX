import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.util.Duration;

public class Vaibhav {
    public TextArea textArea = new TextArea();
    private BorderPane root = new BorderPane();
    private Text[] numberTexts = new Text[100];
    private Rectangle[] numberRectangles = new Rectangle[100];
    private VBox buttonVBox = new VBox(30);
    private GridPane numberGrid = new GridPane();
    private Timeline blinkTimeline;
    private boolean isBlinking = false;
    //private Stage primaryStage;
    static FirstWindow fw=new FirstWindow();

    public void nextWindow(Stage primaryStage) {
        // primaryStage = new Stage();
primaryStage.setMaximized(true);
        primaryStage.setTitle("Number Highlighter");
        
        Scene scene = new Scene(root, 1366, 768);

	    Image img = new Image("Vaibhav.jpg");

        primaryStage.getIcons().add(img);

        // Create a BackgroundImage with your loaded image
        Image backgroundImage = new Image("xyz.jpg");
        BackgroundImage backgroundImg = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        ImageView backImageView = new ImageView(backgroundImage);
        backImageView.setFitWidth(2000);
        backImageView.setFitHeight(1200);
        root.getChildren().add(backImageView);

        // Create a Background with the BackgroundImage
        Background background = new Background(backgroundImg);
        Label nameLabel = new Label("NUMBER HIGHLIGHTER");
        GridPane.setConstraints(nameLabel, 20, 2);

        // Set the background of the root Pane
        root.setBackground(background);

        // Create a GridPane for numbers with larger boxes
        numberGrid.setPadding(new Insets(10,0,0,0));
        numberGrid.setHgap(40);
        numberGrid.setVgap(40);
        Font font = Font.font("Calibri", 25);
        for (int i = 0; i < 100; i++) {
            numberTexts[i] = new Text(Integer.toString(i + 1));
            numberTexts[i].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            numberTexts[i].setFont(font);
            numberRectangles[i] = new Rectangle(60, 60, Color.WHITE);
            numberRectangles[i].setStroke(Color.BLACK);
            numberRectangles[i].setStrokeWidth(1);

            // Create a StackPane to center the number in the rectangle
            StackPane stackPane = new StackPane();
            stackPane.setAlignment(Pos.CENTER);
            stackPane.getChildren().addAll(numberRectangles[i], numberTexts[i]);

            numberGrid.add(stackPane, i % 10, i / 10);
        }

        root.setCenter(numberGrid);

        // Create buttons and add them to the VBox
        Font buttonFont = Font.font("Calibri", 20);
        Button evenButton = createGlowButton("EVEN", Color.BLUE);
        evenButton.setFont(buttonFont);
        evenButton.setMaxWidth(140);
        Button oddButton = createGlowButton("ODD", Color.RED);
        oddButton.setFont(buttonFont);
        oddButton.setMaxWidth(140);
        Button primeButton = createGlowButton("PRIME", Color.GREEN);
        primeButton.setFont(buttonFont);
        primeButton.setMaxWidth(140);
        Button armstrongButton = createGlowButton("ARMSTRONG", Color.ORANGE);
        armstrongButton.setFont(buttonFont);
        armstrongButton.setMaxWidth(140);
        Button perfectButton = createGlowButton("PERFECT", Color.PURPLE);
        perfectButton.setFont(buttonFont);
        perfectButton.setMaxWidth(140);
        Button compositeButton = createGlowButton("PERFECT", Color.PURPLE);
        compositeButton.setFont(buttonFont);
        compositeButton.setMaxWidth(140);
        
        Button aboutButton = createGlowButton("ABOUT", Color.PURPLE);
        aboutButton.setFont(buttonFont);
        aboutButton.setMaxWidth(140);
        Button backButton = createGlowButton("BACK", Color.BLACK);
        backButton.setFont(buttonFont);
        backButton.setMaxWidth(140);

        evenButton.setOnAction(e -> highlightEvenNumbers(evenButton));
        oddButton.setOnAction(e -> highlightOddNumbers(oddButton));
        primeButton.setOnAction(e -> highlightPrimeNumbers(primeButton));
        armstrongButton.setOnAction(e -> highlightArmstrongNumbers(armstrongButton));
        perfectButton.setOnAction(e -> highlightPerfectNumbers(perfectButton));
        compositeButton.setOnAction(e -> highlightPerfectNumbers(perfectButton));
        aboutButton.setOnAction(e -> printAbout());
        backButton.setOnAction(e -> {
            
        
            primaryStage.close();
            fw.start(primaryStage);
           // primaryStage.show();
           
        });

        buttonVBox.getChildren().addAll(evenButton, oddButton, primeButton, armstrongButton, perfectButton);
        buttonVBox.setAlignment(Pos.TOP_LEFT); // Align buttons to the left
        buttonVBox.setPadding(new Insets(10, 20, 30, 20)); // Adjust padding as needed

        VBox aboutVBox = new VBox(20);
        aboutVBox.getChildren().addAll(backButton,aboutButton);
        aboutVBox.setAlignment(Pos.BASELINE_LEFT);
      
        aboutVBox.setPadding(new Insets(0, 20, 0, 20));
        
        VBox cmVBox =  new VBox(530);
        cmVBox.getChildren().addAll(buttonVBox,aboutVBox);
        root.setLeft(cmVBox);


        // Create a VBox for the "Check Number" button
        VBox checkNumButtonBox = new VBox(700);
        checkNumButtonBox.setAlignment(Pos.BOTTOM_RIGHT);

        // Create the "Check Number" button with a glow effect
        Button checkNumButton = createGlowButton("Check Number", Color.BLUEVIOLET);
        checkNumButton.setPrefWidth(250); // Adjust the width as needed
        checkNumButton.setPrefHeight(150); 
        // Set the action to run when the button is clicked
        checkNumButton.setOnAction(e -> NumberCheck.RunCode(textArea));
       // checkNumButton.setPadding(new Insets(0,20,20,0));
       Insets buttonMargins = new Insets(0, 270, 100, 0); // Adjust the right margin as needed

       // Set the margins for the button
        VBox.setMargin(checkNumButton, buttonMargins);
       
        checkNumButtonBox.getChildren().add(checkNumButton);

        // Create a VBox to contain the textArea and the "Check Number" button
        VBox rightVBox = new VBox(10);
        rightVBox.setAlignment(Pos.CENTER_RIGHT);

        // Added TextArea to the right side
        textArea.setPrefWidth(600);
        textArea.setPrefHeight(700); // Set the preferred height
        textArea.setEditable(false);
        textArea.setStyle("-fx-font-family: 'Calibri'");
        textArea.setStyle("-fx-control-inner-background: BLACK");

        Font font1 = Font.font("Arial", FontWeight.BOLD, 20);

        textArea.setFont(font1);

        Insets textAreaMargins = new Insets(100, 70, 150,10 ); // Adjust the left margin as needed

 //       // Set the margins for the textArea
        VBox.setMargin(textArea, textAreaMargins);

        //root.setRight(rightVBox);
        BorderPane.setMargin(textArea, new Insets(100, 70, 300, 10));
        textArea.setBackground(background);

        // Add the "Check Number" button and textArea to the rightVBox
        rightVBox.getChildren().addAll(textArea,checkNumButtonBox);

        root.setRight(rightVBox);


        
        primaryStage.setScene(scene);

        primaryStage.show();
        
    }

    // Rest of your code...
public static Button createGlowButton(String text, Color glowColor) {
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

    public void printAbout(){
        readFile("C:\\Users\\Pranav Pisal\\OneDrive\\Desktop\\VSCODE\\C2W_Project\\Original_Project\\About.txt");
    }

    public static String toHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
 
    private void highlightEvenNumbers(Button button) {
        stopBlinking();

        for (int i = 0; i < numberTexts.length; i++) {
            int number = Integer.parseInt(numberTexts[i].getText());

            if (number % 2 == 0) {
                startBlinking(numberRectangles[i], Color.BLUE);
            } else {
                resetHighlight(numberRectangles[i]);
            }
        }
        //startButtonBlinking(button);

        readFile("C:\\Users\\Vaibhav\\Desktop\\java\\NumberChecker\\src\\even_no.txt");
    }

    public void readFile(String filePath) {
       
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n"); // Append each line and a newline character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // The content of the file is now stored in the 'content' StringBuilder
        String fileContent = content.toString();
        // String fileContent = "My Name Is Pranav Pisal";

        // Set the text in the TextArea to display the file content
        textArea.setText(fileContent);
    }

    private void highlightOddNumbers(Button button) {
        stopBlinking();
        for (int i = 0; i < numberTexts.length; i++) {
            int number = Integer.parseInt(numberTexts[i].getText());

            if (number % 2 != 0) {
                startBlinking(numberRectangles[i], Color.RED);
            } else {
                resetHighlight(numberRectangles[i]);
            }
        }
        //startButtonBlinking(button);
        readFile("C:\\Users\\Vaibhav\\Desktop\\java\\NumberChecker\\src\\odd_no.txt");
    }

    private void highlightPrimeNumbers(Button button) {
        stopBlinking();
        for (int i = 0; i < numberTexts.length; i++) {
            int number = Integer.parseInt(numberTexts[i].getText());

            if (isPrime(number)) {
                startBlinking(numberRectangles[i], Color.GREEN);
            } else {
                resetHighlight(numberRectangles[i]);
            }
        }
        //startButtonBlinking(button);
        readFile("C:\\Users\\Vaibhav\\Desktop\\java\\NumberChecker\\src\\prime_no.txt");
    }

    private void highlightArmstrongNumbers(Button button) {
        stopBlinking();
        for (int i = 0; i < numberTexts.length; i++) {
            int number = Integer.parseInt(numberTexts[i].getText());

            if (isArmstrong(number)) {
                startBlinking(numberRectangles[i], Color.ORANGE);
            } else {
                resetHighlight(numberRectangles[i]);
            }
        }
        //startButtonBlinking(button);
        readFile("C:\\Users\\Vaibhav\\Desktop\\java\\NumberChecker\\src\\Amstrong_no.txt");
    }

    private void highlightPerfectNumbers(Button button) {
        stopBlinking();
        for (int i = 0; i < numberTexts.length; i++) {
            int number = Integer.parseInt(numberTexts[i].getText());

            if (isPerfect(number)) {
                startBlinking(numberRectangles[i], Color.PURPLE);
            } else {
                resetHighlight(numberRectangles[i]);
            }
        }
        //startButtonBlinking(button);
        readFile("C:\\Users\\Vaibhav\\Desktop\\java\\NumberChecker\\src\\perfect_no.txt");
    }

    private void startBlinking(Rectangle rectangle, Color color) {
        stopBlinking();
        resetHighlight(rectangle);
        Glow glow = new Glow(0.7);
        glow.setInput(rectangle.getEffect());
        rectangle.setFill(color);
        rectangle.setEffect(glow);

        // Create a blinking effect
        KeyValue keyValue = new KeyValue(rectangle.opacityProperty(), 0.3);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
        blinkTimeline = new Timeline(keyFrame);
        blinkTimeline.setCycleCount(Timeline.INDEFINITE);
        blinkTimeline.setAutoReverse(true);
        blinkTimeline.play();
    }

    private void resetHighlight(Rectangle rectangle) {
        rectangle.setFill(Color.WHITE);
        rectangle.setEffect(null);
        if (blinkTimeline != null) {
            blinkTimeline.stop();
        }
        rectangle.setOpacity(1.0);
    }

    private void stopBlinking() {
        if (isBlinking) {
            if (blinkTimeline != null) {
                blinkTimeline.stop();
                isBlinking = false;
            }
        }
    }

    private boolean isPrime(int number) {
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

    private boolean isArmstrong(int number) {
        int originalNumber = number;
        int result = 0;
        int n = String.valueOf(number).length();

        while (number != 0) {
            int digit = number % 10;
            result += Math.pow(digit, n);
            number /= 10;
        }

        return result == originalNumber;
    }

    private boolean isPerfect(int number) {
        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }
        return sum == number && number != 1;
    }
/*    public static void main(String[] args) {
        launch(args);
    }*/
}
