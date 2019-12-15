package org.tuto.service.sessions;

import java.util.List;

import javax.ejb.Remote;

import org.tuto.service.entities.Account;

@Remote
public interface IBankRemote {
	public void addAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccount(long code);
	public void pay(long code, double balance);
	public void withdraw(long code, double balance);
	public void transfer(long code1, long code2, double balance);
}

