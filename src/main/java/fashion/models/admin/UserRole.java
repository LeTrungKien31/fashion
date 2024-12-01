// package fashion.models.admin;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;


// @Entity(name = "UserRole")
// public class UserRole {
//       @Id
//     @Column(name = "id")
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;
//     @ManyToOne
// 	@JoinColumn(name = "userId",referencedColumnName = "id")
// 	private User user;
// 	@ManyToOne
// 	@JoinColumn(name = "roleId",referencedColumnName = "id")
// 	private Role role;
    
//     public UserRole() {

//     }
//     public UserRole(int id, User user, Role role) {
//         super();
//         this.id = id;
//         this.user = user;
//         this.role = role;
//     }
//     public int getId() {
//         return id;
//     }
//     public void setId(int id) {
//         this.id = id;
//     }
//     public User getUser() {
//         return user;
//     }
//     public void setUser(User user) {
//         this.user = user;
//     }
//     public Role getRole() {
//         return role;
//     }
//     public void setRole(Role role) {
//         this.role = role;
//     }
    
// }







    
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private int id;
	// private String name;
	// @OneToMany(mappedBy = "role")
	// private Set<UserRole> roleUser;
    // public Role() {
        
    // }
    // public Role(int id, String name, Set<UserRole> roleUsers) {
    //     this.id = id;
    //     this.name = name;
    //     this.roleUser = roleUsers;
    // }
    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public Set<UserRole> getRoleUsers() {
    //     return roleUser;
    // }
    // public void setRoleUsers(Set<UserRole> roleUsers) {
    //     this.roleUser = roleUsers;
    // }
    

