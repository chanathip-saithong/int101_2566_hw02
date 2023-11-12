package work03;
import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;
    
    public Account(Person owner){
        if (owner == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
        this.balance = 0.0;

        long result = Utilitor.computeIsbn10(nextNo);
        while (result == 10) {
            nextNo++;
            result = Utilitor.computeIsbn10(nextNo);
        }
        this.no = 10 * nextNo + result;
        nextNo++;
    }

    public long getNo(){
        return no;
    }

    public Person getOwner(){
        return owner;
    }
    
    public double getBalance(){
        return balance;
    }

    public double deposit(double amount){
        if (Utilitor.testPositive(amount) != amount){
            throw new IllegalArgumentException();
        }
        balance += amount;
        return balance;
    }

    public double withdraw(double amount){
        if (Utilitor.testPositive(amount) != amount) {
            throw new IllegalArgumentException();
        }
        if (balance - amount >= 0){
            balance -= amount;
            return balance;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void transfer(double amount , Account account){
        if (account == null) {
            throw new IllegalArgumentException();
        }
        try {
            double withdrawAmount = this.withdraw(amount);
            account.deposit(withdrawAmount);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Account(").append(no).append(",").append(balance).append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }return false;    
    }
}
