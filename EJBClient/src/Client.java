import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.tuto.service.entities.Account;
import org.tuto.service.sessions.IBankRemote;

public class Client {
	public static void main(String[] args) {
		Context context;
		try {
			context = new InitialContext();
			IBankRemote bankRemote = (IBankRemote) 
					context.lookup
						("ejb:/Tuto-Bank/Bank!"+IBankRemote.class.getName());
			List<Account> accounts = bankRemote.getAccounts();
			for (Account account : accounts) {
				System.out.println(account.toString());
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
