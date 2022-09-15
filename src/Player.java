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
    }

    public int pay(Player p, int amount) {
        if (balance < amount)
            return -1;

        balance -= amount;
        p.balance += amount;

        return 0;
    }

    public void updateBalance() {
        balance_label.setText("$" + balance.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
