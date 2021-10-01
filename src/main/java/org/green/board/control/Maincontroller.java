package org.green.board.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.green.board.dto.Board;
import org.green.board.dto.ComCode;
import org.green.board.dto.User;
import org.green.board.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Maincontroller {

	@Autowired
	private MainService service;
	
	@RequestMapping(value= {"/", "goHome"})
	public String goHome() {
		return "home";
	}
	
	@RequestMapping("/insert")
	public void goInsert() {}
	
	@RequestMapping("/login")
	public void goLogin() {}
	
	@RequestMapping(value= {"/join", "goJoin"})
	public ModelAndView goJoin(ModelAndView mav) {
		List<ComCode> phoneComCode = service.getPhoneComCode(mav);
		mav.addObject(phoneComCode);
		
		return mav;
	}
	
	@RequestMapping(value= {"/goList", "goList"})
	public ModelAndView goList(ModelAndView mav) {
		List<Board> list = service.getList(mav);
		mav.addObject(list);
		
		return mav;
	}
	
	@RequestMapping(value= {"/detail", "detail"})
	public ModelAndView detail(ModelAndView mav, int no) {
		Board boardInfo = service.getBoard(mav, no);
		mav.addObject(boardInfo);
		
		return mav;
	}
	
	@RequestMapping(value="doJoin", method=RequestMethod.POST)
	public String doJoin(User user, HttpServletRequest req) {
		int result = service.addUser(user);
		
		if (result == 1) {
			HttpSession session = req.getSession();
			session.setAttribute("loginUserID", user.getUser_id());
			session.setAttribute("LoginUserName", user.getUser_name());
			
			return "redirect:/goList";
		} else {
			return "acceessFailed";
		}
	}
	
	@RequestMapping(value="doLogin", method=RequestMethod.POST)
	public String doLogin(User user, HttpServletRequest req) {
		List<User> AllUserList = service.getAllUser();
		
		HttpSession session = req.getSession();
		String msg = "어서오세요";
		session.setAttribute("msg", msg);
		for (User userList : AllUserList) {
			if (!user.getUser_id().equals(userList.getUser_id())) {
					msg = "아이디가 존재하지 않습니다.";
					session.setAttribute("msg", msg);
			} else {
				if (!user.getUser_pw().equals(userList.getUser_pw())) {
					msg = "비밀번호가 일치하지 않습니다.";
					session.setAttribute("msg", msg);
				} else {
					session.setAttribute("loginUserID", userList.getUser_id());
					session.setAttribute("LoginUserName", userList.getUser_name());
					
					return "redirect:/goList";
				}
			}
		}
		return "redirect:/login";
	}
	
//	@RequestMapping(value="doLogin", method=RequestMethod.POST)
//	public String doLogin(User user, HttpServletRequest req) {
//		List<User> AllUserList = service.getAllUser();
//		HttpSession session = req.getSession();
//		String msg;
//		User findUser = null;
//		int idx = AllUserList.lastIndexOf(new User(user.getUser_id()));
//		
//		if (idx != -1) {
//			findUser = AllUserList.get(idx);
//			if (!findUser.getUser_pw().equals(user.getUser_pw())) {
//				msg = "비밀번호가 일치하지 않습니다";
//				session.setAttribute("msg", msg);
//			} else {
//				session.setAttribute("loginUserID", findUser.getUser_id());
//				session.setAttribute("LoginUserName", findUser.getUser_name());
//				
//				return "redirect:/goList";
//			}
//		}
//		msg = "아이디가 존재하지 않습니다.";
//		session.setAttribute("msg", msg);
//		
//		return "redirect:/login";
//	}
	
	@RequestMapping(value="doInsert", method=RequestMethod.POST)
	public String doInsert(Board board) {
		int result = service.addBoard(board);
		
		if (result == 1) {
			return "redirect:/goList";
		} else {
			return "acceessFailed";
		}
	}
	
	@RequestMapping(value="doModify", method=RequestMethod.POST)
	public String doModify(Board board) {
		int result = service.updateBoard(board);
		
		if(result == 1) {
			return "redirect:/goList";
		} else {
			return "acceessFailed";
		}
	}
	
	@RequestMapping(value="doInsert", method=RequestMethod.GET)
	public String doInsert() {
		return "acceessFailed";
	}
}
