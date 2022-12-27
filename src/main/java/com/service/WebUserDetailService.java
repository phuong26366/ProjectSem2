package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.Staff;
import com.reponsitory.StaffReponsitory;

@Service
public class WebUserDetailService implements UserDetailsService {
	@Autowired
	private StaffReponsitory reponsitory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Staff staff = reponsitory.getByName(username);
		if (staff == null) {
			return null;
		}
		return new org.springframework.security.core.userdetails.User(username, staff.getPassword(), true, true, true,
				true, staff.getAuthorities());
	}

}
