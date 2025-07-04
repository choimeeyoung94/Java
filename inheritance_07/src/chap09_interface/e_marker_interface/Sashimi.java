package chap09_interface.e_marker_interface;

public class Sashimi implements Food, FavoriteFood {
  @Override
  public void howToEat() {
    System.out.println("회는 간장, 초장, 와사비 등과 함께 먹습니다.");
  }
}
