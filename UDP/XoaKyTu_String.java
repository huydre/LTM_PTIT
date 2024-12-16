package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class XoaKyTu_String {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        String code = ";B21DCCN093;LhukCPio";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String s = new String(dpNhan.getData());
        System.out.println(s);
        String[] sTmp = s.trim().split(";");
        String requestId = sTmp[0];
        String str1 = sTmp[1];
        String str2 = sTmp[2];
        String res = "";
        for (int i = 0 ; i < str1.length(); i++) {
            int check = 1;
            for (int j = 0 ; j < str2.length(); j ++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    check = 0;
                    break;
                }
            }
            if (check == 1) {
                res += str1.charAt(i);
            }
        }
        res = requestId +";"+ res;
        System.out.println(res);

        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), address, port);
        socket.send(dpGui1);
    }
}
