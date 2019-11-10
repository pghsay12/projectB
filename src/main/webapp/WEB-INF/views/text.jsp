<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	
 $(function() {
	 
 	$("#input-submit").on("click", function() {
 		event.preventDefault();
 		event.stopPropagation();
 		
 		$("form").attr("method", "POST").attr("action", "/main/")
 		.submit();
 	});
 	
 	$('.cname').on("click", function(e) {
 		event.preventDefault();
 		var value = $(event.target).children("div").attr("value");
 		var url = "/main/json/updateGuest?no="+value;
 		
 	$.ajax({
 		async : false,
 		type : "POST",
 		contentType : 'application/json',
 		url : "/main/json/updateGuest?no="+value,
 		dataType : "json",
 		success : function(Data){
 		
 			$(".iname").val(Data.name);
 			$(".kname").val(Data.pwd);
 			$(".lname").val(Data.content);
 			
 		}
 	});
 		
 		alert(Data.pwd)
 		
 		//$("form").attr("method", "POST").attr("action", url).submit();
  		//$("form").attr("method", "POST").attr("action", "/main/json/updateGuest?no="+value).submit();
 		
 	});
 	
 });
 
</script>

<title>테이블 테스트</title>
</head>
<body>
	<form id="add-form" >
	
		<input type="text" class="iname" name="name" id="input-name" placeholder="이름" >
		<div class="dname"></div>
		<input type="password" class="kname" name="pwd" id="input-password" placeholder="비밀번호">
		<textarea id="tx-content" class="lname" name="content" placeholder="내용을 입력해주세요"></textarea>
		<input type="submit" id="input-submit" value="보내기">
		<br>
		<table border="1">
			<tr>
				<td>번호</td><td>이름</td><td>내용</td><td>수정</td>
			</tr>
			<c:forEach var="list" items="${list }">
				<c:set var="i" value="${i+1 }"></c:set>
				<tr>
				<td>${i}</td><td>${ list.name}</td><td>${list.content }</td>
				<td class="cname">
				<div class="name" style="display:none" name="no" value="${list.no }">
				</div>
				수정
				</td>
				<td><a href="/main/deleteform?no=${list.no }"/>삭제</td>
				<tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>