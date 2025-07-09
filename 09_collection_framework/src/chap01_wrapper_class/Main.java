package chap01_wrapper_class;

/*
 * Wrapper Class
 * 
 * 1. 기본 타입(Primitive Type) 데이터를 참조 타입(Reference Type)으로 다뤄야 할 때 사용하는 클래스
 * 2. 기본 타입 값을 객체로 감싸서 객체처럼 사용할 수 있다
 * 3. 모든 Wrapper Class는 java.lang 패키지에 포함되어 있다
 * 4.박싱(Boxing)& 언박싱(UnBoxing)
 *   1) 박싱   : 기본 타입 값을 Wrapper 객체로 변환하는 과정
 *   2) 언박싱 : Wrapper 객체에서 기본 타입 값을 꺼내는 과정
 * 5. JDK 1.5 이상에서는 컴파일러가 자동으로 박싱/언박싱을 지원해준다 (Auto Boxing/Auto UnBoxing)
 * 
 * 
 * */



public class Main {
  public static void main(String[] args) {
    
    
    // Wrapper Class를 이용해 기본 타입 값 저장하기 (Auto Boxing)
    Byte a = 1;
    Short b = 2;
    Integer c = 3; 
    Long d = 4L;
    Float e = 5.0F;
    Double f = 6.0;    
    Character g = 'A';
    Boolean h = true;
    
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);
    System.out.println(f);
    System.out.println(g);
    System.out.println(h);
    
    // Wrapper 객체에서 기본 타입 값을 꺼내기 (Auto UnBoxing)
    int x = c;
    System.out.println(x);
    
    
    
    
  }
}
