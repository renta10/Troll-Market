package TrollMarket.Market.Cofiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context .annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(2)
public class MvcSecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationProviderWithRole authenticationProviderWithRole;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);//keakuatan password
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/style.css","/styleNav.css", "/static/JS/**", "/static/Gambar/**", "/account/**","/account/saveAccount").permitAll()
                .antMatchers("/admin/**").hasAuthority("Administrator")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/account/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser").permitAll()
                .and()
                .logout().permitAll();
//                .and()
//                .exceptionHandling().accessDeniedPage("/home/access-denied");
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(
            HttpSecurity http,
            PasswordEncoder getPasswordEncoder,
            UserDetailsService userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder)
                .and()
                .build();
    }
    //cooment pada bagian authority ini karena kita memebuat custom authenticaton
}
