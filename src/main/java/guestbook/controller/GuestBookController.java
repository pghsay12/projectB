package guestbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import guestbook.repository.GuestBookDAO;
import guestbook.service.GuestbookService;
import guestbook.vo.GuestBookVO;
// 컨트롤러 작성시 스프링이 해당 클래스를 컨트롤러라고 인식하고 리퀘스트매핑을 작성하면 url과 메소드 매핑이 이루어짐
@Controller
@RequestMapping("/main")
public class GuestBookController {
	@Autowired
	private GuestbookService guestBookService;
	
	@RequestMapping(value="/text", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<GuestBookVO> list = guestBookService.getList();
		model.addAttribute("list", list);
		return "text";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insert(@ModelAttribute("vo") GuestBookVO vo ) throws Exception {
		System.out.println("왓냐 vo :: " + vo.toString());
		guestBookService.insert(vo);
		return "redirect:/main/text";
	}
	
	
	@RequestMapping(value="/deleteform", method=RequestMethod.GET)
	public String delete(@RequestParam Integer no, Model model) throws Exception {
		System.out.println("1. no :: " + no);
		model.addAttribute("no",no);
		return "deleteform";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestBookVO vo) throws Exception {
		System.out.println("2. vo check :: " + vo);
		guestBookService.delete(vo);
		return "redirect:/main/text";
	}
	


		@ResponseBody
		@RequestMapping("/join")
		public Map<String, Object> join() {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "park");
			map.put("age",27);
			
			
			return map;
		}
	
}