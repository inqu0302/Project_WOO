<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<style>
div ul{
	display: flex;
	list-style: none;
}

div ul li{
	display: flex;
	flex-direction: column;
}



</style>
<div>
	<ul>
		<%=request.getAttribute("TIME")%>
		<li>${TD.fcstTime}</li>
		<c:forEach items="${TODAY}" var="TD">
			<c:if test="${TD.category == '3시간 기온'}">
				<li id="time">${TD.fcstTime}</li>
				<li>${TD.fcstValue}</li>
				<li id="value"></li>
			</c:if>
		</c:forEach>
		<li>"${SEASON}"</li>
	</ul>
</div>

<script>
var time = document.getElementById("time")

 console.log(time)
</script>