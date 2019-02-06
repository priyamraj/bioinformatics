// Find Skew values in DNA Strand
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class Skew {
    static ArrayList<Integer> ans=new ArrayList<>();
    
    public static void findSkew() throws IOException {
        int g=0, c=0, minSkew=Integer.MAX_VALUE;


        FileReader fr = new FileReader("/home/priyamraj/Downloads/dataset_7_6.txt"); 
  
        int i;
        int pos=1; 
        while ((i=fr.read()) != -1){
            if((char)i=='G') g++;
            else if((char)(i)=='C') c++;
            if(g-c < minSkew){
                ans.clear();
                ans.add(pos);
                minSkew=g-c;
            }
            else if(g-c==minSkew) ans.add(pos);
            pos++;
        }
    }
    public static void main(String[] args) throws IOException{
        MyScanner sc = new MyScanner();
        findSkew();
        for(Integer x:ans) System.out.print(x+" ");
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