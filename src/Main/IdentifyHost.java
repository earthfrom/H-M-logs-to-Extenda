
package Main;

//another commit

    //IDENTIFY WHERE USER WANTS TO CONNECT
public class IdentifyHost
{
    
    String host;
    int aim;
    
    String IdentifyHost(String target)
    {
        
        
        //till or posserver
    if ((target.matches("......t..")) || (target.matches("......s1"))  )
        {
           host = target + "." + target.substring(0,6) + "." + target.substring(0,2); 
        }

    
        //centraloffice
    if (target.matches("p1.."))  
        {
            host = target + "." + "as0"+ 1 + "." + target.substring(0,2);  
        } 

        return host;
    }
    
    
    
}

