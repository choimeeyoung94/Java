package chap09_interface.b_extends;

public class Main {
  public static void main(String[] args) {
    Computable computer = new Computer();
    
    System.out.println("전압: " + computer.VOLT);
    
    computer.powerOff();
    computer.powerOn();
    
    
    System.out.println(computer.add(1, 3));
    System.out.println(computer.div(4, 2));
    System.out.println(computer.mul(2, 5));
    System.out.println(computer.mod(4, 2));
    
  }
}
