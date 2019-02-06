//Find the most frequent k-mers with atmost d mismatches in a string alongwith reverse complement matching.
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;
public class MaxApproxMatchWithRevC{

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

    public static String reverseComplement(String x){
      StringBuilder str = new StringBuilder(x);
        str = str.reverse();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A')
                s += 'T';
            else if (str.charAt(i) == 'T')
                s += 'A';
            else if (str.charAt(i) == 'G')
                s += 'C';
            else if (str.charAt(i) == 'C')
                s += 'G';
        }
        return s;
    }
    public static void main(String[] args) {
      MyScanner sc=new MyScanner();
      String s=sc.next();
      int k=sc.ni();
      int d=sc.ni();
      
      HashMap<String, Integer> count=new HashMap<>();
      ArrayList<String> allNeighs=new ArrayList<>();

      for(int i=0;i<s.length()-k+1;i++){
        
        String window=s.substring(i, i+k);
        ArrayList<String> neighs=neighbours(window, d);

        for(String x:neighs){
          if(count.containsKey(x)) count.put(x, count.get(x)+1);
          else{allNeighs.add(x);count.put(x, 1);}
        } // end of x for loop

        String revC=reverseComplement(window);
        neighs=neighbours(revC, d);

        for(String x:neighs){
          if(count.containsKey(x)) count.put(x, count.get(x)+1);
          else{allNeighs.add(x);count.put(x, 1);}
        } // end of x for loop
      }

      ArrayList<String> answer=new ArrayList<>();
      int maxFreq=0;
      for(String x:allNeighs){
        if(count.get(x)>maxFreq){maxFreq=count.get(x);answer.clear();answer.add(x);}
        else if(count.get(x)==maxFreq){answer.add(x);}
      }

      for(String x:answer) System.out.println(x);
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