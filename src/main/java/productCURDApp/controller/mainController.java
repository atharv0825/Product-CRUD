package productCURDApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productCURDApp.dao.ProductDao;
import productCURDApp.modelClass.Product;

@Controller
public class mainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Product>products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String add_product(Model model) {
		model.addAttribute("title", "Add product");
		return "add_product_form";
	}
	
	
//	handle product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleproduct(@ModelAttribute Product product , HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/delete-product/{product_id}")
	@Transactional
	public RedirectView deleteProduct(@PathVariable("product_id") int product_id,HttpServletRequest request) {
		productDao.deleteProduct(product_id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update-product/{product_id}")
	public String updateForm(@PathVariable("product_id") int product_id , Model model) {
		Product product = this.productDao.getProduct(product_id);
		model.addAttribute("product", product);
		return "update_form";
	}
}
