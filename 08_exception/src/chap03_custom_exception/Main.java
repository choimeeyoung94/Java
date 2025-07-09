package chap03_custom_exception;

public class Main {
  
  public static void customException() throws MyException { // customException() 메소드를 호출한 곳으로 MyException 예외 던지기
    // MyException 발생 후 예외 위임
    throw new MyException("예외메시지");
    
    
  }
  
  // 직접 예외 처리하기 (권장함)
  public static void main(String[] args) {
    try {
      customException();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  // JVM에게 예외 위임하기 (권장하지 않음)
//  public static void main(String[] args) throws MyException { // main메소드를 호출한 곳으로 MyException 예외 던지기
//    customException(); 
//  }
}
