package myspring.aop.annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public * myspring..*(..))")
    public void before(JoinPoint joinPoint){
        String signatureString = joinPoint.getSignature().getName();

        System.out.println("@Before [ "+signatureString+" ] 메서드 실행 전처리 수행");

        for(Object arg : joinPoint.getArgs())
            System.out.println("@Before [ "+signatureString+" ] arguments "+arg);
    }
    @AfterReturning(pointcut = "execution(public * myspring.user.service.*.*(..))",returning = "ret")
    public void afterReturning(JoinPoint joinPoint,Object ret){
        String signatureString = joinPoint.getSignature().getName();
        System.out.println("@AfterReturning [ "+signatureString+" ] perform method post-processing");
        System.out.println("@AfterReturning [ "+signatureString+" ] return value= "+ret);
    }
    @AfterThrowing(pointcut = "execution(* *..UserService*.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Throwable ex){
        String signatureString = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing [ "+signatureString+" ] Exception occured while perform method");
        System.out.println("@AfterThrowing [ "+signatureString+" ] Exception= "+ex.getMessage());
    }
    @After("execution(* *..*.*User(..))")
    public void afterFinally(JoinPoint joinPoint) {
        String signatureString = joinPoint.getSignature().getName();
        System.out.println("@After [ "+signatureString+" ] Finish performing method");
    }
}
