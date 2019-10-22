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
- 포인트컷은 결합점(join points) 을 지정하여 Advice 가 언제 실행될지를 지정하는데 사용한다. Spring AOP 는 스프링 빈에 대한 메소드 실행 Join Points 를 지원하므로, 스프링에서 포인트컷은 빈의 메소드 실행점을 지정하는 것으로 생각할 수 있다.
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
