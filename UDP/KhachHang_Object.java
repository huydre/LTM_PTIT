package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import UDP.Customer;

public class KhachHang_Object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket= new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        String code = ";B21DCCN093;NMdXhbCF";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length, address, port);
        socket.receive(dpNhan);

        String requestId = new String(dpNhan.getData(), 0, 8);
        System.out.println("RequestId: " + requestId);

        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer customer = (Customer) ois.readObject();
        System.out.println(customer.getName());

        //Xu ly ho ten
        String[] name = customer.getName().split("\\s+");
        String formatedName = name[name.length-1].toUpperCase() + ", ";
        for (int i = 0 ; i < name.length-1; i++) {
            formatedName += Character.toUpperCase(name[i].charAt(0)) + name[i].substring(1).toLowerCase() + " ";
        }
        customer.setName(formatedName.trim());

        //Xu ly ngay sinh
        String[] bday = customer.getDayOfBirth().trim().split("-");
        String formatedBday = bday[1] + "/" + bday[0] + "/" + bday[2];
        customer.setDayOfBirth(formatedBday);

        //Xu ly username
        String username = "";
        for (int i = 0 ; i < name.length - 1; i++) {
            username += name[i].toLowerCase().charAt(0);
        }
        username += name[name.length-1].toLowerCase();
        customer.setUserName(username);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();

        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(requestId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length, address, port);
        socket.send(dpGui1);
    }
}
