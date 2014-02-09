package be.rd.beans;

import java.security.MessageDigest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO this one does not actually perform any asserts ... it just runs the code
 * 
 * @author ruben
 *
 */
public class MessageDigestFactoryBeanTest {

	private MessageDigest sha1Digest;
	private MessageDigest defaultDigest;
	
	private static String SHA1_DIGEST_RESULT="[B@4097d66a";
	private static String DEFAULT_DIGEST_RESULT="[B@307dea47";
	
	
	private ClassPathXmlApplicationContext appCtx;
	private ClassPathXmlApplicationContext getAppCtx(){
		if(appCtx == null){
			appCtx = new ClassPathXmlApplicationContext("appcontextfactorybean.xml");
		}
		return appCtx;
	}
	
	@Test
	public void testDigests(){
		String msg="Hello world";
		
		sha1Digest = getAppCtx().getBean("sha1Digest", MessageDigest.class);
		defaultDigest = getAppCtx().getBean("defaultDigest", MessageDigest.class);
		
		System.out.println("Using sha1digest with algirithm " + sha1Digest.getAlgorithm());
		digest(sha1Digest, msg, SHA1_DIGEST_RESULT);
		System.out.println("Using defaultdigest " + defaultDigest.getAlgorithm());
		digest(defaultDigest, msg, DEFAULT_DIGEST_RESULT);
	}
	
	private void digest(MessageDigest digest, String msg, String expectedResult){
		digest.reset();
		byte[] out = digest.digest(msg.getBytes());
		System.out.println(out);
	}
}
