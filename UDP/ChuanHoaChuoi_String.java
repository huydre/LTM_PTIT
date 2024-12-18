package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChuanHoaChuoi_String {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        String code = ";B21DCCN713;A5suXtXI";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String data = new String(dpNhan.getData());
        String[] a = data.split(";");
        String requestid = a[0];
        String s = a[1];
        System.out.println(s);
        String[] arr = s.trim().split("\\s+");
        String ans = requestid+";";
        for (String x: arr) {
            String res = x.trim().substring(0,1).toUpperCase() + x.trim().substring(1).toLowerCase();
            ans += res + " ";
        }
        System.out.println(ans);
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), address, port);
        socket.send(dpGui1);
    }
}
