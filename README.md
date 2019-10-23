# pasudo123-aop-sample

### @Aspect
- 관점을 정의한다.
- 포인트컷과 어드바이스의 결합이다.
```java
@Aspect
@Component
public class LoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    
    /** 생략 **/
    
}
```

### @Pointcut
- 포인트컷을 정의한다.
- 포인트컷은 __결합점(join points)__ 을 지정하여 Advice 가 언제 실행될지를 지정하는데 사용한다. Spring AOP 는 스프링 빈에 대한 메소드 실행 Join Points 를 지원하므로, 스프링에서 포인트컷은 빈의 메소드 실행점을 지정하는 것으로 생각할 수 있다.

### Advice
- 실제 기능을 담고 있다.
- Advice 의 동작시점은 아래와 같다.
  - Before : 메소드 실행 전에 동작
  - After : 메소드 실행 후에 동작
  - After-returning : 메소드가 정상적으로 실행된 후에 동작
  - After-throwing : 예외가 발생한 후에 동작
  - Around : __메소드 호출 이전, 이후, 예외발생 등 모든 시점에서 동작__
```java
/**
 * Pointcut that matches all repositories, services and Web REST endpoints.
 */
@Pointcut("within(@org.springframework.stereotype.Repository *)" +
        " || within(@org.springframework.stereotype.Service *)" +
        " || within(@org.springframework.web.bind.annotation.RestController *)")
public void springBeanPointcut() {
    /** 포인트컷이기 때문에 메소드 내부는 비어있으며, 세부 구현은 advice 에서 수행한다. **/
}

/**
 * Pointcut that matches all Spring beans in the application's main packages.
 */
@Pointcut("within(edu.pasudo123.aop.app.service..*)" +
        " || within(edu.pasudo123.aop.app.controller..*)")
public void applicationPackagePointcut() {
    /** 포인트컷이기 때문에 메소드 내부는 비어있으며, 세부 구현은 advice 에서 수행한다. **/
}
```
#### within (클래스 경로)
```java
@Pointcut("within(edu.pasudo123.aop.app.service..*)" +
            " || within(edu.pasudo123.aop.app.controller..*)")
            
/** 
edu.pasudo123.aop.app.service..* ::  하위 패키지를 포함한 모든 클래스의 모든 메소드에 aop 적용
edu.pasudo123.aop.app.controller..* :: 하위 패키지룰 포함한 모든 클래스의 모든 메소드에 aop 적용
edu.pasudo123.aop.app.service.EmployeeService :: EmployeeService 클래스의 모든 메소드에 aop 적용
**/

// 

@Pointcut("within(@org.springframework.stereotype.Repository *)" +
        " || within(@org.springframework.stereotype.Service *)" +
        " || within(@org.springframework.web.bind.annotation.RestController *)")
/**
@Repository, @Service, @RestController 어노테이션이 달린 클래스에 aop 를 적용한다. (스프링 빈에 적용)
**/
```
