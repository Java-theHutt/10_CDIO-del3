package Game;

import static java.lang.Math.abs;

public class Account {
    private int balance;

    public Account (int balance){
        this.balance = balance;
    }

    public int addToBalance(int amount){
        balance += amount;
        return balance;
    }

    public void subtractFromBalance(int amount){
        if (abs(amount) > balance) {
            balance = 0;
        }
        else {
            balance -= abs(amount);
        }
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
