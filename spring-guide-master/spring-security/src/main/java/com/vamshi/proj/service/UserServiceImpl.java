package com.vamshi.proj.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vamshi.proj.model.User;
import com.vamshi.proj.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepo repo; 

	@Override
	public Long saveUser(User user) {
		String encPwd = encoder.encode(user.getUsrPwd());
		user.setUsrPwd(encPwd);
		user = repo.save(user);
		return user.getUsrId();

	}

	@Override
	public Optional<User> findByEmai(String email) {

		return repo.findByUsrMail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> opt = repo.findByUsrMail(username);

		if (opt.isEmpty()) {
			throw new UsernameNotFoundException("Not exist");
		} else {
			User user = opt.get();
			return new org.springframework.security.core.userdetails.User(username, user.getUsrPwd(), user.getUsrRoles()
					.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		}

	}

}
