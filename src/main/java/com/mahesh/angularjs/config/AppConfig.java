package com.mahesh.angularjs.config;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.core.env.Environment;
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages= {"com.mahesh.angularjs"})
@EnableTransactionManagement
@Configuration
@EnableWebMvc
public class AppConfig 
{
	 @Autowired
	    private Environment environment;

	    	@Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] {
	            "com.mahesh.angularjs.model"
	        });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	        }
	        @Bean
	        public DriverManagerDataSource dataSource() {
	            DriverManagerDataSource dataSource = new DriverManagerDataSource();
	            dataSource.setDriverClassName(environment.getRequiredProperty("database.driver"));
	            dataSource.setUrl(environment.getRequiredProperty("database.url"));
	            dataSource.setUsername(environment.getRequiredProperty("database.username"));
	            dataSource.setPassword(environment.getRequiredProperty("database.password"));
	            return dataSource;
	        }
	        private Properties hibernateProperties() {
	            Properties properties = new Properties();
	            properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	            properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	            properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	            properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
	            return properties;
	        }

	        @Bean
	        public HibernateTransactionManager getTransactionManager() {
	            HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	            transactionManager.setSessionFactory(sessionFactory().getObject());
	            return transactionManager;
	        }
			@Bean
			public InternalResourceViewResolver resolver()
			{
				InternalResourceViewResolver resolver=new InternalResourceViewResolver();
				resolver.setPrefix("/WEB-INF/pages/");  
			    resolver.setSuffix(".jsp");
			    return resolver;
			}
}


