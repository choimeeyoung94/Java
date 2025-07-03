package chap01_is_a;

/*Person을 확장한 클래스가 Student이다
 * 기본적으로 자식이 부모보다 기능이 더 많다
 * 자식은 부모의 기능도 가지고 있다
 * 코드의 재사용성이 좋아진다
 * 부모클래스를 super라고 부른다*/
public class Designer extends Worker {
  
  public void design() {
    System.out.println("디자인한다.");
  }
  
}
