package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DoiTien_Data {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService service = (DataService) rg.lookup("RMIDataService");
        String msv = "B21DCCN713", qCode = "fD9in1FP";
        int n = (int) service.requestData(msv, qCode);
        System.out.println(n);
        int tenCnt = 0 , fiveCnt = 0, twoCnt = 0, oneCnt = 0;
        tenCnt = n / 10;
        n %= 10;
        fiveCnt = n / 5;
        n %= 5;
        twoCnt = n / 2;
        n %= 2;
        oneCnt = n;
        String res = String.valueOf(tenCnt+fiveCnt+twoCnt+oneCnt) + "; ";
        for (int i = 0 ; i < tenCnt; i++) res += "10,";
        for (int i = 0 ; i < fiveCnt; i++) res += "5,";
        for (int i = 0 ; i < twoCnt; i++) res += "2,";
        for (int i = 0 ; i < oneCnt; i++) res += "1,";
        res = res.substring(0, res.length()-1);
        System.out.println(res);
        service.submitData(msv, qCode, res);
    }
}
