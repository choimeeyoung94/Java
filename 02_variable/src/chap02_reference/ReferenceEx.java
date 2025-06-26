package chap02_reference;

public class ReferenceEx {

  public static void main(String[] args) {
    
    
    /*
     * Rererence Type
     * 1. 참조 타입이다
     * 2. 값이 아니라 데이터가 저장된 메모리의 참조값(주소값)을 저장하는 타입
     * 3. 종류 (Primitive Type이 아닌 모든 타입)
     *    1) 클래스 타입
     *    2) 배열 타입
     *    3) 인터페이스
     *    4) 열거 타입 등
     * */
    
    
    /*
     * 자바 메모리 구조
     * 1. 자바 프로그램이 실행 되면 JVM(Java Virtual Machine)이 여러 메모리 영역을 사용
     * 2. 자바 프로그램을 구성하는 모든 것(변수, 메소드, 클래스 등)들은 메모리에 저장된다
     * 3. 주요 영역
     *    1) 스택(Stack) 영역 : 변수가 저장되는 영역
     *    2) 힙(Heap) 영역    : 객체, 배열 등이 저장되는 영역
     *    3) 메소드(Method) 영역 : 클래스 정보, static 변수 등이 저장되는 영역
     * 4. 메모리 구조
     *    1) 1바이트 마다 참조값(주소값)을 부여한다
     *    2) 참조값은 16진수로 표기한다(0x 또는 0X로 시작하는 숫자)
     * 5. 자바는 실제 참조값(메모리의 주소값)을 직접 확인하거나 수정할 수 없다          
     *    
     * 
     * */
    
    
    // 가장 대표적인 참조 타입은 문자열을 저장하기 위한 String 클래스 타입
    String a = new String("Hello World"); // 변수 a                    : 스택 영역에 생성. "Hello World"가 저장된 메모리 참조값이 변수 a에 저장된다
    System.out.println(a);                // new String("Hello World") : 힙 영역에 저장. "Hello World" 자체가 저장된다
    System.out.println(a); // 자바에서는 참조값에 접근할 수 없으므로 참조값이 출력되지 않는다. 그냥 참조값을 통해 얻을 수 있는 "Hello World"를 출력
    System.out.println(System.identityHashCode(a)); // 참조값은 아니지만 유사한 값을 대신 확인 (참조값 유사한 값)

  }

}
