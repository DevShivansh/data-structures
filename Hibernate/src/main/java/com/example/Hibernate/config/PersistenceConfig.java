/*package com.example.Hibernate.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
//@PropertySource({ "classpath:persistence-mysql.properties" })
@ComponentScan({ "com.example.Hibernate" })
public class PersistenceConfig {
 
   
   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(restDataSource());
      sessionFactory.setPackagesToScan(
        new String[] { "org.baeldung.spring.persistence.model" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
 
    
    protected String[] getHibernateEntityPackagesToScan()
    {
        return new String[]{"com.example.Hibernate"};
    }
    
    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource( restDataSource() );
        bean.setPackagesToScan( getHibernateEntityPackagesToScan() );
        Properties props = new Properties();
        //show_sql is false because it only would dump it to std out. The logger setting handles outputting SQL.
        props.put( Environment.SHOW_SQL, "false" );
        //props.put( Environment.FORMAT_SQL, hibernateFormat );
        props.put( Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect" );
        
        bean.setHibernateProperties( props );
        bean.afterPropertiesSet();
        return bean.getObject();
    }
    
   
   
   
   @Bean
   public DataSource restDataSource() {
      
       HikariConfig config = new HikariConfig();
       config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
       config.setMaximumPoolSize( 10 );
       config.setMinimumIdle( 1800000 );
       config.setConnectionTimeout( 500000 );
       config.setIdleTimeout( 1800000 );
       config.setMaxLifetime( 3600000 );
       config.setLeakDetectionThreshold( 300000 );
       //config.setInitializationFailFast(false);
       
       config.addDataSourceProperty("serverName", "localhost");
       config.addDataSourceProperty("port", 3306);
       config.addDataSourceProperty("databaseName", "chromeriver_uat");
       config.addDataSourceProperty("user", "root");
       config.addDataSourceProperty("password", "");
       config.setPoolName( "uat-service-pool" );
       config.setRegisterMbeans( true );
       return new HikariDataSource(config);
       
       
       BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/chromeriver_uat?useSSL=false");
      dataSource.setUsername("root");
      dataSource.setPassword("");
 
      return dataSource;
   }
 
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(
     SessionFactory sessionFactory) {
  
      HibernateTransactionManager txManager
       = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
 
      return txManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   Properties hibernateProperties() {
      return new Properties() {
         {
            setProperty("hibernate.hbm2ddl.auto",
              "validate");
            setProperty("hibernate.dialect",
              "org.hibernate.dialect.MySQL5InnoDBDialect");
            setProperty("hibernate.globally_quoted_identifiers",
             "true");
         }
      };
   }
}*/