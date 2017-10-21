
package Main;


public class IdentifyHost
{
    
    String host;
    int aim;
    
    String IdentifyHost(String target)
    {
    //IDENTIFY WHERE USER WANTS TO CONNECT
        //till 
    if (target.matches("......t.."))
    {
        aim = 1;
    }
        //posserver
    if (target.matches("......s1"))  
    {
        aim = 2;
    } 
        //centraloffice
    if (target.matches("p1.."))  
    {
        aim = 3;
    } 
        //error
    else{aim = 0;}
    
    switch (aim)
    {
        case 1: host = target + "." + target.substring(0,6) + "." + target.substring(0,2); 
        case 2: host = target + "." + target.substring(0,6) + "." + target.substring(0,2);
        case 3: host = target + "." + "as0"+ 1 + "." + target.substring(0,2); 
    }
    return host;
    }   
}
