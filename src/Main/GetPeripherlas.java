
package Main;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.concurrent.Task;
import javafx.scene.control.DatePicker;


public class GetPeripherlas 
{
    
    Task arrtask[] = new Task[5] ;
    Thread th[] = new Thread[5];
    
    
   
   
    BufferedInputStream bis;
    String lff="peripheral.log";
    
    
    
    
    int k = 0;
    
    void downloadPeripherlas (Session session,DatePicker date,File folder) throws FileNotFoundException, IOException
    {
        
    
        //PREPARING WORKING PATH'S
        String peripheralfile= System.getProperty("user.home") + "/Desktop/" + folder.getName() + "/" + "peripheral.log" ;
        String remotePath = "/opt/extenda/posclient/logs/";

        //OBTAIN SFTP CHANNEL 
        SFTPchannel sc = new SFTPchannel();
        ChannelSftp channelSftp = sc.getSFTPchannel(session);

        try 
        { 
        channelSftp.cd(remotePath); 
        }
        catch (Exception ex) {}
        byte[] buffer = new byte[1024];
        
 
        
for (k=0;k<5;k++)
{
        
        arrtask[k] = new Task <Void>() 
        {  
           @Override protected Void call() throws Exception 
            { 
  
         


    try 
    {
        if (k==0){bis = new BufferedInputStream(channelSftp.get("peripheral.log"));}
        else { lff = "peripheral.log." + String.valueOf(k);}
        
        System.out.print("Looking for ");
        System.out.println(lff);
        bis = new BufferedInputStream(channelSftp.get(lff));

        //CREATE LOCAL EMPTY FILE
        File newFile = new File(peripheralfile+"."+String.valueOf(k));
        System.out.print("Local file created. ");
        System.out.println(peripheralfile+"."+String.valueOf(k));

        //WRITING FILE
        FileOutputStream os = new FileOutputStream(newFile);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        int readCount;

        System.out.println("Writing... ");
        while ((readCount = bis.read(buffer)) > 0) 
        {
            bos.write(buffer, 0, readCount);
        }
        System.out.println("Writing Complete");

        bis.close();
        bos.close();
        os.close();

    }
    catch (Exception e) {System.out.println(e);}
    
    
    
    
                          GetEPSlog gel = new GetEPSlog();
                gel.downloadPoslog(session, date, folder);
                return null;
            }
       };
        
}//end loop
        
        
        
     
   

         
             
    



    }
}
