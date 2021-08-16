package dio.desafio.springcloud.productcatolog.repository;

import dio.desafio.springcloud.productcatolog.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByName(String name);
}
