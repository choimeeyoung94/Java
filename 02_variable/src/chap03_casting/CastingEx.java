package chap03_casting;

public class CastingEx {

  public static void main(String[] args) {
    
    /*
     * Casting
     * 
     * 1. 데이터 타입 변환의 한 종류
     * 2. 개발자가 직접 변환할 타입을 명시하는 명시적 변환 과정을 의미한다
     * 3. 큰 데이터 타입을 작은 데이터 타입으로 강제 변환하는 과정을 의미한다
     * 4. 타입 변환 시 데이터 손실이 발생할 수 있다
     * */
    
    // int -> byte 변환
    int i = 256;       //                       이진값(비트값) : 100000000
    byte b = (byte)i; //-------- Casting       이진값(비트값) : 00000000
    //System.out.println(i);
   // System.out.println(b);
    
    // double -> long 변환
    double d = 1.9;
    long l = (long)d; // ------- Casting (실수 -> 정수 변환 시 소수 아래는 모두 손실)
    //System.out.println(l);
    //System.out.println(d);
    
    // int -> char
    int iNum = 48; // 48('0'), 65('A'), 97('a') 32('')
    char f = (char)iNum; // Casting (정수 -> 문자 변환시 정수를 코드값으로 가지는 문자로 변환)
    System.out.println(iNum);
    System.out.println(f);
  }

}
