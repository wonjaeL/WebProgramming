package kr.ac.inha.board.reply.service;

import java.util.List;

import kr.ac.inha.board.reply.dto.ReplyDto;

public interface ReplyService {
	List<ReplyDto> selectReplyList(int boardIdx) throws Exception;
	void insertReply(ReplyDto reply) throws Exception;
	ReplyDto selectReplyDetail(int replyNo) throws Exception;
	void updateReply(ReplyDto reply) throws Exception;
	void deleteReply(int replyNo) throws Exception;
}