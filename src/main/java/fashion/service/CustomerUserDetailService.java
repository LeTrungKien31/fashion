// package fashion.service;


// // import java.util.Collection;
// // import java.util.HashSet;
// // import java.util.Set;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.security.core.authority.SimpleGrantedAuthority;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.core.userdetails.UsernameNotFoundException;
// // import org.springframework.stereotype.Service;

// import java.util.Collection;
// import java.util.HashSet;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import fashion.models.admin.User;
// import fashion.models.admin.UserRole;

// @Service
// public class CustomerUserDetailService implements UserDetailsService {
//     @Autowired
//     private UserService userService;
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         // TODO Auto-generated method stub
//         User user = userService.findByTenDangNhap(username);
//         if(user == null) {
//         throw new UsernameNotFoundException("Tai khoan hoac mat khau sai");
//         }
//          Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//          Set<UserRole> roles =  user.getUserRole();
//          for (UserRole userRole : roles) {
//             grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getTen()));
//          }
//          return new UserDetails(user, grantedAuthoritySet);
//     }

// }
