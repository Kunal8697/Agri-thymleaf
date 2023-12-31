package com.example.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.Register;

public class CustomRegisterDetails implements UserDetails {

	private Register register;

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public CustomRegisterDetails(Register register) {
		super();
		this.register = register;
	}

	@Override
	// This part of the syntax defines the return type of the method. 
	//It specifies that the method will return an object of a type that implements the Collection interface
	public Collection<? extends GrantedAuthority> getAuthorities() {

		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(register.getType());

		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {

		return register.getPassword();
	}

	@Override
	public String getUsername() {

		return register.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
