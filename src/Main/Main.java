package Main;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


 
public class Main extends Application 
	{
    
    
    
    @FXML TextField fjpass;
    @FXML TextField fjlogin;
  
        @Override
        
        public void start(Stage Stage) throws Exception
                {
                        Stage.setTitle("HM logs");
                        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
                        Scene scene = new Scene(root,280,266);
                        Stage.setScene(scene);
                        Stage.show();
                        
                        
                          Task task0 = new Task <Void>() 
        {  
           @Override protected Void call() throws Exception 
            { 
                
                Cache ch = new Cache();
                        //get login and password from file and insert them into TextFields
                        String[] logpas = ch.fromFile();
                        System.out.println(logpas[0]+"  "+logpas[1]);
                        
                          
                        fjlogin.setText(logpas[0]);
                        fjpass.setText(logpas[1]);
                                   
                           
                       
                        return null;
              
                
            }
       };
        

         Thread th0 = new Thread(task0);
  
         th0.setDaemon(true);
        
         th0.start();
         
                        
                        
                        
                        

                }

		public static void main(String[] args) throws IOException
			{
				launch(args);
                                
                             
			}
	}
