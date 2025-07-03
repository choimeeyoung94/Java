package chap06_polymorphism;

public class Main {

  public static void main(String[] args) {
    
    // 치와와, 허스키에게 밥 주기
    Chihuahua chiuahua = new Chihuahua("뭉치");
    Husky husky = new Husky("초코");
    
    Person person = new Person();
    person.feedFood("개밥", chiuahua);
    person.feedFood("개껌", husky);
    

  }

}
