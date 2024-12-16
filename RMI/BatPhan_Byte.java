package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BatPhan_Byte {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN093", "35YWmpsF");
        for (byte x:a) System.out.print(x + " ");
        System.out.println();
        String res = "";
        for (byte x: a) {
            StringBuilder tmp = new StringBuilder();
            int y = x;
            while (y > 0) {
                int z = y % 8;
                tmp.append(z);
                y /= 8;
            }
            res += tmp.reverse().toString();
        }
        System.out.println(res);
        byte[] ans = res.getBytes();
        sv.submitData("B21DCCN093", "35YWmpsF", ans);
    }
}
