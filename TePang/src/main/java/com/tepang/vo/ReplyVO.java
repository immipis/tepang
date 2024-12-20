package com.tepang.vo;

import java.util.Date;

import lombok.Data;


@Data
public class ReplyVO {
	private String replyCode;
	private String replyContent;
	private String memberId;
	private String replyAnswer;
	private Date replyDate;
}
