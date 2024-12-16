package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

public class LonThuHai {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109",2206 );
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN123;4XNRzWzl";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int byteRead = in.read(buffer);
        String s = new String(buffer, 0, byteRead);
//        String s = "1,3,9,19,33,20";
        System.out.println(s);
        String []a = s.split(",");
        ArrayList<Integer> n = new ArrayList<>();
        for (String x: a) n.add(Integer.parseInt(x));
        Collections.sort(n);
        int res = n.get(n.size()-2);
        System.out.println(res);
        out.write(String.valueOf(res).getBytes());
        out.flush();
        in.close();
        socket.close();
    }
}
