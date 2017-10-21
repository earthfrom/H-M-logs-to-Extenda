package Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.jcraft.jsch.*;
import javafx.application.Platform;
import javafx.concurrent.*;
import javafx.scene.text.Text;



public class Controller 
{
    @FXML TextField fjpass;
    @FXML TextField fjlogin;
    @FXML TextField target;
    @FXML DatePicker date;
    @FXML Text outputtext;
    @FXML Button button;
    String lff;
    String hostB = "10.239.255.20";

    public Controller() {
        
    }

    //Actions after user presses Download 
    @FXML protected void go(ActionEvent event)
    {
        
       //make a folder
       CreateFolder cf = new CreateFolder();
       String path =  cf.createfolder(target.getText());
        
       //identify host
       IdentifyHost ih = new IdentifyHost();
       String hostC = ih.IdentifyHost(target.getText());
       
       //estabilish connection
       Connect c = new Connect();
       Session session = c.connect(fjlogin.getText(), fjpass.getText(), hostB ,hostC);
     
    

  
       Task task1;
        task1 = new Task <Void>() 
        {
            @Override protected Void call() throws Exception
            {
               
                
                
                
                
                return null;   
            }
        };
       
       
       
              Task task2 = new Task <Void>() 
       {  
           @Override protected Void call() throws Exception 
            { 
               
                return null;
            }
       };
       
       
          
         Thread th1 = new Thread(task1);
         Thread th2 = new Thread(task2);
         th1.setDaemon(true);
         th2.setDaemon(true);
         th1.start();
         th2.start();
        
       
       
    }
}
