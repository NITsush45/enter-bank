package util;

import annotation.Audit;
import entity.AuditLog;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.security.Principal;
import java.time.LocalDateTime;


@Interceptor
@Audit
public class AuditingInterceptor implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditingInterceptor.class);

    @Inject
    private Provider<SecurityContext> securityContextProvider;

    @PersistenceContext(unitName = "bankingPU")
    private EntityManager em;

    @AroundInvoke
    public Object auditInvocation(InvocationContext ctx) throws Exception {
        Object result;
        try {
            result = ctx.proceed();
            logAction(ctx, "SUCCESS");
        } catch (Exception e) {
            logAction(ctx, "FAILED: " + e.getMessage());
            LOGGER.error("Exception in method {}.{}()", ctx.getTarget().getClass().getSimpleName(),
                    ctx.getMethod().getName(), e);
            throw e;
        }
        return result;
    }

    private void logAction(InvocationContext ctx, String status) {
        try {
            SecurityContext securityContext = securityContextProvider.get();
            String principalName = "SYSTEM";

            if (securityContext != null) {
                Principal principal = securityContext.getCallerPrincipal();
                if (principal != null) {
                    principalName = principal.getName();
                }
            }

            AuditLog log = new AuditLog();
            log.setPrincipalName(principalName);
            log.setAction(ctx.getTarget().getClass().getSimpleName() + "." + ctx.getMethod().getName());
            log.setTimestamp(LocalDateTime.now());

            String details = "Status: " + status + ", Params: " + maskSensitive(ctx.getParameters());
            log.setDetails(truncate(details, 255));

            em.persist(log);

        } catch (Exception e) {
            LOGGER.error("Audit logging failed for {}.{}()", ctx.getTarget().getClass().getSimpleName(),
                    ctx.getMethod().getName(), e);
        }
    }

/*This ensures the details string is at most 255 characters,
 preventing errors if the database column can’t store longer strings. */
    private String truncate(String str, int maxLength) {
        return str.length() <= maxLength ? str : str.substring(0, maxLength);
    }

    private Object[] maskSensitive(Object[] params) {
        Object[] safeParams = params.clone();
        for (int i = 0; i < safeParams.length; i++) {
            if (safeParams[i] instanceof char[] || safeParams[i] instanceof String) {
                // Simple masking example, you can customize for specific methods/params
                String paramStr = String.valueOf(safeParams[i]);
                if (paramStr.toLowerCase().contains("password")) {
                    safeParams[i] = "***";
                }
            }
        }
        return safeParams;
    }
}
