package javaSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(1221);
			Socket socket = serverSocket.accept();
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());			
			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
			BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
			
			String clientMsg = "";
			String serverMsg = "";
			
			while (!clientMsg.equals("stop")) {
				clientMsg = dis.readUTF();
				System.out.println("Client message: " + clientMsg);
				serverMsg = bfReader.readLine();
				dOut.writeUTF(serverMsg);
				dOut.flush();				
			}
			
			dis.close();
			socket.close();
			serverSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
