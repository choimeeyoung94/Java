package chap10_instance_array;

public class Main {

  public static void main(String[] args) {
    Bus bus = new Bus();
   
    bus.on(new Person("낸시"));
    bus.on(new Person("폴"));
    bus.on(new Person("제레미"));
    bus.on(new Person("캐서린"));
    bus.on(new Person("제시카"));
    
    bus.off(5);
    
    bus.on(new Person("앤드류"));
    
    bus.seatInfo();
  }
}
