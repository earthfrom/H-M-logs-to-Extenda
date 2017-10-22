
package Main;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

public class SFTPchannel 

{   
   //ESTABILISH SFTP CHANNELL
      ChannelSftp getSFTPchannel(Session session)
      {
                Channel channel = null;
                ChannelSftp channelSftp = null;
            try 
            {
                channel = session.openChannel("sftp");
                channel.connect();
                channelSftp = (ChannelSftp) channel;
            }
            catch (Exception ex) {}  
            return channelSftp;
      }  
}
