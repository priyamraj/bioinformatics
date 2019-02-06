import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;
public class ApproxMatch{

    public static boolean isHam(String s1, String s2, int diff){
      int ans=0;
      for(int i=0;i<s1.length();i++){
        if(s1.charAt(i)!=s2.charAt(i)) ans++;
      }
      if(ans<=diff) return true;
      return false;
    }

    public static void main(String[] args) {
      MyScanner sc=new MyScanner();
      String small=sc.next();
      String big=sc.next();
      int diff=sc.ni();
      int m=big.length(), n=small.length();
      ArrayList<Integer> arr=new ArrayList<>();
      for(int i=0;i<m-n+1;i++){
        String toMatch=big.substring(i, i+n);
        if(isHam(toMatch, small, diff)) arr.add(i);
      }
      for(Integer x:arr) System.out.print(x+" ");
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