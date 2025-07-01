package chap03_ex;

import java.util.Arrays;

public class Ex05 {

  public static void main(String[] args) {
    
    // 다음 정수형 배열이 오름차순으로 정렬되어 있으면 
    // boolean result 변수에 true, 아니면 false를 저장하세요.
    
    int[] numbers = {1, 2, 3, 4, 5, 0};

    boolean result = true;
    
    for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
            result = false; 
        }
        
    }
    System.out.println(result);
    System.out.println(Arrays.toString(numbers));
  }
}
