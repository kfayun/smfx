/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.dao.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import net.jpcode.smfx.Constants;
import net.jpcode.smfx.config.AppProperties;
import net.jpcode.smfx.dao.DaoCondition;

/**
 * Hibernate 配置类
 * @author Billy Zhang
 *
 */
@Configuration
@EnableTransactionManagement
@Conditional(DaoCondition.Hibernate.class)
public class HibernateConfig implements TransactionManagementConfigurer {

	@Autowired
	private AppProperties appProperties;
	
	@Bean
	public SessionFactory sessionFactory( DataSource dataSource) throws Exception {
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		
		Properties props = new Properties();
		for (String key : appProperties.keys()) {
			if (key.startsWith("hibernate.")) {
				props.put(key, appProperties.getString(key));
			}
		}
		
		factoryBean.setHibernateProperties(props);
		
		factoryBean.setMappingLocations( new PathMatchingResourcePatternResolver()
                .getResources( Constants.HIBERNATE_MAPPER_LOCATION ) );
		
		factoryBean.afterPropertiesSet();
		
		return factoryBean.getObject();
	}
	
	private HibernateTransactionManager txManager;
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		txManager = new HibernateTransactionManager(sessionFactory);
		return txManager;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		
		return txManager;
	}
}
