<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Nai - Product</title>
</head>
<body>
    <div class="col-12 mt-4">
        <div class="mb-2 ps-3">
            <a class="btn bg-gradient-dark mb-0" id="toggleAddProduct" data-bs-toggle="collapse" href="#formNewProduct"><i class="material-icons text-sm">add</i>&nbsp;&nbsp;Add New Product</a>
          <div class="collapse multi-collapse my-3" id="formNewProduct">
            <div class="card py-2 px-4" >
              <form id="saveNewProduct" enctype="multipart/form-data" method="POST">
                <div class="input-group input-group-outline my-3">
                  <label class="form-label">Title</label>
                  <input type="text" class="form-control" name="title" required>
                </div>
                <div class="input-group input-group-outline my-3">
                  <label class="form-label">Content</label>
                  <input type="text" class="form-control" name="content" required>
                </div>
                <div class="input-group input-group-outline my-3">
                  <label class="form-label">Short Description</label>
                  <input type="text" class="form-control" name="shortDescription" required>
                </div>
                <div class="input-group input-group-outline my-3">
                  <label class="form-label">Price</label>
                  <input type="number" class="form-control" name="price" required>
                </div>
                <div class="input-group input-group-static mb-4">
                  <label for="category" class="ms-0">Category</label>
                  <select class="form-control" id="category" name="categoryId" required>
                    <option value="" selected>-- Select category --</option>
                   <c:forEach var="category_item" items="${LIST_CATEGORY}">
                     <option value="${category_item.id}">${category_item.name}</option>
                   </c:forEach>
                  </select>
                </div>
                <div class="input-group input-group-static mb-4">
                  <label for="size" class="ms-0">Size</label>
                  <select multiple class="form-control" id="size" name="sizeId[]" required>
                    <c:forEach var="size_item" items="${LIST_SIZE}">
                      <option value="${size_item.id}">${size_item.name}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="input-group input-group-static mb-4">
                  <label for="thumbnailProduct" class="me-2">Thumbnail Product:</label>
                  <input type="file" multiple accept="image/*" id="thumbnailProduct" name="thumbnailProduct"/>
                </div>
                <div class="row preview-thumbnail-product">

                </div>
                <div class="input-group input-group-static mb-4">
                  <label for="imageProduct" class="me-2">Image Product:</label>
                  <input type="file" multiple accept="image/*" id="imageProduct" name="imageProduct"/>
                </div>
                <div class="row preview-img-product">

                </div>
                <button class="btn btn-primary" type="submit">Add Product</button>
              </form>
            </div>
          </div>
        </div>
        <div class="row justify-content-center">
          <div class="col-xl-3 col-md-4 col-sm-6 col-12 mb-4">
            <div class="card py-3">
              <div class="card-header p-0  mx-3">
                <a class="d-block shadow-xl border-radius-xl">
                  <img src="/template/admin/assets/img/home-decor-2.jpg" alt="img-blur-shadow" class="img-fluid shadow border-radius-lg">
                </a>
              </div>
              <div class="card-body p-3">
                <p class="mb-0 text-sm">Product #1</p>
                <a href="javascript:;">
                  <h5>
                    Shoes 1
                  </h5>
                </a>
                <p class="mb-2 text-sm" style="
                    line-height: 1.5em;
                    height: 2em;
                    overflow: hidden;
                    white-space: nowrap;
                    text-overflow: ellipsis;
                    width: 100%;
                    "
                >
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nobis reprehenderit eligendi assumenda sint molestiae adipisci animi at officiis natus eius, ea labore ratione deserunt quos nulla nostrum veniam. Ab, tenetur.
                </p>
                <div class="d-flex align-items-center justify-content-between">
                  <button type="button" class="btn btn-outline-primary btn-sm mb-0 mx-auto">View Product Detail</button>
                </div>
              </div>
            </div>
          </div>


        </div>
    </div>
    <script>
      window.addEventListener("DOMContentLoaded", function () {
        async function getBase64FromFile(file) {
          return new Promise((resolve, reject) => {
            fetch(window.URL.createObjectURL(file))
                    .then(res => res.blob())
                    .then(blob => {
                      let reader = new FileReader();
                      reader.onload = function () {
                        let base64 = reader.result;
                        resolve(base64);
                      };
                      reader.onerror = function (error) {
                        reject(error);
                      };
                      reader.readAsDataURL(blob);
                    })
                    .catch(error => reject(error));
          });
        }
        // Render preview image product
        $("#imageProduct").change(async function () {
          $(".preview-img-product").empty();
          // Convert FileList to an array
          const filesArray = Array.from($("#imageProduct").prop("files"));
          for (let file of filesArray) {
            const imageUrl = await getBase64FromFile(file);
            const imgHtml = `
                <div class="col-xl-2 col-md-3 col-4">
                    <input type="hidden" value="`+imageUrl+`" name="imageUrl[]"/>
                    <img style="width: 100%;" src="`+imageUrl+`" class="card-body"/>
                </div>
            `;
            $(".preview-img-product").append(imgHtml);
          }
        });
      //   Render preview thumbnail product
        $("#thumbnailProduct").change(async function () {
          $(".preview-thumbnail-product").empty();
          // Convert FileList to an array
          const filesArray = Array.from($("#thumbnailProduct").prop("files"));
          for (let file of filesArray) {
            const imageUrl = await getBase64FromFile(file);
            const imgHtml = `
                <div class="col-xl-2 col-md-3 col-4">
                    <input type="hidden" value="`+imageUrl+`" name="imageUrl[]"/>
                    <img style="width: 100%;" src="`+imageUrl+`" class="card-body"/>
                </div>
            `;
            $(".preview-thumbnail-product").append(imgHtml);
          }
        });
      });

    </script>
</body>
</html>