package chap12_ex;

import java.util.Arrays;

/**
 * 대학(College) 클래스입니다.
 * 
 * 대학 이름을 저장할 String name 필드를 선언합니다.
 * 학생을 여러 명 저장할 수 있는 Student[] 배열을 선언합니다.
 * 교수를 여러 명 저장할 수 있는 Professor[] 배열을 선언합니다.
 * 학생이 몇 명인지 저장할 수 있는 int studentCount 필드를 선언합니다.
 * 교수가 몇 명인지 저장할 수 있는 int professorCount 필드를 선언합니다. 
 * 
 * 매개변수 String name을 가지는 생성자를 정의합니다.
 * 생성자에서는 name의 초기화를 진행하고,
 * 학생을 최대 10명, 교수를 최대 3명 저장할 수 있도록 배열을 생성합니다.
 */
public class College {
	
	private String name;
	private Student[] students;
	private Professor[] professors;
    private int studentCount;
    private int professorCount;

    private static final int STUDENT_LIMIT = 10;
    private static final int PROFESSOR_LIMIT = 3;
	
	public College(String name) {
		super();
		this.name = name;
		students = new Student[STUDENT_LIMIT];
		professors = new Professor[PROFESSOR_LIMIT];
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	/**
	   * 학생 등록 메소드입니다. 등록 최대 수는 10명입니다.
	   * 학생은 Student[] 배열의 처음부터 빈 공간을 찾은 뒤 발견된 첫 공간에 등록합니다.
	   * @param student 등록할 학생 객체입니다.
	   */
	  public void addStudent(Student student) {
	    students[studentCount++] = student;
	  }
	  
	  /**
	   * 교수 등록 메소드입니다. 등록 최대 수는 3명입니다.
	   * 교수는 Professor[] 배열의 마지막 요소로 등록합니다.
	   * @param professor 등록할 교수 객체입니다.
	   */
	  public void addProfessor(Professor professor) {
	    professors[professorCount++] = professor;
	  }
	  
	  /**
	   * 학생 삭제 메소드입니다. 
	   * 학생은 Student[] 배열의 요소 중 전달 받은 학생과 학번이 일치하는 학생을 삭제합니다.
	   * 삭제하지 않는 다른 학생들은 일체 건드리지 않습니다. 
	   * @param student 삭제할 학생 객체입니다. 
	   * @return 삭제된 학생 정보를 담고 있는 객체입니다.
	   */
	  public Student removeStudent(Student student) {
		Student removed = null;
        int removeIdx = -1;

        for (int i = 0; i < studentCount; i++) {
            if (student.getStudentId().equals(students[i].getStudentId())) {
                removed = students[i];
                removeIdx = i;
                break;
            }
        }

        if (removeIdx != -1) {
            System.arraycopy(students, removeIdx + 1, students, removeIdx, studentCount - removeIdx - 1);
            students[--studentCount] = null;
        }

		 
	    return removed;
	  }
	  
	  /**
	   * 교수 삭제 메소드입니다. 
	   * 교수는 Professor[] 배열의 요소 중 전달 받은 인덱스에 저장된 교수를 삭제합니다.
	   * 삭제된 교수 이후의 모든 교수들을 한 자리씩 앞으로 옮겨서 처리합니다.
	   * @param index 삭제할 교수의 인덱스입니다. 
	   * @return 삭제된 교수 정보를 담고 있는 객체입니다.
	   */
	  public Professor removeProfessor(int index) {
		Professor removed = null;
		
		System.arraycopy(professors, index + 1, professors, index, professorCount - index - 1 );
		professors[--professorCount] = null;  
	    return removed;
	  }
	  
	  /**
	   * 학교 정보 출력 메소드입니다.
	   * 학교 이름, 학생 명단, 교수 명단을 출력합니다.
	   * 오버라이드한 toString() 메소드를 활용할 수 있도록 구성합니다.
	   */
	  public void collegeInfo() {
	    System.out.println(toString());
	  }



	@Override
	public String toString() {
		return "College [name=" + name + ", students=" + Arrays.toString(students) + ", professors="
				+ Arrays.toString(professors) + "]";
	}
	  
	  
}
