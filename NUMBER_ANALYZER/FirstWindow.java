
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the primary window
        
        primaryStage.setTitle("MODULUS");
        StackPane primaryLayout = new StackPane();

        Image backgroundImage = new Image("img5.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        Image image = new Image("master.png");
        Image img = new Image("Vaibhav.jpg");
        primaryStage.getIcons().add(img);
        ImageView imageView = new ImageView(image);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

        Image image1 = new Image("team.png");

        ImageView imageView1 = new ImageView(image1);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

        imageView1.setFitWidth(500); // Set the desired width
        imageView1.setFitHeight(700);
        imageView.setFitWidth(500); // Set the desired width
        imageView.setFitHeight(700);

        primaryLayout.getChildren().add(backgroundImageView);

        Font buttonFont = Font.font("Times New Roman",15);
        Button switchButton = createGlowButton("LAUNCH PROJECT", Color.BROWN);
        switchButton.setFont(buttonFont);

        Vaibhav obj1 = new Vaibhav();
        
        switchButton.setOnAction(e -> obj1.nextWindow(primaryStage));

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
        vb2.setPadding(new Insets(100, 0, 100, 100));

        // primaryLayout.getChildren().add(vb2);
        primaryLayout.getChildren().add(vb1);
        primaryLayout.getChildren().add(vb2);
        primaryLayout.getChildren().add(vb);
   
        primaryLayout.setAlignment(Pos.CENTER_RIGHT);
        Scene primaryScene = new Scene(primaryLayout, 1366, 768);
        primaryStage.setScene(primaryScene);
       
        primaryStage.setResizable(false);
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