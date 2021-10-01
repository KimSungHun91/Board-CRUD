package org.green.board.service;

import java.util.List;

import org.green.board.dao.SpringBoardDAO;
import org.green.board.dto.Board;
import org.green.board.dto.ComCode;
import org.green.board.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MainService {
	
	@Autowired
	private SpringBoardDAO dao;
	
	public List<ComCode> getPhoneComCode(ModelAndView mav) {
		List<ComCode> phoneComCode = dao.getCodeList();
		mav.addObject("phoneComCode", phoneComCode);
		mav.setViewName("join");
		
		return phoneComCode;
	}
	
	public List<Board> getList(ModelAndView mav) {
		List<Board> list = dao.getAll();
		mav.addObject("list", list);
		mav.addObject("count", list.size());
		mav.setViewName("list");
		
		return list;
	}
	
	public Board getBoard(ModelAndView mav, int no) {
		Board boardInfo = dao.selectBoard(no);
		mav.addObject("boardInfo", boardInfo);
		mav.setViewName("detail");
		
		return boardInfo;
	}
	
	public List<User> getAllUser() {
		List<User> AllUserList = dao.getAllUser();
		
		return AllUserList;
	}
	
	public int addUser(User user) {
		return dao.insertUser(user);
	}
	
	public int addBoard(Board board) {
		return dao.insertBoard(board);
	}
	
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
}
