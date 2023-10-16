package serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.Search;
import domain.Product;
import repository.ProductRepository;
import service.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("productDaoImpl")
	ProductService productService;

	public ProductServiceImpl() {
		System.out.println("::" + getClass() + ".default Constructor Call....");
	}

	@Override
	public int addProduct(Product product) throws Exception {
		return productService.addProduct(product);
	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		return productService.getProduct(prodNo);
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		return productService.updateProduct(product);
	}

	@Override
	public Map<String , Object > getProductList(Search search) throws Exception {
		List<Object> list = productService.getProductList(search);
		int totalCount = 0;
		if(list.size()>0) totalCount=((Product)list.get(0)).getCount();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

}