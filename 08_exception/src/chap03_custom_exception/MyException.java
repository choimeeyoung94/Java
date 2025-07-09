package chap03_custom_exception;

/*
 * 사용자 예외 클래스
 * 
 * 1. 기존에 만들어져 있는 예외 클래스를 사용하지 않고, 새로운 예외 클래스를 직접 만들어 사용
 * 2. 기존 예외 클래스로 처리하기 어려운 상황을 처리할 때 사용한다
   3. 생성 방법
      1) java.lang.Exception 클래스를 상속받는 클래스를 만든다
      2) 예외 클래스는 다른 곳으로 전송이 가능한 직렬화(Seriallizable) 객체이므로 serialVersionUID 값을 생성하길 권장
      3) 예외 클래스 이름이 Exception으로 끝나도록 한다
 * */

public class MyException extends Exception {

  @java.io.Serial // import를 생략할 수 있다
  private static final long serialVersionUID = 6836813439025494565L;
    
  public MyException(String message) {
    super(message);// Exception의 생성자를 호출하며 예외 메시지(String message)를 전달한다
    
    
  }
  
  
}
