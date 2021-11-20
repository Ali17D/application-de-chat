package multicast;

import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClientMcst extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress adr = InetAddress.getByName("224.10.10.10");
			MulticastSocket sc = new MulticastSocket(5000);
			sc.joinGroup(adr);
			SendM s = new SendM(sc);
			ReceiveM r = new ReceiveM(sc);
			s.start();
			r.start();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
