package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class TungXucSac {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2206 );
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN123;DDKJG8E4";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] b = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            b[in.readInt()] += 1;
        }
        for (int i = 1; i <= 6 ; i++) {
            float res = (float) b[i] /n;
            System.out.println(res);
            out.writeFloat(res);
            out.flush();
        }
        in.close();
        socket.close();
    }
}
