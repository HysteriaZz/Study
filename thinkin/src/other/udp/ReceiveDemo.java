package other.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
public static void main(String[] args) throws IOException {
	DatagramSocket dgR = new DatagramSocket(5533);
	byte [] buf = new byte[1024];
	DatagramPacket dpR = new DatagramPacket(buf, buf.length);
	// 若未设置超时时间会一直死等
	dgR.setSoTimeout(60000);
	dgR.receive(dpR);
	// 获取发送者的ip
	String ip = dpR.getAddress().getHostAddress();
	String str = new String(dpR.getData(),0,dpR.getLength());
	System.out.println(ip+"--"+str);
	dgR.close();
	
}
}
