package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MaHoa_DataType {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        String code = ";B21DCCN713;kD0URZcQ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(dpGui);
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String[] s = new String(dpNhan.getData()).trim().split(";");
        System.out.println(s[1] + " " + s[2]);
        String res =  s[0] + ";";
        int k = Integer.parseInt(s[2]) % 26;
        for (Character x: s[1].toCharArray()) {
            //from a - z -> 97 to 133
            //from A - Z -> 65 to 91
            int tmp = (int) x;
            if (tmp >= 65 && tmp <= 91) {
                tmp = (tmp + k - 65) % 26 ;
                tmp += 65;
            } else if (tmp >= 97 && tmp <= 133) {
                tmp = (tmp + k - 97) % 26;
                tmp += 97;
            }
            res += String.valueOf((char) tmp);
        }
        System.out.println(res);

        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), address, port);
        socket.send(dpGui1);
    }
}
