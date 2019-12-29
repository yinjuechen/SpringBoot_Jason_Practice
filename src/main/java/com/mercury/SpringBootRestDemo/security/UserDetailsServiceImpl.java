package com.mercury.SpringBootRestDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyUser;
import com.mercury.SpringBootRestDemo.beans.User;
import com.mercury.SpringBootRestDemo.daos.MyUserDao;
import com.mercury.SpringBootRestDemo.daos.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MyUserDao myUserDao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		MyUser u = myUserDao.findByEmail(email);
		if(u == null){
			throw new UsernameNotFoundException(email + " not found");
		}else{
			return u;
		}
	}

}
