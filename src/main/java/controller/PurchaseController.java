package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dto.Purchase;
import service.ProductService;
import service.PurchaseService;
import service.UserService;

@Controller
@RequestMapping("/purchase/*")
public class PurchaseController {

	/// Field
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	int pageSize;

	public PurchaseController() {
		System.out.println(this.getClass());
	}

	@RequestMapping("addPurchaseView")
	public ModelAndView addPurchaseView(@RequestParam("prodNo") int prodNo, HttpSession session) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", session.getAttribute("user"));
		modelAndView.addObject("product", productService.getProduct(prodNo));
		modelAndView.setViewName("forward:/purchase/addPurchaseView.jsp");

		return modelAndView;
	}

	@RequestMapping("addPurchase")
	public ModelAndView addPurchase( @ModelAttribute("purchase") Purchase purchase,
			@RequestParam("buyerId") String buyerId, @RequestParam("prodNo") int prodNo) throws Exception {

		purchase.setBuyer(userService.getUser(buyerId));
		purchase.setPurchaseProd(productService.getProduct(prodNo));
		purchase.setTranCode("1");
		
		purchaseService.addPurchase(purchase);
		
		return new ModelAndView("forward:/purchase/addPurchase.jsp","purchase", purchase);
	}

	@RequestMapping("getPurchase")
	public ModelAndView getPurchase (@RequestParam("tranNo") int tranNo) throws Exception {
		return new ModelAndView("forward:/purchase/getPurchase.jsp","purchase",purchaseService.getPurchase(tranNo));
	}
	
	@RequestMapping("getPurchase2")
	public ModelAndView getPurchase2 (@RequestParam("prodNo") int prodNo) throws Exception {
		return new ModelAndView("forward:/purchase/getPurchase.jsp","purchase",purchaseService.getPurchase(prodNo));
	}
	
	@RequestMapping("listPurchase")
	public ModelAndView listPurchase (@ModelAttribute("search") Search search, HttpSession session) throws Exception {
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		String buyerId = ((User)session.getAttribute("user")).getUserId();
		Map<String, Object> map = purchaseService.getPurchaseList(search, buyerId);

		Page resultPage = new Page( search.getCurrentPage(),((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);

		System.out.println("ListPurchase ::" + resultPage);
		System.out.println("ListPurchase ::" + search);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list",map.get("list"));
		modelAndView.addObject("resultPage", resultPage);
		modelAndView.addObject("search", search);
		modelAndView.setViewName("forward:/purchase/listPurchase.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="updatePurchase" , method = RequestMethod.GET)
	public ModelAndView updatePurchaseView (@RequestParam("tranNo") int tranNo) throws Exception {
		return new ModelAndView("forward:/purchase/updatePurchase.jsp","purchase",purchaseService.getPurchase(tranNo));
	}
	
	@RequestMapping(value="updatePurchase" , method = RequestMethod.POST)
	public ModelAndView updatePurchase (@ModelAttribute("purchase") Purchase purchase,@RequestParam("tranNo") int tranNo) throws Exception {
		
		purchaseService.updatePurchase(purchase);
		
		return new ModelAndView("forward:/purchase/getPurchase.jsp","tranNo",tranNo);
	}
	@RequestMapping("updateTranCodeByProd")
	public ModelAndView updateTranCodeByProd(@RequestParam("currentPage") int currentPage, @RequestParam("prodNo") int prodNo, @RequestParam("tranCode") String tranCode) throws Exception {
		Purchase purchase = purchaseService.getPurchase2(prodNo);
		purchase.setTranCode(tranCode);
		purchaseService.updateTranCode(purchase);
		return new ModelAndView("redirect:/product/listProduct?menu=manage&currentPage="+currentPage);
	}

	
}