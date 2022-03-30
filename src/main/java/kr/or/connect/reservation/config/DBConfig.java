package kr.or.connect.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@PropertySource("classpath:application.properties")
@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;// = "com.mysql.jdbc.Driver";
	@Value("${spring.datasource.url}")
	private String url;// = "jdbc:mysql://localhost:3306/reservationdb?useUnicode=true&characterEncoding=utf8";
	@Value("${spring.datasource.username}")
	private String username;// = "connectuser";
	@Value("${spring.datasource.password}")
	private String password;// = "connect123!@#";

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManger();
	}

	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}
}