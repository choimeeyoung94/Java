package chap09_interface.d_extends_implements;

// 클래스를 먼저 상속하고, 인터페이스를 나중에 구현한다

public class JejuTour extends Domestic implements Trip {

  @Override
  public void sightseeing() {
    // TODO Auto-generated method stub
    System.out.println("올레길");
  }

  @Override
  public void foodTrip() {
    // TODO Auto-generated method stub
    System.out.println("감귤 초콜릿");
  }
    
}
