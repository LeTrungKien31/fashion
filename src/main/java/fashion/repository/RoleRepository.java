package fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.models.admin.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
