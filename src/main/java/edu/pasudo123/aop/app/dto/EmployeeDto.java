package edu.pasudo123.aop.app.dto;

import edu.pasudo123.aop.app.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;

/**
 * Created by pasudo123 on 2019-10-21
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
public class EmployeeDto {

    @Getter
    @NoArgsConstructor
    public static class Request{

        private String email;
        private String name;

        public Employee toEntity() {
            return Employee.builder()
                    .email(this.email)
                    .name(this.name)
                    .build();
        }
    }

    @Getter
    public static class OneResponse {

        private Long id;
        private String email;
        private String name;

        public OneResponse(final Employee employee) {
            this.id = employee.getId();
            this.email = employee.getEmail();
            this.name = employee.getName();
        }
    }
}