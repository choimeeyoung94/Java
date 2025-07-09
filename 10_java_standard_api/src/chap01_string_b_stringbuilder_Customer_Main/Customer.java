package chap01_string_b_stringbuilder_Customer_Main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    this.money = money;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public void addToCart(Map<String, Object> product) {
    if (cart == null) {
      JOptionPane.showMessageDialog(null, "cart를 먼저 준비하세요");
    }
    cart.addProduct(product);
  }

  public void removeFromCart(int idx) {
    Map<String, Object> removed = cart.removeProduct(idx);
    if (removed != null) {
      JOptionPane.showMessageDialog(null, removed.get("name") + "제품이 Cart에서 제거되었습니다.");
    }
  }
 
  public String purchase() {
    if (cart == null) {
      JOptionPane.showMessageDialog(null, "cart가 없어서 구매할 수 없습니다.");
      return null;
    }

    List<Map<String, Object>> products = cart.getProducts();
    int count = products.size();
    if (count == 0) {
      JOptionPane.showMessageDialog(null, "cart에 담긴 Product이 없어서 구매할 수 없습니다.");
      return null;
    }

    StringBuilder recipt = new StringBuilder("구디마트 영수증\n");
    
    int total = 0; // 구매총액
    for (int i = 0; i < count; i++) { // 구매한 Product 개수만큼 반복
      Map<String, Object> product = products.get(i); // 구매한 개별 Product
      // 구매총액에 누적
      int price = (int) product.get("price");
      total += price; // 개별 product의 가격

      recipt.append((String)product.get("name")); // 구매내역을 영수증에 기록
      recipt.append("......");
      recipt.append(price + "\n");
      // recipt.append().append().append();
    }
    if (total > money) { // 돈이 부족한 상황
      JOptionPane.showMessageDialog(null, "돈이 부족해서 구매할 수 없습니다.");
      return null;
    }
    money -= total; // 고객이 구매총액을 내고 구매 완료
    recipt.append((String) "구매총액....." + total + "\n");
    return recipt.toString();
  }

}
