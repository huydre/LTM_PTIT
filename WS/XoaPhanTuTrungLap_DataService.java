package WS;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class XoaPhanTuTrungLap_DataService {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN713", qCode = "23E2jjJ2";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int x: a) set.add(x);
        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(set);
        System.out.println(set);

        port.submitDataIntArray(msv, qCode, res);
    }
}
