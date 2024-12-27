package actions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import actions.entity.Student;
import actions.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudnentController {
	
	
	@Autowired
    private StudentService studentService;
	
	// 모든 학생 조회
    @GetMapping("/")
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // id로 학생 조회
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id).orElse(null);  // 학생이 없으면 null 반환
    }
    
    // 학생 추가
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }


    // 학생 이름 변경 (id로 조회)
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestParam String name) {
        return studentService.updateStudent(id, name).orElse(null);  // 학생이 없으면 null 반환
    }

    // 학생 삭제 (id로 삭제)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        return isDeleted ? "Student deleted successfully" : "Student not found";
    }
	
}
