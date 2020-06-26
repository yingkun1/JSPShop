package online.luffyk.dao;

import online.luffyk.domain.Product;

import java.util.List;

public interface ProductDao {
    Integer addOneProductDao(Product product);

    List<Product> showAllProductDao();

    List<Product> getSomeProductByPIDDao(Integer PID);

    List<Product> getSomeProductByCIDDao(Integer CID);

    Product getProductByIDDao(Integer product_id);
}
