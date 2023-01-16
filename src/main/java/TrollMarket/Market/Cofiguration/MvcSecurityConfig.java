package TrollMarket.Market.Cofiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context .annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class MvcSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationProviderWithRole authenticationProviderWithRole;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);//keakuatan password
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/style.css","/styleNav.css", "/static/JS/**",
                        "/static/Gambar/**", "/account/**","/account/saveAccount").permitAll()
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
    }


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService).passwordEncoder(MvcSecurityConfig.passwordEncoder());
//        auth.authenticationProvider(authenticationProviderWithRole).build();
//    }
    //cooment pada bagian authority ini karena kita memebuat custom authenticaton
}
