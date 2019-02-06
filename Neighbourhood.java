import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;
public class Neighbourhood{

    public static int hammingDistance(String s1, String s2){
      int ans=0;
      for(int i=0;i<s1.length();i++){
        if(s1.charAt(i)!=s2.charAt(i)) ans++;
      }
      return ans;
    }

    public static ArrayList<String> neighbours(String pattern, int d){
      ArrayList<String> ans=new ArrayList<>();
      if(d==0) {ans.add(pattern);return ans;}
      else if(pattern.length()==1) {
        ans.add("A");ans.add("G");ans.add("C");ans.add("T");
        return ans;
      }

      String suffix=pattern.substring(1);
      String prefix=""+pattern.charAt(0);
      ArrayList<String> suffixNeighbours=neighbours(suffix, d);

      for(int i=0;i<suffixNeighbours.size();i++){
        String endPart=suffixNeighbours.get(i);
        if(hammingDistance(endPart, suffix)<d){
          ans.add("A"+endPart);ans.add("G"+endPart);
          ans.add("T"+endPart);ans.add("C"+endPart);
        }
        else ans.add(prefix+endPart);
      } // end of neighbourhood loop
      return ans;
    } 

    public static void main(String[] args) {
      MyScanner sc=new MyScanner();
      String s=sc.next();
      int d=sc.ni();
      ArrayList<String> ans=neighbours(s,d);
      for(String x:ans) System.out.println(x);
      System.out.println(ans.size());
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