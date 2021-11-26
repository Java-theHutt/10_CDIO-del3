package GUI;

import Game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class extends the default Jframe class + implements an Actionlistener.
//Actionlistener listens for an action, we define what the action is.
//when the action is performed the ActionListeners default method (ActionPerformed) will run. We can override that method.
public class GuiSetup extends JFrame implements ActionListener {

    DiceCollection diceCollection = new DiceCollection();
    JButton button;
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    ImageIcon monopoly = new ImageIcon("Monopoly.png");   //saves the imagefile in the variable monopoly

    int count = 0;

    public GuiSetup(){

        button = new JButton("Roll Dice");
        button.setBackground(Color.GREEN);
        button.setFont(new Font("MV Boli",Font.BOLD,25));
        button.setBounds(250, 235, 150, 50);
        label.setBounds(240,285,170,50);
        label.setFont(new Font("MV Boli",Font.BOLD,25));
        //adds the actionslistener to button. Everytime this button is clicked the Actionlisteners method runs.
        button.addActionListener(this);
        button.setFocusable(false);

        this.add(label);

        this.add(button);
        this.add(panel);        //adds panel to frame
        this.setPreferredSize(new Dimension(monopoly.getIconWidth(), monopoly.getIconHeight()+30));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //Exits the code when the frame is closed
        this.setTitle("Monopoly");      //sets title of the frame to monopoly
        this.pack();        //Makes the frame adjust its size to all the components, thats been implemented.
        this.setResizable(false);
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
        if(e.getSource() == button){
            diceCollection.roll();
            label.setText("You rolled " + diceCollection.getRollSum());
            System.out.println("You rolled " + diceCollection.getRollSum());
        }
    }
}
