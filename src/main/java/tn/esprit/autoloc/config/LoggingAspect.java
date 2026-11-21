package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* tn.esprit.autoloc.services.*.*(..))")
    public void logAvantMethode(JoinPoint joinPoint) {
        String nomMethode = joinPoint.getSignature().getName();
        Object[] parametres = joinPoint.getArgs();
        log.info("[AOP - Before] Méthode appelée : {} | Paramètres : {}", nomMethode, Arrays.toString(parametres));
    }

    @After("execution(* tn.esprit.autoloc.services.*.*(..))")
    public void logApresMethode(JoinPoint joinPoint) {
        String nomMethode = joinPoint.getSignature().getName();
        log.info("[AOP - After] Fin de l'exécution de la méthode : {}", nomMethode);
    }
}