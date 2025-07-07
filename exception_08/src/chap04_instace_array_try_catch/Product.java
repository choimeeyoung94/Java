package chap04_instace_array_try_catch;

public class Product {
   
  // 필드
  private String name;
  private int price;
    
  // 생성
  public Product() {}

  public Product(String name, int price) {
    this.name = name;
    this.price = price;
  }

  // 메소드
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
   // ----가격은 음수로 설정하면 예외가 발생합니다  
   try {
     if (price < 0) {
       throw new RuntimeException(price + "원은 잘못된 가격 입니다.");
     }
     this.price = price;
     
   } catch(Exception e) {
     System.out.println(e.getMessage());
   }
     

    
  }
}
