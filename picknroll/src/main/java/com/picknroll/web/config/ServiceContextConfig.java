package com.picknroll.web.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ComponentScan(basePackages = { "com.picknroll.web.dao.mybatis", "com.picknroll.web.service.mybatis" })
@Configuration
public class ServiceContextConfig {

	// 1. 데이터소스 객체 만들기
	@Bean
	public BasicDataSource basicDataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();

		// db 연결 설정

		/* mssqlserver */
		/*
		 * basicDataSource.setDriverClassName(
		 * "com.microsoft.sqlserver.jdbc.SQLServerDriver"); basicDataSource.setUrl(
		 * "jdbc:sqlserver://211.238.142.251:1433;databaseName=lecture");
		 * basicDataSource.setUsername("sist"); basicDataSource.setPassword("dclass");
		 */

		/* mysql */
		  basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		  basicDataSource.setUrl("jdbc:mysql://localhost/picknrolldb?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"); 
		  basicDataSource.setUsername("hong"); 
		  basicDataSource.setPassword("1234");
		 

		/* mariadb */
/*		basicDataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mariadb://picknroll.gonetis.com:3306/picknrolldb?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8");
		basicDataSource.setUsername("pi");
		basicDataSource.setPassword("magnetic0611");*/
		
		// 커넥션풀 설정
		basicDataSource.setRemoveAbandoned(true);
		basicDataSource.setInitialSize(20);
		basicDataSource.setMaxActive(30);
		return basicDataSource;
	}

	// Hibernate 설정을 위한 빈 객체들
/*	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		Properties props = new Properties();
		// props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.put("hibernate.show_sql", "true");

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(basicDataSource());
		sessionFactoryBean.setPackagesToScan("com.picknroll.web.entity");
		sessionFactoryBean.setHibernateProperties(props);

		return sessionFactoryBean;
	}

	// 하이버네이트를 위한 트랜잭션 프록시
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		// .getObject() 세션팩토리로 반환
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}*/

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(BasicDataSource basicDataSource) throws Exception {

		// 매개변수에 IoC 컨테이너에 있는 basicDataSource가 참조된다.
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(basicDataSource);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:com/picknroll/web/dao/mybatis/mapper/*.xml"));
		return sqlSessionFactory.getObject();
	}

	// 위에서 만든 SqlSesstionFactory를 IoC 컨테이너에서 찾아 매개변수에 자동으로 넣어주고
	// SqlSesstionTemplate객체를 반환하자, 매개변수에 위에서 설정한 팩토리
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public JavaMailSender mailSender() {
		// 이메일을 보내기 위한 준비작업

		// 이메일 보낼 때 이용할 smtp 정보
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("magnetic0824");
		mailSender.setPassword("magnetic0611");

		// 이메일 보낼 때 이용할 설정값
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put("mail.debug", true);
		mailSender.setJavaMailProperties(javaMailProperties);

		return mailSender;

	}

}
