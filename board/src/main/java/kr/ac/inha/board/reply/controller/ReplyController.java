package kr.ac.inha.board.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inha.board.reply.dto.ReplyDto;
import kr.ac.inha.board.reply.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	@RequestMapping("/reply/openReplyWrite.do")
	public ModelAndView openReplyWrite(@RequestParam int boardIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/reply/replyWrite");
		mv.addObject("boardIdx", boardIdx);
		return mv;
	}

	@RequestMapping("/reply/insertReply.do")
	public String insertReply(ReplyDto reply) throws Exception {
		replyService.insertReply(reply);
		return "redirect:/board/openBoardDetail.do?boardIdx=" + reply.getBoardIdx();
	}

	@RequestMapping("/reply/openReplyDetail.do")
	public ModelAndView openReplyDetail(@RequestParam int replyNo) throws Exception {
		ModelAndView mv = new ModelAndView("/reply/replyDetail");
		ReplyDto reply = replyService.selectReplyDetail(replyNo);
		mv.addObject("reply", reply);
		return mv;
	}

	@RequestMapping("/reply/updateReply.do")
	public String updateReply(ReplyDto reply) throws Exception {
		int boardIdx = getBoardIdxByReplyNo(reply.getReplyNo());
		replyService.updateReply(reply);
		return "redirect:/board/openBoardDetail.do?boardIdx=" + boardIdx;
	}

	@RequestMapping("/reply/deleteReply.do")
	public String deleteReply(int replyNo) throws Exception {
		int boardIdx = getBoardIdxByReplyNo(replyNo);
		replyService.deleteReply(replyNo);
		return "redirect:/board/openBoardDetail.do?boardIdx=" + boardIdx;
	}

	private int getBoardIdxByReplyNo(int replyNo) throws Exception {
		ReplyDto reply = replyService.selectReplyDetail(replyNo);
		int boardIdx = reply.getBoardIdx();
		return boardIdx;
	}
}