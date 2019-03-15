package cn.shopee.common.hibernate.mvc.hibernate.dynamic.listener;

import cn.shopee.common.utils.SpringContextHolder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import  cn.shopee.common.hibernate.mvc.hibernate.dynamic.builder.DynamicHibernateStatementBuilder;
import  cn.shopee.common.hibernate.mvc.hibernate.dynamic.builder.NoneDynamicHibernateStatementBuilder;

public class DynamicStatementInitListener implements ApplicationListener<ContextRefreshedEvent> {

	protected DynamicHibernateStatementBuilder dynamicStatementBuilder = SpringContextHolder.getApplicationContext()
			.getBean(DynamicHibernateStatementBuilder.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			if (this.dynamicStatementBuilder == null) {
				this.dynamicStatementBuilder = new NoneDynamicHibernateStatementBuilder();
			}
			dynamicStatementBuilder.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}