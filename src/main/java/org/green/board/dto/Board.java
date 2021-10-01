package org.green.board.dto;

public class Board {
	private String board_type;
	private int board_num;
	private String board_title;
	private String board_comment;
	
	public Board() {}

	public Board(int board_num) {
		super();
		this.board_num = board_num;
	}

	public Board(String board_type, int board_num, String board_title, String board_comment) {
		super();
		this.board_type = board_type;
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_comment = board_comment;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_comment() {
		return board_comment;
	}

	public void setBoard_comment(String board_comment) {
		this.board_comment = board_comment;
	}
}
