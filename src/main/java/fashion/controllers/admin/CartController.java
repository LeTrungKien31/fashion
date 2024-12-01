// package fashion.controllers.admin;

// import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.CookieValue;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import fashion.models.admin.Cart;
// import fashion.models.admin.CartDetails;
// import fashion.models.admin.Product;
// import fashion.repository.CartRepository;
// import fashion.repository.ProductRepository;
// import fashion.service.Helper;
// import jakarta.servlet.http.Cookie;
// import jakarta.servlet.http.HttpServletResponse;


// @Controller
// public class CartController {

//     private static final Logger logger = LoggerFactory.getLogger(CartController.class);

//     @Autowired
//     private CartRepository cartRepository;

//     @Autowired
//     private ProductRepository productRepository;

//     // Hiển thị trang giỏ hàng
//     @GetMapping("/cart")
//     public String index(Model model, @CookieValue(value = "cart", required = false) String cartCode, HttpServletResponse response) {
//         if (cartCode == null || cartCode.isEmpty()) {
//             cartCode = Helper.randomString(32);
//             response.addCookie(new Cookie("cart", cartCode));
//         }
//         Cart cart = cartRepository.findById(id);
//         model.addAttribute("cartItems", cart != null ? cart.getCartDetails() : null);
//         model.addAttribute("totalPrice", cart != null ? cart.getTotalPrice() : 0);
//         return "cart/index";
//     }

//     // Thêm sản phẩm vào giỏ hàng
//     @PostMapping("/cart/add")
//     public String add(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity,
//                       @CookieValue(value = "cart", required = false) String cartCode, HttpServletResponse response, Model model) {
//         if (quantity <= 0) {
//             model.addAttribute("error", "Số lượng phải lớn hơn 0.");
//             return "redirect:/cart";
//         }

//         Cart cart;
//         if (cartCode == null || cartCode.isEmpty()) {
//             cartCode = Helper.randomString(32);
//             cart = new Cart();
//             cart.setCode(cartCode);
//             cartRepository.save(cart);
//             response.addCookie(new Cookie("cart", cartCode));
//         } else {
//             cart = cartRepository.findById(cartCode);
//         }

//         Optional<Product> product = productRepository.findById(productId);
//         if (product.isEmpty()) {
//             model.addAttribute("error", "Sản phẩm không tồn tại.");
//             return "redirect:/cart";
//         }

//         cartRepository.addCartItem(cart.getId(), productId, quantity);
//         return "redirect:/cart";
//     }

//     // Xóa sản phẩm khỏi giỏ hàng
//     @PostMapping("/cart/delete/{id}")
//     public String delete(@PathVariable("id") int id, @CookieValue(value = "cart", required = false) String cartCode, Model model) {
//         if (cartCode != null && !cartCode.isEmpty()) {
//             Cart cart = cartRepository.findById(cartCode);
//             if (cart != null) {
//                 cartRepository.deleteCartItemByIdAndCart(id, cart.getId());
//             } else {
//                 model.addAttribute("error", "Không tìm thấy giỏ hàng.");
//             }
//         } else {
//             model.addAttribute("error", "Cookie giỏ hàng không tồn tại.");
//         }
//         return "redirect:/cart";
//     }

//     // Cập nhật số lượng sản phẩm trong giỏ hàng
//     @PostMapping("/cart/update")
//     public String updateQuantity(@RequestParam("id") int id, @RequestParam("quantity") int quantity,
//                                  @CookieValue(value = "cart", required = false) String cartCode, Model model) {
//         if (quantity <= 0) {
//             model.addAttribute("error", "Số lượng phải lớn hơn 0.");
//             return "redirect:/cart";
//         }

//         if (cartCode == null || cartCode.isEmpty()) {
//             model.addAttribute("error", "Không có giỏ hàng để cập nhật.");
//             return "redirect:/cart";
//         }

//         Cart cart = cartRepository.findById(cartCode);
//         if (cart == null) {
//             model.addAttribute("error", "Không tìm thấy giỏ hàng.");
//             return "redirect:/cart";
//         }

//         CartDetails cartItem = cart.getCartDetails()
//                 .stream()
//                 .filter(item -> item.getId() == id)
//                 .findFirst()
//                 .orElse(null);

//         if (cartItem == null) {
//             model.addAttribute("error", "Sản phẩm không có trong giỏ hàng.");
//             return "redirect:/cart";
//         }

//         cartItem.setQuantity(quantity);
//         cartRepository.save(cart);
//         return "redirect:/cart";
//     }
// }


// //     private static final Logger logger = LoggerFactory.getLogger(CartController.class);

// //     @Autowired
// //     private CartRepository cartRepository; // Inject repository cho giỏ hàng

// //     @Autowired
// //     private ProductRepository productRepository; // Inject repository cho sản phẩm

// //     // @Autowired
// //     // private CartService cartService; // Inject service cho giỏ hàng

// //     // Hiển thị trang giỏ hàng
// //     @GetMapping("/cart")
// //     public String index(Model model, @CookieValue(value = "cart", required = false) String cartCode) {
// //         if (cartCode == null || cartCode.isEmpty()) {
// //             cartCode = Helper.randomString(32); // Tạo mã giỏ hàng ngẫu nhiên nếu không có
// //         }
// //         Cart cart = cartRepository.findByCode(cartCode); // Tìm giỏ hàng theo mã
// //         model.addAttribute("cartItems", cart != null ? cart.getCartDetails() : null); // Thêm danh sách sản phẩm vào model

// //         return "cart/index"; // Trả về trang giỏ hàng
// //     }

// //     // Thêm sản phẩm vào giỏ hàng
// //     @PostMapping("/cart/add")
// //     public String add(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity,
// //                       HttpServletResponse response, @CookieValue(value = "cart", required = false) String cartCode) {
// //         String code;
// //         Cart cart;

// //         // Kiểm tra xem giỏ hàng đã tồn tại chưa
// //         if (cartCode == null || cartCode.isEmpty()) {
// //             code = Helper.randomString(32); // Tạo mã giỏ hàng mới
// //             cart = new Cart();
// //             cart.setCode(code);
// //             cartRepository.save(cart); // Lưu giỏ hàng vào cơ sở dữ liệu
// //             response.addCookie(new Cookie("cart", code)); // Thêm cookie cho giỏ hàng
// //         } else {
// //             cart = cartRepository.findByCode(cartCode); // Tìm giỏ hàng theo mã
// //             code = cartCode;
// //         }

// //         // Kiểm tra xem sản phẩm có tồn tại không
// //             Optional<Product> product = productRepository.findById(productId);
// //             if (product == null) {
// //                 System.out.println("Không tìm thấy sản phẩm với id: " + productId);
// //                 return "redirect:/cart?error=ProductNotFound"; // Nếu không tìm thấy, chuyển hướng với thông báo lỗi
// //             }

// //         // Thêm sản phẩm vào giỏ hàng
// //         cartRepository.addCartItem(cart.getId(), productId, quantity);

// //         return "redirect:/cart"; // Chuyển hướng về trang giỏ hàng
// //     }

// //     // Xóa sản phẩm khỏi giỏ hàng
// //     @PostMapping("/cart/delete/{id}")
// //     public String delete(@PathVariable("id") int id, @CookieValue(value = "cart", required = false) String cartCode) {
// //         if (cartCode != null && !cartCode.isEmpty()) {
// //             Cart cart = cartRepository.findByCode(cartCode); // Tìm giỏ hàng theo mã
// //             if (cart != null) {
// //                 // Xóa sản phẩm khỏi giỏ hàng
// //                 cartRepository.deleteCartItemByIdAndCart(id, cart.getId());
// //             }
// //         }
// //         return "redirect:/cart"; // Chuyển hướng về trang giỏ hàng
// //     }

// //     // Cập nhật số lượng sản phẩm trong giỏ hàng
// //     @PostMapping("/cart/update")
// //     public String updateQuantity(@RequestParam("id") int id, @RequestParam("quantity") int quantity,
// //                                  @CookieValue(value = "cart", required = false) String cartCode) {
// //         if (cartCode == null || cartCode.isEmpty()) {
// //             return "redirect:/cart?error=NoCart"; // Nếu không có giỏ hàng, chuyển hướng với thông báo lỗi
// //         }

// //         // Tìm giỏ hàng
// //         Cart cart = cartRepository.findByCode(cartCode);
// //         if (cart == null) {
// //             return "redirect:/cart?error=CartNotFound"; // Nếu không tìm thấy giỏ hàng, chuyển hướng với thông báo lỗi
// //         }

// //         // Tìm sản phẩm trong giỏ hàng
// //         CartDetails cartItem = cart.getCartDetails()
// //                 .stream()
// //                 .filter(item -> item.getId() == id)
// //                 .findFirst()
// //                 .orElse(null);

// //         if (cartItem == null) {
// //             return "redirect:/cart?error=ProductNotInCart"; // Nếu sản phẩm không có trong giỏ hàng, chuyển hướng với thông báo lỗi
// //         }

// //         // Cập nhật số lượng
// //         cartItem.setQuantity(quantity);
// //         cartRepository.save(cart); // Lưu giỏ hàng đã cập nhật

// //         return "redirect:/cart"; // Chuyển hướng
// //     }
    
// // }