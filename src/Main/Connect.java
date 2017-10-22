package Main;
import com.jcraft.jsch.*;
import com.jcraft.jzlib.*;

public class Connect 
{
    
     Session session_ts,session_target ;
    
    
    Session connect(String user,String pass,String hostB,String hostC) {
        
        JSch jsch = new JSch();
       
    try 
    {
        session_ts = jsch.getSession(user,hostB, 22);
        session_ts.setConfig("StrictHostKeyChecking", "no");
        session_ts.setPassword(pass);
        session_ts.setConfig("compression.s2c", "zlib@openssh.com,zlib,none");
        session_ts.setConfig("compression.c2s", "zlib@openssh.com,zlib,none");
        session_ts.setConfig("compression_level", "9");
        System.out.println("The session has been established to "+ user +"@"+ hostB);
        session_ts.connect();
    }
    catch(Exception ex1){}
        
        
    try
    {
        int assinged_port = session_ts.setPortForwardingL(0, hostC , 22);
        System.out.println("portforwarding: "+ "localhost:"+assinged_port+" -> "+hostC +":"+22);
        session_target = jsch.getSession(user, "127.0.0.1", assinged_port);
        session_target.setPassword(pass);
        session_target.setHostKeyAlias(hostC);
        session_target.setConfig("StrictHostKeyChecking", "no");
        session_target.setConfig("compression.s2c", "zlib@openssh.com,zlib,none");
        session_target.setConfig("compression.c2s", "zlib@openssh.com,zlib,none");
        session_target.setConfig("compression_level", "9");
        session_target.connect();
        System.out.println("The session has been established to "+ user+"@"+hostC);
    }
    catch (Exception ex2){System.out.println(ex2);}
    
    return session_target;
    
    }
    
    
    
    
    
    
    
    
    
}
