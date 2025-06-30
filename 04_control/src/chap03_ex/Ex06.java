package chap03_ex;

public class Ex06 {

  public static void main(String[] args) {
    
    // 100부터 1까지 역순으로 값을 출력하세요.
    // 한 줄에 숫자를 10개씩 출력하세요.
	  int count = 0;
  	for (int i = 100; i >= 1; i--) {
  		 if (count <= 10) {
  			 ++count;
  			 System.out.print(i + " ");
  		 } 
  		 
  		 if (count == 10){
  			 count = 0;
  			 System.out.println();
  		 }
  		 
  	}
    

  }

}
