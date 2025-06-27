package chap03_ex;

public class Ex01 {

  public static void main(String[] args) {
    
    // 정수형 변수 a와 b에 임의의 값을 저장한 뒤, 두 수의 합과 차를 출력하세요.
    // 차는 항상 양수 값으로 출력하세요.
    int a = 10;
    int b = 20;
    int sum = a + b;
    int minusResult = 0;
    if (a < b) {
      minusResult = b - a;
    } else {
      minusResult = a - b; 
    }
    System.out.println("두 수의 합: " + sum);
    System.out.println("두 수의 차: " + minusResult);

  }

}
