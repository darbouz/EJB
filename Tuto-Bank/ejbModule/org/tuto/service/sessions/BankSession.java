package org.tuto.service.sessions;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.tuto.service.entities.Account;

@Stateless(name = "Bank")


public class BankSession implements IBankRemote, IBankLocal{

	@PersistenceContext(unitName = "Tuto-Bank")
	EntityManager entityManager;
	
	public void addAccount(Account account) {
		entityManager.persist(account);
	}
	
	public List<Account> getAccounts() {
		Query query = entityManager.createQuery("select a from Account a where a.active=1");
		return query.getResultList();
	}
	
	public Account getAccount(long code) {
		Account account = entityManager.find(Account.class, code);
		if(account == null) throw new RuntimeException();
		return account;
	}
	
	public void pay(long code, double balance) {
		Account account = getAccount(code);
		if(account != null)
			account.setBalance(account.getBalance() + balance);
	}

	public void withdraw(long code, double balance) {
		balance *= -1; 
		pay(code, balance);
	}
	
	public void transfer(long code1, long code2, double balance) {
		withdraw(code1, balance);
		pay(code2, balance);
	}

}
