package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;
import com.tepang.vo.BoardVO;
import com.tepang.vo.MainVO;

public class ProductDetailControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDAO bdao = new ProductDAO();
		
		if (req.getMethod().equals("GET")) {
			String pno = req. getParameter("productCode");
			String page = req.getParameter("page");
			String sc = req.getParameter("searchCondition");
			String kw = req.getParameter("keyword");
			
			MainVO bvo = bdao.selectProduct(pno);
			
			req.setAttribute("product", bvo);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			req.setAttribute("page", page);
			
			req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
			
		}else if (req.getMethod().equals("POST")) {
			String savePath = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 5;
			
			MultipartRequest mr = new MultipartRequest(
					req
					,savePath
					,maxSize
					,"utf-8"
					,new DefaultFileRenamePolicy()
					);
			
			String productCode  = mr.getParameter("product_Code");
			String category = mr.getParameter("category");
			String productDetail = mr.getParameter("product_Detail");
			String productName = mr.getParameter("product_Name");
			String productImg = mr.getFilesystemName("product_Img");
			String productDetImg = mr.getFilesystemName("product_DetImg");
			String productSale = mr.getParameter("product_Sale");
//			int productStock = mr.getParameter("product_Stock");
//			int productPrice = mr.getParameter("product_Price");
			
			MainVO product = new MainVO();
			product.setProductCode(productCode);
			product.setCategory(category);
			product.setProductDetail(productDetail);
			product.setProductName(productName);
//			product.setProductPrice(productPrice);
			product.setProductImg(productImg);
			product.setProductDetImg(productDetImg);
//			product.setProductStock(productStock);
			product.setProductSale(productSale);
			
			if(bdao.insertProduct(product)) {
				resp.sendRedirect("boardList.do");
			}else {
				req.getRequestDispatcher("WEB-INF/html/mainList.do").forward(req, resp);
			}
			
		}

	}

}
