package javaSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) {
		
		try {
			
			Socket socket = new Socket("localhost", 1221);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());			
			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
			BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
			
			String clientMsg = "";
			String serverMsg = "";
			
			while (!clientMsg.equals("stop")) {
				clientMsg = bfReader.readLine();
				dOut.writeUTF(clientMsg);
				dOut.flush();
				serverMsg = dis.readUTF();
				System.out.println("Server message: " + serverMsg);
			}
			
			bfReader.close();
			dOut.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
