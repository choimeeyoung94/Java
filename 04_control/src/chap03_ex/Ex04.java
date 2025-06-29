package chap03_ex;

public class Ex04 {

  public static void main(String[] args) {
    
    // 점수와 학년에 따른 합격 여부를 출력하세요.
    // 대학 1~2학년은 60점 이상이면 "합격"이고, 3~4학년은 70점 이상이어야 "합격"입니다.
    int year = 2;
    int grade = 65;
    String state = "불합격";
    
    if ((year >= 1 && year <= 2) && grade >= 60) {
    	state = "합격";
    	System.out.println("대학" + year + "학념, " + grade + "점" + state);
    } else if ((year >= 3 && year <= 4) && grade >= 70) {
    	state = "합격";
    	System.out.println("대학" + year + "학념, " + grade + "점" + state);
    }
    

  }

}
