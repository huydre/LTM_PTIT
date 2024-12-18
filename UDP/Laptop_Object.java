package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Laptop_Object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        String code = ";B21DCCN713;E6Spt7XU";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(dpGui);
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String requestId = new String(dpNhan.getData(), 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();

        String[] name = product.getName().trim().split("\\s+");
        String cvName = name[name.length-1] + " ";
        for (int i = 1 ; i < name.length-1; i++) cvName += name[i] + " ";
        cvName += name[0];
        product.setName(cvName);

        StringBuilder quantity = new StringBuilder(String.valueOf(product.getQuantity()));
        quantity.reverse();
        System.out.println(quantity);
        product.setQuantity(Integer.parseInt(quantity.toString()));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(requestId.getBytes(), 0 , sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData,8, baos.size());
        DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length, address, port);
        socket.send(dpGui1);




    }
}
