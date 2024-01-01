package com.ltweb_servlet_ecommerce.controller.admin.product;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ltweb_servlet_ecommerce.constant.SystemConstant;
import com.ltweb_servlet_ecommerce.model.ProductImageModel;
import com.ltweb_servlet_ecommerce.model.ProductModel;
import com.ltweb_servlet_ecommerce.model.ProductSizeModel;
import com.ltweb_servlet_ecommerce.service.*;
import com.ltweb_servlet_ecommerce.utils.FormUtil;
import com.ltweb_servlet_ecommerce.utils.NotifyUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin/product/list"})
@MultipartConfig
public class ProductListController  extends HttpServlet {
    @Inject
    IProductService productService;
    @Inject
    IProductImageService productImageService;
    @Inject
    ICategoryService categoryService;
    @Inject
    ISizeService sizeService;
    @Inject
    IProductSizeService productSizeService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NotifyUtil.setUp(req);
        try {
            req.setAttribute(SystemConstant.LIST_MODEL,productService.findAll());
            req.setAttribute("LIST_CATEGORY",categoryService.findAll());
            req.setAttribute("LIST_SIZE",sizeService.findAll());
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/list.jsp");
            rd.forward(req,resp);
        } catch (Exception e) {
            resp.sendRedirect("/admin/product/list?message=error&toast=danger");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "da5wewzih",
                "api_key", "594116454729532",
                "api_secret", "ZmY7c6OjD1xJImXIH2eYGRSayQs"
        ));
        cloudinary.config.secure = true;
        try {
            ProductModel productModel = FormUtil.toModel(ProductModel.class,req);
            String thumbnailProduct = req.getParameter("thumbnailProduct");
            Map<String, Object> uploadThumbnail = cloudinary.uploader().upload(thumbnailProduct, ObjectUtils.emptyMap());
            String thumbnailProductUrl = (String) uploadThumbnail.get("url");
            productModel.setThumbnail(thumbnailProductUrl);
            productModel = productService.save(productModel);
            String[] sizesId = req.getParameterValues("sizeId[]");
            for (String sizeId : sizesId) {
                ProductSizeModel productSizeModel = new ProductSizeModel();
                productSizeModel.setProductId(productModel.getId());
                productSizeModel.setSizeId(Long.parseLong(sizeId));
                productSizeService.save(productSizeModel);
            }
            String[] imagesUrlBase64 = req.getParameterValues("imageUrl[]");
            for (String image : imagesUrlBase64) {
                    Map<String, Object> uploadResult = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());
                    String imageProductUrl = (String) uploadResult.get("url");
                ProductImageModel productImageModel = new ProductImageModel();
                productImageModel.setProductId(productModel.getId());
                productImageModel.setImageUrl(imageProductUrl);
                productImageService.save(productImageModel);
            }
            resp.sendRedirect("/admin/product/list?message=add_success&toast=success");
        } catch ( Exception e) {
            resp.sendRedirect("/admin/product/list?message=error&toast=danger");
        }
    }

}
