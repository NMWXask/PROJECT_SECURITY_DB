package com.xask.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Slf4j
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Pointcut("execution(public * com.xask.service.SecurityService.delete(Integer))")
    public void anyDeleteMethod(){
    }

    @Before(value = "anyDeleteMethod()" +
                    " && args(id) " +
                    " && target(service)", argNames = "joinPoint,id,service")
    public void logging(JoinPoint joinPoint,
                        Object id,
                        Object service){
        log.info(" Попытка удаления сотрудника в классе {}, с id {}. ",service,id);
    }
}
