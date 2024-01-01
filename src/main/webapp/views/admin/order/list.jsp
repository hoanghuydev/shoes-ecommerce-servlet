<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 12/30/2023
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-12">
        <div class="card my-4">
            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                    <h6 class="text-white text-capitalize ps-3">Orders Table</h6>
                </div>
            </div>
            <div class="card-body px-0 pb-2">
                <div class="table-responsive p-0">
                    <table class="table align-items-center mb-0" id="dataTable">
                        <thead>
                        <tr>
                            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">ID</th>
                            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Customer Info</th>
                            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Address</th>
                            <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                            <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product</th>
                            <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Total</th>
                            <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Note</th>
                            <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Create By</th>
                            <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Create At</th>
                            <th class="text-secondary opacity-7"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
<!-- <%--                            Id--%> -->
                            <td>
                                <div class="d-flex">
                                <p class="text-xs font-weight-bold mx-auto mb-0">1</p>

                                </div>
                            </td>
<!-- <%--                            End Id--%> -->
                            <!-- Customer -->
                            <td>
                                <div class="d-flex px-2 py-1">
                                    <div class="d-flex flex-column justify-content-center">
                                        <h6 class="mb-0 text-sm">John Michael</h6>
                                        <p class="text-xs text-secondary mb-0">0847573848</p>
                                    </div>
                                </div>
                            </td>
                            <!-- End Customer -->

                            <td style="cursor: pointer;" data-bs-toggle="tooltip" data-bs-placement="top" title="Số 14 Đường 18, Phường 3, Thanh Xuân, Hà Nội" >
                                <p class="text-xs font-weight-bold mb-0">Ha Noi</p>
                                <p class="text-xs text-secondary mb-0">Thanh Xuan</p>
                            </td>
                            <td class="align-middle text-center text-sm">
                                <span class="badge badge-sm bg-gradient-success">Online</span>
                            </td>
                            <!-- Product list -->
                            <td class="align-middle text-center">
                                <p class="text-xs font-weight-bold mb-0">1 Shoes Runake - XL</p>
                                <p class="text-xs font-weight-bold mb-0">3 Shoes LightNos - XL</p>
                            </td>
                            <!-- End Product list -->
                            <!-- Total -->
                            <td class="align-middle text-center">
                                <p class="text-xs text-secondary mb-0">3.000.000đ</p>
                            </td>
                            <!-- End total -->
                            <!-- Note -->
                            <td style="cursor: pointer;" data-bs-toggle="tooltip" data-bs-placement="top" title="Đây là chi tiết về note" >
                                <div class="d-flex">
                                    <p class="text-xs font-weight-bold mx-auto mb-0">Chi tiết note</p>
                                </div>
                            </td>
                            <!-- End Note -->
                            <!-- Create By -->
                            <td style="cursor: pointer;" data-bs-toggle="tooltip" data-bs-placement="top" title="Hoàng Huy|21130386@st.hcmuaf.edu.vn|hoanghuydev" >
                                <div class="d-flex flex-column">
                                    <p class="text-xs font-weight-bold mx-auto mb-0">Hoàng Huy</p>
                                </div>
                            </td>
                            <!-- Create At -->
                            <td >
                                <div class="d-flex">
                                    <p class="text-xs font-weight-bold mx-auto mb-0">11/10/2023 13:10:30</p>
                                </div>
                            </td>
                            <!-- Action -->
                            <td class="align-middle">
                                <a class="btn btn-link text-dark px-1 mb-0" href="javascript:;"><i class="material-icons text-sm me-1">edit</i>Edit</a>
                                <a class="btn btn-link text-danger text-gradient px-1 mb-0" href="javascript:;"><i class="material-icons text-sm me-1">delete</i>Delete</a>

                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script >
    window.addEventListener("DOMContentLoaded",function (){
        $("table").each(function (){
            new DataTable(this);
        })
    })
</script>
</body>
</html>
