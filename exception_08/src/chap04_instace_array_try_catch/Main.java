package chap04_instace_array_try_catch;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    
    Product product1 = new Product("양파1.5kg", 3000);
    Product product2 = new Product("고등어1손", 5000);
    Product product3 = new Product("한돈앞다리1kg", 15000);
    Product product4 = new Product("블랙앵거스살치살500g", 20000);
    Product product5 = new Product("꼬마돈까스", 9000);
    
    // Cart 진열하기
    Cart cart1 = new Cart();
    Cart cart2 = new Cart();

    // Customer 입장
    Customer customer = new Customer(500000);
    
    // Customer가 Cart 취득
    customer.setCart(cart1);
    
    // 쇼핑
    customer.addToCart(product1); 
    customer.addToCart(product2);
    customer.addToCart(product3); 
    customer.addToCart(product4);
    customer.addToCart(product5); 
    
    customer.removeFromCart(0);
    
    // 구매
    String receipt = customer.purchase();
   
    // 구매내역 확인
    if (receipt != null) {
      JOptionPane.showMessageDialog(null, receipt); // 구매 Product 목록 + 총 구매금액
      JOptionPane.showMessageDialog(null, "남은돈: " + customer.getMoney());
    }
  }
}
