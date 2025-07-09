package chap09_interface.e_marker_interface;

public class BloodCakeSoup implements Food {
    @Override
    public void howToEat() {
      System.out.println("선지 빼고 먹거나, 같이 먹습니다.");
    }
}
