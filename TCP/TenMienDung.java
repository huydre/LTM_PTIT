package TCP;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class TenMienDung {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN093;3pddEaFn";
        out.write(code);
        out.newLine();
        out.flush();
        String s = in.readLine();
        System.out.println(s);
        String []a = s.split(", ");
        ArrayList<String> arr = new ArrayList<>();
        String res = "";
        for (String x:a) {
            if (x.endsWith(".edu")) {
                arr.add(x);
            }
        }
        for (int i = 0 ; i < arr.size()-1; i ++) res += arr.get(i) + ", ";
        res += arr.get(arr.size()-1);
        System.out.println(res);
        out.write(res);
        out.newLine();
        out.flush();
        in.close();
        socket.close();
    }
}
