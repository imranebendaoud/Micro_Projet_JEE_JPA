<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produit</title>
</head>
<body>
PRODUIT
<div>
Réference:REF${article.id }
</div>
<div>
Titre:${article.designation }
</div>
<div>
<img src="${article.photo}" alt="" height=100 width=100>
</div>
<div>
Quantité en stock:${article.stock }
</div>
<div>
Prix:${article.prix }
</div>
<div>
Catégorie:${article.categorie }
</div>

<a href="CatalogueServlet?select=90">Retour au catalogue</a>

</body>
</html>