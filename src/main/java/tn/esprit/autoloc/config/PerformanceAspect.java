package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    private static final long SEUIL_MS = 1000;

    @Around("execution(* tn.esprit.autoloc.services.*.*(..))")
    public Object mesurerTempsExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long debut = System.currentTimeMillis();

        Object resultat = joinPoint.proceed();          // exécute la vraie méthode

        long duree = System.currentTimeMillis() - debut;
        String nomMethode = joinPoint.getSignature().getName();

        log.info("[AOP - Performance] La méthode {} s'est exécutée en {} ms", nomMethode, duree);
        if (duree > SEUIL_MS) {
            log.warn("[AOP - Performance] ATTENTION : la méthode {} est lente ({} ms > {} ms)", nomMethode, duree, SEUIL_MS);
        }

        return resultat;                                // on renvoie le résultat de la méthode
    }
}