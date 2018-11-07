package org.gonnys.security;

import org.gonnys.domain.MemberVO;
import org.gonnys.mapper.MemberMapper;
import org.gonnys.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("loadUserByUsername.......................");
		log.info("PARAM: " + username);
		
		MemberVO vo = mapper.getMember(username);
		
		log.info(vo);
		
		return new CustomUser(vo);
	}

}
