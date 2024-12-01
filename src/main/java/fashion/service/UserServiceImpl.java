package fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fashion.models.admin.User;
import fashion.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User UserByUserName(String username) {
        return userRepository.findByTenDangNhap(username)
                .orElseThrow(() -> new UsernameNotFoundException("Người dùng không tồn tại"));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
