
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog Detail</title>
        <style>
            /* Thiết lập một font chung cho toàn bộ trang */
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }

            /* Thiết lập kiểu cho phần container chứa nội dung */
            .container {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
                border-radius: 5px;
            }

            /* Thiết lập kiểu cho tiêu đề lớn (ID) */
            h1 {
                font-size: 28px;
                color: #333;
                margin-top: 0;
            }

            /* Thiết lập kiểu cho tiêu đề (Title of Blog) */
            h2 {
                font-size: 24px;
                color: #333;
                margin-top: 20px;
            }

            /* Thiết lập kiểu cho đoạn nội dung */
            p {
                font-size: 18px;
                color: #666;
                line-height: 1.5;
            }

            /* Thiết lập kiểu cho hình ảnh */
            img {
                max-width: 100%;
                height: auto;
                display: block;
                margin-top: 20px;
                border: 2px solid #ddd;
                border-radius: 5px;
            }

            /* Thiết lập kiểu cho nút "Back" */
            .back-button {
                display: inline-block;
                padding: 10px 20px;
                background-color: #007bff; /* Màu xanh duy nhất */
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
                margin-top: 20px;
                font-size: 18px;
                transition: background-color 0.3s ease-in-out;
            }

            /* Kiểu hover cho nút "Back" */
            .back-button:hover {
                background-color: #0056b3; /* Màu xanh đậm khi hover */

            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>ID: ${sessionScope.p.idP}</h1>

            <h2>Name </h2>
            <p>${sessionScope.p.nameProduct}</p>

            <h2>Image</h2>
            <img src="${sessionScope.p.imgProduct}" alt="Blog Image"/>



            <h2>Price</h2>
            <p>${sessionScope.p.priceProduct}</p>




            <h2>Title</h2>
            <p>${sessionScope.p.tiltleProduct}</p>

            <h2>Description</h2>
            <p>${sessionScope.p.descriptionProduct}</p>





            <a href="ProductController" class="back-button">Back</a>
        </div> 


    </body>
</html>

