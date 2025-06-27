package chap01_branch;

public class IfEx {

  public static void main(String[] args) {
      
    // 짝수 홀수
    int num = 300;
    if (num % 2 == 0) {
       System.out.println(num + "는 짝수");
    } else {
      System.out.println(num + "는 홀수");
    }

    // 배수
    int y = 10;
    if (y % 3 == 0) {
        System.out.println(y + "는 3의 배수");
    } else {
      System.out.println(y + "는 3의 배수가 아니다");
    }
   
    // 학점 (A, B, C, D, F)
    int score = 90;
    int result; // 추천은 char grade;이다
    if (score >= 90) {
        result = 'A';
    } else if (score >= 80) {
        result = 'B';
    } else if (score >= 70) {
      result = 'C';
    } else if (score >= 60) {
      result = 'D';
    } else {
      result = 'F';
    }
    System.out.println(score + "점은 " + (char)result + "학점입니다.");
    
    
    
  }
}
