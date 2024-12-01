// package fashion;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class WebConfig implements WebMvcConfigurer {

//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         // Đảm bảo ánh xạ đúng thư mục chứa ảnh
//         registry.addResourceHandler("/uploads/avatars/**")
//                 .addResourceLocations("file:" + System.getProperty("user.dir") + "/uploads/avatars/");
//     }
// }
