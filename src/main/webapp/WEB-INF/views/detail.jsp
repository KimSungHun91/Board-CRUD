<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
table, th, td {
  border: 1px solid black;
}
.centerBox {
	margin : 0 auto;
	padding : 2em;
	width : 15em;
}
</style>
<form action="doModify" method="post">
<div class="centerBox">
	<a href="/board">Home</a> <a href="goList">List</a>
	<table id="infoTable">
		<caption>◎ 게시글 상세보기 ◎</caption>
		<tr>
			<th>Type</th>
			<th><input type="text" name=board_type value="${ boardInfo.board_type }" /></th>
			<!-- 
				<th>Type</th>
				<th>
					<select name="board_type" >
						 <option value = "nor" selected>일반</option>
						 <option value = "ano" >익명</option>
						 <option value = "qa" >Q&A</option>
					</select>
				</th>
			-->
		</tr>
		<tr>
			<th>Title</th>
			<th><input type="text" name=board_title value="${ boardInfo.board_title }" /></th>
		</tr>
		<tr>
			<th>comment</th>
			<th><textarea cols="23" rows="16" name="board_comment"  >${ boardInfo.board_comment }</textarea></th>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="Modify" />
			</th>
		</tr>
	</table>
</div>
<input type="hidden" name="board_num" value="${ boardInfo.board_num }" />
</form>