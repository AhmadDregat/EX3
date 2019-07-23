package Networking;
import java.io.*;
import java.net.*;
/**
 *These program only for the learning exam and not necessarily that it will compile
 * @author Ahmad dregat
 *@version geeksforgeeks
 */


public class Server {
	// initialize socket and input output streams 
	private	Socket socket =null ;
	private ServerSocket server =null ;
	private DataInputStream in =null;
	public Server(int port ){
		// starts server and waits for a connection
		try {
			server =new ServerSocket(port);
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 
			socket =server.accept();
			System.out.println("Client accepted"); 
			// takes input from the client socket 
			in =new DataInputStream( new BufferedInputStream(socket.getInputStream()));
			String line ="";
			// reads message from client until "Over" is sent 
			while (!line.equals("over ")) {
				try {
					line =in.readUTF();
					System.out.println(line );

				} catch (IOException e) {
					// TODO: handle exception
					System.out.println(e);
				}
				// close connection 
				socket.close();
				in.close();
			}



		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server server =new Server(5000);




	}

}
