package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.entity.User;
import cn.shopee.bbs.config.autoconfigure.ShiroConfigProperties;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("passwordService")
public class PasswordService {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	@Autowired
	private ShiroConfigProperties shiroConfigProperties;

	public void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(shiroConfigProperties.getCredentialsHashAlgorithmName(), user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), shiroConfigProperties.getCredentialsHashIterations()).toHex();
		user.setPassword(newPassword);
	}

	public void chenckEncryptPassword(User user) {
		//user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(shiroConfigProperties.getCredentialsHashAlgorithmName(), user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), shiroConfigProperties.getCredentialsHashIterations()).toHex();
		user.setPassword(newPassword);
	}
}
