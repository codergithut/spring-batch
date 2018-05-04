package hello;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ApplicationContext() {
            @Override
            public String getId() {
                return null;
            }

            @Override
            public String getApplicationName() {
                return null;
            }

            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public long getStartupDate() {
                return 0;
            }

            @Override
            public ApplicationContext getParent() {
                return null;
            }

            @Override
            public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
                return null;
            }

            @Override
            public BeanFactory getParentBeanFactory() {
                return null;
            }

            @Override
            public boolean containsLocalBean(String s) {
                return false;
            }

            @Override
            public boolean containsBeanDefinition(String s) {
                return false;
            }

            @Override
            public int getBeanDefinitionCount() {
                return 0;
            }

            @Override
            public String[] getBeanDefinitionNames() {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(ResolvableType resolvableType) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> aClass) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> aClass, boolean b, boolean b1) {
                return new String[0];
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> aClass) throws BeansException {
                return null;
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> aClass, boolean b, boolean b1) throws BeansException {
                return null;
            }

            @Override
            public String[] getBeanNamesForAnnotation(Class<? extends Annotation> aClass) {
                return new String[0];
            }

            @Override
            public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> aClass) throws BeansException {
                return null;
            }

            @Override
            public <A extends Annotation> A findAnnotationOnBean(String s, Class<A> aClass) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public Object getBean(String s) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(String s, Class<T> aClass) throws BeansException {
                return null;
            }

            @Override
            public Object getBean(String s, Object... objects) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> aClass) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
                return null;
            }

            @Override
            public boolean containsBean(String s) {
                return false;
            }

            @Override
            public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public String[] getAliases(String s) {
                return new String[0];
            }

            @Override
            public void publishEvent(Object event) {

            }

            @Override
            public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
                return null;
            }

            @Override
            public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public Environment getEnvironment() {
                return null;
            }

            @Override
            public Resource[] getResources(String s) throws IOException {
                return new Resource[0];
            }

            @Override
            public Resource getResource(String s) {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }
        } ;
        SpringApplication.run(Application.class, args);
    }

}
