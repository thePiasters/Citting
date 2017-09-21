package com.citting.config;

import com.citting.converters.CategoryConverter;
import com.citting.converters.QuestionConverter;
import com.citting.converters.UserPlacePlaceConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

@Configuration
@EnableWebMvc
@ComponentScan("com.citting")
@EnableJpaRepositories(basePackages	="com.citting.repositories")
@EnableTransactionManagement


public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver()	{
        InternalResourceViewResolver viewResolver	=
                new	InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return	viewResolver;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("citting");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/").setCachePeriod(315569299);
    }

    @Override
    public	void addFormatters(FormatterRegistry registry)	{
        registry.addConverter(getQuestionConverter());
        registry.addConverter(getCategoryConverter());
        registry.addConverter(getUserPlacePlaceConverter());
    }

    @Bean
    public CategoryConverter getCategoryConverter() {
        return new CategoryConverter();
    }

   @Bean
   public UserPlacePlaceConverter getUserPlacePlaceConverter()
   {return new UserPlacePlaceConverter();}



    @Bean
    public QuestionConverter getQuestionConverter() {
        return new QuestionConverter();
    }

    @Bean
    public Validator validator()	{
        return	new LocalValidatorFactoryBean();
    }
}

