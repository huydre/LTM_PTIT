package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class UCLN_BCNN {
    public static int UCLN(int a, int b) {
        if (b==0) return a;
        return  UCLN(a,a%b);
    }

    public static int BCNN(int a, int b) {
        return a*b/ UCLN(a,b);
    }
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.188.19.218", 1605);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN093;i9VhkNb";
        out.writeUTF(code);
        out.flush();
        int a = in.readInt();
        int b = in.readInt();
        System.out.println("a: " + a+ " b: " + b);
        int ucln = UCLN(a,b);
        System.out.println(ucln);
        out.writeInt(ucln);
        out.flush();
        int bcnn = BCNN(a,b);
        System.out.println(bcnn);
        out.writeInt(bcnn);
        out.flush();
        in.close();
        socket.close();
    }
}
