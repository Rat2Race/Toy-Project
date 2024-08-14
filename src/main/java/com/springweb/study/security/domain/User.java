package com.springweb.study.security.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(nullable = false, name = "username")
	private String name;

	@Column(nullable = false, unique = true, length = 30, name = "email")
	private String email;

	@Column(nullable = false, name = "password")
	private String password;

	@Column(nullable = false, name = "number")
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "role")
	private UserRoleEnum role;

	@Column(length = 1000, name = "refreshToken")
	private String refreshToken;

	public void updateRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public void destroyRefreshToken() {
		this.refreshToken = null;
	}
}
