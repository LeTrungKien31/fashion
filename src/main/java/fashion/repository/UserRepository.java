package fashion.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fashion.models.admin.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUserName(String userName);
}
