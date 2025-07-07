package chap01_exception.a_try_catch;

import javax.swing.JOptionPane;

/*
 * 예외 처리 (Exception Handling)
 * 
 * 1. 프로그램의 실행 중 발생할 수 있는 비정상적인 상황(예외 상황)에 대해 적절히 대응하는 것
 * 2. 발생한 예외로 인해서 프로그램이 비정상적으로 종료되는 것을 막을 수 있다
 * 3. 발생한 예외를 분석하여 예외의 원인을 파악하고 복구를 시도할 수 있다
 * 4. 기본 구문
 *    1) try 블록    : 예외 발생 가능성이 있는 코드를 작성하는 블록
 *    2) catch 블록  : 예외가 발생했을때 실행할 코드를 작성하는 블록
 * */

/*
 * 다중 catch 블록
 * 
 * 1. try 블록에서 발생한 예외는 catch 볼록에 순서대로 전달된다
 * 2. 발생한 예외를 받아주는 첫 catch 블록이 예외를 처리한다
 * 3. 상속 관계를 가진 예외 처리 시에는 반드시 자식 타입의 예외를 먼저 catch 블록으로 작성해야 한다
 * */

/*
 * java.lang.Exception
 * 
 * 1. 자바에서 예외를 처리하기 위한 최상위 클래스 중 하나
 * 2. 모든 예외 상황을 객체로 표현할 수 있도록 해주는 기반 클래스
 * 3. java.lang.throwable 클래스를 상속 한다
 * 4. 자바에서 발생하는 예외 대부분은 java.lang.Exception 클래스를 상속 받아서 구현되어 있다
 * 5. 주요 메소드
 *    1) getMessage() : 예외 메시지를 반환한다
 *    2) printStackTrace() : 예외 발생 위치를 추적하여 출력한다
 *    
 * 
 * */




public class Main {
  
  
  public static void tryCatch() {

    // 예외 발생 가능성이 있는 코드
    try {
      
      
      String input = JOptionPane.showInputDialog("정수를 입력하세요.");
      int number = Integer.parseInt(input);
      System.out.println(number);
      
      
    } 
    
    // 예외 발생 시 동작하는 코드
    // try에서 발생한 예외를 저장하기 위한 매개변수가 필요하다
    catch(NumberFormatException e) {
      System.out.println("정수만 입력하세요.");
    }
    
  }
  
  public static void multiCatch() {
    
    try {
      String[] inputs = {"10", "20", "3.0", "40"};
      int total = 0;
      for (int i = 0; i <= inputs.length; i++) {
        total += Integer.parseInt(inputs[i]);
      }
      System.out.println("총합: " + total);
    } catch (NumberFormatException e) { // RuntimeException 하위 예외 타입
      System.out.println("정수값만 변환 후 누적할 수 있다");
    } catch (ArrayIndexOutOfBoundsException e) { // RuntimeException 하위 예외 타입                   
      
      System.out.println("사용할 수 없는 인덱스가 사용되었습니다.");
    }
    catch(RuntimeException e) { // RuntimeException 상위 예외 타입 
      System.out.println("알 수 없는 예외가 발생했습니다.");
    }   
  }
 
  public static void javaLangException() {
    
    try {
      int a = 10, b = 0; 
      
      System.out.println(a + b);
      System.out.println(a - b);
      System.out.println(a * b);
      System.out.println(a / b);
      
    } catch (Exception e) { // 거의 모든 예외를 받을 수 있는 java.lang.Exception 클래스
      // 1. 예외 클래스 확인하기
      String exception = e.getClass().getName();
      System.out.println(exception);
      
      // 2. 예외 메시지 확인하기
      String message = e.getMessage();
      
      System.out.println(exception + ": " + message);
    
      // 3. 예외 발생 위치 추적하여 출력하기 (개발중에는 printStackTrace 만 있으면 된다)
      e.printStackTrace();
    }
    
  }
  
  
  
  public static void main(String[] args) {
    //tryCatch();
    //multiCatch();
    javaLangException();
  }
}
