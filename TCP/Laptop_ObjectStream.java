package TCP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Laptop_ObjectStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2209 );
        String code = "B21DCCN093;gbCoJytL";
       ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
       ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
       out.writeObject(code);
       out.flush();
       Laptop laptop = (Laptop) in.readObject();
       System.out.println(laptop);

       String[] nameArr = laptop.getName().split("\\s+");
       String processedName = nameArr[nameArr.length-1] + " ";
       for (int i = 1; i < nameArr.length - 1; i++) processedName += nameArr[i] + " ";
       processedName += nameArr[0];
       laptop.setName(processedName);
       System.out.println(processedName);

       StringBuilder processedQuantity = new StringBuilder(String.valueOf(laptop.getQuantity()));
       processedQuantity = processedQuantity.reverse();
       laptop.setQuantity(Integer.parseInt(processedQuantity.toString()));
       System.out.println(processedQuantity);

       out.writeObject(laptop);
       out.flush();

    }
}
