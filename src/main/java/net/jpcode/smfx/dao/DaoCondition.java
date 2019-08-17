/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.dao;

import java.util.Properties;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import net.jpcode.smfx.util.PropertiesUtil;

/**
 * Dao 条件注解类
 * @author Billy Zhang
 *
 * 根据属性配置中dao.provider给定的值来生成Dao相关的Bean
 * 
 */
public abstract class DaoCondition implements Condition {

	private static final String DAO_PROVIDER = "dao.provider";
	private static final String DEFAULT_DAO = "mybatis";
	
	protected abstract String getName();
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		Properties props = PropertiesUtil.load(context.getEnvironment());
		
		if ( props.containsKey(DAO_PROVIDER) ) {
			return getName().equals( props.getProperty(DAO_PROVIDER) );
		}
		
		return DEFAULT_DAO.equals(getName());  // default
	}
	
	/**
	 * MyBatis 条件注解
	 * @author billy
	 *
	 */
	public final static class MyBatis extends DaoCondition {
		
		@Override
		public String getName() {
			return "mybatis";
		}
	}
	
	/**
	 * Hibernate 条件注解
	 * @author billy
	 *
	 */
	public final static class Hibernate extends DaoCondition {
		
		@Override
		public String getName() {
			return "hibernate";
		}
	};
	
	
}
