package multicast;

import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class ReceiveM extends Thread {
	MulticastSocket sc;

	public ReceiveM(MulticastSocket sc) {
		this.sc = sc;
	}

	public void run() {
		try {
			while (true) {
				DatagramPacket pk = new DatagramPacket(new byte[1024], 1024);
				sc.receive(pk);
				String msg = new String(pk.getData(), 0, pk.getLength());
				System.out.println(msg);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
