<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath }" />
<div>
	<ul>
		 <li>오늘날씨</li>
		 <c:forEach items="${TODAY}" var="TD">
			<li>${TD.fcstDate}</li>
			<li>${TD.fcstTime}</li>
			<li>${TD.category}</li>
			<li>${TD.fcstValue}</li>
		</c:forEach>
		<li>내일날씨=====================================================================</li>
		 <c:forEach items="${TOMORROW}" var="TM">
			<li>${TM.fcstDate}</li>
			<li>${TM.fcstTime}</li>
			<li>${TM.category}</li>
			<li>${TM.fcstValue}</li>
		</c:forEach>
		<li>2일뒤날씨=====================================================================</li>
		 <c:forEach items="${AFTERTOMORROW}" var="AM">
			<li>${AM.fcstDate}</li>
			<li>${AM.fcstTime}</li>
			<li>${AM.category}</li>
			<li>${AM.fcstValue}</li>
		</c:forEach>
	</ul>
</div>