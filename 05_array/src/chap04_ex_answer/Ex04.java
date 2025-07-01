package chap04_ex_answer;

import java.util.Arrays;

public class Ex04 {

  public static void main(String[] args) {
    
    // 다음 정수형 배열의 모든 요소들의 순서를 뒤집으세요.
    
    // 교환해야 할 요소 인덱스 분석하기
    //   numbers[0] --- numbers[7]
    //   numbers[1] --- numbers[6]
    //   numbers[2] --- numbers[5]
    //   numbers[3] --- numbers[4]
    //   -------------------------
    //   numbers[i] --- numbers[numbers.length - 1 - i]

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
    
    for (int i = 0; i < numbers.length / 2; i++) {
      int temp = numbers[i];
      numbers[i] = numbers[numbers.length - 1 - i];
      numbers[numbers.length - 1 - i] = temp;
    }
    
    System.out.println(Arrays.toString(numbers));
    
  }
  
}
