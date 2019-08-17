/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.web.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import net.jpcode.smfx.util.CryptoUtil;

/**
 * PasswordEncoder 实现类
 * @author Billy Zhang
 *
 */
@Component
public class PasswordEncoderImpl implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return CryptoUtil.MD5Hex(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.toString().equals(CryptoUtil.MD5Hex(rawPassword.toString()));
	}

}
