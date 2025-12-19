import java.util.ArrayList;
import java.util.List;

public class ATMService {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public Account login(String name, String pin) {
        for(Account acc : accounts) {
            if(acc.getName().equals(name) && acc.getPin().equals(pin)) {
                return acc;
            }
        }
        return null;
    }
}
