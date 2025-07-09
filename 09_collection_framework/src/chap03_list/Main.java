package chap03_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Collection 인터페이스
 * 
 * 1. 자바 컬렉션 프레임워크(JCF)의 핵심 인터페이스
 * 2. 데이터의 집합(여러 데이터)을 다루는 기본 동작을 제공
 * 3. Iterable(반복할 수 있는) 인터페이스의 하위 인터페이스로 for-each와 같은 반복문에서 활용할 수 있다
 * 4. List, Set, Queue 인터페이스의 상위 인터페이스로 해당 인터페이스들의 공통 동작(추가, 삭제 등)을 추상화한다
 * 5. 제네릭(Generic)을 지원하여 타입 안정성을 보장
 * 6. 주요 메소드
 *    1) int size() 저장된 요소의 개수 반환
 *    2) boolean isEmpty() 컬렉션 비어 있으면 true 반환
 *    3) boolean contains(Object o) 모든 객체를 전부 저장하겠다(만능타입) - 전달된 객체가 컬렉션에 포함되어 있으면 true 반환
 *    4) boolean add(E e) 전달된 객체 저장, 성공하면 true 반환
 *    5) boolean remove(Object o) 전달된 객체 삭제, 성공하면 true 반환
 * */

/*
 * List 인터페이스
 * 
 * 1. Collection 인터페이스의 하위 인터페이스이다
 * 2. 객체들을 저장할 때 저장된 순서를 유지한다 (인덱스를 사용한다)
 * 3. 중복된 데이터 저장이 가능하다
 * 4. 주요 구현 클래스
 *    1) ArrayList : 배열처럼 연속된 공간을 사용하는 리스트, 순회 강점, 추가/삭제 단점(삭제 하고 나서 뒤에 것을 앞으로 땡겨와야 한다) , 잦은 조회가 필요할때
 *    2) LinkedList : 서로 다른 공간을 참조로 연결해서 사용하는 리스트, 순회(조회)가 단점, 잦은 추가/삭제가 필요할때
 *    3) Vector : 컬렉션 프레임워크 이전의 클래스. 기존 메소드와 컬렉션 프레임워크 메소드가 섞여 있다
 * */

public class Main {
  
  public static void mutable() {
    // mutable : 저장된 요소의 개수를 변경할 수 있는 리스트 (크기는 자동 변경)
    List<String> seasons = new ArrayList<String>(); // 디폴트 크기: 10
    seasons.add("spring"); // 순서대로 저장
    seasons.add("summer");
    seasons.add("autumn");
    seasons.add("winter");
    
    System.out.println(seasons.size()); // 저장된 요소 크기 확인
    
    System.out.println(seasons.get(0)); // 요소 확인
    System.out.println(seasons.get(1)); // 요소 확인
    System.out.println(seasons.get(2)); // 요소 확인
    System.out.println(seasons.get(3)); // 요소 확인
  }
  
  public static void traversal() {
    List<String> seasons = Arrays.asList("spring","summer","autumn","winter");
    
    // 일반 for문 : size() 메소드 호출의 반복을 제거하기 위해서 초기화 영역에서 한 번만 호출한다
    for (int i = 0, length = seasons.size(); i < length; i++) {
      System.out.println(seasons.get(i));
    }
    
    // 향상 for문
    for (String season :  seasons) {
      System.out.println(season);
    }
  }
  
  public static void immutable() {
    // immutable : 저장된 요소의 개수를 변경할 수 없는 리스트
    List<String> seasons = Arrays.asList("spring","summer","autumn","winter");
    //seasons.add("aespa"); // 요소 추가 (실패)
    //seasons.remove(0);    // 인덱스 0 요소 삭제 (실패)
    seasons.set(0, "봄"); // 인덱스 0 요소 수정 (성공)
    seasons.set(1, "여름"); // 인덱스 0 요소 수정 (성공)
    seasons.set(2, "가을"); // 인덱스 0 요소 수정 (성공)
    seasons.set(3, "겨울"); // 인덱스 0 요소 수정 (성공)
    
    System.out.println(seasons);
    
  }
  
  public static void sort() {
    /*
     * List 정렬하기
     * 
     * 1. 오름차순 정렬
     *    Collections.sort(List<Comparable>)
     * 2. 내림차순 정렬
     *    Collections.sort(List<Comparable>,  Collections.reversOrder())
     * 3. List 정렬을 위해서는 Comparable 인터페이스를 구현한 객체를 요소로 저장해야 한다   
     * */
    
    // String 리스트 (Comparable 인터페이스의 구현클래스)
    List<String> list1 = new ArrayList<String>();
    list1.add("cream");
    list1.add("donets");
    list1.add("banana");
    list1.add("apple");

    Collections.sort(list1);
    System.out.println(list1);
    
    Collections.sort(list1, Collections.reverseOrder());
    System.out.println(list1);
    
    
    
    // Data 리스트
    List<Data> list2 = new ArrayList<Data>();
    list2.add(new Data(30));
    list2.add(new Data(10));
    list2.add(new Data(40));
    list2.add(new Data(20));
    
    
    Collections.sort(list2);
    System.out.println(list2.toString());
    
    Collections.sort(list2, Collections.reverseOrder());
    System.out.println(list2.toString());
    
    /*
     * Comparator<T> 인터페이스
     * 
     * 1. Functional interface이다 (추상 메소드가 1개이다)
     * 2. 정렬 방식을 동적으로 설정할 때 사용
     * 3. Comparator 인터페이스를 이용하면 Comparable 인터페이스를 구현하지 않은 클래스의 객체도 정렬할 수 있다
     * 4. 1) int compareTo(T t1, T t2);
     *    2) 결과가 음수이면 현재 객체를 t1을 t2 앞에 두고, 양수이면 t1을 t2의 뒤에 둔다
     *    
     * */
    // Person 리스트 (일반 클래스)
    List<Person> team = new ArrayList<Person>();
    team.add(new Person("뽀로로",  35));
    team.add(new Person("루피",  15));
    team.add(new Person("에디",  25));
    
    // Comparator 인터페이스를 이용해 정렬 방식을 동적으로 설정
    Collections.sort(team, new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge(); // 결과가 음수이면 o1이 앞으로, 양수이면 o1이 뒤로 간다
      };
    });
    // 람다식으로 작성한 문법
    Collections.sort(team, (o1,o2) -> o1.getAge() - o2.getAge());
    System.out.println(team);
    
    
    Collections.sort(team, new Comparator<Person>() {
      @Override
      public int compare(Person p1, Person p2) {
        // 이름순으로 정렬해보자
        // String은 Comparable 인터페이스의 구현체이므로 compareTo() 메소드를 사용할 수 있다
        
        return p1.getName().compareTo(p2.getName());
        
      };
    });
    System.out.println(team);
    
    
    
  }
  
  public static void main(String[] args) {
    // mutable();
   //immutable(); 
   //traversal(); 
    sort();
  }
}
