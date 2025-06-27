package chap02_loop;

public class ForEx {

  public static void main(String[] args) {
    
    // 1 ~ 100 누적하기
    int total = 0;
    for (int x = 1; x <= 100; x++) {
      total += x;
    }
    System.out.println(total);
   
    // 1 ~ 100 홀수의 평균
    
    int oddTotal = 0;
    int oddCount = 0;
    double oddAverage;
    
    for (int x = 1; x <= 100; x+=2) {      
       oddTotal += x;
       oddCount += 1;
    }
    oddAverage = (double)(oddTotal) / oddCount; // oddTotal을 double로 casting 하면 oddCount는 double로 promotion 된다
    // 형변환을 안하면 int / int의 결과가 int가 되어서 소수점이 버려지게 된다
    // 따라서 강제형변환을 해줘야 정확한 평균 값이 계산된다
    System.out.println(oddAverage);
    
    
    
  }

}
