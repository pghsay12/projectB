package guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import guestbook.service.GuestbookService;
import guestbook.vo.GuestBookVO;

@RestController
@RequestMapping("/main")
public class GuestBookRestController {
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="/json/updateGuest", method=RequestMethod.POST)
	public GuestBookVO updateGuest( GuestBookVO guestBookVO) throws Exception{
		System.out.println("수정할 넘버는???" + guestBookVO.getNo());
		
		int no = guestBookVO.getNo();
		
		GuestBookVO guBookVO = guestbookService.updateGuest(no);
		System.out.println("웹으로 보내기 마지막 데이터 :: " + guBookVO.toString());
		return guBookVO;
	}

}
