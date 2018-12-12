
// Finding all the most frequent k-mers in a genome
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class FrequentKmers {
    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        String s = sc.next();
        int k = sc.ni();

        ArrayList<String> ans = new ArrayList<>();
        int maxFreq = 0;

        HashMap<String, Integer> hs = new HashMap<>();

        for (int i = 0; i < s.length() - k + 1; i++) {
            String p = s.substring(i, i + k);
            if (hs.containsKey(p)) {
                int newFreq = hs.get(p) + 1;
                hs.put(p, newFreq);
                if (newFreq > maxFreq) {
                    ans.clear();
                    ans.add(p);
                    maxFreq = newFreq;
                } else if (newFreq == maxFreq) {
                    ans.add(p);
                }
            } else {
                hs.put(p, 1);
                int newFreq = 1;
                if (newFreq > maxFreq) {
                    ans.clear();
                    ans.add(p);
                    maxFreq = newFreq;
                } else if (newFreq == maxFreq) {
                    ans.add(p);
                }
            }
        }

        for (String x : ans)
            System.out.println(x);
    }

    /////////// TEMPLATE FROM HERE /////////////////
    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int ni() {
            return Integer.parseInt(next());
        }

        float nf() {
            return Float.parseFloat(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nd() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}