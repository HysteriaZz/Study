package other.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendDemo {

	public static void main(String[] args) throws SocketException, IOException {
		DatagramSocket dgS = new DatagramSocket();
		byte [] buf = "发送数据成功".getBytes();
		DatagramPacket dpS = new DatagramPacket(buf, buf.length,InetAddress.getByName("63") , 5533);
		dgS.send(dpS);
		dgS.close();

	}
}
