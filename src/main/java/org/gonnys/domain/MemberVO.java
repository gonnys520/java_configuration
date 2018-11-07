package org.gonnys.domain;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import lombok.Data;

@Data
public class MemberVO {


	public MemberVO(DataSource dataSource) {
		// TODO Auto-generated constructor stub
	}

	private String userid, userpw, username;
	private boolean enabled;
	private Date regdate, updatedate;
	
	private List<AuthVO> authList;

}