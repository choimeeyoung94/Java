package chap04_instace_array_try_catch;

public class Cart {
  
  // 필드
  private Product[] products; // Product[] 배열 선언 (배열의 생성이 필요하다)
  private int count; // products 배열에 저장된 Product 개수
  private final int LIMIT = 100; // products 배열의 최대 길이 (final 상수 : 값을 바꿀 수 없다. 반드시 초기화가 필요하다. 관례상 대문자로 작성한다)
  
  // 생성자
  public Cart() {
    // new Cart() 실행 시 products 배열이 생성된다
    products = new Product[LIMIT];
  }
  
  // 메소드
  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
  
  public void addProduct(Product product) {
    // 예외 발생 후 예외 처리하기
    try {
      
      if (product == null) {
        throw new RuntimeException( "전달된 Product이 없습니다.");
      }
      
      if (count == LIMIT) {
        throw new RuntimeException("더 이상 Cart에 담을 수 없습니다.");
        
      }
      products[count++] = product;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
  }
  
  public Product removeProduct(int idx) {
    Product removed = null;
    try {
      
      if (count == 0) {
        throw new RuntimeException("Car가 비어있습니다.");
      }
      
      if (idx < 0 || idx >= count) {
        throw new RuntimeException(idx + "는 없는 인덱스 입니다.");
        
      }
      removed = products[idx]; // 삭제된 요소 (현재는 삭제될 요소)
      System.arraycopy(products, idx + 1, products, idx, count - idx - 1);
      products[--count] = null;
   
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e.getMessage());
    }
   
    // 삭제된 요소 반환
    return removed;  
  }
  
  
  
}
