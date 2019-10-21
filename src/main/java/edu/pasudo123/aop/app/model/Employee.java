package edu.pasudo123.aop.app.model;

import edu.pasudo123.aop.app.dto.EmployeeDto;
import lombok.*;

import javax.persistence.*;

/**
 * Created by pasudo123 on 2019-10-21
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @Builder
    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void updateEmployee(EmployeeDto.Request dto) {
        this.email = dto.getEmail();
        this.name = dto.getName();
    }
}
