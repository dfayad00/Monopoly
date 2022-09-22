import javax.swing.*;

public class Player {
    String name;
    Integer balance;
    JLabel name_label;
    JLabel balance_label;

    public Player(String name) {
        this.name = name;
        balance = 1500;
        name_label = new JLabel(name);
        balance_label = new JLabel("$" + balance.toString());
    }

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        balance_label = new JLabel();
    }

    public void pay(Player p, int amount) {
        if (balance < amount)
            return;

        balance -= amount;
        p.balance += amount;

        updateBalance();
        p.updateBalance();
    }

    public void updateBalance() {
        balance_label.setText("$" + balance.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
