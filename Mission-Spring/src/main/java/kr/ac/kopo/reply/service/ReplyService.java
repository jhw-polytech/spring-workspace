package kr.ac.kopo.reply.service;

import java.util.List;

import kr.ac.kopo.reply.vo.ReplyVO;

public interface ReplyService {

	// DAO의 메소드명과 다른 이유: DAO에서는 CRUD메소드와 이름 일치,
	// 						Service에서는 주체(대상) 이름까지 붙여둔다
	
	void insertReply(ReplyVO replyVO);
	List<ReplyVO> selectAllByBoardNo(int boardNo);
	void removeReply(int replyNo);	
	
}
