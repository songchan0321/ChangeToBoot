package service;

import java.util.Map;

import common.Search;
import dto.Purchase;

public interface PurchaseService {

	public void addPurchase(Purchase purchase) throws Exception;
	public Purchase getPurchase(int tranNo) throws Exception;
	public Purchase getPurchase2(int prodNo) throws Exception;
	public Map<String,Object> getPurchaseList(Search search, String buyerId) throws Exception;
	public void updatePurchase(Purchase purchase) throws Exception;
	public void updateTranCode(Purchase purchase) throws Exception;
	
}