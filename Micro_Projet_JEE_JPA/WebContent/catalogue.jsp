<%@page import="JavaBeans.Categorie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">

<title>Catalogue</title>
</head>
<body>
<form action="CatalogueServlet">
<div class="row">
<select class="custom-select col-sm-2" name="select">
   <option value="90">Choisir</option>
  <c:forEach items="${listCategorie}" var="category">
       
        <option value="${category.id}">${category.categorie}</option>
    </c:forEach>
  
</select>
<button type="submit" class="btn btn-primary">Ok</button>
</div>
  

</form>

	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Titre</th>
      <th scope="col">Prix</th>
      <th scope="col">Image</th>
      <th scope="col">Panier</th>
      
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listArticle}" var="article">
        <tr>
            <td><a href="ProduitServlet?id=${article.id}">REF00${article.id}</a></td>
            <td>${article.designation}</td>
            <td>${article.prix}</td>
            <td><img src="${article.photo}" alt=""  height=100 width=100></img></td>
            <td><a href="PanierServlet?id=${article.id}&ordre=ajouter">Ajouter au panier</a></td>
            
        </tr>
    </c:forEach>
  </tbody>
</table>


 
</body>
</html>