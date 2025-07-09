package chap04_set;

import java.util.Objects;

public class Person {
  
  private String name;
  private int age;
  
  public Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  
  @Override
  public String toString() {
    return name + "(" + age + ")";
  }

  
  // HashSet 객체에 Person 객체를 저장할 때 오버라이드된 hashCode()와 equals()를 이용하여 
  // 기존에 저장되 Person 객체와 새로 저장하려는 Person 객체의 중복 여부를 판단한다
  // 먼저 hashCode() 메소드로 해시값을 비교하고 동일한 해시값을 가지고 있으면 equals() 메소드를 호출한다
  
  // 해시는 무슨 값이여도 상관없다
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    return age == other.age && Objects.equals(name, other.name);
  }
  
 
  
}
