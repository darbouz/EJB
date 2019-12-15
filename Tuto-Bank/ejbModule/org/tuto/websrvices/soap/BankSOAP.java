package org.tuto.websrvices.soap;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.tuto.service.entities.Account;
import org.tuto.service.sessions.IBankLocal;

@WebService
@Stateless
public class BankSOAP {
	
	@EJB(name = "Bank")
	IBankLocal bankLocal;
	
	public String addAccount(@WebParam(name = "balance") double balance) {
		bankLocal.addAccount(new Account(balance, new Date(), true));
		return "success";
	}

	public List<Account> getAccounts() {
		return bankLocal.getAccounts();
	}

	public Account getAccount(@WebParam(name = "code") long code) {
		return bankLocal.getAccount(code);
	}

	public void pay(@WebParam(name = "code") long code, 
					@WebParam(name = "balance") double balance) {
		bankLocal.pay(code, balance);
	}

	public void withdraw(@WebParam(name = "code") long code, 
						 @WebParam(name = "balance") double balance) {
		bankLocal.withdraw(code, balance);
	}

	public void transfer(@WebParam(name = "code1") long code1,
						 @WebParam(name = "code2") long code2,
						 @WebParam(name = "balance") double balance) {
		bankLocal.transfer(code1, code2, balance);
	}
}
