package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ByteSteamEx {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109",2207 );
        String code = "B21DCCN093;gvAMAEDp";
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(code);
        out.flush();
        int x =  in.readInt();
        int y = in.readInt();
        System.out.println("a: " + x + " b: " + y);
        out.writeInt(x+y);
        out.flush();
        out.writeInt(x*y);
        out.flush();
        in.close();
        socket.close();
    }
}
