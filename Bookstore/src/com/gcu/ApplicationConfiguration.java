package com.gcu;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.gcu.business.BookBusinessService;
import com.gcu.business.DataBusinessInterface;
import com.gcu.business.UserBusinessInterface;
import com.gcu.business.UserBusinessService;
import com.gcu.models.BookModel;

@Configuration
class ApplicationConfiguration {
	@Bean(name="UserService")
	@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserBusinessInterface getUserBusinessInterface() {
		return new UserBusinessService();
	}
	
	@Bean(name="BookService")
	@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataBusinessInterface<BookModel> getDataBusinessInterface() {
		return new BookBusinessService();
	}
	
	@Bean(name="jdbcTemplate")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.DERBY)
			.setName("CST;create=true")
			.ignoreFailedDrops(true)
			.addScript("classpath:com/gcu/create-db.sql")
			.addScript("classpath:com/gcu/insert-data.sql")
			.build();
		return db;
	}
	
}
