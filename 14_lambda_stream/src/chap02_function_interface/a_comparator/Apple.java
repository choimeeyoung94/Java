package chap02_function_interface.a_comparator;

public class Apple {
  private double weight;

  public Apple(double weight) {
    super();
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Apple [weight=" + weight + "]";
  }
  
  
}
