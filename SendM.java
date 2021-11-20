package multicast;

import java.io.*;
import java.net.*;

public class SendM extends Thread {
	MulticastSocket sc;

	public SendM(MulticastSocket sc) {
		this.sc = sc;
	}

	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Donner votre login : ");
			String login = br.readLine();
			while (true) {
				String msg = br.readLine();
				msg = login + ">" + msg;
				InetAddress adr = InetAddress.getByName("224.10.10.10");
				DatagramPacket pk = new DatagramPacket(msg.getBytes(), msg.length(), adr, 5000);
				sc.send(pk);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
