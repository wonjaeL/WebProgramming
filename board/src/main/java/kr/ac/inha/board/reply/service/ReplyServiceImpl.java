package kr.ac.inha.board.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.inha.board.board.mapper.BoardMapper;
import kr.ac.inha.board.reply.dto.ReplyDto;
import kr.ac.inha.board.reply.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<ReplyDto> selectReplyList(int boardIdx) throws Exception {
		return replyMapper.selectReplyList(boardIdx);
	}

	@Override
	public void insertReply(ReplyDto reply) throws Exception {
		replyMapper.insertReply(reply);
		boardMapper.addReplyCount(reply.getBoardIdx());
	}

	@Override
	public ReplyDto selectReplyDetail(int replyNo) throws Exception {
		return replyMapper.selectReplyDetail(replyNo);
	}

	@Override
	public void updateReply(ReplyDto reply) throws Exception {
		replyMapper.updateReply(reply);
	}

	@Override
	public void deleteReply(int replyNo) throws Exception {
		ReplyDto reply = replyMapper.selectReplyDetail(replyNo);
		
		replyMapper.deleteReply(replyNo);
		boardMapper.minusReplyCount(reply.getBoardIdx());
	}
}