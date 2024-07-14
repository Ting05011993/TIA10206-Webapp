package com.store.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.model.StoreService;
import com.store.model.StoreVO;

public class StoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("getName_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			//儲存錯誤資訊
			req.setAttribute("errorMsgs", errorMsgs);
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("storeName");
				if(str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入門市名稱");
				}
				//如有錯誤送回表單
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/store/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				String storeName = str.trim();
				String storeNameReg = "^[\\u4e00-\\u9fa5]+$";
				if(!storeName.matches(storeNameReg)) {
					errorMsgs.add("請輸入中文店名");
				}
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/store/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始查詢資料*****************************************/
				StoreService storeSvc = new StoreService();
				StoreVO storeVO = storeSvc.getOneStoreByName(storeName);
				if(storeVO ==null) {
					errorMsgs.add("查無資料");
				}
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/store/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("storeVO", storeVO);  // 資料庫取出的storeVO物件,存入req
				String url = "/store/listOneStore.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneStore.jsp
				successView.forward(req, res);
		}
		
		if("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			//儲存錯誤資訊
			req.setAttribute("errorMsgs", errorMsgs);
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/			
				String strStoreId = req.getParameter("storeId");
		        if (strStoreId == null || strStoreId.trim().length() == 0) {
		            errorMsgs.add("請選擇門市地區");
		        }
	
		        Integer storeId = null;
		        try {
		            storeId = Integer.parseInt(strStoreId);
		        } catch (NumberFormatException e) {
		            errorMsgs.add("門市地區格式不正確");
		        }
				/***************************2.開始查詢資料*****************************************/
				StoreService storeSvc = new StoreService();
				StoreVO storeVO = storeSvc.getOneStore(storeId);
				if(storeVO ==null) {
					errorMsgs.add("查無資料");
				}
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/store/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("storeVO", storeVO);  // 資料庫取出的storeVO物件,存入req
				String url = "/store/listOneStore.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneStore.jsp
				successView.forward(req, res);
		}
		
		if("getOne_For_Update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數****************************************/
				Integer storeId = Integer.valueOf(req.getParameter("storeId"));
				
			/***************************2.開始查詢資料****************************************/
				StoreService storeSvc = new StoreService();
				StoreVO storeVO = storeSvc.getOneStore(storeId);
				
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("storeVO", storeVO);
				String url = "/store/updateStore.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
		if("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer storeId = Integer.valueOf(req.getParameter("storeId").trim());
			
			String storeName = req.getParameter("storeName");
			String storeNameReg = "^[\\u4e00-\\u9fa5]+$";
			if(storeName == null || storeName.trim().length() == 0) {
				errorMsgs.add("門市名稱:請勿空白");
			}else if(!storeName.trim().matches(storeNameReg)) {
				errorMsgs.add("門市名稱:請輸入中文");
			}
			
			Integer cntCode = Integer.valueOf(req.getParameter("cntCode").trim());
			Integer distCode = Integer.valueOf(req.getParameter("distCode").trim());
			
			String storeAddress = req.getParameter("storeAddress");
			if(storeAddress == null || storeAddress.trim().length() == 0) {
				errorMsgs.add("地址:請勿空白");
			}
			
			String longitude = req.getParameter("longitude");
			String longitudeReg = "^(-?(180(\\.0{1,5})?|1[0-7][0-9](\\.\\d{1,5})?|[1-9]?[0-9](\\.\\d{1,5})?))$";
			if(longitude == null || longitude.trim().length() == 0) {
				errorMsgs.add("經度:請勿空白");
			}else if(!longitude.trim().matches(longitudeReg)) {
				errorMsgs.add("經度:請輸入正確經度至小數點後五位");
			}

			String latitude = req.getParameter("latitude");
			String latitudeReg = "^(-?([1-8]?[0-9](\\.\\d{1,5})?|90(\\.0{1,5})?))$";
			if(latitude == null || latitude.trim().length() == 0) {
				errorMsgs.add("緯度:請勿空白");
			}else if(!latitude.trim().matches(latitudeReg)) {
				errorMsgs.add("緯度:請輸入正確緯度至小數點後五位");
			}
			
			String storePhone = req.getParameter("storePhone");
			String storePhoneReg = "^\\d{2}-\\d{4,8}$";
			if (storePhone == null || storePhone.trim().length() == 0) {
				errorMsgs.add("電話:請勿空白");
			}else if(!storePhone.trim().matches(storePhoneReg)) {
				errorMsgs.add("電話:請填0X-XXXXXXXX");
			}
			
			String openingHours = req.getParameter("openingHours");
			if(openingHours == null || openingHours.trim().length() == 0) {
				errorMsgs.add("營業時間:請勿空白");
			}
			
			String storeMail = req.getParameter("storeMail");
			String storeMailReg = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
			if(storeMail == null || storeMail.trim().length() == 0) {
				errorMsgs.add("電子信箱:請勿空白");
			}else if(!storeMail.trim().matches(storeMailReg)) {
				errorMsgs.add("電子信箱:請輸入正確信箱格式");
			}
			
			StoreVO storeVO = new StoreVO();
			storeVO.setStoreId(storeId);
			storeVO.setStoreName(storeName);
			storeVO.setCntCode(cntCode);
			storeVO.setDistCode(distCode);
			storeVO.setStoreAddress(storeAddress);
			storeVO.setLongitude(longitude);
			storeVO.setLatitude(latitude);
			storeVO.setStorePhone(storePhone);
			storeVO.setOpeningHours(openingHours);
			storeVO.setStoreMail(storeMail);
			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("storeVO", storeVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/store/updateStore.jsp");
				failureView.forward(req, res);
				return;
			}
			
			/***************************2.開始修改資料*****************************************/
			StoreService storeSvc = new StoreService();
			storeVO = storeSvc.updateStore(storeId, storeName, cntCode, distCode, storeAddress, longitude, latitude, storePhone, openingHours, storeMail);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("storeVO", storeVO);
			String url = "/store/listOneStore.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			}
		
		if("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer storeId = null;
			try {
			storeId = Integer.valueOf(req.getParameter("storeId").trim());
			}catch(NumberFormatException e) {
				storeId = 0;
				errorMsgs.add("請輸入門市編號");
			}
			
			String storeName = req.getParameter("storeName");
			String storeNameReg = "^[\\u4e00-\\u9fa5]+$";
			if(storeName == null || storeName.trim().length() == 0) {
				errorMsgs.add("門市名稱:請勿空白");
			}else if(!storeName.trim().matches(storeNameReg)) {
				errorMsgs.add("門市名稱:請輸入中文");
			}
			
			Integer cntCode = Integer.valueOf(req.getParameter("cntCode").trim());
			Integer distCode = Integer.valueOf(req.getParameter("distCode").trim());
			
			String storeAddress = req.getParameter("storeAddress");
			if(storeAddress == null || storeAddress.trim().length() == 0) {
				errorMsgs.add("地址:請勿空白");
			}
			
			String longitude = req.getParameter("longitude");
			String longitudeReg = "^(-?(180(\\.0{1,5})?|1[0-7][0-9](\\.\\d{1,5})?|[1-9]?[0-9](\\.\\d{1,5})?))$";
			if(longitude == null || longitude.trim().length() == 0) {
				errorMsgs.add("經度:請勿空白");
			}else if(!longitude.trim().matches(longitudeReg)) {
				errorMsgs.add("經度:請輸入正確經度至小數點後五位");
			}
			
			String latitude = req.getParameter("latitude");
			String latitudeReg = "^(-?([1-8]?[0-9](\\.\\d{1,5})?|90(\\.0{1,5})?))$";
			if(latitude == null || latitude.trim().length() == 0) {
				errorMsgs.add("緯度:請勿空白");
			}else if(!latitude.trim().matches(latitudeReg)) {
				errorMsgs.add("緯度:請輸入正確緯度至小數點後五位");
			}
			
			String storePhone = req.getParameter("storePhone");
			String storePhoneReg = "^\\d{2}-\\d{4,8}$";
			if (storePhone == null || storePhone.trim().length() == 0) {
				errorMsgs.add("電話:請勿空白");
			}else if(!storePhone.trim().matches(storePhoneReg)) {
				errorMsgs.add("電話:請填0X-XXXXXXXX");
			}
			
			String openingHours = req.getParameter("openingHours");
			if(openingHours == null || openingHours.trim().length() == 0) {
				errorMsgs.add("營業時間:請勿空白");
			}
			
			String storeMail = req.getParameter("storeMail");
			String storeMailReg = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
			if(storeMail == null || storeMail.trim().length() == 0) {
				errorMsgs.add("電子信箱:請勿空白");
			}else if(!storeMail.trim().matches(storeMailReg)) {
				errorMsgs.add("電子信箱:請輸入正確信箱格式");
			}
			
			String createdBy = null;
			try {
			createdBy = req.getParameter("createdBy").trim();
			}catch(NumberFormatException e) {
				storeId = 0;
				errorMsgs.add("請輸入員工編號");
			}
			
			Timestamp now = Timestamp.valueOf(LocalDateTime.now());
			Timestamp dateCreated = now;
			
			String lastUpdatedBy = createdBy;
			
			Timestamp lastUpdated = now;
			
			StoreVO storeVO = new StoreVO();
			storeVO.setStoreId(storeId);
			storeVO.setStoreName(storeName);
			storeVO.setCntCode(cntCode);
			storeVO.setDistCode(distCode);
			storeVO.setStoreAddress(storeAddress);
			storeVO.setLongitude(longitude);
			storeVO.setLatitude(latitude);
			storeVO.setStorePhone(storePhone);
			storeVO.setOpeningHours(openingHours);
			storeVO.setStoreMail(storeMail);
			storeVO.setCreatedBy(createdBy);
			storeVO.setDateCreated(dateCreated);
			storeVO.setLastUpdatedBy(lastUpdatedBy);
			storeVO.setLastUpdated(lastUpdated);
			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("storeVO", storeVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/store/addStore.jsp");
				failureView.forward(req, res);
				return;
			}
			
			/***************************2.開始修改資料*****************************************/
			StoreService storeSvc = new StoreService();
			storeVO = storeSvc.addStore(storeId, storeName, cntCode, distCode, storeAddress, longitude, latitude, storePhone, openingHours, storeMail, createdBy, dateCreated, lastUpdatedBy, lastUpdated);
			
			/***************************3.新增完成,準備轉交(Send the Success view)*************/
			String url = "/store/listAllStore.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			}
		}
	
		}
	

	
