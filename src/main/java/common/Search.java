package common;


import lombok.Getter;

public class Search {
	
	///Field
	@Getter
	private int currentPage;
	@Getter
	private String searchCondition;
	@Getter
	private String searchKeyword;
	///Method
	@Getter
	private int pageSize;
	@Getter
	private String orderCondition;
	private int endRowNum;
	private int startRowNum;
	
	///Constructor
	public Search() {
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public void setOrderCondition(String orderCondition) {
		this.orderCondition = orderCondition;
	}
	
	public int getStartRowNum() {
		return (getCurrentPage()-1)*getPageSize()+1;
	}

	public int getEndRowNum() {
		return getCurrentPage()*getPageSize();
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Search [currentPage=");
		builder.append(currentPage);
		builder.append(", searchCondition=");
		builder.append(searchCondition);
		builder.append(", searchKeyword=");
		builder.append(searchKeyword);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", orderCondition=");
		builder.append(orderCondition);
		builder.append(", endRowNum=");
		builder.append(endRowNum);
		builder.append(", startRowNum=");
		builder.append(startRowNum);
		builder.append("]");
		return builder.toString();
	}
	

}