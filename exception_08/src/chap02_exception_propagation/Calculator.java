package chap02_exception_propagation;

public class Calculator {
  
  public static double add(String x, String y) throws NumberFormatException{
    return Double.parseDouble(x) + Double.parseDouble(y); // java.lang.NumberformatException
  }                                                        // Unchecked이므로 예외 처리 및 예외 위임 코드 없어도 동작하지만
                                                           // 예외 위임 (throws) 코드를 작성해 본다
  public static double sub(String x, String y) throws NumberFormatException {
    
    return Double.parseDouble(x) - Double.parseDouble(y);
  }
  
  public static double mul(String x, String y) throws NumberFormatException {
    
    return Double.parseDouble(x) * Double.parseDouble(y);
  }
  
  public static double div(String x, String y) throws NumberFormatException {
    
    return Double.parseDouble(x) / Double.parseDouble(y);
  }
}
