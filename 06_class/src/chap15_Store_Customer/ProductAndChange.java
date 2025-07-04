package chap15_Store_Customer;

/**
 * 상품과 잔돈을 저장하는 상품앤잔돈(ProductAndChange) 클래스입니다.
 * 
 * 고객에게 전달할 상품 개수를 의미하는 int count 필드를 선언합니다.
 * 고객에게 전달할 잔돈을 의미하는 double change 필드를 선언합니다.
 * 
 * 모든 필드 정보를 전달 받는 생성자를 생성합니다.
 * 
 * 모든 필드에 대해서 Getter/Setter를 생성합니다.
 */

public class ProductAndChange {

  /* 구현 */
  private int count;
  private double change;
  
  public ProductAndChange(int count, double change) {
    this.count = count;
    this.change = change;
  }
  
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public double getChange() {
    return change;
  }
  public void setChange(double change) {
    this.change = change;
  }
  
  
  
}
