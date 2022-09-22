import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Monopoly {
    static JPanel panel = new JPanel();
    static JFrame frame = new JFrame("I Love This City!");
    static ArrayList<Player> Players = new ArrayList<>();

    public static void main(String[] args) {
        Players.add(new Player("Bank", 100000));
        create_window2(frame);
    }

    /*public static void build_gui() {
        frame.setLayout(new GridLayout(2, 2));

        frame.add(get_players_panel(), new Dimension(0, 0));

    }*/

    /*public static JPanel get_players_panel() {
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel players_panel = new JPanel();

        players_panel.setLayout(new GridBagLayout());
        JTextField player_field = new JTextField(24);
        JButton add_player_button = new JButton("Add");
        JLabel players_label = new JLabel("Players");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        players_panel.add(players_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        players_panel.add(add_player_button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        players_panel.add(player_field, gbc);

        //add player button listener
        final int[] i = {1};
        final int[] gridy = {2};

        add_player_button.addActionListener(actionEvent ->  {
            if(!player_field.getText().isEmpty() && Players.size() < 7) {
                Players.add(new Player(player_field.getText()));
                JLabel name = new JLabel(Players.get(i[0]).name);
                JLabel balance = new JLabel("$" + Players.get(i[0]).balance.toString());

                gbc.gridy = gridy[0];
                gbc.gridx = 1;
                players_panel.add(balance, gbc);

                gbc.gridx = 0;
                players_panel.add(name, gbc);

                tx_player1.addItem(Players.get(i[0]).name);

                panel.revalidate();
                panel.repaint();

                tx_panel.revalidate();
                tx_panel.repaint();

                gridy[0]++;
                i[0]++;
            }
        });

        return players_panel;
    }*/

    /*public static JPanel get_tx_panel() {
        JPanel tx_panel = new JPanel();

        tx_panel.setLayout(new GridLayout(4, 2));

        JComboBox<String> tx_player1 = new JComboBox<>();
        tx_player1.addItem("Bank");
        tx_panel.add(tx_player1, new Dimension(0,0));

        return tx_panel;
    }*/

    public static void create_window2(JFrame frame) {
        JPanel players_panel = new JPanel();
        JPanel notes_panel = new JPanel();
        JPanel tx_panel = new JPanel();
        JPanel tx_hist_panel = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();

        //window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(960, 540);
        panel.setSize(960, 540);
        panel.setLayout(new GridLayout(2, 2));


        //players panel
        players_panel.setLayout(new GridBagLayout());
        players_panel.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextField player_field = new JTextField(12);
        JButton add_player_button = new JButton("Add");
        JLabel players_label = new JLabel("Players");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        players_panel.add(players_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        players_panel.add(add_player_button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        players_panel.add(player_field, gbc);


        //notes panel
        notes_panel.setLayout(new GridBagLayout());
        notes_panel.setBorder(BorderFactory.createLineBorder(Color.black));


        gbc.gridx = 0;
        gbc.gridy = 0;
        notes_panel.add(new JLabel("Notes"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        notes_panel.add(new JTextArea(10, 20), gbc);


        //transactions panel
        tx_panel.setLayout(new GridBagLayout());
        tx_panel.setBorder(BorderFactory.createLineBorder(Color.black));

        JComboBox<Player> tx_player1 = new JComboBox<>();
        JComboBox<Player> tx_player2 = new JComboBox<>();
        JLabel tx_pays_label = new JLabel("pays");
        JTextField tx_field = new JTextField();
        JButton tx_confirm_button = new JButton("Confirm");

        tx_pays_label.setBorder(new EmptyBorder(0,8,0,0));
        tx_field.setPreferredSize(new Dimension(25, 16));
        tx_player1.setPreferredSize(new Dimension(75,16));
        tx_player2.setPreferredSize(new Dimension(75,16));
        tx_confirm_button.setPreferredSize(new Dimension(220, 24));

        tx_field.setSize(200,24);

        tx_player1.addItem(Players.get(0));
        tx_player2.addItem(Players.get(0));

        gbc.ipadx = 10;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        tx_panel.add(new JLabel("Transactions"), gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        tx_panel.add(tx_player1, gbc);

        gbc.gridx = 1;
        tx_panel.add(tx_pays_label, gbc);

        gbc.gridx = 2;
        tx_panel.add(tx_player2, gbc);

        gbc.gridx = 3;
        tx_panel.add(tx_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        tx_panel.add(tx_confirm_button, gbc);


        //transactions history panel


        //add player button listener
        final int[] i = {1};
        final int[] gridy = {2};

        add_player_button.addActionListener(actionEvent ->  {
            if(!player_field.getText().isEmpty() && Players.size() < 7) {
                Players.add(new Player(player_field.getText()));

                gbc.gridy = gridy[0];
                gbc.gridx = 1;
                players_panel.add(Players.get(i[0]).balance_label, gbc);

                gbc.gridx = 0;
                players_panel.add(Players.get(i[0]).name_label, gbc);

                tx_player1.addItem(Players.get(i[0]));
                tx_player2.addItem(Players.get(i[0]));

                panel.revalidate();
                panel.repaint();

                gridy[0]++;
                i[0]++;
            }
        });


        //confirm transaction button listener
        tx_confirm_button.addActionListener(actionEvent -> {
            if (!tx_field.getText().isEmpty()) {
                Player temp = (Player) tx_player1.getSelectedItem();
                Player temp2 = (Player) tx_player2.getSelectedItem();

                assert temp != null;
                assert temp2 != null;

                temp.pay(temp2, Integer.parseInt(tx_field.getText()));

                players_panel.revalidate();
                players_panel.repaint();
            }
        });

        panel.add(players_panel, new Dimension(0, 0));
        panel.add(notes_panel, new Dimension(1, 0));
        panel.add(tx_panel, new Dimension(1, 0));

        frame.setVisible(true);

        frame.add(panel);
    }
}