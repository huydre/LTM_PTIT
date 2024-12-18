package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TachChuoi_CharacterStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        String code = "B21DCCN093;umNdj417";
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(code);
        writer.newLine();
        writer.flush();
        String s = reader.readLine();
        System.out.println(s);

        String res1 = "", res2 = "";
        for (Character x : s.toCharArray()) {
            if (Character.isAlphabetic(x) || Character.isDigit(x)) res1 += x;
            else res2 += x;
        }

        writer.write(res1);
        writer.newLine();
        writer.flush();
        writer.write(res2);
        writer.newLine();
        writer.flush();
    }
}
