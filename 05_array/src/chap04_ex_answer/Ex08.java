package chap04_ex_answer;

public class Ex08 {

  public static void main(String[] args) {
    
    // 아래 apt 배열에는 각 가구당 인원수가 저장되어 있습니다.
    // 각 층마다 총 몇 명이 거주하는지 출력하세요.
    // 출력 예시)
    // 1층 : 7명
    // 2층 : 7명
    // ...
    
    int[][] apt = {
        {2, 5},  // 1층에 2명, 5명 거주
        {3, 4},
        {1, 4},
        {2, 3},
        {3, 3}
    };
    
    for(int i = 0; i < apt.length; i++) {
      int total = 0;
      for(int j = 0; j < apt[i].length; j++) {
        total += apt[i][j];
      }
      System.out.println((i + 1) + "층 : " + total + "명");
    }
    
  }
  
}
