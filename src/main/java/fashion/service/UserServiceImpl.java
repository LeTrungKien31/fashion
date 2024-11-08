package fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fashion.models.admin.User;
import fashion.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String username) {
        
        return userRepository.findByUserName(username);
    }

}
