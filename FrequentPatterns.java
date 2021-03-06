
// Finding the frequency of a given pattern in a genome
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class FrequentPatterns {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        String s = sc.next();
        String p = sc.next();

        int m = s.length(), n = p.length();
        int cnt = 0;

        for (int i = 0; i < m - n + 1; i++) {
            String t = s.substring(i, i + n);
            if (t.equals(p))
                cnt++;
        }
        System.out.println(cnt);
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