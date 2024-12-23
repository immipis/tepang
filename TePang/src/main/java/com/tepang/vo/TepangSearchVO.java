package com.tepang.vo;

import java.util.Date;

import lombok.Data;


@Data
public class TepangSearchVO{
	private String memberId,searchName;
	private int searchCnt;
	private Date searchDate;
}
