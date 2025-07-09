package chap01_exception.c_unchecked;

/*
 * Unchecked Exception
 * 
 * 1. 자바 컴파일러가 예외 처리를 강제하지 않는 예외를 의미한다
 * 2. 자바 컴파일러가 예외 처리를 강제하지 않기 때문에 try - catch 문을 생략할 수 있다
 *    (try - catch 문이 없어도 프로그램을 실행할 수 있다)
 * 3. java.lang.RuntimeException 예외 클래스와 그 하위 클래스들을 의미한다
 * 4. 주로 프로그래머의 실수나 잘못된 API 사용 등 논리적 오류로 인해 발생 한다
 * 5. 주요 Unchecked Exception
 *    1) NullPointerException : null 객체 참조 시 발생
 *    2) ArrayindexOutOfBoundsException : 배열의 인덱스가 사용 범위를 벗어난 경우 발생
 *    3) ArithmeticException : 산술 연산 오류 발생 시 발생
 *    4) ClassCastexception  : 잘못된 클래스 타입으로 캐스팅 시 발생
 *    5) NumberFormatException : 잘못된 형식의 문자열을 숫자로 변환할 때 발생
 *런타임 에러는 언체크드 익셉션 이다
 * */


public class Main {

  public static void firstCharacter(String str) {
    System.out.println("첫 문자: " + str.charAt(0));
  }
  
  
  public static void main(String[] args) {
    firstCharacter("Hello");
    firstCharacter(null);
  }

}
