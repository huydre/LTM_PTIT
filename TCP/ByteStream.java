package TCP;

import java.io.*;
import java.net.Socket;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN093;qNxxdZlh";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        int sum = 0;
        String []a = s.split("\\|");
        for (String x:a) sum += Integer.parseInt(x);
        out.write(String.valueOf(sum).getBytes());
        System.out.println("Result: " + sum);
        out.flush();
        in.close();
        socket.close();
    }
}
