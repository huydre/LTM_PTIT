package UDP;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Student_DataType {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        String code = ";B21DCCN093;GjG253sm";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String s = new String(dpNhan.getData());
        System.out.println(s);
        String[] sTmp = s.trim().split(";");
        String rI = sTmp[0];
        int n = Integer.parseInt(sTmp[1]);
        String num = sTmp[2];
        int[] cnt = new int[100005];
        String[] tmp = num.trim().split(",");
        for (int i = 0 ; i < tmp.length; i++) cnt[Integer.parseInt(tmp[i])]++;
        String res = rI + ";";
        for (int i = 1 ; i <= n ; i++) {
            if (cnt[i] == 0) res+= String.format("%d,", i);
        }
        res = res.substring(0, res.length() - 1);
        System.out.println(res);

        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), address, port);
        socket.send(dpGui1);
    }
}
