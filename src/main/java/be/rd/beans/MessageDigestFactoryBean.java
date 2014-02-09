package be.rd.beans;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>,
		InitializingBean {

	private String algorithmName = "MD5";
	private MessageDigest md;
	
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.md = MessageDigest.getInstance(algorithmName);
	}

	@Override
	public MessageDigest getObject() throws Exception {
		return this.md;
	}

	@Override
	public Class<?> getObjectType() {
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
