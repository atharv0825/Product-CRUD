<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product List</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product Application</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Sr No.</th>
							<th scope="col">Product</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<th scope="row">${p.product_id}</th>
								<td>${p.name}</td>
								<td>${p.description}</td>
								<td class="font-weight-bold">&#8377;${p.price}</td>
								<td><a href="delete-product/${p.product_id}"><i
										class="fa-solid fa-trash"></i></a> 
										<a href="update-product/${p.product_id}"><i
										class="fa-solid fa-pen"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="text-center">
					<a href="add-product" class="btn btn-outline-success">Add
						Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
