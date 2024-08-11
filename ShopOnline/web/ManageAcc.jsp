<%-- 
    Document   : table-user-table
    Created on : 26-09-2023, 01:49:44
    Author     : ADMIN
--%>
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
        <style>
            /* Định dạng div chứa form */
            .search-form {
                display: flex;
                align-items: center;
            }

            /* Định dạng select box */
            #group {
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                background-color: #fff;
                font-size: 14px;
                margin-right: 5px;
            }

            /* Định dạng nút tìm kiếm */
            .search-button {
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                padding: 8px 12px;
                cursor: pointer;
                font-size: 14px;
            }

            /* Hiệu ứng hover cho nút tìm kiếm */
            .search-button:hover {
                background-color: #0056b3;
            }

            /* Để căn giữa div chứa form, bạn có thể sử dụng các thuộc tính sau trong class col-sm-8 */
            .col-sm-8 {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            /* Để tạo khoảng cách giữa label và select box */
            optgroup {
                margin-top: 10px;
            }
        </style>
        <style>/* Style for the search box container */
            .search-box {
                display: flex;
                align-items: center;
                background-color: #f5f5f5; /* Background color for the search box container */
                border-radius: 5px; /* Rounded corners */
                padding: 5px 10px; /* Add padding to the container */
            }

            /* Style for the input field */
            .input-search {
                flex-grow: 1; /* Allow the input field to grow and take available space */
                border: none; /* Remove input border */
                padding: 8px; /* Add padding to the input field */
                font-size: 14px; /* Adjust font size */
                outline: none; /* Remove the input outline */
            }

            /* Style for the search button */
            .btn-search {
                background-color: #007bff; /* Button background color */
                color: #fff; /* Text color */
                border: none; /* Remove button border */
                border-radius: 5px; /* Rounded corners */
                margin-left: 5px; /* Add spacing between input and button */
                padding: 5px 10px; /* Add padding to the button */
                cursor: pointer; /* Change cursor on hover */
            }

            /* Hover effect for the search button */
            .btn-search:hover {
                background-color: #0056b3; /* Darker background color on hover */
            }
            /* Tùy chỉnh kiểu phân trang */
            .pagination {
                display: flex;
                list-style: none;
                padding: 0;
            }

            .pagination li {
                margin-right: 10px;
            }

            .pagination a {
                color: #007bff;
                background-color: #fff;
                border: 1px solid #ddd;
                padding: 2px 5px; /* Điều chỉnh kích thước padding tại đây */
                text-decoration: none;
                transition: background-color 0.3s;
                font-size: 5px; /* Điều chỉnh kích thước font tại đây */
            }

            .pagination a:hover {
                background-color: #007bff;
                color: #fff;
            }

            .pagination .active a {
                background-color: #007bff;
                color: #fff;
            }

            /* Tùy chỉnh kiểu nút trước và nút sau */
            .pagination .prev-next a {
                font-weight: bold;
            }

            /* Tùy chỉnh kiểu nút đầu và nút cuối */
            .pagination .first-last a {
                font-weight: bold;
            }

            /* Tùy chỉnh kiểu nút không hoạt động */
            .pagination .disabled a {
                cursor: not-allowed;
                pointer-events: none;
                color: #ccc;
                background-color: transparent;
            }</style>
        <style>
            .switch {
                position: relative;
                display: inline-block;
                width: 60px;
                height: 34px;
            }

            .switch input {
                opacity: 0;
                width: 0;
                height: 0;
            }

            .slider {
                position: absolute;
                cursor: pointer;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: #ccc;
                -webkit-transition: .4s;
                transition: .4s;
            }

            .slider:before {
                position: absolute;
                content: "";
                height: 26px;
                width: 26px;
                left: 4px;
                bottom: 4px;
                background-color: white;
                -webkit-transition: .4s;
                transition: .4s;
            }

            input:checked + .slider {
                background-color: #2196F3;
            }

            input:focus + .slider {
                box-shadow: 0 0 1px #2196F3;
            }

            input:checked + .slider:before {
                -webkit-transform: translateX(26px);
                -ms-transform: translateX(26px);
                transform: translateX(26px);
            }

            /* Rounded sliders */
            .slider.round {
                border-radius: 34px;
            }

            .slider.round:before {
                border-radius: 50%;
            }
        </style>

    </head>

    <body onload="time()" class="app sidebar-mini rtl">

        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>

        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách Acc</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">





                            <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0"
                                   id="sampleTable">
                                <thead>
                                    <tr>

                                        <th>ID</th>
                                        <th>Account</th>
                                        <th>Password</th>   
                                        <th>Full Name</th>
                                        <th>Phone</th>
                                        <th>Address</th>
                                        <th>Delete</th><!-- comment -->
                                    </tr>
                                </thead>
                                <tbody>  <c:forEach items = "${listAcc}" var = "o" >

                                        <tr>

                                            <td> ${o.getuID()}</td>
                                            <td>${o.getAccount()}</td>  
                                            <td>${o.getPassword()}</td>                           
                                            <td>${o.getFullname()}</td>
                                            <td>${o.getPhone()} </td>
                                            <td>${o.getAddress()}</td>     


                                            <td class="table-td-center"> 
                                                <a href="deleteAcc?uid=${o.getuID()}">  <button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                                                                                                onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                                                    </button></a>
                                            </td>

                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                            <a class="btn btn-cancel" href="index.jsp">Cancel</a>

                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!--
        MODAL
        -->
        <div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
             data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">


                        <BR>
                        <a href="#" style="    float: right;
                           font-weight: 600;
                           color: #ea0000;">Chỉnh sửa nâng cao</a>
                        <BR>
                        <BR>
                        <button class="btn btn-save" type="button">Lưu lại</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                        <BR>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
        MODAL
        -->
        <script>
            // Lấy tất cả các phần tử input có id là "statusCheckbox"
            const checkboxes = document.querySelectorAll('input#statusCheckbox');

            // Lặp qua từng checkbox
            checkboxes.forEach(checkbox => {
                // Lắng nghe sự kiện "change" của checkbox
                checkbox.addEventListener('change', function () {
                    // Tìm biểu mẫu (form) chứa checkbox hiện tại
                    const form = this.closest('form');

                    // Kiểm tra xem biểu mẫu có tồn tại không
                    if (form) {
                        // Gửi biểu mẫu đi khi checkbox thay đổi
                        form.submit();
                    }
                });
            });
        </script>
        <!-- Essential javascripts for application to work-->
        <script src="../new_assetssjs/jquery-3.2.1.min.js"></script>
        <script src="../new_assetssjs/popper.min.js"></script>
        <script src="../new_assetssjs/bootstrap.min.js"></script>
        <script src="../ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="../new_assetssjs/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="../new_assetssjs/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>
        <script>
            function deleteRow(r) {
                var i = r.parentNode.parentNode.rowIndex;
                document.getElementById("myTable").deleteRow(i);
            }
            jQuery(function () {
                jQuery(".trash").click(function () {
                    swal({
                        title: "Cảnh báo",

                        text: "Đã xóa thành công!!",
                        buttons: ["Hủy bỏ", "Đồng ý"],
                    })
                            .then((willDelete) => {
                                if (willDelete) {
                                    swal("Đã xóa thành công.!", {

                                    });
                                }
                            });
                });
            });
            oTable = $('#sampleTable').dataTable();
            $('#all').click(function (e) {
                $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
                e.stopImmediatePropagation();
            });

            //EXCEL
            // $(document).ready(function () {
            //   $('#').DataTable({

            //     dom: 'Bfrtip',
            //     "buttons": [
            //       'excel'
            //     ]
            //   });
            // });


            //Thời Gian
            function time() {
                var today = new Date();
                var weekday = new Array(7);
                weekday[0] = "Chủ Nhật";
                weekday[1] = "Thứ Hai";
                weekday[2] = "Thứ Ba";
                weekday[3] = "Thứ Tư";
                weekday[4] = "Thứ Năm";
                weekday[5] = "Thứ Sáu";
                weekday[6] = "Thứ Bảy";
                var day = weekday[today.getDay()];
                var dd = today.getDate();
                var mm = today.getMonth() + 1;
                var yyyy = today.getFullYear();
                var h = today.getHours();
                var m = today.getMinutes();
                var s = today.getSeconds();
                m = checkTime(m);
                s = checkTime(s);
                nowTime = h + " giờ " + m + " phút " + s + " giây";
                if (dd < 10) {
                    dd = '0' + dd
                }
                if (mm < 10) {
                    mm = '0' + mm
                }
                today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                        '</span>';
                document.getElementById("clock").innerHTML = tmp;
                clocktime = setTimeout("time()", "1000", "Javascript");

                function checkTime(i) {
                    if (i < 10) {
                        i = "0" + i;
                    }
                    return i;
                }
            }
            //In dữ liệu
            var myApp = new function () {
                this.printTable = function () {
                    var tab = document.getElementById('sampleTable');
                    var win = window.open('', '', 'height=700,width=700');
                    win.document.write(tab.outerHTML);
                    win.document.close();
                    win.print();
                }
            }
            //     //Sao chép dữ liệu
            //     var copyTextareaBtn = document.querySelector('.js-textareacopybtn');

            // copyTextareaBtn.addEventListener('click', function(event) {
            //   var copyTextarea = document.querySelector('.js-copytextarea');
            //   copyTextarea.focus();
            //   copyTextarea.select();

            //   try {
            //     var successful = document.execCommand('copy');
            //     var msg = successful ? 'successful' : 'unsuccessful';
            //     console.log('Copying text command was ' + msg);
            //   } catch (err) {    
            //     console.log('Oops, unable to copy');
            //   }
            // });


            //Modal
            $("#show-emp").on("click", function () {
                $("#ModalUP").modal({backdrop: false, keyboard: false})
            });
        </script>

    </body>

</html>

