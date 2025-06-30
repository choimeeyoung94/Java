package chap03_method_return;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Return ret = new Return();
    ret.methodA(-10);
    ret.methodA(0);
    
    int sum = ret.methodB(1, 2);
    System.out.println(sum);
    System.out.println(ret.methodB(1, 2));
    
    int[] numbers = ret.methodC(3);
    System.out.println(Arrays.toString(numbers));
    
    String carInfo = ret.methodD();
    System.out.println("methodsD's return: " + carInfo);
    
    
  }

}
