package com.forecastportal.util;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forecastportal.domain.user.User;
import com.forecastportal.service.user.UserService;

@Service
public class TokenServiceImpl implements TokenService {

	private static final String SALT = "ForecastPortalUA";
	private static final String CIPHER = "AES/ECB/PKCS5Padding";
	private static final String KEY_ALG = "AES";
	private static final String DELIMETER = "/";

	@Autowired
	public UserService userService;

	@Transactional
	public User getUserFromLink(String token) {
		String s = decode(token);
		String[] args = s.split(DELIMETER);
		if (args.length != 2) {
			return null;
		}
		Long userId = null;
		try {
			userId = Long.valueOf(args[0]);
		} catch (NumberFormatException e) {
		}
		if (userId == null) {
			return null;
		}
		User user = userService.findById(userId);
		String hashedCreationTime = hashCreationTime(user.getCreationTime().getTime());
		if (!args[1].equals(hashedCreationTime)) {
			return null;
		}
		return user;
	}

	//@Override
	public String createToken(User u) {
		User user = userService.findById(u.getId());
		String s = user.getId() + DELIMETER
				+ hashCreationTime(user.getCreationTime().getTime());
		return encode(s);
	}

	

	private String hashCreationTime(Long creationTime) {
		return md5(sha1(creationTime));
	}

	private String encode(String link) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(CIPHER);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(SALT.getBytes(),
					KEY_ALG));
			char[] chars = Hex.encode(cipher.doFinal(link.getBytes()));
			String ticket = new String(chars);
			return ticket;
		} catch (InvalidKeyException e) {
			throw new IllegalArgumentException(
					"Length of salt must be 16, 24 or 32 sumbols", e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String decode(String token) {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(SALT.getBytes(),
					KEY_ALG));
			byte[] bytes = cipher.doFinal(Hex.decode(token));
			String link = new String(bytes);
			return link;
		} catch (InvalidKeyException e) {
			throw new IllegalArgumentException(
					"Length of salt must be 16, 24 or 32 sumbols", e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private byte[] sha1(Long base) {
		try {
			byte[] bytes = ByteBuffer.allocate(8).putLong(base).array();
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			byte[] hash = digest.digest(bytes);
			return hash;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private String md5(byte[] base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] hash = digest.digest(base);
			return new String(Hex.encode(hash));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
