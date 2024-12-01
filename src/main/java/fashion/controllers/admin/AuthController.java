package fashion.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fashion.models.admin.Role;
import fashion.models.admin.User;
import fashion.repository.RoleRepository;
import fashion.repository.UserRepository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;
    

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
        }
        return "auth/login";
    }

 

    @GetMapping("/register")
    public String registerPage() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam String confirmPassword, @RequestParam int roleId,
                               @RequestParam(required = false) String hoTen,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String diaChi,
                               @RequestParam(required = false) String soDienThoai,
                               @RequestParam(required = false) String ngaySinh,
                               Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Mật khẩu không khớp!");
            return "auth/register";
        }

        if (userRepository.existsByTenDangNhap(username)) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "auth/register";
        }

        User newUser = new User();
        newUser.setTenDangNhap(username);
        newUser.setMatKhau(passwordEncoder.encode(password));
        newUser.setHoTen(hoTen);
        newUser.setEmail(email);
        newUser.setDiaChi(diaChi);
        newUser.setSoDienThoai(soDienThoai);
        newUser.setKichHoat(true); // Hoặc giá trị mặc định

        // Chuyển đổi ngày sinh từ String sang Date
        if (ngaySinh != null && !ngaySinh.isEmpty()) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
                newUser.setNgaySinh(date);
            } catch (ParseException e) {
                model.addAttribute("error", "Ngày sinh không hợp lệ!");
                return "auth/register";
            }
        }
       

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Vai trò không hợp lệ"));
        newUser.setRole(role);

        userRepository.save(newUser);

        return "redirect:/login";
    }
}




   

   
