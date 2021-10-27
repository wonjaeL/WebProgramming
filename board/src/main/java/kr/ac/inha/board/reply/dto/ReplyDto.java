package kr.ac.inha.board.reply.dto;

import lombok.Data;

@Data
public class ReplyDto {
	private int replyNo;
	private int boardIdx;
	private String replyMemo;
	private String createdDatetime;
	private String creatorId;
}
