package com.tepang.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private String replyCode;
	private String replyContent;
	private String memberId;
	private Date replyDate;
}
