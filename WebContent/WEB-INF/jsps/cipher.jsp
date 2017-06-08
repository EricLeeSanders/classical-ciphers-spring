<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Classical Cipher</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets/css/cipher.css" rel="stylesheet" type="text/css">
	<script>var ctx = "${pageContext.request.contextPath}"</script>
</head>
<body>
<div class="container">
	<div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-xs-12 main-container">
			<div id="main-panel">
			    <a id="homepage" href="http://www.EricLeeSanders.com">
              		<img src="${pageContext.request.contextPath}/assets/imgs/homepage.png" alt="Eric Sanders" height="42" id="name-icon">
              	</a>
              	<a id="githubpage" href="https://github.com/EricLeeSanders/classical-ciphers-spring">
		            <img src="${pageContext.request.contextPath}/assets/imgs/GitHub-Mark-Light-64px.png" alt="GitHub" height="42">
		        </a>
            	<h2>
					<label id="cipherTitle">Shift</label>
				</h2>
				<div class="row">
					<div class="btn-group collapsed" role="group" id="cipher-type-buttons" >
					  <button type="button" class="btn btn-default active" id="btnShift" name="Shift">Shift</button>
					  <button type="button" class="btn btn-default" id="btnAffine" name="Affine">Affine</button>
					  <button type="button" class="btn btn-default" id="btnSubstitution" name="Substitution">Substitution</button>
					  <button type="button" class="btn btn-default" id="btnVigenere" name="Vigenere">Vigenere</button>
					</div>
				</div>
            	<div class="row">
	            	<div class="btn-group collapsed" role="group" id="cipher-direction-buttons">
					  <button type="button" id="btn-encrypt" class="btn btn-default active" name="Encrypt">Encrypt</button>
					  <button type="button" id="btn-decrypt" class="btn btn-default" name="Decrypt">Decrypt</button>
					  <button type="button" id="btn-auto-decrypt" class="btn btn-default" name="AutoDecrypt">Auto-Decrypt</button>
					</div>
				</div>
				<hr style="border:1px solid #FFF;" />
				<div>
					<ul class="errors"></ul>
				</div>
				<form class="cipher-form form-horizontal" role="form" method="post" action="">
					<div class="form-group">
						<div id="shift-key-panel" class="key-panel active-key-panel">
							<label for="shift-amount" class="col-sm-2 control-label">Shift</label>
							<div class="col-sm-2">
								<select class="form-control key-input" id="shift-amount" name="shiftAmount">
							    <c:forEach var="validShift" items="${shift.validShifts}">
										<option value="${validShift}">${validShift}</option>
								    </c:forEach>
								</select>
							</div>
						</div>
						<div id="affine-key-panel" class="key-panel">
							<label for="shift-amount-a" class="col-sm-2 control-label">Shift A</label>
							<div class="col-sm-2">
								<select class="form-control key-input" id="shift-amount-a" name="shiftAmountA">
								    <c:forEach var="validShift" items="${affine.validShiftsA}">
										<option value="${validShift}">${validShift}</option>
								    </c:forEach>
								</select>
							</div>
							<label for="shift-amount-b" class="col-sm-2 control-label">Shift B</label>
							<div class="col-sm-2">
								<select class="form-control key-input" id="shift-amount-b" name="shiftAmountB">
								    <c:forEach var="validShift" items="${affine.validShiftsB}">
										<option value="${validShift}">${validShift}</option>
								    </c:forEach>
								</select>
							</div>
						</div>
						<div id="substitution-key-panel" class="key-panel">
							<label for="substititon-key" class="col-sm-2 control-label">Key</label>
							<div class="col-sm-9">
							<textarea class="form-control key-input" rows="1" id="substititon-key" name="substitutionKey"></textarea>
							</div>
						</div>
						<div id="vigenere-key-panel" class="key-panel">
							<label for="vigenere-key" class="col-sm-2 control-label">Key</label>
							<div class="col-sm-9">
							<textarea class="form-control key-input" rows="1" id="vigenere-key" name="vigenereKey"></textarea>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="plain-text" class="col-sm-2 control-label">Plain Text</label>
						<div class="col-sm-9">
							<textarea id="plain-text" class="form-control" rows="4" name="plainText"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="cipher-text" class="col-sm-2 control-label">Cipher Text</label>
						<div class="col-sm-9">
							<textarea id="cipher-text" class="form-control" rows="4" name="cipherText"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<div class="col-sm-12">
								<input id="submit" type="submit" value="Encrypt" class="btn btn-primary">
								<input id="cipher-example" type="button" value="Example" class="btn btn-info">
								<input id="clear" type="button" value="Clear" class="btn btn-danger">
							</div>
						</div>
					</div>
				</form> 
            </div>
        </div>
  </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/cipher.js"></script>
</body>
</html>