package chap04_instace_array_try_catch;

import javax.swing.JOptionPane;

public class Customer {

  // 필드
  private int money;
  private Cart cart;

  // 생성자
  public Customer(int money) {
    this.money = money;
  }

  // 메소드
  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    // 마이너스 money는 예외 발생 후 예외 처리
    try {
      if (money < 0) {
        throw new RuntimeException("머니는 음수 일 수 없습니다.");
      }
      this.money = money;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
   
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public void addToCart(Product product) {
    // 예외 발생 후 예외 처리
    try {
      if (cart == null) {
        throw new RuntimeException("cart를 먼저 준비하세요");
       }
       cart.addProduct(product);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void removeFromCart(int idx) {
    Product removed = cart.removeProduct(idx);
    if (removed != null) {
      JOptionPane.showMessageDialog(null, removed.getName() + "제품이 Cart에서 제거되었습니다.");
    }
  }
 
  public String purchase() {
    // 예외 발생 후 예외 처리
    String receipt = null;
    try {
      
      if (cart == null) {
        throw new RuntimeException("cart가 없어서 구매할 수 없습니다.");
      }
      
      int count = cart.getCount();
      if (count == 0) {
        throw new RuntimeException("cart에 담긴 Product이 없어서 구매할 수 없습니다.");
      }
      
      int total = 0; // 구매총액
      receipt = "구디마트 영수증\n";
      Product[] products = cart.getProducts(); // Cart에 저장된 Product[] 배열
      for (int i = 0; i < count; i++) { // 구매한 Product 개수만큼 반복
        Product product = products[i]; // 구매한 개별 Product
        // 구매총액에 누적
        int price = product.getPrice();
        total += price; // 개별 product의 가격
        
        receipt += product.getName(); // 구매내역을 영수증에 기록
        receipt += "......";
        receipt += price + "\n";
        // receipt += String.format("%-30s%10d\n", product.getName(),
        // product.getPrice(), price);
        // %30s: 문자열을 30자리 고정폭에 작성, 마이너스(-) 기호는 왼쪽 정렬을 의미
        // %10d: 정수를 6자리 고정폭으로 작성, 마이너스(-) 기호가 없으면 오른쪽 정렬을 의미
      }
      if (total > money) { // 돈이 부족한 상황
        receipt = null;
        throw new RuntimeException("돈이 부족해서 구매할 수 없습니다.");
      }
      money -= total; // 고객이 구매총액을 내고 구매 완료
      receipt += "구매총액....." + total + "\n";
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return receipt;
  }

}
