package ua.lviv.lgs.hbm.xml;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {

		// create configuration object with credentionls to DB
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		// create
		Cart cart = new Cart("Andrew", "Beta");
		Item item = new Item("Rim");
		Item item2 = new Item("Berlin");
		Item item3 = new Item("Kiev");
		Item item4 = new Item("Warshava");
		cart.setItems(new HashSet<>(Arrays.asList(item, item2, item3, item4)));
		session.persist(cart);

		transaction.commit();
		session.close();

	}
}


