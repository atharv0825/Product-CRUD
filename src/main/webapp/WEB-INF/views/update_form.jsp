<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-5">
        <h2>Change Product Details</h2>
        <form action="${pageContext.request.contextPath}/handle-product" method="post">

			<div class="form-group">
                <label for="product_id">Product ID</label>
                <input type="text" class="form-control" id="product_id	" name="product_id" placeholder="Enter Product Name" value="${product.product_id }" required>
            </div>
            
            <div class="form-group">
                <label for="name">Product Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter Product Name" value="${product.name }" required>
            </div>
            <div class="form-group">
                <label for="description">Product Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" placeholder="Enter Product Description" required>${product.description }</textarea>
            </div>
            <div class="form-group">
                <label for="price">Product Price</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="Enter Product Price" value="${product.price }" required>
            </div>
            <div class="form-group">
                <!-- Back Button -->
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Back</a>
                <!-- Submit Button -->
                <button type="submit" class="btn btn-warning">Update</button>
            </div>
        </form>
    </div>
</body>
</html>