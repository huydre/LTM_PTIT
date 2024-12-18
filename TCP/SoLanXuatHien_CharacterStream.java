package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedHashMap;

public class SoLanXuatHien_CharacterStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        String code = "B21DCCN713;NTZesiAL";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.write(code);
        out.newLine();
        out.flush();
        String s = in.readLine();
        System.out.println(s);
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (Character x : s.toCharArray()) {
            if (map.containsKey(x)) {
                int cnt = map.get(x) + 1;
                map.put(x, cnt);
            } else {
                map.put(x, 1);
            }
        }
        String res = "";
        for (Character x : map.keySet()) {
            if (map.get(x) > 1) {
                res += x + ":" + map.get(x) + ",";
            }
        }
        System.out.println(res);

        out.write(res);
        out.newLine();
        out.flush();
    }
}

//b:2,R:2,J:4,Q:2,O:3,n:2,g:2,2:2,H:3,G:3,P:2,p:3,W:2,k:2,
//b:2,R:2,K:1,t:1,J:4,0:1,Q:2,O:3,u:1,n:2,g:2,Z:1,2:2,N:1,V:1,H:3,L:1,G:3,P:2, :2,3:1,8:1,p:3,a:1,U:1,W:2,Y:1,r:1,k:2,M:1,x:1,