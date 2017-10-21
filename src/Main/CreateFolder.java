
package Main;

import java.io.File;

public class CreateFolder 
{
    String pathtofolder;
    String createfolder(String foldername)
            
            
            
    {
        File folder = new File(System.getProperty("user.home") + "/Desktop/" + foldername);
        
        
            // if the directory does not exist, create it
            if (!folder.exists()) 
            {
                boolean result = false;
                try
                {
                    folder.mkdir();
                    pathtofolder = folder.getAbsolutePath();
                    result = true;
                } 
                catch(SecurityException se){}  
                if(result) {}
            }
            
 return pathtofolder;
    
    }
}