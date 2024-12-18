package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TongSoNguyen_ByteStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN093;M4TAWEbG";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        String[] arr = s.split("\\|");
        int sum = 0;
        for (String x: arr) {
            sum += Integer.parseInt(x);
        }
        System.out.println(sum);
        out.write(String.valueOf(sum).getBytes());
        out.flush();

    }
}
