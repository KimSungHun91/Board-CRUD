<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>list.jsp</title>
<style>
table, th, td {
  border: 1px solid black;
}
table {
    width: 600px;
}
.th3 {
	width: 400px;
}
.centerBox {
	margin : 0 auto;
	padding : 6em;
	width : 40em;
}
</style>
</head>
<body>
<div class="centerBox">
<a href="/board">Home</a> <a href="insert">글쓰기</a> <p style="text-align: right">LoginUser : ${ LoginUserName }</p>
<table>
	<thead>
		<tr>
			<th class="th1">Type</th>
			<th>No</th>
			<th class="th3">Title</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th colspan="3">total : ${ count }</th>
		</tr>
	</tfoot>
	<tbody>
		<c:choose>
			<c:when test="${ empty list }">
				<tr>
					<th colspan="3">empty</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${ list }" var="board">
					<tr>
						<td>${ board.board_type }</td>
						<td>${ board.board_num }</td>
						<td><a href="detail?no=${ board.board_num }">${ board.board_title }</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</div>
</body>
</html>
