
package Main;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.DatePicker;


public class Getposlog
{
   
    
    
    void downloadPoslog (Session session,DatePicker date,File folder) throws FileNotFoundException, IOException
    
    {
            //PREPARING WORKING PATH'S
            String posPath = System.getProperty("user.home") + "/Desktop/" + folder.getName() + "/" + "pos.log" + "." + date.getValue().toString();
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

            //READ FILE
            //timeStamp is TODAY date
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            //POS LOG DOWNLOAD ----------------------------------------------------------------
            BufferedInputStream bis = null;
            try
            {
                bis = new BufferedInputStream(channelSftp.get("pos.log"));
                if (!date.getValue().toString().equals(today)) //if we reading poslog not from today
                    {
                        String lff = "pos.log"+"." + date.getValue().toString();
                        try { bis = new BufferedInputStream(channelSftp.get(lff)); }
                        catch (Exception ex) {}
                    }
            }
            catch (Exception ex){}
			
            
          
            //CREATE LOCAL EMPTY FILE
            File newFile = new File(posPath);
            //WRITING FILE
        
            OutputStream os = new FileOutputStream(newFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int readCount;
  
            System.out.println("Writing... ");
          
            while ((readCount = bis.read(buffer)) > 0) 
            {
                bos.write(buffer, 0, readCount);
            }
            System.out.println("Writing Complete");
                                   
            //closing streams
            bis.close();
            bos.close();
            os.close(); 
    }
}
