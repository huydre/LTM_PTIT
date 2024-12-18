package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TimGiaTriThieu_DataType {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        String code = ";B21DCCN076;HGWRIdEZ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String s = new String(dpNhan.getData());
        System.out.println(s);
        String[] data = s.split(";");
        int n = Integer.parseInt(data[1]);
        String[] arrStr = data[2].trim().split(",");
        int[] b = new int[n+1];

        for (String x: arrStr) {
            int tmp = Integer.parseInt(x);
            b[tmp]++;
        }
        String res = data[0]+";";
        for (int i = 1 ; i <= n ; i++) {
            if (b[i] <= 0) {
                res += String.valueOf(i) + ",";
            }
        }
        res = res.substring(0,res.length()-1);
        System.out.println(res);

        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), address, port);
        socket.send(dpGui1);
    }
}
