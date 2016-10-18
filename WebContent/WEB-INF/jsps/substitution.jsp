<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Classical Cipher</title>
	<link href="${pageContext.request.contextPath}/assets/css/cipher.css" rel="stylesheet" type="text/css">
</head>
<body>

    <nav id = "navbar-ciphers">
      <h2>Ciphers</h2>
      <hr>
      <ul class = "menu">
        <li><a href="${pageContext.request.contextPath}/shift">Shift</a></li>   
        <li><a href="${pageContext.request.contextPath}/affine">Affine</a></li>             
        <li><a href="${pageContext.request.contextPath}/substitution">Substitution</a></li>   
        <li><a href="${pageContext.request.contextPath}/vigenere">Vigenere</a></li>   
      </ul>
    </nav>
    <div id="main-content">
      <div id="cipher-input">
      <sf:form method="post" action="${pageContext.request.contextPath}/substitution" commandName="substitution">
        <div id ="substitution-cipher-input" class="selected-cipher">
	    	<label> Key: </label>
	    	<input type="text" name="key" id="substitution-key" value="${substitution.key}"/>
        </div>
        <br>
        <label>Plain Text</label>
        <br>
        <textarea name="plainText" id="plain-text" placeholder="Plain text"><c:out value="${substitution.plainText}"></c:out></textarea>
        <br>
        <label>Cipher Text</label>
        <br>
        <textarea name="cipherText" id="cipher-text" placeholder="Cipher text"><c:out value="${substitution.cipherText}"></c:out></textarea>
        <br>
        <button type="submit" id="encrypt" name="cipherDirection" value="ENCRYPT">Encrypt</button>
        <button type="submit" id="decrypt" name="cipherDirection" value="DECRYPT">Decrypt</button>
        <input type="button" id="clear-ciphers" value = "Clear">
     </sf:form>
     </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/cipher.js"></script>

</body>

</html>