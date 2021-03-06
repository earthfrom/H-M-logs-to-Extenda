package Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import java.io.*;
import com.jcraft.jsch.*;
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


    //Actions after user presses Download 
    @FXML protected void go(ActionEvent event) throws IOException
    {
      
       final  File folder = new File(System.getProperty("user.home") + "/Desktop/" + target.getText());

       
       
       //copy login and password to file
       Cache ch = new Cache();
       ch.toFile(fjlogin.getText(), fjpass.getText());
 
     

       
       
       //get login and password from file and insert them into TextFields
       String[] logpas = ch.fromFile();
       System.out.println(logpas[0]+"  "+logpas[1]);
       fjlogin.setText(logpas[0]);
       fjpass.setText(logpas[1]);
       
       
    
       //make a folder
       CreateFolder cf = new CreateFolder();
       String path =  cf.createfolder(target.getText());
        
       //identify host
       IdentifyHost ih = new IdentifyHost();
       String hostC = ih.IdentifyHost(target.getText());
       System.out.println(hostC);
       
       //estabilish connection
       Connect c = new Connect();
       Session session = c.connect(fjlogin.getText(), fjpass.getText(), hostB ,hostC);
     
        //thread1 download pos.log
        Task task1;
        task1 = new Task <Void>() 
        {
            @Override protected Void call() throws Exception
            {
                Getposlog gpl = new Getposlog();
                gpl.downloadPoslog(session, date, folder);
                return null;   
            }
        };
        
        //thread2 download eps.log
        Task task2 = new Task <Void>() 
        {  
           @Override protected Void call() throws Exception 
            { 
                GetEPSlog gel = new GetEPSlog();
                gel.downloadPoslog(session, date, folder);
                return null;
            }
       };
        

         Thread th1 = new Thread(task1);
         Thread th2 = new Thread(task2);
         th1.setDaemon(true);
         th2.setDaemon(true);
         th1.start();
         th2.start();
       
       
       /* BETA NOT WORKING YET
         
         
        //five threads will be created inside this class
        GetPeripherlas gp = new GetPeripherlas();
        gp.downloadPeripherlas(session, date, folder);
        for (int j=0;j<5;j++)
           {
              System.out.println("Staring thread "+ j);
               gp.th[j] = new Thread(gp.arrtask[j]);
               gp.th[j].setDaemon(true);
               gp.th[j].start();
           }
        
       */
       
    
    }
}
 

  
      
       
  
