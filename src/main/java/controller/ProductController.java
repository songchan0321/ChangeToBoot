package controller;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import common.Page;
import common.Search;
import dto.Product;
import repository.ProductRepository;
import service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	private ProductService productService;

	@Value("${commonProperties.pageUnit}")
	int pageUnit;

	@Value("${commonProperties.pageSize}")
	int pageSize;

	@Value("${commonProperties.path}")
	String path;
	
	public ProductController() {
		System.out.println(this.getClass());
		
	}

	@RequestMapping(value="addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct()  {
		System.out.println("addProduct : GET");
		System.out.println(path);
		return new ModelAndView("forward:/product/addProductView.jsp");
	}

	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, MultipartHttpServletRequest request) throws Exception {

	    System.out.println(path);
	    System.out.println("addProduct : POST");


	    Map<String, MultipartFile> files = request.getFileMap();
	    

	    CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("uploadFile");
	    

	    String uploadPath = path + cmf.getOriginalFilename();
	    

	    File file = new File(uploadPath);
	    System.out.println(uploadPath);
	    cmf.transferTo(file);
	    

	    product.setFileName(cmf.getOriginalFilename());
	    

	    productService.addProduct(product);


	    return new ModelAndView("forward:/product/addProductResult.jsp", "product", product);
	}

	@RequestMapping("listProduct")
	public ModelAndView listProduct(@RequestParam("menu") String menu, 
									@ModelAttribute("search") Search search)
			throws Exception {

		System.out.println("listProduct/"+menu);

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);

		Map<String, Object> map = productService.getProductList(search);
		Page resultPage = new Page(search.getCurrentPage(), 
								   ((Integer) map.get("totalCount")).intValue(),
								   pageUnit,
								   search.getPageSize());
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("forward:/product/listProduct.jsp");
		modelAndView.addObject("menu", menu);
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("resultPage", resultPage);
		modelAndView.addObject("search", search);

		return modelAndView;
	}

	@RequestMapping(value="getProduct" , method = RequestMethod.GET)
	public ModelAndView getProduct( @RequestParam("menu") String menu,
									@RequestParam("prodNo") int prodNo, 
									HttpServletRequest request, 
									HttpServletResponse response) throws Exception {

		System.out.println("getProduct/"+menu);

		Product product = productService.getProduct(prodNo);
		setCookie(request, response);
		String viewName = menu.equals("manage")?"forward:/product/updateProductView.jsp":"forward:/product/getProduct.jsp";
		
		String[] fileList = product.getFileName().split("/");
		
		System.out.println("viewName = "+viewName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("product", product);
		modelAndView.addObject("menu",menu);
		modelAndView.addObject("fileList",fileList);
		
		return modelAndView;
	}
	
	@RequestMapping(value="updateProduct" , method = RequestMethod.GET)
	public ModelAndView updateProduct( @RequestParam("prodNo") int prodNo ) throws Exception {

		System.out.println("updateProduct/"+prodNo);
		
		return new ModelAndView("forward:/product/updateProductView.jsp","product",productService.getProduct(prodNo));
	}
	
	@RequestMapping(value="updateProduct" , method = RequestMethod.POST)
	public ModelAndView updateProduct( @ModelAttribute("product") Product product ) throws Exception {
		
		System.out.println("updateProduct : POST");
		
		productService.updateProduct(product);
		product = productService.getProduct(product.getProdNo());
		
		return new ModelAndView("forward:/product/getProduct.jsp","product", product);
		
	}

	private void setCookie(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		String history = "";
		
		String newHistory = request.getParameter("prodNo");
		
		for (Cookie cookie : cookies) {
			System.out.println("cookie name:"+cookie.getName());
			if (cookie.getName().equals("history")) {
				System.out.println("history exists");
				if (cookie.getValue().contains(newHistory)) {
					System.out.println("same named cookie exists");
					history = cookie.getValue();
				} else {
					System.out.println("no same named cookie");
					history = newHistory+cookie.getValue();
				}
				cookie.setValue(history);
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
				break;
			} else {
				System.out.println("no history cookie");
				response.addCookie(new Cookie("history", newHistory));
				System.out.println("make history");
			}
		}
		System.out.println("===========history"+history);
		
	}

}