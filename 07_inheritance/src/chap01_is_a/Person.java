package chap01_is_a;

/*
 * A는 B이다 (is a 관계)
 * 
 * 학생은 사람이다   (자식)Student is a Person(부모)
 * 워커는 사람이다   (자식)Worker is a Person(부모)
 * 개발자는 워커이다 (자식)Developer is a Worker(부모)
 * 디자이너는 워커이다
 * */


public class Person {
    
  public void eat() {
    System.out.println("먹자");
  }
  
  public void sleep() {
    System.out.println("잔다.");
  }
  
}
