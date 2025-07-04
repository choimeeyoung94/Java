package chap09_interface.e_marker_interface;

public class Person {
  
  public void eat(Food food) {
    food.howToEat();
  }
  
  public void favoriteEat(FavoriteFood favoriteFood) {
    ((Food)favoriteFood).howToEat();
  }
  
}
