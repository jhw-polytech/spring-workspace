package kr.ac.kopo.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public void insertReply(ReplyVO replyVO) {
		replyDAO.insert(replyVO);
	}
	
	@Override
	public List<ReplyVO> selectAllByBoardNo(int boardNo) {
		List<ReplyVO> replyList = replyDAO.selectAll(boardNo);
		return replyList;
	}
	
	@Override
	public void removeReply(int replyNo) {
		replyDAO.delete(replyNo);		
	}

}
