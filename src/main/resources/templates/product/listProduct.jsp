<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>상품 목록조회</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">
 
<script type="text/javascript">

	function fncSearchConditionCheck() {
		var searchCondition = document.detailForm.searchCondition.value;
		var searchKeyword = document.detailForm.searchKeyword.value;

		if (searchKeyword == null) {
			alert("검색어를 입력해주세요");
		} else {
			if (searchCondition == 1 && isNaN(Number(searchKeyword)) == true) {
				alert("검색하실 상품의 상품 번호로 입력해주세요.");
			} else {
				document.getElementById("currentPage").value = 1;
				document.getElementById("orderCondition").value = null;
				document.detailForm.submit();
			}
		}
	}
	
	function fncGetList(currentPage) {
		document.getElementById("currentPage").value = currentPage;
		document.detailForm.submit();
	}
	
	function fncOrderList(orderCondition) {
		document.getElementById("currentPage").value = 1;
		document.getElementById("orderCondition").value = orderCondition;
		document.detailForm.submit();
	}

</script>

</head>

<body bgcolor="#ffffff" text="#000000">

	<div style="width: 98%; margin-left: 10px;">

		<form name="detailForm" action="/product/listProduct?menu=${menu}" method="post">

			<table width="100%" height="37" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"
						width="15" height="37" /></td>
					<td background="/images/ct_ttl_img02.gif" width="100%"
						style="padding-left: 10px;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="93%" class="ct_ttl01">
									${ menu eq 'manage' ? '상품관리': '상품검색'}
								</td>
							</tr>
						</table>
					</td>
					<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"
						width="12" height="37" /></td>
				</tr>
			</table>

			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;">
				<tr>
					<td align="right">
						<c:if test="${ menu eq 'manage'}" >
							<select name="searchCondition" id="searchCondition" class="ct_input_g" style="width: 80px">
								<option value="2" ${ search.searchCondition eq '2' ? 'selected' : '' }>상품명</option>
								<option value="1" ${ search.searchCondition eq '1' ? 'selected' : '' }>상품번호</option>
								
							</select> 
						</c:if>
						<c:if test="${ menu eq 'search'}" >
							<input type="hidden" id="searchCondition" name="searchCondition" value="2" />
						</c:if>
						<input type="text" name="searchKeyword" value="${ search.searchKeyword }" class="ct_input_g" style="width: 200px; height: 19px"  />
					</td>
					
					<td align="right" width="70">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
								<td background="/images/ct_btnbg02.gif" class="ct_btn01"
									style="padding-top: 3px;">
									<a href="javascript:fncSearchConditionCheck();">검색</a>
								</td>
								<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>


				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin: 30px 0;">
					<tr>
						<td colspan="7">전체 ${ resultPage.totalCount } 건수, 현재  ${ resultPage.currentPage } 페이지
						</td>
						
						<td colspan="100%" style="text-align: right;">
							<input type="hidden" id="orderCondition" name="orderCondition" value="${ search.orderCondition }" />
							정렬 기준 : 
							<a href="javascript:fncOrderList('${menu eq 'manage'? '2' : '1'}');" >${menu eq 'manage'? '결제완료 된' : '구매 가능한'} 상품만 보기</a>
							|
							<a href="javascript:fncOrderList('3');">가격 높은 순</a>
							|
							<a href="javascript:fncOrderList('4');">가격 낮은 순</a>
						</td>
					</tr>
					<tr>
						<td class="ct_list_b" width="100">No</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b" width="150">상품명</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b" width="150">가격</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">등록일</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">배송 현황</td>
					</tr>
					<tr>
						<td colspan="11" bgcolor="808285" height="1"></td>
					</tr>
					
					<c:if test="${resultPage.totalCount == 0}">
						<tr class="ct_list_pop"> 
							<td align="center" colspan="100%">
								검색 내역이 없습니다.
							</td>
						</tr>
						<tr>
							<td colspan="11" bgcolor="D6D7D6" height="1"></td>
						</tr>
					</c:if>
					
					<c:if test="${resultPage.totalCount > 0}">
					<c:set var="i" value="0" />
					<c:forEach var="product" items="${list}">
						<c:set var="i" value="${ i+1 }" />
						<tr class="ct_list_pop">
							<td align="center">${ i }</td>
							<td></td>
							<td align="left">
								<c:choose>
									<c:when test="${ product.proTranCode eq '0' }">
										<a href="/product/${ menu eq 'manage' ? 'updateProduct' : 'getProduct'}?prodNo=${ product.prodNo }&menu=${menu}">${ product.prodName }</a>
									</c:when>
									<c:otherwise>
										${ product.prodName }
									</c:otherwise>
								</c:choose>
							</td>						
							<td></td>
							<td align="left">${product.price }</td>
							<td></td>
							<td align="left">${product.regDate}</td>
							<td></td>
							<td align="left">
							<c:if test="${ menu eq 'manage' }"> 
								<c:choose>
									<c:when test="${ product.proTranCode eq '0' }">
										판매중
									</c:when>
									<c:when test="${ product.proTranCode eq '1' }">
										결제 완료  (배송 대기)
										<a href="/purchase/updateTranCodeByProd?prodNo=${ product.prodNo }&tranCode=2&currentPage=${resultPage.currentPage}">배송하기</a>
									</c:when>
									<c:when test="${ product.proTranCode eq '2' }">
										배송중
									</c:when>
									<c:when test="${ product.proTranCode eq '3' }">
										배송 완료
									</c:when>
				               </c:choose>
			               </c:if>
			               <c:if test="${ menu eq 'search' }"> 
			                   <c:choose>
									<c:when test="${ product.proTranCode eq '0' }">
										판매중
									</c:when>
									<c:otherwise>
										재고 없음
									</c:otherwise>
								</c:choose> 
			               </c:if>
						</td>
						</tr>
						
						<tr>
							<td colspan="11" bgcolor="D6D7D6" height="1"></td>
						</tr>
					</c:forEach>
					</c:if>
				</table>
				
				<!-- PageNavigation Start... -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					style="margin-top: 10px;">
					<tr>
						<td align="center">
							<input type="hidden" id="currentPage" name="currentPage" value="" /> 
							<jsp:include page="../common/pageNavigator2.jsp"/>
						</td>
					</tr>
				</table>
				<!-- PageNavigation End... -->
			
		</form>

	</div>
</body>
</html>