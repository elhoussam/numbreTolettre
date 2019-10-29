package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import static me.elhoussam.mvn.generator.NumToLet.print ;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add( 
					new Image( getClass().getClassLoader().getResource("icon/converter.png").toString() )
						);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Nombre Generator");
			

			primaryStage.show();
			primaryStage.setOnCloseRequest(event -> { print("\nExit ...\n"); System.exit(0); });			
			primaryStage.setResizable(false);		
			primaryStage.setAlwaysOnTop(true);	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		print("Start\n");
		launch(args);
		print("End\n");
	}
}
