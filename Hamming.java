// Find Hamming distance between two strings
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;
public class Hamming{
    public static void main(String[] args) {
      MyScanner sc=new MyScanner();
      String s1=sc.next();
      String s2=sc.next();

      int ans=0;
      for(int i=0;i<s1.length();i++){
        if(s1.charAt(i)!=s2.charAt(i)) ans++;
      }
      System.out.println(ans);
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

      String nextLine(){
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