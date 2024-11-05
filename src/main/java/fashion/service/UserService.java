package fashion.service;

import fashion.models.admin.User;

public interface UserService {
    User findByUserName(String username);

}
