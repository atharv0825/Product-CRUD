package productCURDApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productCURDApp.modelClass.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
//	create Product
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}	
	
//	get single product
	public Product getProduct(int product_id) {
		Product p = this.hibernateTemplate.get(Product.class, product_id);
		return p;
	}
//	get all product
	public List<Product> getAllProducts() {
		List<Product>products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
//	delete single product
	public void deleteProduct(int product_id) {
		Product p =this.hibernateTemplate.load(Product.class,product_id);
		this.hibernateTemplate.delete(p);
	}
}
