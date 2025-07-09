package chap08_abstract;

// 추상 클래스 (Abstract Class)
// 1. 추상 메소드를 1개 이상 보유한 클래스이다
// 2. abstract 키워드를 class 앞에 추가한다
// 3. 특징
//    1) 추상 클래스를 상속 받은 서브클래스들은 반드시 모든 추상 메소드를 오버라이드 해야 한다
//    2) 추상 클래스는 (객체)인스턴스를 생성할 수 없다 
// 추상 메소드로 인해 추상클래스화 된다
public abstract class Animal {
  
  // 추상 메소드 (Abstract Method)
  // 1. 본문이 없는 메소드
  // 2. 본문을 나타내는 코드 블록({})을 없애고, abstract 키워드를 추가한다
  // 3. 존재 이유: 서브 클래스 객체들이 호출하기 위해서 존재
	public abstract void move(); 
	
}
