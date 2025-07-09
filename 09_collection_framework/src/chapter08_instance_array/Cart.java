package chapter08_instance_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Cart {
  
  // 필드
  private List<Map<String, Object>> products; // Product[] 배열 선언 (배열의 생성이 필요하다)

  
  // 생성자
  public Cart() {
    // new Cart() 실행 시 products 배열이 생성된다
    products = new ArrayList<Map<String, Object>>();
  }
  
  // 메소드
  public List<Map<String, Object>> getProducts() {
    return products;
  }

  public void setProducts(List<Map<String, Object>> products) {
    this.products = products;
  }
  
  public void addProduct(Map<String, Object> product) {
    if (product == null) {
      JOptionPane.showMessageDialog(null, "전달된 Product이 없습니다.");
      return;
    }
   
   products.add(product);
  }
  
  public Map<String, Object> removeProduct(int idx) {
    return products.remove(idx); // 삭제된 요소 반환
  }
  
  
  
}
