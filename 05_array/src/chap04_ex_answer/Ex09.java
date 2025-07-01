package chap04_ex_answer;

public class Ex09 {

  public static void main(String[] args) {
    
    // 2단부터 9단까지 구구단을 2차원 배열에 저장하세요.
    
    /*
        gugudan[0][0] = "2x1=(2*1)"
        gugudan[0][1] = "2x2=(2*2)"
        gugudan[0][2] = "2x3=(2*3)"
        ...
        gugudan[1][0] = "3x1=(3*1)"
        gugudan[1][1] = "3x1=(3*1)"
        gugudan[1][2] = "3x1=(3*1)"
        ...
        ---------------------
        gugudan[i][j] = "(i+2)x(j+1)=((i+2)*(j+1))"
    */
    
    String[][] gugudan = new String[8][9];
    
    for (int i = 0; i < gugudan.length; i++) {
      for (int j = 0; j < gugudan[i].length; j++) {
        gugudan[i][j] = String.format("%dx%d=%d", i+2, j+1, (i+2)*(j+1));  // 첫 번재 인자에 있는 %d는 정수가 출력되는 자리임을 나타내고,
                                                                           // 두 번째 인자들이 순서대로 %d에 표시됩니다. 
      }
    }
    
    // 행 우선(row major) 방식으로 출력해 보기
    System.out.println("Row Major");
    for (int i = 0; i < gugudan.length; i++) {
      for (int j = 0; j < gugudan[i].length; j++) {
        System.out.print(gugudan[i][j] + "\t");
      }
      System.out.println();
    }
    
    // 열 우선(column major) 방식으로 출력해 보기
    System.out.println("Column Major");
    for (int j = 0; j < 9; j++) {
      for (int i = 0; i < 8; i++) {
        System.out.print(gugudan[i][j] + "\t");
      }
      System.out.println();
    }
    
  }
  
}
