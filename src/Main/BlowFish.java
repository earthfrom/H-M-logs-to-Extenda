
package Main;

import java.io.File;
import java.io.PrintWriter;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

//https://edwin.baculsoft.com/2013/02/a-simple-blowfish-encryption-decryption-using-java/


public class BlowFish 
{
     File newFile = new File(System.getProperty("user.home") + "//credentials.txt");
        
      void encrypt(String username, String password) throws Exception {
          System.out.println(newFile);
        byte[] keyData = (username+password).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(password.getBytes());
        
        try(  PrintWriter out = new PrintWriter( newFile )  )
        {
        out.println( new BASE64Encoder().encode(hasil) );
}
        
        
      
    }
     
      void decrypt(String string) throws Exception {
        byte[] keyData = ("edwin"+"password").getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(new BASE64Decoder().decodeBuffer(string));
        System.out.println(new String(hasil));
    }  
    
    
}
