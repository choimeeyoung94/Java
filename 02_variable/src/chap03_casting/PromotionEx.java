package chap03_casting;

public class PromotionEx {

  public static void main(String[] args) {
    
    /*
     * Promotion
     * 
     * 1. 데이터 타입 변환의 한 종류
     * 2. 별도 코드 없이 자동으로 수행하는 타입 변환
     * 3. 작은 데이터 타입을 큰 데이터 타입으로 자동 변환하는 과정을 의미 (크기가 아닌 데이터 표현 범위가 기준)
     * 4. 타입 변환 시 데이터 손실이 발생하지 않는다
     * */
    
    // 예시1) int -> long
    int i = 10;
    long l = i; // Promotion 자동으로 4바이트 짜리 int 값이 8바이트 짜리 long으로 바뀐다 (자동 변환)
    double d = l; // Promotion (자동 변환)
    System.out.println(i);
    System.out.println(l);
    System.out.println(d);
    
    char ch = '가'; 
    int iNum = ch;
    System.out.println(ch);
    System.out.println(iNum);
    
  }

}
