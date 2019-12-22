package config;


import com.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author cj
 * @date 2019/11/25
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.controller")
public class MvcConfig implements WebMvcConfigurer {


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistry = registry.addInterceptor(new LoginInterceptor());
        //interceptorRegistry.addPathPatterns("/**");
        interceptorRegistry.addPathPatterns("/userIndex");
        interceptorRegistry.addPathPatterns("/getCart");
        interceptorRegistry.addPathPatterns("/orderList");
        //interceptorRegistry.excludePathPatterns("/login");
        //interceptorRegistry.excludePathPatterns("/userIndex");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration registration
                = registry.addResourceHandler("/static/**");
        registration.addResourceLocations("classpath:/static/");
    }
}
