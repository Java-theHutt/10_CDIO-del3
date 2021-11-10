package GUI;

import Game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class extends the default Jframe class + implements an Actionlistener.
//Actionlistener listens for an action, we define what the action is.
//when the action is performed the ActionListeners default method (ActionPerformed) will run. We can override that method.
public class GuiExample extends JFrame implements ActionListener {

    DiceCollection diceCollection = new DiceCollection();
    JButton button;
    JLabel label;
    JPanel panel;
    ImageIcon monopoly = new ImageIcon("Monopoly.png");   //saves the imagefile in the variable monopoly

    int count = 0;

    public GuiExample(){

        button = new JButton("Roll Dice");
        button.addActionListener(this);

        label = new JLabel("Number of clicks");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(monopoly.getIconWidth(), monopoly.getIconHeight()));
        panel.add(button);        //adds button to panel
        panel.add(label);        //add label to panel

        this.add(panel);        //adds panel to frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //Exits the code when the frame is closed
        this.setTitle("Monopoly");      //sets title of the frame to monopoly
        this.pack();        //Makes the frame adjust its size to all the components, thats been implemented.
        this.setVisible(true);        //makes the frame visible

    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics g2D = (Graphics) g;

        g2D.drawImage(monopoly.getImage(),0,30,null);
    }

    @Override
    //This method is performed when the button is pressed.
    public void actionPerformed(ActionEvent e) {

        diceCollection.roll();
        label.setText("You rolled" + diceCollection.getRollSum());
        System.out.println("You rolled" + diceCollection.getRollSum());
    }
}
