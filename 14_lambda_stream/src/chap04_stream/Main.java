package chap04_stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * java.util.stream.Stream
 * 
 * 1. JDK 8부터 도입된 기능, 컬렉션 JCF, 배열, 파일 등 다양한 데이터를 효율적으로 처리하기 위한 API를 제공하는 인터페이스
 * 2. 반복문에 의존하지 않고 데이터 가공 및 집계 작업 등을 함수형 스타일로 처리할 수 있다
 * 3. 주요 특징
 *    1) 함수형 프로그래밍 지원: forEach, map, filter 등 함수형 연산을 지원
 *    2) 메소드 체이닝 지원: 여러 연산을 연속해서 사용할 수 있다
 *    3) 원본 데이터 유지: 기존 JCF나 배열의 변형 없이 새로운 결과를 반환
 * 4. Stream 처리 단계
 *    1) Stream 생성
 *      (1) JCF, 배열, 파일, 값 범위 등 다양한 데이터를 이용해 Stream 객체를 생성할 수 있다
 *      (2) list.stream(), Arrays.stream(array), Stream.of(값,...), Files.lines(path) 등
 *    2) 중간 연산
 *      (1) 연산 결과로 Stream을 반환하여 메소드 체이닝이 가능하도록 처리한다
 *      (2) filter(), map(), peek() 등
 *    3) 최종 연산
 *      (1) 반환이 없는 구조를 가지고 있어 메소드 체이닝 구조에서 마지막에 호출할 수 있다
 *      (2) forEach(), collect(), count() 등
 *    
 * 
 * */

public class Main {
  
  public static void forEach() throws Exception {
    
    // Stream 생성
    Stream<String> s = Stream.of("봄", "여름", "가을", "겨울");
    
    // void forEach(Consumer<T> c);
    s.forEach(season -> System.out.println(season)); // 람다 표현식
    
    // Stream 사용은 일회성이므로 다시 사용하려면 다ㅣㅅ 생성해야 한다
    s = Stream.of("봄", "여름", "가을", "겨울");
    s.forEach(System.out::println); // 메소드 참조
    
    
    
    
  }
  
  public static void map() throws Exception {
    // Stream 생성
    Stream<String> s = Stream.of("spring", "summer", "autumn", "winter");
    
    // String<R> map(Function<T, R> mapper); : Function의 반환 결과를 새로운 Stream으로 생성한 뒤 반환
    Stream<String> s2 = s.map(season ->  season.toUpperCase());
    // s.map(String::toUpperCase); // 메소드 참조
    
    // forEach
    s2.forEach(System.out::println);
    
    
    // 지금까지 과정을 물 흐르듯(stream) 한번에 처리하기
    Stream.of("spring", "summer", "autumn", "winter").map(season -> season.toUpperCase()).forEach(System.out::println);
    
  }

  public static void filter() throws Exception {
    
    
    // 스트림 생성
    IntStream s = IntStream.of(-1, 1, -2, 2, -3, 3, -4, 4, -5, 5);
    
    // Stream<T> filter(Predicate<T> predicate);
    IntStream s2 = s.filter(number -> number > 0);
    
    // forEach
    s2.forEach(positive -> System.out.println(positive));
    
    // 지금까지 과정을 한 번에 처리
    IntStream.of(-1, 1, -2, 2, -3, 3, -4, 4, -5, 5).filter(number -> number > 0).forEach(positive -> System.out.println(positive));
  }
  
  public static void collect() throws Exception {
    // Stream 생성
    IntStream s = IntStream.range(1, 11); // 1 이상 11 미만 (1 ~ 10)
    
    // filter()
    IntStream s2 = s.filter(num -> num % 2 == 1); // 홀수만 필터링
    
    // R collect(Collecor<T, A, R> collector);
    // Collectors.toList() : public static <T> Collector<T, ?, List<T>> toList()
    List<Integer> oddNumbers = s2.boxed().collect(Collectors.toList());
    System.out.println(oddNumbers);
    
    // 지금까지 과정을 한 번에 처리하기
    List<Integer> odds = IntStream.range(1, 11) // 1. IntStream 생성
      .filter(number -> number % 2 == 1)        // 2. 중간 (필터) 
      .boxed()                                  // 3. intStream -> Stream 변환
      .collect(Collectors.toList());            // 4. 최종 : List 반환      
 
    System.out.println(odds);
    
    
    
  }

  public static void peek() throws Exception {
    
    // Stream<T> peek(Consumer<T> action);
    // forEach()와 달리 Stream을 반환하므로 중간 연산으로 사용하며, 중간 과정의 로그 추적에 주로 활용된다
   
    // Stream 생성
    Stream<String> s = Stream.of("C", "C#", "C++", "JAVA", "JSP", "PYTHON");
    
    // filter(), map(), forEach() 함께 사용
    List<String> langs = Stream.of("C", "C#", "C++", "JAVA", "JSP", "PYTHON")
    .filter(language ->  language.length() > 3)
    .peek(lang -> System.out.println("Filtered: " + lang)) // 필터링 결과 확인
    .map(lang -> lang.toLowerCase())
    .peek(lang -> System.out.println("Mapped: " + lang)) // 변환 결과 확인
    .collect(Collectors.toList());
    System.out.println(langs);
  }
  
  public static void listStream() throws Exception {

    
    // List 생성
    List<Fruit> fruits = new ArrayList<>();
    fruits.add(new Fruit("Apple", 100.0));
    fruits.add(new Fruit("Mango", 200.0));
    fruits.add(new Fruit("Peach", 500.0));
    fruits.add(new Fruit("Strawberry", 50.0));
    fruits.add(new Fruit("Melon", 1000.0));
    
    // 문제1. weight가 100 이상인 Fruit의 이름 출력
    
    List<String> fruitsName = fruits.stream()
                  .filter(fruit -> fruit.getWeight() >= 100.0)
                  .map(fruit -> fruit.getName())
                  .collect(Collectors.toList());
    System.out.println(fruitsName);
    
 
    // 문제2. 모든 Fruit의 이름을 대문자로 변환 후 List로 모으기
    fruitsName = fruits.stream()
        .filter(fruit -> fruit.getWeight() >= 100.0)
        .map(fruit -> fruit.getName().toUpperCase())
        .collect(Collectors.toList());
    System.out.println(fruitsName);
    
    
    // 문제3. 모든 Fruit의 이름을 쉽표(,)로 연결한 문자열 만들기
    String str = fruits.stream()
      .map(fruit -> fruit.getName())
      .collect(Collectors.joining(","));
    System.out.println(str);
    
    
    
  }
  

  public static void fileStream() throws Exception {
    
    File javaHome = new File("C:/Program Files/Java/jdk-17");
    File[] files = javaHome.listFiles();
    
    // 문제1 모든 파일과 디렉터리의 이름을 출력
    Stream<File> fileStream = Arrays.stream(files);
    fileStream.map(f -> f.getName()).forEach(n -> System.out.println("파일: " + n));
   
    // 문제2 모든 디렉터리의 이름을 출력
    fileStream = Arrays.stream(files);
    fileStream.filter(f -> f.isDirectory())
    .map(n -> n.getName())
    .forEach(n -> System.out.println("디렉터리 이름: " + n));
    
    // 문제3  모든 파일의 크기의 합을 구하기 
    long sum = Arrays.stream(files)
    .filter(f -> f.isFile())
    .mapToLong(f -> f.length()) // Stream은 sum() 지원이 안되므로 LongStream으로 바꾼 뒤 sum() 호출
    .sum();
    System.out.println(sum);
  }
  
  
  
  
  
  
  
  
  public static void main(String[] args) {
    try {
      //forEach();
      //listStream();
     // map();
      //filter();
      //collect();
      //peek();
      //listStream();
      fileStream();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
    
    
    
    
  }
}
