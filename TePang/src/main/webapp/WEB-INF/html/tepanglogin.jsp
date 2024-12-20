<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<h3>로그인화면 (tepanglogin.jsp)</h3>
<form action="tepanglogin.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" class="form-control" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" class="form-control" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-primary" value="로그인"></td>
		</tr>
	</table>
</form>
