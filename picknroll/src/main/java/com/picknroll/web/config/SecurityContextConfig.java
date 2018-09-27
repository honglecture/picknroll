package com.picknroll.web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@ComponentScan("com.picknroll.web.config") // 컴포넌트 스캔 가즈아
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable() // scrf 비활성화 나중에 꼭 활성화 해야 함
		.authorizeRequests() // 권한 인터셉터 설정
			.antMatchers("/admin/**").hasAnyRole("ADMIN") // ADMIN 권한이 필요해
			.antMatchers("/client/**").hasAnyRole("ADMIN, CLIENT") // CLIENT 권한이 필요해
			.antMatchers("/member/profile").authenticated()  // 로그인이 필요해!!
			.anyRequest().permitAll() // 나머지는 권한 필요없어
		.and()
		.formLogin() // 폼을 이용해서 로그인
			.defaultSuccessUrl("/index") // 기본 로그인성공 url
			.loginPage("/member/login") // GET 내가 만든 로그인페이지로 이동
			.loginProcessingUrl("/member/login") // POST LOGIN ACTION 지정
			.successHandler(authenticationSuccessHandler) // 로그인 처리 핸들러
		.and()
		.logout() // 로그아웃 설정
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/index");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 사용자 만들기 - 인메모리 방식
		// 엘뎁, 인메모리, jdbc
/*		UserBuilder user = User.builder();
		
		// 1. 인메모리 방식
		auth.inMemoryAuthentication()
		.withUser(
				 user.username("newlec")
				.password("1234")
				.roles("ADMIN"))
		.withUser(
				 user.username("hong")
				.password("1234")
				.roles("TEACHER")
		);*/
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select id, password, 1 enabled from Member where id=?") // 사용자 쿼리
		.authoritiesByUsernameQuery("select memberId id, roleName authority  from MemberRole where memberId=?") //권한 테이블 쿼리
		.passwordEncoder(new BCryptPasswordEncoder()); // 패스워드 인코딩 방식
		
		// 1. 내가 쿼리를 만들어서 제공
		// 2. 약속된 인터페이스로 구현된 사용자정보 제공 객체
	}
	

/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication() // jdbc방식
		.dataSource(dataSource) // service에서 만든 basicDataSource
		.usersByUsernameQuery("select id, password, 1 enabled from Member where id=?") // 유저 리스트
		.authoritiesByUsernameQuery("select memberId id, roleName authority from MemberRole where memberId=?") //권한 리스트
		.passwordEncoder(new BCryptPasswordEncoder()); // 패스워드 인코딩 방식 BCrypt
		// usernameQuery는 id, password, enabled 컬럼을 전해줘야 한다. where조건은 id=? 로 한다.
		// ahthQuery는 id, authority 컬럼을 전해줘야 한다. where 조건은 id=? 로 한다.
	}*/

}
