
// Print the starting points of a pattern occurences in a genome
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class PatternCount {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        String p = sc.next(); // Replace here
        String s = sc.next(); // Replace here
        // Run and copy-paste from terminal
        int m = s.length(), n = p.length();
        for (int i = 0; i < m - n + 1; i++) {
            String str = s.substring(i, i + n);
            if (str.equals(p))
                System.out.print(i + " ");
        }
        System.out.println();
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