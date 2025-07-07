package chap02_exception_propagation;

public class Main {
  public static void main(String[] args) {
    
    try {
      String x = "1.5";
      String y = "0.5";
      
      System.out.println(Calculator.add(x, y));
      System.out.println(Calculator.sub(x, y));
      System.out.println(Calculator.mul(x, y));
      System.out.println(Calculator.div(x, y));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
