
package ss.week7.cmdline;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	if (args[0] != null && args[1] != null && args.length <= 2) {
    		int port;
    		ServerSocket ss;
    		try {
    			port = Integer.parseInt(args[1]);
    		} catch (NumberFormatException e) {
    			port = 0;
    			e.printStackTrace();
    		}
    		try {
    			ss = new ServerSocket(port);
    			Socket s = ss.accept();
    			Peer peer = new Peer(args[0], s);
    			Thread streamInputHandler = new Thread(peer);
    			streamInputHandler.start();
    			peer.handleTerminalInput();
    			peer.shutDown();
    		
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
    
    

} // end of class Server
