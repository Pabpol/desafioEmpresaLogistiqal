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
<title>Biblioteca Booklet</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="mx-2">Biblioteca Booklet</h1>
	<form:form action="/agregarLibro"
		class="fluid-container my-3 mx-1 border border-dark" method="post"
		modelAttribute="libro">
		<div class="row  g-3 align-items-center p-1">
			<div class="col">
				<label class="visually-hidden" for="titulo">Título</label>
				<div class="input-group border border-dark">
					<div class="input-group-text">Título</div>
					<input type="text" class="form-control" id="titulo" name="titulo" value="<c:out value="${tempLibro.getTitulo()}"></c:out>"></div>
			</div>
			<div class="col">
				<label class="visually-hidden" for="anio">Año
					publicación</label>
				<div class="input-group border border-dark">
					<div class="input-group-text">Año publicación</div>
					<input type="text" class="form-control" id="anio" name="anio"
						value="<c:out value="${tempLibro.getAnio()}"></c:out>">
				</div>
			</div>
			<div class="col">
				<label class="visually-hidden" for="imprenta">Imprenta</label>
				<div class="input-group border border-dark">
					<div class="input-group-text">Imprenta</div>
					<input type="text" class="form-control" id="imprenta"
						name="imprenta" value="<c:out value="${tempLibro.getImprenta()}"></c:out>">
				</div>
			</div>
		</div>

		<div class="row g-3 align-items-center p-1 ">
			<div class="col-8">
				<label class="visually-hidden" for="autor">Autor</label>
				<div class="input-group border border-dark">
					<div class="input-group-text">Autor</div>
					<input type="text" class="form-control" id="autor" name="autor"
						value="<c:out value="${tempLibro.getAutor()}"></c:out>">
				</div>
			</div>
			<div class=" col-4 py-0 ">
				<label class="visually-hidden py-0 " for="disponible">Disponible</label>
				<div class="input-group-text border border-dark py-0 pe-0 ">Disponible
				<select class="form-select ms-2  "
					aria-label="form-select" id="disponible" name="disponible"">
					<c:if test="${tempLibro.isDisponible() == true  }">
						<option value="${true}">Si</option>
						<option value="${false}">No</option>
					</c:if>
					<c:if test="${tempLibro.isDisponible() == false  }">
						<option value="${false}">No</option>
						<option value="${true}">Si</option>
					</c:if>	
					<c:if test="${tempLibro.isDisponible() != false && tempLibro.isDisponible() != true}">
						<option  value="" disabled selected hidden" > </option>
						<option value="${false}">No</option>
						<option value="${true}">Si</option>
					</c:if>	
				</select> 
				</div>
			</div>
		</div>

		<div class="row d-flex justify-content-between p-1  ">
			<div class="col-4 ">
				<button type="submit" class="btn btn-success">Agregar</button>
				<span><button type="submit"  formaction="/eliminarLibro?id=${tempLibro.getId()}" formmethod="post" class="btn btn-danger">Eliminar</button></span>
			</div>
			<div class="col-2 text-end"> 
				<button type="submit" formaction="/modificarLibro?id=${tempLibro.getId()}" class="btn btn-primary">Actualizar</button>
			</div>
		</div>
	</form:form>

	<div class="container-fluid d-flex justify-content-between mx-2">
		<div>
			<h2>Lista de libros</h2>
		</div>
		<div>
			<form:form action="/filtrar" method="post" modelAttribute="libro">
				<input type="text" name="filtro" placeholder="Buscar libro o autor">
				<button class="btn btn-primary me-2" type="submit">Buscar</button>
			</form:form>
		</div>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Título</th>
				<th scope="col">Año publicación</th>
				<th scope="col">Autor</th>
				<th scope="col">Imprenta</th>
				<th scope="col">Disponibile</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="libro" items="${libros}">
				<tr>

					<td><a href="/seleccionLibro?id=${libro.getId()}"><c:out value="${libro.getId()}"></c:out> </a></td>
					<td><c:out value="${libro.getTitulo()}"></c:out></td>
					<td><c:out value="${libro.getAnio()}"></c:out></td>
					<td><c:out value="${libro.getAutor()}"></c:out></td>
					<td><c:out value="${libro.getImprenta()}"></c:out></td>
					<td> 
						<select onChange="window.location.href=this.value" class="form-select ms-2" aria-label="form-select" id="disponible" name="disponible">
								<c:if test="${libro.isDisponible() == true  }">
									<option value="/modificarDisponible?id=${libro.getId()}&disponible=${true}">Si</option>
									<option value="/modificarDisponible?id=${libro.getId()}&disponible=${false}">No</option>
								</c:if>
								<c:if test="${libro.isDisponible() == false  }">
									<option value="/modificarDisponible?id=${libro.getId()}&disponible=${false}">No</option>
									<option value="/modificarDisponible?id=${libro.getId()}&disponible=${true}">Si</option>
								</c:if>					
						</select> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>