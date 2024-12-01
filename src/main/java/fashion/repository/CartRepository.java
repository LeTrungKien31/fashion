// package fashion.repository;

// import org.springframework.data.jpa.repository.query.Procedure;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

// import fashion.models.admin.Cart;

// public interface CartRepository extends CrudRepository<Cart, Integer> {
//     @Procedure(procedureName = "AddCartItem")
//     void addCartItem(@Param("cartId") int cartId, @Param("id") int id, @Param("quantity") int quantity);
//     @Procedure(procedureName = "DeleteCartItemByIdAndCart")
//     void deleteCartItemByIdAndCart(@Param("itemId") int itemId, @Param("cartId") int cartId);

// }

