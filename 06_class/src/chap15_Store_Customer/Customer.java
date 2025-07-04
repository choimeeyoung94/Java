package chap15_Store_Customer;

/**
 * 상품을 구매하는 고객(Customer) 클래스입니다.
 * 
 * 구매한 상품을 저장할 int count 필드를 선언합니다.
 * 고객이 가진 돈을 저장할 double money 필드를 선언합니다.
 * 
 * 모든 필드 정보를 전달 받는 생성자를 생성합니다.
 * 
 * 모든 필드에 대해서 Getter/Setter를 생성합니다.
 * 
 * 구매 메소드를 생성합니다. 구매 메소드의 세부 내용은 Customer 클래스 본문을 참고하세요.
 */
public class Customer {

  /* 구현 */
  private int count = 0;
  private double money = 0;
  
  public Customer(int count, double money) {
    this.count = count;
    this.money = money;
  }
  
  public int getCount() {
    return count;
  }
  
  public void setCount(int count) {
    this.count = count;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  /**
   * 구매 메소드입니다. 
   * 고객이 가지고 있는 돈 이상을 상점에 지불할 수는 없습니다.
   * 
   * @param store 상품을 구매하기 위해서 고객이 들어간 상점(Store)입니다.
   * @param count 몇 개의 상품을 구매하는지 그 개수(count)를 의미합니다.
   * @param money 구매를 위해 상점에 내는 돈(money)입니다.
   */
  public void purchase(Store store, int count, double money) {
    /* 구현 */
    
    if (this.money < money) {
      System.out.println("구매 실패. 현재 보유액: " + this.money + "원");
      return;
    }
    
    // 구매하기
    ProductAndChange productAndChange = null;
    if (store != null) {
      productAndChange = store.sell(money, count);
    }
    
    // 구매확인
    if (productAndChange != null) {
      this.count += productAndChange.getCount();
      this.money -= (money - productAndChange.getChange());
      this.money += productAndChange.getChange();
    }
    
  }
  
}
