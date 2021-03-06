import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class SocketClient
{
    public static void main( String[] args ) throws IOException
    {
        String host = "192.168.0.107";
        int port = 80;
        Socket socket = null;
        
        Scanner consoleInput = new Scanner( System.in );
        /*
        System.out.println("請輸入Server端位址");
        host = consoleInput.nextLine();
        */
        try
        {
            socket = new Socket( host, port );
            DataInputStream input = null;
            DataOutputStream output = null;
            
            try
            {
                input = new DataInputStream( socket.getInputStream() );
                output = new DataOutputStream( socket.getOutputStream() );
//                output.writeInt(1);
//                output.flush();
                while ( true )
                {
                    System.out.println( input.readUTF() );
                    break;
                }
            }
            catch ( IOException e )
            {
            	System.out.println(e.toString());
                
            }
            finally 
            {
                if ( input != null )
                    input.close();
                if ( output != null )
                    output.close();
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        finally
        {
            if ( socket != null )
                socket.close();
            if ( consoleInput != null )
                consoleInput.close();
        }
    }
}
