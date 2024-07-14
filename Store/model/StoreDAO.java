package com.store.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StoreDAO implements StoreDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/tia102g1");
			if (ds != null) {
				System.out.println("DataSource initialized successfully.");
			} else {
				System.out.println("Failed to initialize DataSource.");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO STORE(storeId, storeName, cntCode, distCode, storeAddress, longitude, latitude, storePhone, openingHours, storeMail, createdBy, dateCreated, lastUpdatedBy, lastUpdated) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM STORE order by storeId";
	private static final String GET_ONE_STMT = "SELECT storeId, storeName, cntCode, distCode, storeAddress, longitude, latitude, storePhone, openingHours, storeMail, createdBy, dateCreated, lastUpdatedBy, lastUpdated FROM STORE where storeId = ?";
	private static final String DELETE = "DELETE FROM STORE where storeId = ?";
	private static final String UPDATE = "UPDATE STORE set storeName=?, cntCode=?, distCode=?, storeAddress=?, longitude=?, latitude=?, storePhone=?, openingHours=?, storeMail=? where storeId = ?";
	private static final String GET_BY_NAME_STMT = "SELECT * FROM store WHERE storeName = ?";

	@Override
	public void insert(StoreVO storeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, storeVO.getStoreId());
			pstmt.setString(2, storeVO.getStoreName());
			pstmt.setInt(3, storeVO.getCntCode());
			pstmt.setInt(4, storeVO.getDistCode());
			pstmt.setString(5, storeVO.getStoreAddress());
			pstmt.setString(6, storeVO.getLongitude());
			pstmt.setString(7, storeVO.getLatitude());
			pstmt.setString(8, storeVO.getStorePhone());
			pstmt.setString(9, storeVO.getOpeningHours());
			pstmt.setString(10, storeVO.getStoreMail());
			pstmt.setString(11, storeVO.getCreatedBy());
			pstmt.setTimestamp(12, storeVO.getDateCreated());
			pstmt.setString(13, storeVO.getLastUpdatedBy());
			pstmt.setTimestamp(14, storeVO.getLastUpdated());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(StoreVO storeVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, storeVO.getStoreName());
			pstmt.setInt(2, storeVO.getCntCode());
			pstmt.setInt(3, storeVO.getDistCode());
			pstmt.setString(4, storeVO.getStoreAddress());
			pstmt.setString(5, storeVO.getLongitude());
			pstmt.setString(6, storeVO.getLatitude());
			pstmt.setString(7, storeVO.getStorePhone());
			pstmt.setString(8, storeVO.getOpeningHours());
			pstmt.setString(9, storeVO.getStoreMail());
			pstmt.setInt(10, storeVO.getStoreId());
			
			pstmt.executeUpdate();


		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer storeId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, storeId);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public StoreVO findByPrimaryKey(Integer storeId) {

		StoreVO storeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, storeId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				storeVO = new StoreVO();
				storeVO.setStoreId(rs.getInt("storeId"));
				storeVO.setStoreName(rs.getString("storeName"));
				storeVO.setCntCode(rs.getInt("cntCode"));
				storeVO.setDistCode(rs.getInt("distCode"));
				storeVO.setStoreAddress(rs.getString("storeAddress"));
				storeVO.setLongitude(rs.getString("longitude"));
				storeVO.setLatitude(rs.getString("latitude"));
				storeVO.setStorePhone(rs.getString("storePhone"));
				storeVO.setOpeningHours(rs.getString("openingHours"));
				storeVO.setStoreMail(rs.getString("storeMail"));
				storeVO.setCreatedBy(rs.getString("createdBy"));
				storeVO.setDateCreated(rs.getTimestamp("dateCreated"));
				storeVO.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				storeVO.setLastUpdated(rs.getTimestamp("lastUpdated"));

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return storeVO;
	}

	@Override
	public List<StoreVO> getAll() {
		List<StoreVO> list = new ArrayList<StoreVO>();
		StoreVO storeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				storeVO = new StoreVO();
				storeVO.setStoreId(rs.getInt("storeId"));
				storeVO.setStoreName(rs.getString("storeName"));
				storeVO.setCntCode(rs.getInt("cntCode"));
				storeVO.setDistCode(rs.getInt("distCode"));
				storeVO.setStoreAddress(rs.getString("storeAddress"));
				storeVO.setLongitude(rs.getString("longitude"));
				storeVO.setLatitude(rs.getString("latitude"));
				storeVO.setStorePhone(rs.getString("storePhone"));
				storeVO.setOpeningHours(rs.getString("openingHours"));
				storeVO.setStoreMail(rs.getString("storeMail"));
				storeVO.setCreatedBy(rs.getString("createdBy"));
				storeVO.setDateCreated(rs.getTimestamp("dateCreated"));
				storeVO.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				storeVO.setLastUpdated(rs.getTimestamp("lastUpdated"));
				list.add(storeVO);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public StoreVO findByStoreName(String storeName) {

		StoreVO storeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_NAME_STMT);

			pstmt.setString(1, storeName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				storeVO = new StoreVO();
				storeVO.setStoreId(rs.getInt("storeId"));
				storeVO.setStoreName(rs.getString("storeName"));
				storeVO.setCntCode(rs.getInt("cntCode"));
				storeVO.setDistCode(rs.getInt("distCode"));
				storeVO.setStoreAddress(rs.getString("storeAddress"));
				storeVO.setLongitude(rs.getString("longitude"));
				storeVO.setLatitude(rs.getString("latitude"));
				storeVO.setStorePhone(rs.getString("storePhone"));
				storeVO.setOpeningHours(rs.getString("openingHours"));
				storeVO.setStoreMail(rs.getString("storeMail"));
				storeVO.setCreatedBy(rs.getString("createdBy"));
				storeVO.setDateCreated(rs.getTimestamp("dateCreated"));
				storeVO.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				storeVO.setLastUpdated(rs.getTimestamp("lastUpdated"));
				storeVO.setStoreId(rs.getInt("storeId"));

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return storeVO;
	}
	
	public static void main(String[] args) {
		StoreDAO dao = new StoreDAO();
		List<StoreVO> list = dao.getAll();
		for (StoreVO s : list) {
            System.out.println(s);
        }
	}
}
