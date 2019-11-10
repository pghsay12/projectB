package guestbook.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import guestbook.exception.GuestBookException;
import guestbook.vo.GuestBookVO;

@Repository
public class GuestBookDAO {
  
	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSession sqlSession;
	
	
	public List<GuestBookVO> getList() throws Exception{
		List<GuestBookVO> list = sqlSession.selectList("guestbook.getList");
		return list;
	}
	
	public String getPwd(Integer no) throws Exception {
		System.out.println("4. no check :: " + no);
		String pwd = sqlSession.selectOne("guestbook.getOriginPwd", no);
		System.out.println("5. db에 있는 pwd ::" + pwd );
		return pwd;
	}
	
	
	public boolean insert(GuestBookVO vo ) throws Exception{
		int count = sqlSession.insert("guestbook.insert", vo);
		return count == 1;
	}
	
	public boolean delete(Integer no) throws Exception{
		int count = sqlSession.delete("guestbook.delete", no);
		System.out.println("count :: " + count);
		return count == 1;
	}
	
	public GuestBookVO updateGuest(int no) throws Exception {
		
		System.out.println("sql전까지 와라!!!!");
		
		GuestBookVO guestBookVO = sqlSession.selectOne("guestbook.getUpdate", no);
		
		System.out.println("guestBook :: " + guestBookVO.toString());
		
		return guestBookVO;
	}

}