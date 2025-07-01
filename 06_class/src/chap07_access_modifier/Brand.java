package chap07_access_modifier;

/*
 * Access Modifier (접근 지시자) 
 * 
 * 1. 클래스 내의 멤버(필드, 메소드)에 접근할 수 있는 권한을 의미한다
 * 2. 종류
 *    1) public     : 누구나 접근할 수 있다 (패키지가 달라도 접근할 수 있다)
 *    2) protected  : 동일 패키지에 있거나 상속 관계인 경우 접근할 수 있다
 *    3) default    : 동일 패키지에 있으면 접근할 수 있다 (default 키워드는 존재하지 않는다. package 권한 이라고도 한다. Access Modifier가 없는 경우 default 권한을 가진다)
 *    4) private    : 클래스 내부에서만 접근할 수 있다
 * 3. 멤버의 권한
 *    1) 필드       : private (정보 은닉) 
 *    2) 메소드     : public
 *    3) 생성자     : public 
 */

/*
 * import 
 * 
 * 1. 다른 패키지에 있는 클래스, 인터페이스, 라이브러리 등을 현재 소스 파일에서 사용할 수 있도록 불러오는 명령어
 * 2. 동일한 패키지에 있거나, java.lang 패키지에 있으면 import를 하지 않는다
 * 3. 다른 패키지에 있거나, java.lang 패키지에 없는 것들은 import를 해야 한다
 * 4. import 사용 예시
 *    1) 특정 클래스 import 
 *       import java.util.Arrays;
 *    2) 특정 패키지 전체 import 하기
 *       import java.util.*;
 * 5. 이클립스 import 정리 단축키
 *    Ctrl + Shift + O(대문자)
 * */

/*
 * 캡슐화 (Encapsulation)
 * 
 * 데이터(필드)와 기능(메소드)을 하나의 클래스로 묶고,
 * 데이터를 외부에서 직접 볼 수 없게 은닉하여 보호하고
 * 필요한 기능만 외부에 공개한다
 * */

/*
 * 필드에 간접적으로 접근하는 방법
 * 
 *  1. Getter
 *     1) 필드 값을 반환하는 메소드이다
 *     2) Getter의 이름은 "get + 필드" 또는 "is + 필드" 규칙을 따른다
 *  2. Setter
 *     1) 인자를 받아서 필드에 저장하는 메소드이다
 *     2) Setter의 이름은 "set + 필드" 규칙을 따른다
 */


public class Brand {
  private String name;
  private String nation;
  
  public Brand() {
//    name = "Benz";
//    nation = "Germany";
    this("Benz", "Germany");
  }
  
  public Brand(String name, String nation) {
    this.name = name;
    this.nation = nation;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public void printInfo() {
    System.out.println(name + ", " + nation);
  }  
}
