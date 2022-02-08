package javaURL;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class MyURL {

	public static void main(String[] args) {
		String urlString = "https://www.google.com/";
		
		try {
			
			// Getting information of the example URL
			URL myUrl = new URL(urlString);
			System.out.println(myUrl.getProtocol());
			System.out.println(myUrl.getHost());
			System.out.println(myUrl.getDefaultPort());
			System.out.println(myUrl.getPath());
			System.out.println(myUrl.getAuthority());
			System.out.println(myUrl.getContent());	
			System.out.println("\n");	

			
			// Printing web page source in the console using URLConnection
			URLConnection urlConnection = myUrl.openConnection();
			InputStream inStream = urlConnection.getInputStream();
			int i = 0;
			while ((i = inStream.read()) != -1) {
				System.out.print((char)i);
			}
			System.out.println("\n");	
			
			
			// Getting the first 10 fields of the example URL header 
			HttpURLConnection huc=(HttpURLConnection)myUrl.openConnection();  
			for(i=1; i<=10; i++){  
				System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));  
			}  
			huc.disconnect();  
			System.out.println("\n");	

			
			// Getting IP details from the URL name string
			InetAddress inetAddress = InetAddress.getByName("www.google.com");
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
