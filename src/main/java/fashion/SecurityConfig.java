

package fashion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import fashion.repository.UserRepository;


@Service
@Configuration
@EnableWebSecurity
public class SecurityConfig {

private final UserRepository userRepository;

public SecurityConfig(UserRepository userRepository) {
    this.userRepository = userRepository;
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}


@Bean
public UserDetailsService userDetailsService() {
    return username -> userRepository.findByTenDangNhap(username)
            .map(user -> User.withUsername(user.getTenDangNhap())
                    .password(user.getMatKhau())
                    .roles(user.getRole().getTen())
                    .build())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
}


@Bean
public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder());
    return authenticationManagerBuilder.build();
}

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(auth ->
                    auth
                                .requestMatchers("/login", "/register").permitAll()
                                .requestMatchers("/static/**","/fe/**","assets/**", "images/**").permitAll() // Cho phép truy cập tài nguyên tĩnh
                                .requestMatchers("/admin/**").permitAll()
                                .requestMatchers("/user/**").hasRole("USER")
                                .anyRequest().authenticated()
            )
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/index", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index")
                        .permitAll()

                );


    return http.build();
}
}















// public class SecurityConfig {
//     @Autowired
//     private CustomerUserDetailService customerUserDetailService;
//     @Bean
//     BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
//     @Bean 
//     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         // http.csrf(csrf -> csrf.disable())
//         //     .authorizeHttpRequests((auth) -> auth
//         //         .requestMatchers("/*").permitAll()
//         //         .requestMatchers("/admin/**").hasAuthority("ADMIN")
//         //         .anyRequest().authenticated()
//         //     )
//         //     .formLogin(login -> login
//         //         .loginPage("/login")
//         //         .loginProcessingUrl("/login")
//         //         .usernameParameter("username")
//         //         .passwordParameter("password")
//         //         .defaultSuccessUrl("/admin", true)
//         //     )
//         //     .logout(logout -> logout
//         //     .logoutUrl("/admin-logout")
//         //     .logoutSuccessUrl("/login"))
//         //     .logout(logout ->logout
//         //     .logoutUrl("/admin-logout")
//         //     .logoutSuccessUrl("/login"));

//         http
//             .csrf(csrf -> csrf.disable()) // Tắt CSRF nếu không cần
//             .authorizeHttpRequests(auth -> auth
//                 .anyRequest().permitAll() // Cho phép tất cả các yêu cầu mà không cần xác thực
//             );
    
//         return http.build();
//     }
//     @Bean
//     WebSecurityCustomizer webSecurityCustomizer() {
//         return (web)->web.ignoring().requestMatchers("/static/**","/fe/**","assets/**", "images/**");
//     }
    


// }

// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     http
//         .authorizeHttpRequests(authorize -> authorize
//             .requestMatchers("/login", "/register").permitAll()
//             .requestMatchers("/css/**", "/images/**", "/js/**").permitAll()
//             .requestMatchers("/admin/**").hasRole("QUANTRIVIEN")
//             .requestMatchers("/user/**").hasRole("NGUOIDUNG")
//             .anyRequest().authenticated()
//         )
//         .csrf(csrf -> csrf.disable())
//         .formLogin(form -> form
//             .loginPage("/login")
//             .successHandler((request, response, authentication) -> {
//                 // Điều hướng theo vai trò
//                 String role = authentication.getAuthorities().iterator().next().getAuthority();
//                 if (role.equals("ROLE_QUANTRIVIEN")) {
//                     response.sendRedirect("/admin/index");
//                 } else if (role.equals("ROLE_NGUOIDUNG")) {
//                     response.sendRedirect("/user/home");
//                 } else {
//                     response.sendRedirect("/login?error=true");
//                 }
//             })
//             .permitAll()
//         )
//         .logout(logout -> logout
//             .logoutUrl("/logout")
//             .logoutSuccessUrl("/index")
//             .permitAll()
//         );

//     return http.build();
// }
