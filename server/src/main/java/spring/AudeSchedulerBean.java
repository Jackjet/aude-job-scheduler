package spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.io.Serializable;

/**
 * Created by lrkin on 2016/11/26.
 */
public class AudeSchedulerBean<T> extends SchedulerBeanConfig implements InitializingBean, DisposableBean, ApplicationContextAware, ApplicationListener, BeanNameAware, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(MarbleSchedulerBean.class);

    private static transient ApplicationContext SPRING_CONTEXT;

    private transient ApplicationContext applicationContext;

    private transient String beanName;

    private transient boolean supportedApplicationListener;

    public AudeSchedulerBean() {
        super();
    }

    public static ApplicationContext getSpringContext() {
        return SPRING_CONTEXT;
    }

    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void destroy() throws Exception {
        logger.info("close the Thrift server");
        AudeManager.getInstance().stopServer();
    }

    public void afterPropertiesSet() throws Exception {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void onApplicationEvent(ApplicationEvent applicationEvent) {

    }
}
