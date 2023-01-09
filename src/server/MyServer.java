package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1010);
			System.err.println("j'attend la connection");
			Socket s = ss.accept();
			System.out.println("le client:"+ s.getRemoteSocketAddress());
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			System.err.println("vous devez donne un octet ");
			int nb = is.read();
			System.err.println("le traitement commence");
			int res = nb*9;
			System.err.println("le traitement ternine");
			os.write(res);
			os.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
