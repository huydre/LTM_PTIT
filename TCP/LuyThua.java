package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LuyThua {
    public static int mu(int a,int b) {
        int res = a;
        for (int i = 0 ; i < b ; i++) {
            res *= a;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.188.19.218",1604);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN093;nxMRj8z";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int byteRead = in.read(buffer);
        String s = new String(buffer, 0, byteRead);
        System.out.println(s);
        String []arr = s.split("//|");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(mu(a,b));
        int res = mu(a,b);
        out.write(String.valueOf(res).getBytes());
        out.flush();
        in.close();
        socket.close();
    }
}
