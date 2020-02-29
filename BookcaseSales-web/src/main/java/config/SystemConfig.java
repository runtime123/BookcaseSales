package config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * @author cj
 * @date 2019/11/25
 */
public class SystemConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 当你的项目只有一个spring 容器,那么只需要下面方法返回有值即可
     *
     * 如果有2个容器,那么这2个配置类的方法都需要返回配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 注册过滤器
     * @param servletContext
     * @param filter
     * @return
     */
    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
        return servletContext.addFilter("encoding" , new CharacterEncodingFilter("utf-8", true));
    }

    /**
     * 启用文件上传支持
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        /**
         * MultipartConfigElement类  构造函数参数如下
         * location参数设置要把这个上传上来的文件放在服务器的那个位置，这个位置是一个基础位置。
         * maxFileSize设置单个文件最大大小，  以k为单位  5242880 = 5M
         * maxRequestSize设置上传上来所有文件的总和大小限制。
         */
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }
}
