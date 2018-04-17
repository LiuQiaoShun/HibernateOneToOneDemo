package test;





import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import online.qsx.model.Card;
import online.qsx.model.User;



public class HibernateTest {
	public static void main(String[] args) {
		//加载配置文件   
		Configuration configuration=new Configuration();   
		configuration.configure("hibernate.cfg.xml");
		
		//注册标准服务  
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();   
		StandardServiceRegistry ssr=ssrb.applySettings(configuration.getProperties()).build();
		
		SessionFactory sf=configuration.buildSessionFactory(ssr);//二级缓存     
		//开启一个会话 
		
		Session session=sf.openSession();//一级缓存  
		System.out.println("连接开启成功");
		
//		//开启事物
		Transaction transaction=session.beginTransaction();
		
		//操作   
		//增加都改成EAGER
		User user=new User("adnim","123",new Date());
		Card card=new Card(100,100);
		card.setUser(user);
		user.setCard(card);
		session.saveOrUpdate(card);
		session.saveOrUpdate(user);
		
		//查询都改成lazy
//		User user=(User)session.get(User.class, 1L);
//		System.out.println(user.toStringAndCard());
//		//提交事物
//		
		transaction.commit();
		
//		//关闭会话  
		session.close();
		sf.close();
		System.out.println("连接关闭成功");
	}
		
		
}
