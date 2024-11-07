package fashion.models.admin;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "role")
	private Set<UserRole> roleUser;
    public Role() {
        
    }
    public Role(int id, String name, Set<UserRole> roleUsers) {
        this.id = id;
        this.name = name;
        this.roleUser = roleUsers;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<UserRole> getRoleUsers() {
        return roleUser;
    }
    public void setRoleUsers(Set<UserRole> roleUsers) {
        this.roleUser = roleUsers;
    }
    
}
