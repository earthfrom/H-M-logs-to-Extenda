
package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;





public class Cache
{
      File file = new File(System.getProperty("user.home") + "//credentials.txt");
      
      void toFile (String login, String password) throws IOException
      {
          BufferedWriter writer = new BufferedWriter (new FileWriter(file));
          writer.write(login+"\n"+password);
          writer.close();
      }

      String[]  fromFile() throws IOException 
      {  
          FileReader fr=null;
          BufferedReader br=null;
          try
          {
          fr = new FileReader( System.getProperty("user.home") + "//credentials.txt" );
          br = new BufferedReader(fr);
          }
          catch (Exception ex) {}
          String[] logpas = new String[2];
          
          logpas[0] = br.readLine();
          logpas[1] = br.readLine();
          
          return logpas;
      }
     
    
    
}


