package fashion.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.models.admin.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByTenDangNhap(String tenDangNhap);
    boolean existsByTenDangNhap(String tenDangNhap);
    
}


