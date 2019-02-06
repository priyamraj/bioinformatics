
// Find all k-mers with distinct (l,t) clumps in the genome, where l is window length and t is threshold
// Basic method, (Run on ideone)
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class ClumpFinding {
    static HashSet<String> outputPatterns = new HashSet<>();

    public static void clumpFind(String genome, int k, int t) {
        HashMap<String, Integer> hs = new HashMap<>();
        ArrayList<String> distinctPatterns = new ArrayList<>();
        for (int i = 0; i < genome.length() - k + 1; i++) {
            String pattern = genome.substring(i, i + k);

            if (hs.containsKey(pattern)) {
                hs.put(pattern, hs.get(pattern) + 1);
            } else {
                hs.put(pattern, 1);
                distinctPatterns.add(pattern);
            }
        }

        for (String s : distinctPatterns) {
            if (!outputPatterns.contains(s) && hs.get(s) >= t)
                outputPatterns.add(s);
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        String genome = sc.next();
        int k = sc.ni(), l = sc.ni(), t = sc.ni();

        for (int i = 0; i < genome.length() - l + 1; i++) {
            String genomeWindow = genome.substring(i, i + l);
            clumpFind(genomeWindow, k, t);
        }
        Iterator<String> itr = outputPatterns.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println(genome.length());
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