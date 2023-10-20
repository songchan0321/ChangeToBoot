package dto;

import lombok.Getter;

import java.sql.Date;


@Getter
public class Product {

	private Long prodNo;
	private String prodName;
	private String prodDetail;
	private String manuDate;
	private int price;
	private String fileName;
	private Date regDate;
	private String proTranCode;
	private int count;
	
	public Product() {
	}

	public void setProdNo(Long prodNo) {
		this.prodNo = prodNo;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public void setManuDate(String manuDate) {
		this.manuDate = manuDate;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setProTranCode(String proTranCode) {
		this.proTranCode = proTranCode;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [prodNo=");
		builder.append(prodNo);
		builder.append(", prodName=");
		builder.append(prodName);
		builder.append(", prodDetail=");
		builder.append(prodDetail);
		builder.append(", manuDate=");
		builder.append(manuDate);
		builder.append(", price=");
		builder.append(price);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", proTranCode=");
		builder.append(proTranCode);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}

}