
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <link rel="stylesheet" href="../new_assetss/css/main.css"/>
        <link rel="stylesheet" href="assets/new_assetss/css/main.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

    </head>

    <body onload="time()" class="app sidebar-mini rtl">




        <main class="app-content">


            <div class="tile">
                <form  action="editProductServlet" method="post">
                    <h3 class="tile-title">Edit Product</h3>
                    <div class="tile-body">

                        <div class="form-group  col-md-4">
                            <label class="control-label">ID</label>
                            <input class="form-control" type="text" name="txtId" value="${pid}" readonly>
                        </div>

                        <div class="form-group  col-md-4">
                            <label class="control-label">Name </label>
                            <input class="form-control" type="text"  value="${sessionScope.dataProduct.nameProduct}" name="txtName" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Img</label>
                            <input class="form-control" type="text"     value="${sessionScope.dataProduct.imgProduct}"name="txtImg" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Price</label>
                            <input class="form-control" type="text"  value="${sessionScope.dataProduct.priceProduct}"  name="txtPrice" required >
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Title</label>
                            <input class="form-control" type="text"   value="${sessionScope.dataProduct.tiltleProduct}"name="txtTitle" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Description</label>
                            <input class="form-control" type="text"   value="${sessionScope.dataProduct.descriptionProduct}"name="txtDescription" required>
                        </div>


                        <button class="btn btn-save" type="submit" >Save</button>
                        <p  style="color: blue ; background-color: white ; width: auto ; margin: auto ;padding: auto ; text-align: center ; border-radius: 50px;">${mess}
                        </p>
                </form></div>   <a class="btn btn-cancel" href="managementPServlet">Cancel</a>
        </div>
    </main>
    <!-- Essential javascripts for application to work-->

    <script src="../new_assetss/js/jquery-3.2.1.min.js"></script>
    <script src="../new_assetss/js/popper.min.js"></script>
    <script src="../new_assetss/js/bootstrap.min.js"></script>
    <script src="../new_assetss/js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="../new_assetss/js/plugins/pace.min.js"></script>
</body>
</html>

