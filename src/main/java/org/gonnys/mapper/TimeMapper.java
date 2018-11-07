package org.gonnys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Insert("insert into tbl_t1 (col) values (#{str})")
	public int insert1 (String str);
	
	@Insert("insert into tbl_t2 (col) values (#{str})")
	public int insert2 (String str);
	
	@Select("select now()")
	public String getTime();

}
