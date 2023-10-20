package common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspectJ {


    public LogAspectJ() {
        System.out.println("\nCommon :: " + this.getClass() + "\n");
    }


    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("현재 메소드 :" + joinPoint.getTarget().getClass().getName() + "." +
                joinPoint.getSignature().getName());
        if (joinPoint.getArgs().length != 0) {

            Object obj = joinPoint.proceed();

            return obj;
        }

        return null;
    }
}