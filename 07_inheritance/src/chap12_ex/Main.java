package chap12_ex;

public class Main {
	public static void main(String[] args) {
		

	    //----- 학생을 5명 생성합니다.
		Student student1 = new Student("홍길동", 20,"010-1111-2222" ,"student_id_01" );
		Student student2 = new Student("박길동", 20,"010-1111-2222" , "student_id_02" );
		Student student3 = new Student("김길동", 20,"010-1111-2222" , "student_id_03" );
		Student student4 = new Student("최길동", 20,"010-1111-2222" , "student_id_04" );
		Student student5 = new Student("정길동", 20,"010-1111-2222" , "student_id_05" );
	    
	    
	    //----- 교수를 3명 생성합니다.
		Professor professor1 = new Professor("홍교수", 60, "010-1111-2222", "전기전자");
		Professor professor2 = new Professor("김교수", 60, "010-3333-4444", "컴퓨타공학");
		Professor professor3 = new Professor("박교수", 60, "010-1111-2222", "기계");
	    
	    
	    //----- 대학을 1개 생성합니다.
		College college = new College("구디대학교");
	    
	    
	    //----- 학생 5명과 교수 3명을 대학에 등록합니다.
		college.addStudent(student1);
		college.addStudent(student2);
		college.addStudent(student3);
		college.addStudent(student4);
		college.addStudent(student5);
		
		college.addProfessor(professor1);
		college.addProfessor(professor2);
		college.addProfessor(professor3);
	    
	    
	    //----- 학생 1명과 교수 1명을 대학에서 삭제합니다.
	    college.removeStudent(student3);
	    college.removeProfessor(1);
	    
	    //----- 대학 정보를 출력해서 정보를 확인합니다.
		college.collegeInfo();
		
	}
}
