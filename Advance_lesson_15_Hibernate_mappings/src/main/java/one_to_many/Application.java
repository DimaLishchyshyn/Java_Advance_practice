package one_to_many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Comment comment = new Comment();
		comment.setAuthorName("Zhanna Bozhenko");

		Post post = new Post();
		post.setTitle(3455);
		post.setComment(comment);

		Post post2 = new Post();
		post2.setTitle(4534);
		post2.setComment(comment);

		Set<Post> posts = new HashSet<>();
		posts.add(post);
		posts.add(post2);

		comment.setPost(posts);

		// save to DB
		Transaction transaction = session.beginTransaction();
		session.save(comment);
		transaction.commit();

		// read from DB
		Comment commentDB = (Comment) session.get(Comment.class, 1);
		System.out.println(commentDB + "---->" + commentDB.getPost());

		Post postDB = (Post) session.get(Post.class, 2);
		System.out.println(postDB + "---->" + postDB.getComment());

	}
}