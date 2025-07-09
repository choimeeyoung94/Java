package chap01_is_a;

public class Main {

  public static void main(String[] args) {
    
     // Student
     Student student = new Student();
     student.eat();
     student.sleep();
     student.sleep();
     System.out.println();
     
    // Worker
     Worker worker = new Worker();
     worker.eat();
     worker.sleep();
     worker.startWork();
     worker.finishWork();
     System.out.println();
    
    
    // Developer
    Developer developer = new Developer();
    developer.eat();
    developer.sleep();
    developer.startWork();
    developer.finishWork();
    developer.develop();
    System.out.println();
    
    // Designer
    Designer designer = new Designer();
    designer.eat();
    designer.sleep();
    designer.startWork();
    designer.finishWork();
    designer.design();
    System.out.println();
  }

}
