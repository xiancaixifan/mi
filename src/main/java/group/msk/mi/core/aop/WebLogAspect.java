package group.msk.mi.core.aop;

import cn.hutool.json.JSONUtil;
import group.msk.mi.core.annotation.WebLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * @Author 吕衡
 * @Create 2020/7/31 - 19:27
 * @Desc TODO
 */
@Aspect
@Component
public class WebLogAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(group.msk.mi.core.annotation.WebLog)")
    public void webLog(){}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        //切`点执行
        Object result = proceedingJoinPoint.proceed();

        logger.info("返回参数  : {}",JSONUtil.toJsonStr(result));
        // 执行耗时
        logger.info("执行时间  : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //这啥
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String aspectLogDescription = getAspectLogDescription(joinPoint);
        Enumeration<String> headerNames = request.getHeaderNames();



        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        logger.info("请求头信息:");
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            logger.info(" ["+header + "]:[" + request.getHeader(header)+"]");
        }
        // 打印请求 url
        logger.info("请求路径         : {}", request.getRequestURL().toString());
        // 打印描述信息
        logger.info("描述信息         : {}", aspectLogDescription);
        // 打印 Http method
        logger.info("请求方式         : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("目标名称         : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("请求入参   : {}", JSONUtil.toJsonStr(joinPoint.getArgs()));
    }



    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        // 接口结束后换行，方便分割查看
        logger.info("=========================================== End ===========================================" + System.lineSeparator());
    }


    /**
     * @return
     */
    public String getAspectLogDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);


        Method[] methods = targetClass.getMethods();
        StringBuffer description = new StringBuffer("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(WebLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }


}
