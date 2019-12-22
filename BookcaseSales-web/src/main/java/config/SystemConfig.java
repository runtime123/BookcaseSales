package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
}
