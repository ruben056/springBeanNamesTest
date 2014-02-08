package be.rd.beans;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean1 {

	private ClassPathXmlApplicationContext appCtx;
	private ClassPathXmlApplicationContext getAppCtx(){
		if(appCtx == null){
			appCtx = new ClassPathXmlApplicationContext("appcontext.xml");
		}
		return appCtx;
	}
	
	private Bean1 getBean1(String someIdentifier){
		return getAppCtx().getBean(someIdentifier, Bean1.class);
	}
	
	@Test
	public void testBeanWithClassname(){
		String className = Bean1.class.getName();
		Bean1 b = getBean1(className);
		Assert.assertEquals(className, b.getMsg());
	}
	
	@Test
	public void testBeanWithID(){
		Bean1 b = getBean1("beanID");
		Assert.assertEquals("beanID", b.getMsg());
	}
	
	@Test
	public void testBeanWithName(){
		Bean1 b = getBean1("beanName");
		Assert.assertEquals("beanName", b.getMsg());
	}
	
	@Test
	public void testBeanAliasing(){
		// different beans (same implementation)
		String className = Bean1.class.getName();
		Bean1 b1 = getBean1(className);
		Bean1 b2 = getBean1("beanID");
		Bean1 b3 = getBean1("beanName");
		
		Assert.assertNotEquals(b1, b2);
		Assert.assertNotEquals(b1, b3);
		Assert.assertNotEquals(b2, b3);
		
		// same beans retrieved by different alias
		b1 = getBean1("beanWitAlias");
		b2 = getBean1("alias1");
		b3 = getBean1("alias2");
		
		Assert.assertEquals(b1, b2);
		Assert.assertEquals(b1, b3);
		Assert.assertEquals(b2, b3);
	}
}
