package chap05_map;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

/*
 * Map 인터페이스
 * 
 * 1. JCF에서 키(Key)와 값(Value)의 쌍으로 구성된 데이터를 저장하는 구조
 * 2. 키(Key)는 값(Value)을 얻기 위한 식별자로 사용되기 대문에 중복이 불가능하다
 * 3. 값(Value)은 Map이 저장하려는 데이터이며 중복 값이 허용된다
 * 4. 키(Key)와 값(Value)을 합쳐서 하나의 Entry라고 부른다
 * 5. Entry들의 저장 순서는 보장하지 않는다 (구현체에 따라 보장하는 경우도 있다)
 * 6. 주요 메소드
 *    1) put(K key, V value) 키와 값을 저장. 기존 키가 있으면 값을 대체하는 방식으로 동작
 *    2) get(Object key) 키에 해당하는 값을 반환
 *    3) containsKey(Object key) 전달된 키 존재하면 true 반환
 *    4) containsValue(Object value) 전달된 값이 존재하면 true 반환
 *    5) keySet() 모든 키를 Set으로 반환 (순서는 보장되지 않는다)
 *    6) entrySet() : 모든 Entry를 Set로 반환
 *       Map.Entry<K, V> 객체들을 요소로 가지는 Set을 반환합니다.
 *       각각의 Entry는 key-value 한 쌍을 나타냅니다.
 * 7. 주요 구현클래스
 *    1) HashMap : 해시 테이블 기반, 저장 순서 보장 없음, 빠른 조회/삽입/삭제, 가장 많이 사용 
 *    2) LinkedHashMap : HashMap 기반, 저장 순서 보장 있음
 *    3) TreeMap : 이진 탐색 트리 기반, 정렬 순서(키의 오름차순) 보장 있음
 *    4) Hashtable : HashMap 기반, 동기화 지원(멀티스레드 환경에서 사용)
 * */



public class Main {
  
  public static void mutable() {
    // mutable: 데이터의 추가, 수정, 삭제가 가능한 Map
    Map<String, Object> map = new HashMap<String, Object>();
    
    map.put("title", "어린왕자");
    map.put("저자정보", "생텍쥐베리");
    map.put("isBestSeller", true);
    map.put("price", 100000);
    map.put("price", 10000);  // 동일한 key를 사용하면 Value를 수정한다
    System.out.println(map.get("title") + " " + map.get("저자정보") + " " + map.get("isBestSeller") + " " + map.get("price") ); // Key를 전달하면 Value를 반환
    
    if ((boolean) map.get("isBestSeller")  ) { // value의 타입이 오브젝트 타입을 사용할때는 casting이 필요하다
      System.out.println("베스트셀러 코너");
    } else {
      System.out.println("일반서적 코너");
    }
  }
  
  
  public static void immutable() {
    // immutable : 데이터의 추가, 수정, 삭제가 불가능한 Map
    Map<String, Object> map = Map.of(
        "name", "kim", 
        "age", 30
    );
    
    //map.put("tel", "02-1111-1111"); // 추가 시도
    //map.put("name", "choi"); // 수정 시도
    //map.remove("name"); // 삭제 시도
    
    // 언제 사용하면 좋을까요? 데이터를 주고 받을때 사용하면 좋다
    // 1. Map을 인자로 전달하는 경우
    // 2. Map을 반환하는 경우
    System.out.println(map);
  }
  
  public static void traversal() {
    
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("title", "파묘");
    map.put("director", "장지환");
    map.put("actors", Arrays.asList("최민식", "김고은", "유해진", "이도현"));
    map.put("stars", 9.5);
    
//    | 메서드          | 반환값                    | 사용 목적                        |
//    | ------------ | ---------------------- | ---------------------------- |
//    | `keySet()`   | `Set<K>`               | 모든 key를 반복하거나 필터링할 때         |
//    | `entrySet()` | `Set<Map.Entry<K, V>>` | key와 value를 함께 다뤄야 할 때 가장 유용 |
    
    
    // 1. keySet()을 이요한 순회
    for (String key : map.keySet()) {
        System.out.println(key + " "+  map.get(key));
    }
    
    System.out.println();
    
    // 2. entrySet()을 이용한 순회 - 엔트리셋 (key, value)를 합쳐놓은 것 => Map.Entry라고 부른다
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      System.out.println(entry);
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }
    
    
    
    
    
  }
  
  
  
  public static void main(String[] args) {
    //mutable();
    //immutable();
    traversal();
    
    
    
  }
}
