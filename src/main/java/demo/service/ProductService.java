package demo.service;

import demo.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductService extends CrudRepository<Product, Integer> {
}
