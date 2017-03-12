package it.coderunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.support.DaoSupport;

import ch.qos.logback.classic.net.SyslogAppender;
import it.coderunner.dao.InvoicesDAO;
import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Invoices;
import it.coderunner.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);

		Person person = new Person();
		person.setName("Michał");
		person.setCountry("Poland");

		personDAO.save(person);

		System.out.println("Person::" + person);

		personDAO.list().forEach(System.out::println);

		
		InvoicesDAO invoicesDao = context.getBean(InvoicesDAO.class);
		
		Invoices invoices = new Invoices();
		invoices.setProduct("PcComputer");
		invoices.setQuantity(2);
		
		invoicesDao.save(invoices);
		
		System.out.println("Invoices: " + invoices);
		
		invoicesDao.list().forEach(System.out::println);
		
		context.close();
		

	}

}