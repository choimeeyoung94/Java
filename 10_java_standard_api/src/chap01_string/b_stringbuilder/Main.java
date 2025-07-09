package chap01_string.b_stringbuilder;

/*
 * java.lang.StringBuilder (JDK 1.5 이상)
 * 
 * 1. 가변 (mutable) 문자열을 효율적으로 처리하기 위해 제공되는 클래스
 * 2. 일반적으로 문자열을 반복적으로 연결하거나 수정할 때 사용한다
 * 3. String과 달리 문자열 변경할 때마다 새로운 문자열 객체를 생성하지 않기 때문에 성능이 뛰어나다
 * 4. 주요 특징
 *    1) 가변성 : 기존의 문자열을 직접 변경할 수 있다
 *    2) 싱글스레드 환경 : thread-safe 하지 않기 때문에 싱글스레드 환경에서만 사용한다
 *                         멀티스레드 환경에서는 java.lang.StringBuffer를 사용한다 (JDK 1.0)
 *                         StringBuilder와 StringBuffer는 동일한 메소드를 가지고 있다
 *    3) 문자열 비교 : Object 클래스의 equals() 메소드가 오버라이드 되어 있지 않기 때문에 문자열 비교를 할 수 없다
 *                     문자열 비교는 String으로 변경한 뒤 할 수 있다  (toString() 메소드 활용)
 *                     
 * */


public class Main {
  
  public static void main(String[] args) {
    
    // StringBuilder 객체 생성
    StringBuilder sb = new StringBuilder();
    
    // 문자열 연결
    sb.append("a");
    sb.append("b");
    sb.append("c");

    //String 객체로 변경
    String str = sb.toString();
    
    System.out.println(str);
    
    
    
    
    
  }
  
  
  
}
