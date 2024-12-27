package actions.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // id는 auto_increment
    private Long id;

    private String name;
 
    public Student(String name) {
        this.name = name;
    }
}
