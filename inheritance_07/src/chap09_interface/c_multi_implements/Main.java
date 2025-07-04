package chap09_interface.c_multi_implements;

public class Main {
  public static void main(String[] args) {
    
    Camera camera = new SmartPhone();
    camera.picture();
    
    ((Phone)camera).call();
    
    Phone phone = new SmartPhone();
    phone.call();
    ((Camera)phone).picture();
    
    SmartPhone smartPhone = new SmartPhone();
    smartPhone.call();
    smartPhone.picture();
    
    
  }
}
