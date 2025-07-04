package chap09_interface.b_extends;

/*
 * 인터페이스 상속
 * 
 * 1. 인터페이스는 다른 인터페이스를 상속 받을 수 있다
 * 2. 인터페이스 상속 시 extends 키워드를 사용한다
 * 
 * 
 * 
 * */


public interface Computable extends ElectronicProduct {
  
  int add(int a, int b);
  int sub(int a, int b);
  int mul(int a, int b);
  int div(int a, int b);
  int mod(int a, int b);
  
}
