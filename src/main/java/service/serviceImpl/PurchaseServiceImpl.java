package service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.Search;
import service.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	@Qualifier("purchaseImpl")
	PurchaseService purchaseService;
	
	public PurchaseServiceImpl() {
		System.out.println("::" + getClass() + "�⺻ ������ ȣ��....");
	}

	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		PurchaseService.addPurchase(purchase);
	}

	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		return PurchaseService.getPurchase(tranNo);
	}

	@Override
	public Purchase getPurchase2(int prodNo) throws Exception {
		return PurchaseService.getPurchase2(prodNo);
	}

	@Override
	public Map<String, Object> getPurchaseList(Search search, String buyerId) throws Exception {
		List<Object> list = PurchaseService.getPurchaseList(search, buyerId);
		int totalCount = 0;
		if(list.size()>0) totalCount=((Purchase)list.get(0)).getCount();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		return map; 
	}


	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		PurchaseService.updatePurchase(purchase);
	}
	@Override
	public void updateTranCode(Purchase purchase) throws Exception {
		PurchaseService.updateTranCode(purchase);
	}



}