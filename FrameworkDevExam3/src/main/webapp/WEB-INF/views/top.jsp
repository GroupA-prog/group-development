<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ</title>
</head>
<body>
  <h2>検索条件または登録情報を入力してください</h2>
  <c:if test="${productList == 1 }">
    <fmt:message key="form.err.erroMsg" />
  </c:if>

  <form:form action="execute" modelAttribute="product" method="post">
    <fmt:message key="form.lbl.productName" /><form:input path="productName" />
     <form:errors path="productName" cssStyle="color: red"/>
    <br>
    <fmt:message key="form.lbl.price" /><form:input path="price" />
    <form:errors path="price" cssStyle="color: red"/>
    <br>
    <form:button name="search"><fmt:message key="form.lbl.select" /></form:button>
    <form:button name="insert"><fmt:message key="form.lbl.insert" /></form:button>
  </form:form>
</body>