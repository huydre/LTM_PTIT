package WS;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

import java.util.*;

public class LonNhoThuK_DataService {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN093", qCode = "IxJ8bKhw";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        int k = a.get(0);
        Collections.sort(a);
        System.out.println(a);
        int nhoK = a.get(k) , lonK = a.get(a.size() -k);
        List<Integer> res = new ArrayList<>(Arrays.asList(lonK, nhoK));
        System.out.println(res);
        port.submitDataIntArray(msv, qCode, res);
    }
}

