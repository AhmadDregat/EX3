package Networking;

import java.io.*;
import java.net.*;
public class Client {
    // initialize socket and input output streams
		private Socket ss= null;
	private DataInputStream input =null ;
	private DataOutputStream output =null ;
    // constructor to put ip address (local host)  and port 
	public Client (String address , int port ) throws UnknownHostException, IOException {
		try{
			ss=new Socket(address, port);
			System.out.println("connected");
            // takes input from terminal 
			input =new DataInputStream(System.in);
            output   = new DataOutputStream(ss.getOutputStream()); 
		}catch (UnknownHostException e) {
			// TODO: handle exception
		System.out.println(e);
		}
		catch(IOException r){
			System.out.println(r);
			
		}
        // string to read message from input 
		String line ="";
        // keep reading until "bay" is input 
		while (!line.equals("bay")){
			try {
				line= input.readLine();
				output.writeUTF(line );
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			try {
				
				input.close();
				output.close();
				ss.close();
			}catch (IOException e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

			Client client =new Client("127.0.0.10", 5000);

		
	}

}
