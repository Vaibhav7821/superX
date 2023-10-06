package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the primary window
        primaryStage.setTitle("Primary Window");
        StackPane primaryLayout = new StackPane();

        Image backgroundImage = new Image("blackAba.jpeg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        Image image = new Image("tirthrup.jpg");

        ImageView imageView = new ImageView(image);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

        Image image1 = new Image("backIntro.png");

        ImageView imageView1 = new ImageView(image1);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

        imageView1.setFitWidth(600); // Set the desired width
        imageView1.setFitHeight(800);
        imageView.setFitWidth(600); // Set the desired width
        imageView.setFitHeight(800);
        // Set the desired heigh
        // Set the position of the HBox (move it to the right)

        // Add the ImageView to the container

        primaryLayout.getChildren().add(backgroundImageView);

        // Create a button to switch to another window
        // Button switchButton = new Button( "SwitchWindow", Color.CRIMSON);
        Font buttonFont = Font.font("Calibri", 20);
        Button switchButton = createGlowButton("LAUNCH PROJECT", Color.BROWN);
        switchButton.setFont(buttonFont);

        MainProject obj1 = new MainProject();
        switchButton.setOnAction(e -> obj1.nextWindow(primaryStage));
        // BorderPane.setMargin(switchButton, new Insets(10, 20, 300, 400));
        // StackPane primaryLayout = new StackPane();

        VBox vb = new VBox(100);
        vb.getChildren().add(switchButton);
        vb.setAlignment(Pos.BOTTOM_CENTER);
        vb.setPadding(new Insets(0, 0, 100, 0));

        VBox vb1 = new VBox(100);
        vb1.getChildren().add(imageView);
        vb1.setAlignment(Pos.CENTER_LEFT);
        vb1.setPadding(new Insets(0, 100, 0, 0));

        VBox vb2 = new VBox(100);
        vb2.getChildren().add(imageView1);
        vb1.setAlignment(Pos.CENTER_RIGHT);
        vb2.setPadding(new Insets(100, 0, 0, 100));

        // primaryLayout.getChildren().add(vb2);
        primaryLayout.getChildren().add(vb1);
        primaryLayout.getChildren().add(vb2);
        primaryLayout.getChildren().add(vb);
        // primaryLayout.getChildren().add(imageView);
        primaryLayout.setAlignment(Pos.CENTER_RIGHT);
        Scene primaryScene = new Scene(primaryLayout, 1366, 768);
        primaryStage.setScene(primaryScene);
        // borderPane.setRight(switchButton);

        // Show the primary window
        primaryStage.show();
    }

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
    };

    public static String toHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    };

    public static void main(String[] args) {
        launch(args);
    }
}