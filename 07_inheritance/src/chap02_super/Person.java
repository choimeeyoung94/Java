package chap02_super;

public class Person {
  
  private  String name;

  public Person(String name) {
    super();
    this.name = name;
  }
  
  public void printInfo() {
    System.out.println("이름: " + name);
  }
  
  
}
