package mestreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.lang.String;

public class ConnectionTread extends Thread{
	private Socket s;
	private int nbclient;
	private String ip;
	public ConnectionTread(Socket s, int nbclient) {
		this.s = s;
		this.nbclient = nbclient;
	}
 @Override
public void run() {
	 InputStream is;
	try {
		is = s.getInputStream();
		System.err.println("vous devez donne une chaine de caractere ");
		InputStreamReader  isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		ip = s.getRemoteSocketAddress().toString();
		System.out.println("la connection d'un client"+ nbclient);
		pw.println("bien vennue monsieur "+nbclient+"votre adresse est "+ ip);
		while (true) {
			String req = br.readLine();
			System.out.println("le clien dont ladresse est:"+ip+"a envoyer un message");
		    pw.println(req.length());	
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
		
}

}
