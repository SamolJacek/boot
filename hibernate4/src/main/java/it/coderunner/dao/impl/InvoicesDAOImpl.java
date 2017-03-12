package it.coderunner.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import it.coderunner.dao.InvoicesDAO;
import it.coderunner.model.Invoices;

@Repository
public class InvoicesDAOImpl implements InvoicesDAO {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Invoices i) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(i);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Invoices> list() {
		Session session = this.sessionFactory.openSession();
		List<Invoices> invoicesList = session.createQuery("from Invoices").list();
		session.close();
		return invoicesList;
	}
}
