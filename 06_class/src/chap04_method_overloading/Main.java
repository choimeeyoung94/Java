package chap04_method_overloading;

public class Main {
  public static void main(String[] args) {
    View view = new View();
    view.print(10);
    view.print(256.6);
    view.print(new String[] {"apple", "banana", "orange"});
    
    view.print(new Car());
  }
}
