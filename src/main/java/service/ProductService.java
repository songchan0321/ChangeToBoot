package service;

import java.util.Map;

import common.Search;
import dto.Product;

public interface ProductService {
	public int addProduct(Product product) throws Exception;
	public Product getProduct(int prodNo) throws Exception;
	public int updateProduct(Product product) throws Exception;
	public Map<String, Object> getProductList(Search search) throws Exception;
}
