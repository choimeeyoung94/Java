package chap02_loop;

public class DoWhileEx {

  public static void main(String[] args) {
    
    // 1~ 100 누적

    int total = 0;
    int x = 1;
    do {
      total += x++;
    } while (x <= 100);
    System.out.println(total);
  }

}
