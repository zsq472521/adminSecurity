package club.codehero.ssm.controller;

import club.codehero.ssm.domain.SysLog;
import club.codehero.ssm.service.ISysLogService;
import org.apache.ibatis.jdbc.Null;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/24 13:24
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; //开始的时间
    private Class clazz=null; //访问的类
    private Method method=null; //访问的方法

    /**
     * 前置通知，获取开始时间，执行的类和方法
     */
    @Before("execution(* club.codehero.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception {
        visitTime = new Date(); //开始时间即是访问时间

        clazz = jp.getTarget().getClass();//访问的类
        if (clazz==SysLogController.class){
            return;
        }

        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs(); //获取访问方法的参数
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName); //只能获取无参数的方法
        } else {
            Class[] classesArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classesArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classesArgs);
        }


    }

    @After("execution(* club.codehero.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {

        long time = new Date().getTime() - visitTime.getTime(); //访问时长

        String url = "";
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class&&clazz!=SysLogController.class) {
            //1.获取类上的@RequestMapping
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();

                //2.获取方法上的@RequestMapping
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();

                    url = classValue[0] + methodValue[0];



                    //获取访问的ip
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext(); //从上下文中获取当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象中
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time); //执行时长
                    sysLog.setIp(ip);
                    sysLog.setVisitTime(visitTime);
                    sysLog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);

                    //调用Service完成日志的存储
                    sysLogService.save(sysLog);
                }

            }
        }


    }
}
