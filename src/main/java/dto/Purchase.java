package dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class Purchase {

	private User buyer;
	private String dlvyAddr;
	private String dlvyDate;
	private String dlvyRequest;
	private Date orderDate;
	private String paymentOption;
	private Product purchaseProd;
	private String prodName;
	private String receiverName;
	private String receiverPhone;
	private String tranCode;
	private int tranNo;
	private int prodNo;
	private int count;

	public Purchase() {

	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public void setDlvyAddr(String dlvyAddr) {
		this.dlvyAddr = dlvyAddr;
	}

	public void setDlvyDate(String dlvyDate) {
		this.dlvyDate = dlvyDate;
	}

	public void setDlvyRequest(String dlvyRequest) {
		this.dlvyRequest = dlvyRequest;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public void setPurchaseProd(Product purchaseProd) {
		this.purchaseProd = purchaseProd;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Purchase [buyer=");
		builder.append(buyer);
		builder.append(", dlvyAddr=");
		builder.append(dlvyAddr);
		builder.append(", dlvyDate=");
		builder.append(dlvyDate);
		builder.append(", dlvyRequest=");
		builder.append(dlvyRequest);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", paymentOption=");
		builder.append(paymentOption);
		builder.append(", purchaseProd=");
		builder.append(purchaseProd);
		builder.append(", prodName=");
		builder.append(prodName);
		builder.append(", receiverName=");
		builder.append(receiverName);
		builder.append(", receiverPhone=");
		builder.append(receiverPhone);
		builder.append(", tranCode=");
		builder.append(tranCode);
		builder.append(", tranNo=");
		builder.append(tranNo);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}

	

}