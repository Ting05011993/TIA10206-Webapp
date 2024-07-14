package com.store.model;

import java.sql.Timestamp;
import java.util.List;

public class StoreService {

	private StoreDAO_interface dao;

	public StoreService() {
		dao = new StoreDAO();
	}

	public StoreVO addStore(Integer storeId, String storeName, Integer cntCode, Integer distCode, String storeAddress,
			String longitude, String latitude, String storePhone, String openingHours, String storeMail, String createdBy, Timestamp dateCreated, String lastUpdatedBy, Timestamp lastUpdated) {

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
		
		dao.insert(storeVO);

		return storeVO;
	}

	public StoreVO updateStore(Integer storeId, String storeName, Integer cntCode, Integer distCode,
			String storeAddress, String longitude, String latitude, String storePhone, String openingHours,
			String storeMail) {

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
	
		dao.update(storeVO);

		return storeVO;
	}
	
	public void deleteStore(Integer storeId) {
		dao.delete(storeId);
	}
	
	public StoreVO getOneStore(Integer storeId) {
		return dao.findByPrimaryKey(storeId);
	}
	
	public StoreVO getOneStoreByName(String storeName) {
		return dao.findByStoreName(storeName);
	}
	
	public List<StoreVO> getAll(){
		return dao.getAll();
	}
}
