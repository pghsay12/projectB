package guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guestbook.repository.GuestBookDAO;
import guestbook.vo.GuestBookVO;

@Service
public class GuestbookService {
	@Autowired
	private GuestBookDAO guestBookDAO;
	
	public List<GuestBookVO> getList() throws Exception{
		return guestBookDAO.getList();
	}
	
	public boolean insert(GuestBookVO vo ) throws Exception {
		return guestBookDAO.insert(vo);
	}
	
	public boolean delete(GuestBookVO vo) throws Exception {

		String originPwd = guestBookDAO.getPwd(vo.getNo());

		String inputPwd = vo.getPwd();
		if(!originPwd.equals(inputPwd) ) {
			return false;
		}
		
		return guestBookDAO.delete(vo.getNo());
	}
	
	public GuestBookVO updateGuest(int no) throws Exception {
		
		return guestBookDAO.updateGuest(no);
	}
	
}