package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109",2209 );
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        String code = "B21DCCN123;151GNZvT";
        out.writeUTF(code);
        out.flush();

        Product product = (Product) in.readObject();
        String price = String.valueOf((int) product.getPrice());
        int sum = 0;
        for (int i = 0 ; i < price.length(); i ++) {
            sum += (int) price.charAt(i);
        }
        product.setDiscount(sum);
        out.writeObject(product);
        out.flush();
        in.close();
        socket.close();
    }
    public static class Product implements Serializable {
        private int id;
        private String name;
        private double price;
        private  int discount;
        public static final long serialVersionUID = 20231107;

        public Product(int id, String name, double price, int discount) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.discount = discount;
        }

        public double getPrice() {
            return price;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }
    }
}
