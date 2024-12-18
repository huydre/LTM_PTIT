package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SoLaMa_Character {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv =(CharacterService) rg.lookup("RMICharacterService");
        String msv = "B21DCCN713", qCode = "RMfcdoR3";
        String s = sv.requestCharacter(msv, qCode);
        System.out.println(s);
        System.out.println(Convert(s));
        sv.submitCharacter(msv, qCode, Convert(s));
    }

    public static String Convert(String s) {
        int res = getValue(s.charAt(0));
        for (int i = 1 ; i < s.length(); i++) {
            if (getValue(s.charAt(i)) > getValue(s.charAt(i-1))) {
                res += getValue(s.charAt(i)) - 2*getValue(s.charAt(i-1));
            } else {
                res += getValue(s.charAt(i));
            }
        }
        return String.valueOf(res);
    }

    public static int getValue(Character c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }
}

// XXLDXMLMCC
// 10 10 50 500 10 1000 50 1000 100 100
// 20 50 500 10 1000 50 1000 100 100
// 30 500 10 1000 50 1000 100 100
// 470 10 1000 50 1000 100 100
// 480 1000 50 1000 100 100
// 520 50 1000 100 100
// 570 1000 100 100
//
