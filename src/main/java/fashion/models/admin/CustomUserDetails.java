// package fashion.models.admin;
// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// public class CustomUserDetails implements UserDetails {
//     private User user;
//     public Collection<? extends GrantedAuthority> authorities;

//     public CustomUserDetails() {
        
//     }
    
//     public CustomUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
//         this.user = user;
//         this.authorities = authorities;
//     }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         // TODO Auto-generated method stub
//         return authorities;
//     }

//     @Override
//     public String getPassword() {
//         // TODO Auto-generated method stub
//         return user.getPassword();
//     }

//     @Override
//     public String getUsername() {
//         // TODO Auto-generated method stub
//         return user.getUserName();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         // TODO Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         // TODO Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         // TODO Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         // TODO Auto-generated method stub
//         return true;
//     }

    

//  }
