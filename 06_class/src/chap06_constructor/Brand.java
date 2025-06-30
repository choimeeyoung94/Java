package chap06_constructor;

public class Brand {
  String name;// 자동차 브랜드 이름
  String nation; // 자동차 브랜드 국적
  
  Brand(String name, String nation) {
    this.name = name;
    this.nation = nation;
  }
  
  void printInto() {
    System.out.println(name + ", " + nation);
  }
  
}
