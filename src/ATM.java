import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        ATMService service = new ATMService();
        service.addAccount(new Account("Pavan", "1234", 5000));
        service.addAccount(new Account("Reddy", "5678", 3000));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        Account acc = service.login(name, pin);

        if(acc == null) {
            System.out.println("Invalid credentials!");
            return;
        }

        while(true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Balance: " + acc.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    System.out.println("Deposited successfully!");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    if(acc.withdraw(wd)) {
                        System.out.println("Withdraw successful!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
