package fashion.service;

import fashion.models.admin.User;

public interface UserService {

    // User findByUserName(String username);

    public User UserByUserName(String username);

    public void saveUser(User user);

}
