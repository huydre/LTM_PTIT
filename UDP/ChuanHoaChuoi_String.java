package UDP;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChuanHoaChuoi_String {
    public static void main(String[] args) throws Exception {
        DatagramSocket dg = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        String code = ";B21DCCN713;A5suXtXI";
    }
}
