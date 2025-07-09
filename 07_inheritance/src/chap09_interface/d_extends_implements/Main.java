package chap09_interface.d_extends_implements;

public class Main {
  public static void main(String[] args) {
    
    Domestic domestic = new JejuTour();
    domestic.foodTrip();
    ((Trip)domestic).sightseeing();

    JejuTour juJejuTour = new JejuTour();
    juJejuTour.foodTrip();
    juJejuTour.sightseeing();
    
    
  }
}
