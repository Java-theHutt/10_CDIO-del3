package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiExample implements ActionListener {

    JFrame frame;
    JButton button;
    JLabel label;
    JPanel panel;

    int count = 0;

    public GuiExample(){
        frame = new JFrame();

        button = new JButton("Start Game");
        button.addActionListener(this);

        label = new JLabel("Number of clicks");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Monopoly");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GuiExample();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number og clicks " + count);
    }
}
