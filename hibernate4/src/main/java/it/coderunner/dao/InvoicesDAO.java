package it.coderunner.dao;

import java.util.List;

import it.coderunner.model.Invoices;

public interface InvoicesDAO {
	
	void save(Invoices i);
	
	List<Invoices> list();

}
