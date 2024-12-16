package WS;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SapXepNguyenAm_CharacterService {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN093" , qCode = "287kqeoG";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> arr = port.requestStringArray(msv, qCode);
        System.out.println(arr);
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return CntNguyenAm(o1) - CntNguyenAm(o2);
            }
        });
        System.out.println(arr);
        port.submitCharacterStringArray(msv, qCode, arr);
    }

    public static int CntNguyenAm(String s) {
        s = s.toLowerCase();
        int cnt = 0;
        for (Character x : s.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ) cnt++;
        }
        return cnt;
    }
}
