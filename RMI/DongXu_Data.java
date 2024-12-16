package RMI;

import javax.xml.crypto.Data;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DongXu_Data {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int a = (int) sv.requestData("B21DCCN093", "sbiY645B");
        System.out.println(a);

        int tenCount = a / 10;
        a %= 10;
        int fiveCount = a / 5;
        a %= 5;
        int twoCount = a / 2;
        a %= 2;
        int oneCount = a;
        String res = String.valueOf(tenCount + fiveCount + twoCount + oneCount) + "; ";
        for (int i = 0 ; i < tenCount; i++) res += "10,";
        for (int i = 0 ; i < fiveCount; i++) res += "5,";
        for (int i = 0 ; i < twoCount; i++) res += "2,";
        for (int i = 0 ; i < oneCount; i++) res += "1,";
        res = res.substring(0,res.length()-1);
        System.out.println(res);
        sv.submitData("B21DCCN093", "sbiY645B", res);
    }
}
