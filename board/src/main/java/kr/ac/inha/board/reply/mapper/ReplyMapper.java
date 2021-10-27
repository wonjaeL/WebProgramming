package kr.ac.inha.board.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.inha.board.reply.dto.ReplyDto;

@Mapper
public interface ReplyMapper {
	List<ReplyDto> selectReplyList(int boardIdx) throws Exception;
	void insertReply(ReplyDto reply) throws Exception;
	ReplyDto selectReplyDetail(int replyNo) throws Exception;
	void updateReply(ReplyDto reply) throws Exception;
	void deleteReply(int replyNo) throws Exception;
}