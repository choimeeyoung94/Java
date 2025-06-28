package chap03_ex;

public class Ex09 {

  public static void main(String[] args) {

    // 전체 구구단을 가로 방향으로 출력하세요.

    // 출력 예시
    // 2x1=2  3x1=3  ...  9x1=9
    // 2x2=4  3x2=6  ...  9x2=18
    // ...
    // 2x9=18 3x9=27 ...  9x9=81 
	  for (int i = 2; i <= 9; i++) {
	    	for (int j = 1; j <= 9; j++) {
	    		
	    		System.out.print(i + "*" + j + "=" + (i*j) + " ");
				if (j == 9) {
	    			System.out.println();
	    		}
	    	}
	    }
	    
    

  }

}
