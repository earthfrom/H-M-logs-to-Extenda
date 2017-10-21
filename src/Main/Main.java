package Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


 
public class Main extends Application 
	{
		@Override
		public void start(Stage Stage) throws Exception
			{
				Stage.setTitle("HM logs");
				Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
				Scene scene = new Scene(root,280,266);
				Stage.setScene(scene);
				Stage.show();
			}

		public static void main(String[] args) 
			{
				launch(args);
			}
	}
