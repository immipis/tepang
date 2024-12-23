package com.tepang.vo;

import java.util.Date;

import lombok.Data;




@Data
public class SingupVO {
	private String memberId, memberPw, memberName, memberPhone, memberAdr, memberBir, memberGen, memberFv, memberTier;
	private Date memberDate;
}
