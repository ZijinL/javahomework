import java.util.Date;
public class homework_3_2 {
    public static void main(String [] args) {
        Account acc_1 = new Account();
        Account acc_2 = new Account(2020, 1102);
        acc_1.disPlayInfo();
        acc_2.disPlayInfo();
        acc_2.setAnnualInterestRate(0.24);
        acc_2.setId(2021);
        acc_2.setBalance(1103);
        acc_2.disPlayInfo();
        System.out.println("MonthlyInterest: " + acc_2.getMonthlyInterest());
        System.out.println("MonthlyInterestRate: " + acc_2.getMonthlyInterestRate());
        acc_2.deposit(100);
        acc_2.disPlayInfo();
        acc_2.withDraw(100);
        acc_2.disPlayInfo();

    }

}

class Account {
    private int id;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate () {
        return annualInterestRate;
    }

    public void setAnnualInterestRate (double rate) {
        annualInterestRate = rate;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate/12;
    }

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 12;
    }

    public void withDraw(double amount) {
        setBalance(balance - amount);
    }

    public void deposit(double amount) {
        setBalance(balance - amount);
    }

    public void disPlayInfo() {
        System.out.println("======Account Infomation======");
        String ft = "id: %s\nbalance: %s\nannualRate: %s\ndateCreate: %s\n";
        System.out.printf(ft, getId(), getBalance(), getAnnualInterestRate(), getDateCreated());
        System.out.println("========No Info Below=========");
    }
}
