package Main;
import java.io.IOException;
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

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("gui.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root,280,266);
                    Stage.setScene(scene);
                    Stage.show();
                    try 
                    {
                    //Read data from File
                    Cache ch = new Cache();
                    String[] credentials = ch.fromFile();
                    
                    //Update login&pass Textfields
                    
                    Controller cnt = loader.getController();
                    cnt.fjlogin.setText(credentials[0]);
                    cnt.fjpass.setText(credentials[1]);
                    }
                    catch(Exception fnf) {System.out.println("File not Found");}
                }

        
        
        
        
        
		public static void main(String[] args) throws IOException
                {
                 launch(args);
                }
	}
