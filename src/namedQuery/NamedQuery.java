package namedQuery;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NamedQuery {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		@NamedQuery		
//		Query query =session.getNamedQuery("UserDetails.byId");
//		query.setInteger(0, 1);
		
//		@NamedNativeQuery
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "apatel");
		
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user : users){
			System.out.println(user.getUserName());
		}
		
		
	}
}

