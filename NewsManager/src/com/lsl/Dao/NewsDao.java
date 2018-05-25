package com.lsl.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lsl.Domain.News;

public class NewsDao {

	public List<News> getNewsList(Integer pageNumber,Integer pageSize){
		List<News> list = new ArrayList<News>();
		String sql = "select * from news limit "+(pageNumber-1)*pageSize+","+pageSize;
		try(Connection con = ServerDBHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				) {
			while(rs.next()) {
				News news = new News(rs.getInt("newsid"), rs.getString("newstitle"), rs.getString("newsContent"), rs.getString("newsStatus"), rs.getString("newsType"),rs.getDate("createtime"));
				list.add(news);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public Integer getNewsCount() {
		String sql = "select count(*) from news";
		Integer NewsCount = 0;
		try(Connection con = ServerDBHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				) {
			if(rs.next()) {
				NewsCount = rs.getInt("count(*)");
			}
			return NewsCount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void createNews(String newstitle,String newstype,String newscontent) {
		String sql = "insert into news(newstitle,newsContent,newsStatus,newsType,createtime) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ServerDBHelper.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, newstitle);
			pst.setString(2, newscontent);
			pst.setString(3, "Œ¥…Û∫À");
			pst.setString(4, newstype);
			pst.setDate(5,new Date(System.currentTimeMillis()));
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public int deleteNews(Integer id) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		String sql = "delete from news where newsid = ?";
		String sql2 = "update news set newsid=newsid-1 where newsid>"+id;
		int a = 0;
		try {
			con = ServerDBHelper.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			a = pst.executeUpdate();
			pst2 = con.prepareStatement(sql2);
			pst2.executeUpdate();
			return a;
		}catch(Exception e) {
			
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst2!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return a;
	}
	public int shenheNews(Integer id) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = " update news set newsStatus = '“—…Û∫À' where newsid = ?";
		int a = 0;
		try {
			con = ServerDBHelper.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			a = pst.executeUpdate();
			return a;
		}catch(Exception e) {
			
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return a;
	}
	public int UpDateNews(String newstitle,String newsContent,String newsType,Integer id) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = " update news set newstitle = ?,newsContent = ?,newsType = ? where newsid = ?";
		int a = 0;
		try {
			con = ServerDBHelper.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1, newstitle);
			pst.setString(2, newsContent);
			pst.setString(3, newsType);
			pst.setInt(4, id);
			a = pst.executeUpdate();
			return a;
		}catch(Exception e) {
			
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return a;
	}
	public News getNewsById(Integer id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = " select * from news where newsid = ?";
		try {
			con = ServerDBHelper.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				News news = new News(rs.getInt("newsid"),rs.getString("newstitle"),rs.getString("newsContent"),rs.getString("newsStatus"),rs.getString("newsType"),rs.getDate("createtime"));
				return news;
			}
		}catch(Exception e) {
			
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}



}
