package org.green.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.green.board.dto.Board;
import org.green.board.dto.ComCode;
import org.green.board.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SpringBoardDAO {

	@Autowired
	private JdbcTemplate jdbcTmp;
	
	@Value("#{sql['user_info.insert']}")
	private String insertUser;
	
	//SELECT * FROM user_info
	@Value("#{sql['user_info.getAllUser']}")
	private String getAllUser;
	
	@Value("#{sql['board.getAll']}")
	private String getAll;
	
	@Value("#{sql['board.insert']}")
	private String insertBoard;
	
	@Value("#{sql['board.selectBoard']}")
	private String selectBoard;
	
	@Value("#{sql['board.updateBoard']}")
	private String updateBoard;
	
	@Value("#{sql['com_code.getCodeList']}")
	private String getCodeList;
	
	public int insertUser(User user) {
		return jdbcTmp.update(insertUser, user.getUser_id(), user.getUser_pw(), user.getUser_name(), user.getUser_phone1(), user.getUser_phone2(), user.getUser_phone3());
	}
	
	public int insertBoard(Board board) {
		return jdbcTmp.update(insertBoard, board.getBoard_type(), board.getBoard_title(), board.getBoard_comment());
	}
	
	public int updateBoard(Board board) {
		return jdbcTmp.update(updateBoard, new Object[] {board.getBoard_type(), board.getBoard_title(), board.getBoard_comment(), board.getBoard_num()});
	}
	
	public List<Board> getAll() {
		return jdbcTmp.query(getAll, new BoardMapper());
	}
	
	public List<User> getAllUser() {
		return jdbcTmp.query(getAllUser, new UserMapper());
	}
	
	public Board selectBoard(int no) {
		Board BoardInfo = jdbcTmp.queryForObject(selectBoard, new Object[]{no}, new BoardMapper());
		return BoardInfo;
	}
	
	public List<ComCode> getCodeList() {
		return jdbcTmp.query(getCodeList, new ComCodeMapper());
	}
	
	class ComCodeMapper implements RowMapper<ComCode> {
		@Override
		public ComCode mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new ComCode(rs.getString("code_type"), rs.getString("code_id"), rs.getString("code_name"));
		}
	}
	
	class BoardMapper implements RowMapper<Board> {
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Board(rs.getString("board_type"), rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_comment"));
		}
	}
	
	class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("user_name"), rs.getString("user_phone1"));
		}
	}
}
