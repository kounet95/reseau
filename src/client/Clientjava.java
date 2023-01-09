package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Clientjava {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Je me conecte au serveur");
				Socket socket=new Socket ("localhost",1010) ;
                InputStream is = socket.getInputStream(); 
				OutputStream os=socket.getOutputStream();
				/*
				Saisir un nombre au clavier
				*/
				Scanner scanner=new Scanner (System.in);
				System.err.println("Donner un nombre: ");
				int nb=scanner.nextInt();
				System.out.println("]'envoie le nombre"+nb+" au serveur");
				os.write(nb);
				System.out.println("J'attend la réponse du serveur..");
				int rep=is.read();
				System.out.println("Reponse du serveur est" + rep);
				
					}

}
