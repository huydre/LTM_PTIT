package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class XucXac_DataStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN093;DDKJG8E4";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        System.out.println("n: "+ n);
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            int tmp = in.readInt();
            arr[tmp]++;
        }
        for (int i = 1 ; i <= 6 ; i++) {
            out.writeFloat((float) arr[i] / n);
            out.flush();
        }
    }
}
