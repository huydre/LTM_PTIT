package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TanSoXuatHien_Character {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN093", "Z2QYoqU5");
        System.out.println(s);
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (Character x: s.toCharArray()) {
            int cnt = 1;
            if (map.containsKey(x)) {
                cnt = map.get(x);
                cnt += 1;
            }
            map.put(x, cnt);
        }
        String res = "{";
        for (Character x: map.keySet()) {
            if (map.get(x) > 0) {
                res += String.format("\"%c\": %d, ",x, map.get(x));
            }
        }
        res = res.substring(0, res.length()-2) + "}";
        System.out.println(res);
        sv.submitCharacter("B21DCCN093", "Z2QYoqU5", res);
    }
}
