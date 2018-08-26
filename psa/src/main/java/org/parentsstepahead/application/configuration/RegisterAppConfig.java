package org.parentsstepahead.application.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "org.parentsstepahead.application")
@PropertySource({ "classpath:application.properties" })
public class RegisterAppConfig implements WebMvcConfigurer {
	

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");
    }

    //Set up variable to hold the properties
    @Autowired
    private Environment env;

    //Set up a logger for diagnostic
    private Logger logger = Logger.getLogger(getClass().getName());

    //Define a bean for viewResolver
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver  = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //Connecting with the db
    @Bean
    public DataSource securityDataSource(){

    	/* ComboPooledDatasource */
        //Create connection pool
        ComboPooledDataSource securityDataSourse = new ComboPooledDataSource();

        //set the jdbc driver
        try {
        	System.out.println("Driver Class : " + env.getProperty("jdbc.driver"));
            securityDataSourse.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        //log the connection properties
        //We want to make sure we are reading data from the properties file
        logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));

        //set database connection properties
        securityDataSourse.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSourse.setUser(env.getProperty("jdbc.user"));
        securityDataSourse.setPassword(env.getProperty("jdbc.password"));

        //set connection pool properties
        securityDataSourse.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSourse.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSourse.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSourse.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));

        return securityDataSourse;
    
    }
    
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;				
	}

    //read enviroment property and convert to int
    private int getIntProperty(String propName){

        String propVal = env.getProperty(propName);

        //now convert it to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
    
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(securityDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	


}

