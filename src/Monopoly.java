import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monopoly {
    static JPanel panel = new JPanel();
    static JFrame frame = new JFrame("I Love This City!");

    public static void main(String[] args) {
        create_window(frame);
    }

    public static void create_window(JFrame frame) {
        //window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(960, 540);


        //layout
        panel.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        //balance panel
        JPanel balance_panel = new JPanel();
        balance_panel.setLayout(new GridBagLayout());
        JButton add_player_button = new JButton("Add Player");
        JTextField player_name_tf = new JTextField();
        player_name_tf.setPreferredSize(new Dimension(200, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        balance_panel.add(player_name_tf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        balance_panel.add(add_player_button, gbc);


        //add player button listener
        final int[] grid = {0};
        add_player_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gbc.gridx = 0;
                JLabel label = new JLabel(player_name_tf.getText() + ": ");
                gbc.gridy = grid[0];
                balance_panel.add(label, gbc);
                panel.revalidate();
                panel.repaint();
                grid[0]++;

            }
        });


        //transactions panel
        JPanel tx_panel = new JPanel();
        tx_panel.setBorder(new EmptyBorder(0, 0, 20, 0 ));
        tx_panel.setLayout(new GridBagLayout());
        JLabel tx_label = new JLabel("Transactions:");
        tx_label.setBorder(new EmptyBorder(0, 10, 10, 0));

        gbc.gridx = 1;
        gbc.gridy = 0;
        tx_panel.add(tx_label, gbc);

        JTextField tx_player1_tf = new JTextField();
        tx_player1_tf.setPreferredSize(new Dimension(50, 24));
        JTextField tx_player2_tf = new JTextField();
        tx_player2_tf.setPreferredSize(new Dimension(50, 24));
        JLabel tx_pay_label = new JLabel("pays   ");

        //add text fields and labels for transactions panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        tx_panel.add(tx_player1_tf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        tx_panel.add(tx_pay_label, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        tx_panel.add(tx_player2_tf, gbc);

        //deals panel
        JPanel deals_panel = new JPanel();
        JLabel deals_label = new JLabel("Deals:");
        JTextArea deals_ta = new JTextArea();
        deals_ta.setPreferredSize(new Dimension(200, 400));
        deals_panel.add(BorderLayout.NORTH, deals_label);
        deals_panel.add(BorderLayout.SOUTH, deals_ta);


        //menu bar
        JMenuBar mb = new JMenuBar();
        JMenu mb_file = new JMenu("File");
        mb.add(mb_file);
        JMenuItem mi = new JMenuItem("suck dick");
        mb_file.add(mi);


        //add components to panel
        panel.add(balance_panel, BorderLayout.WEST);
        panel.add(deals_panel, BorderLayout.EAST);
        panel.add(tx_panel, BorderLayout.SOUTH);

        /*gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(balance_panel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(tx_panel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        panel.add(deals_panel, gbc);*/


        //add components to frame
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
