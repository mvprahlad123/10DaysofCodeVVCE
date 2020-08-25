import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class Day7Solution {
    public static void main(String [] args) throws IOException {
        final int limit = 100;
        
        HashMap<Integer, ArrayList<String>> hmap = new HashMap<>(limit);
        for (int i = 0; i < limit; i++) {
            hmap.put(i, new ArrayList<String>());
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            
            String [] pair = br.readLine().split(" ");
            int key = Integer.parseInt(pair[0]);
            String value = (i < n/2) ? "-" : pair[1];
            
            ArrayList<String> list = hmap.get(key);
            list.add(value);
        }
        br.close();
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < limit; i++) {
            ArrayList<String> values = hmap.get(i);
            for (String str : values) {
                sb.append(str + " ");
            }
        }
        System.out.println(sb);
    }
}