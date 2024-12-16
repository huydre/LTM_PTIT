package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TongSo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN093;qNxxdZlh";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int byteRead = in.read(buffer);
        String s = new String(buffer, 0, byteRead);
        String[] arr = s.split("\\|");

    }
}
