<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head lang="es">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Empresa Logistiqal</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="mx-2">Empresa Logistiqal</h1>
	<form:form action="/addProduct?page=${paginaActual}"
		class="fluid-container my-3 mx-1 border border-dark" method="post"
		modelAttribute="product">
		<div class="row  g-3 align-items-center p-1">
			<div class="col-sm">
				<div class="input-group border border-dark">
					<div class="input-group-text">Nombre Producto</div>
					<input type="text" class="form-control" name="productName">
				</div>
			</div>
			<div class="col-sm">
				<div class="input-group border border-dark">
					<div class="input-group-text">Precio</div>
					<input type="text" class="form-control" name="price">
				</div>
			</div>
			<div class="col-sm">
				<div class="input-group border border-dark">
					<div class="input-group-text">Stock</div>
					<input type="text" class="form-control" name="stock">
				</div>
			</div>
		</div>
		<div class="row d-flex justify-content-between p-1  ">
			<div class="col-4 ">
				<button type="submit" class="btn btn-success">Agregar</button>
			</div>
		</div>
	</form:form>

	<div class="container-fluid d-flex justify-content-between mx-2">
		<div>
			<h2>Lista de Productos</h2>
		</div>
		<div>
			<form:form action="/findProduct" method="post"
				modelAttribute="producto">
				<input type="text" name="productName" placeholder="Buscar producto">
				<button class="btn btn-primary me-2" type="submit">Buscar</button>
			</form:form>
		</div>
	</div>
	<div class="container-fluid">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nombre</th>
					<th scope="col">Precio</th>
					<th scope="col">Stock</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<c:choose>
							<c:when test="${tempProduct.getId()==product.getId()}">
								<form:form action="/updateProduct?page=${paginaActual}" method="post"
									modelAttribute="product">
									<td class="col-2"><input readonly="readonly" type="text"
										class="form-control" id="id" name="id"
										value="<c:out value="${tempProduct.getId()}"></c:out>"></td>
									<td class="col-4"><input type="text" class="form-control"
										id="productName" name="productName"
										value="<c:out value="${tempProduct.getProductName()}"></c:out>"></td>
									<td class="col-2"><input type="text" class="form-control"
										id="price" name="price"
										value="<c:out value="${tempProduct.getPrice()}"></c:out>"></td>
									<td class="col-2"><input type="text" class="form-control"
										id="stock" name="stock"
										value="<c:out value="${tempProduct.getStock()}"></c:out>"></td>
									<td class="text-center col-2">
										<button class="btn btn-primary ms-auto" type="submit">Modificar</button>
									</td>
								</form:form>
							</c:when>
							<c:otherwise>
								<td class="col-2"><c:out value="${product.getId()}"></c:out></td>
								<td class="col-4"><c:out
										value="${product.getProductName()}"></c:out></td>
								<td class="col-2"><c:out value="${product.getPrice()}"></c:out></td>
								<td class="col-2"><c:out value="${product.getStock()}"></c:out></td>
								<td class="text-center col-2"><a
									href="/selectProduct?id=${product.getId()}&page=${paginaActual}"><button
											class="btn btn-primary ms-auto"">Modificar</button></a> <a
									href="/deleteProduct?id=${product.getId()}&page=${paginaActual}"><button
											class="btn btn-danger ms-auto"">Eliminar</button></a></td>

							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination pagination-lg justify-content-center">
			<c:forEach items="${paginas}" var="pagina">
				<li class="page-item ${paginaActual == pagina ? 'disabled' : ''}"><a
					class="page-link" href="/?page=${pagina}" tabindex="-1">${pagina}</a></li>
			</c:forEach>
		</ul>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>