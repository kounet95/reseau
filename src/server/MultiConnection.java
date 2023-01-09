package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import mestreads.*;
import mestreads.ConnectionTread;

public class MultiConnection extends Thread {
	private int nbclient;

	public static void main(String[] args) {
		new MultiConnection().start();

	}
	
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(1010);
			System.out.println("attend la connection");
			while (true) {
				Socket s = ss.accept();
				++nbclient;
				System.out.println("le client:"+ s.getRemoteSocketAddress());
				System.out.println("creation d'un tread pour ce client");
				new ConnectionTread(s, nbclient).start();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	

}
