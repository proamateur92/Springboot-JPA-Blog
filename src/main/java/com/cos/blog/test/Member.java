package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@Data // Getter, Setter 동시에 만들 때
//@AllArgsConstructor // 모든 인자를 받는 생성자
//@RequiredArgsConstructor // final 붙은 애들에 대한 생성자

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private  int id; // DB에서 가져오는 값이기 때문에 불변성 처리(final)
	private  String username;
	private  String password;
	private  String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}
