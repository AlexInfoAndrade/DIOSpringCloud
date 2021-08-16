package dio.desafio.springcloud.shoppingcart.repository;

import dio.desafio.springcloud.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {

}
