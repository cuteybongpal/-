package com.study.demo.sbb.user;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.demo.sbb.SecurityConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public SiteUser getUser(String username){
		return this.userRepository.findByUsername(username).get();
	}
	
	public SiteUser create(String username, String email, String password) {
		SiteUser user = new SiteUser();
		user.setEmail(email);
		user.setUsername(username);
		//비크립트 해시 함수를 사용하는 클래스
		
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
	}
}
