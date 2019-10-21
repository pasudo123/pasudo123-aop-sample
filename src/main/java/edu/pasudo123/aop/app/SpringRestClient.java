package edu.pasudo123.aop.app;

import org.springframework.web.client.RestTemplate;

/**
 * Created by pasudo123 on 2019-10-22
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
public class SpringRestClient {

    private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
    private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";

    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[]args) {

    }
}
