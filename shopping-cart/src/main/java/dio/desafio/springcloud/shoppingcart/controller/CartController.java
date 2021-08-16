package dio.desafio.springcloud.shoppingcart.controller;

import dio.desafio.springcloud.shoppingcart.model.Cart;
import dio.desafio.springcloud.shoppingcart.model.Item;
import dio.desafio.springcloud.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartRepository cartRepository;

    @Autowired
    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable Integer id, @RequestBody Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;

        if(savedCart.isPresent()){
            cart = savedCart.get();
        }else {
            cart = new Cart(id);
        }

        cart.getItems().add(item);

        return cartRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable Integer id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable Integer id) {
        cartRepository.deleteById(id);
    }

}
