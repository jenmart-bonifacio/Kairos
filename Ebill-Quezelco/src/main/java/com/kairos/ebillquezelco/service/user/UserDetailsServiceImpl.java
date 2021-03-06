package com.kairos.ebillquezelco.service.user;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.user.UserAccountDao;
import com.kairos.ebillquezelco.domain.user.UserAccount;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	private static final String ROLE_PREFIX = "ROLE_";
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Login attempt detected for user: " + username);
		UserAccount userAccount = userAccountDao.getByUsername(username);
		if (userAccount==null) {
			throw new UsernameNotFoundException("User with username: " + username + " cannot be found!");
		}
		return createUser(userAccount);
	}
	
	private User createUser(UserAccount userAccount) {
		logger.info("Creating Spring Security User from UserAccount Entity: " + userAccount.toString());
		return new User(userAccount.getUsername(), userAccount.getPassword(), createAuthorities(userAccount));
	}
	
	private Collection<GrantedAuthority> createAuthorities(UserAccount userAccount) {
		Collection<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
		StringBuffer sb = new StringBuffer(ROLE_PREFIX);
		String rawRole = userAccount.getRole().getRole();
		sb.append(rawRole);
		String secRole = sb.toString().replace(" " , "_");
		logger.info("Adding Role: {}", secRole);
		gaList.add(new SimpleGrantedAuthority(secRole));
		return gaList;
	}
	
}
