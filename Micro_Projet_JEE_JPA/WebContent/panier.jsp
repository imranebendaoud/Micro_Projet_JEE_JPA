<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<title>Panier</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Produit</th>
				<th scope="col">Prix</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articlelist}" var="article">
				<tr>
					<td>${article.designation}</td>
					<td>${article.prix}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h5><a href="CatalogueServlet?select=90">Ajouter un produit</a></h5>
	<h5><a href="commande.jsp">Finaliser votre commande</a></h5>
</body>
</html>