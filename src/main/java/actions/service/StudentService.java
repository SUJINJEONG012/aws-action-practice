package actions.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import actions.entity.Student;
import actions.repository.StudentRepository;

@Service
public class StudentService {

	
	 @Autowired
	 private StudentRepository studentRepository;
	 
	 
	 // 모든 학생 조회 (이름만 반환)
	    public Iterable<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    // id로 학생 조회
	    public Optional<Student> getStudentById(Long id) {
	        return studentRepository.findById(id);
	    }

	    // 학생 추가
	    public Student addStudent(Student student) {
	        System.out.println("Saving student: " + student.getName());  // 디버그용 로그
	        return studentRepository.save(student);
	    }

	    // id로 학생 이름 변경
	    @Transactional
	    public Optional<Student> updateStudent(Long id, String newName) {
	        Optional<Student> student = studentRepository.findById(id); // id로 학생 조회
	        if (student.isPresent()) {
	            Student updatedStudent = student.get();
	            updatedStudent.setName(newName); // 새로운 이름 설정
	            return Optional.of(studentRepository.save(updatedStudent)); // 업데이트된 학생 반환
	        }
	        return Optional.empty(); // 학생이 없으면 empty 반환
	    }

	    // id로 학생 삭제
	    @Transactional
	    public boolean deleteStudent(Long id) {
	        if (studentRepository.existsById(id)) {
	            studentRepository.deleteById(id); // 학생 삭제
	            return true; // 삭제 성공
	        }
	        return false; // 학생이 없으면 false 반환
	    }
	 
}
