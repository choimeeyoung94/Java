package chapter09_instance_array;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    
    int x = Integer.parseInt("1");
    System.out.println(x + 1);
    
    double y = Double.parseDouble("1.5");
    System.out.println(y + 1);
    
    // 입력 대화상자 
    // showInputDialog()는 항상 String을 반환하므로 적절한 변환 과정이 필요할 수 있다
    String name = JOptionPane.showInputDialog("이름을 입력하세요");
    System.out.println("name: " + name);
    int age = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요"));
    System.out.println("age: " + age);
  }
}
