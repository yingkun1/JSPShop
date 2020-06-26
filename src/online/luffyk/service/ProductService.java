package online.luffyk.service;

import online.luffyk.domain.Product;

import java.util.List;

public interface ProductService {
    Integer addOneProductService(Product product);

    List<Product> showAllProductService();

    List<Product> getSomeProductByPIDService(Integer PID);

    List<Product> getSomeProductByCIDService(Integer CID);
}
