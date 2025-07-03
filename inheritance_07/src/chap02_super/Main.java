package chap02_super;

public class Main {

  public static void main(String[] args) {
    Developer developer = new Developer("홍길동", new String[]{"java","python","c#", "flutter"});
    developer.printInfo();
  }

}
