package chap09_interface.e_marker_interface;

public class Main {
  public static void main(String[] args) {
   
    Person person = new Person();
    
    Hamburger hamburger = new Hamburger();
    person.eat(hamburger);
    
    Sashimi sashimi = new Sashimi();
    person.eat(sashimi);
    
    BloodCakeSoup bloodCakeSoup = new BloodCakeSoup();
    person.eat(bloodCakeSoup); 
   
    
    // 매개변수가 FavoriteFood인 경우 FavoriteFood 구현체만 넣을 수 있다
    person.favoriteEat(hamburger);
    person.favoriteEat(sashimi);
    //person.favoriteEat(bloodCakeSoup); // 컴파일 오류를 내고 싶다 (실행을 막고 싶다)
    
   }
}
