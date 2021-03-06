package kr.ac.kopo.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	/**
	 * 댓글 추가
	 * 1. DBC에 t_board에 해당 레코드의 댓글 카운트 컬럼값을 1 증가
	 * 2. DB에 t_reply에 새로운 댓글 추가
	 */
	@Transactional // 트랜잭션 처리
	@Override
	public void insertReply(ReplyVO replyVO) {
		boardDAO.incrementReplyCnt(replyVO.getBoardNo());
		replyDAO.insert(replyVO);
		// 즉, service가 여러개의 DAO에 접근한다.
	}
	
	@Override
	public List<ReplyVO> selectAllByBoardNo(int boardNo) {
		List<ReplyVO> replyList = replyDAO.selectAll(boardNo);
		return replyList;
	}
	
	/**
	 * 0. DB에서 삭제할 댓글의 게시물 번호 조회(t_reply)
	 * 1. DB에서 해당 댓글 삭제(t_reply)
	 * 2. DB에서 해당 게시물의 댓글 카운트 감소(t_board)
	 */
	@Transactional
	@Override
	public void removeReply(int replyNo) {
		int boardNo = replyDAO.selectBoardNo(replyNo);
		replyDAO.delete(replyNo);		
		boardDAO.reduceReplyCnt(boardNo);
	}
	
	/*
	 * 1. DB에서 해당 댓글 삭제(t_reply)
	 * 2. DB에서 해당 게시물의 댓글 카운트 감소(t_board) 
	 */
	@Transactional
	@Override
	public void removeReply(ReplyVO replyVO) {
		replyDAO.delete(replyVO.getNo());
		boardDAO.reduceReplyCnt(replyVO.getBoardNo());
	}

}
