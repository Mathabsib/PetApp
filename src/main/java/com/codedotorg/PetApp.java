package com.codedotorg;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetApp {
    // Existing PetApp class code...
    /** The main window to display the app */
    private Stage window;
    
    /** The ImageView for displaying images */
    private ImageView imageView;

    public class App extends Application {
        public static void main(String[] args) {
            launch();
        }
    
        @Override
        public void start(Stage primaryStage) {
            String petName = askForPetName();
            PetApp virtualPet = new PetApp(primaryStage, 500, 500);
            virtualPet.startApp(petName, "Dog");
    
            // PetSelectionScene petSelectionScene = new PetSelectionScene(primaryStage);
            // petSelectionScene.startApp();
        }
    
        /**
         * Asks the user for a name for their pet.
         * 
         * @return the pet name as a string
         */
        private String askForPetName() {
            TextInputDialog dialog = new TextInputDialog("Fido");
            dialog.setTitle("Pet Name");
            dialog.setHeaderText("Enter a name for your pet:");
            dialog.setContentText("Pet Name:");
    
            Optional<String> result = dialog.showAndWait();
            return result.orElse("Fido"); // Default to "Fido" if no name is entered
        }
    }

    /**
     * Determines the pet type.
     * 
     * @return the pet type as a string
     */
    private String getPetType() {
        // Logic to determine the pet type
        // For simplicity, let's return "Cat" or "Dog"
        // This can be replaced with actual logic to get user input or configuration
        return "Cat"; // or "Dog"
    }   // Example usage
        handleUserInput("I love my cat");
    }

    /**
    }* Handles the user's input and sets the image to either a cat or a dog based on the input.
     * 
     * @param userInput the user's input
     */
    public void handleUserInput(String userInput) {
        userInput = userInput.toLowerCase();
        if (userInput.contains("cat")) {
            setImage("path/to/cat/image.png");
        } else if (userInput.contains("dog")) {
            setImage("path/to/dog/image.png");
        }
    }

    /**
     * Sets the image to the ImageView.
     * 
     * @param imagePath the path to the image
     */
    private void setImage(String imagePath) {
        Image image = new Image(imagePath);
        imageView.setImage(image);
    }
}public class PetApp {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene to display in the app */
    private int width;

    /** The height of the scene to display in the app */
    private int height;

    /**
     * Constructs a new PetApp object with the specified window, width, and height.
     *
     * @param window the Stage object representing the application window
     * @param width the width of the application window
     * @param height the height of the application window
     */
    public PetApp(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        window.setTitle("Virtual Pet");
    }

    /**
     * Returns the window of the PetApp.
     *
     * @return the window of the PetApp
     */
    public Stage getWindow() {
        return window;
    }

    /**
     * Returns the width of the pet.
     *
     * @return the width of the pet
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the pet.
     *
     * @return the height of the pet
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Starts the pet application with the given name and pet type.
     * Creates a new MainScene object with the given parameters and shows the main scene.
     *
     * @param name the name of the pet owner
     * @param petType the type of pet
     */
    public void startApp(String name, String petType) {
        MainScene mainScene = new MainScene(window, width, height, name, petType);
        mainScene.showMainScene();
    }

    /**
     * Sets the current layout as the root of a new scene, sets the scene
     * to the window, and shows the window.
     * 
     * @param currentLayout the layout to be set as the root of the new scene
     */
    public void setAndShowScene(VBox currentLayout) {
        Scene currentScene = new Scene(currentLayout, width, height);
        currentScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        
        window.setScene(currentScene);
        window.show();
    }

}
