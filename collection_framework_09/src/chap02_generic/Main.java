package chap02_generic;




public class Main {
  public static void main(String[] args) {
    
    // Integer 저장용 Container
    Container<Integer> container1 = new Container<Integer>();
    container1.setItem(10);
    System.out.println(container1.getItem());
    
    Container<Double> container2 = new Container<Double>();
    container2.setItem(20.5);
    System.out.println(container2.getItem());
    
    Container<String> container3 = new Container<String>();
    container3.setItem("helloworld");
    System.out.println(container3.getItem());
    
    // 생성자 호출시 타입 파라미터 전달은 생략할 수 있다
    /*Container<Integer> container4 = new Container<>();
    Container<Double> container5 = new Container<>();
    Container<String> container6 = new Container<>();
.    */
  }
}
