import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.util.Scanner;

public class MilesToKilos extends JFrame implements ChangeListener {
    private JTextField out;
    private JLabel[] labels;
    private JSpinner input;
    MilesToKilos(){
        setTitle("Convert Miles to Kilometers! (press 'enter' in a text box to calculate)");
        out = new JTextField();
        labels = new JLabel[3];
        input = new JSpinner();
        GridBagConstraints constraints;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,500);
        labels[0] = new JLabel("Select the number of Miles: ");
        labels[1] = new JLabel("Distance in Kilometers: ");

        int y = 0;

        setLayout(new GridBagLayout());
        for(byte i = 0;i<2;i++)
        {
            constraints = new GridBagConstraints();
            constraints.insets = new Insets(20,10,20,10);
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridx = 0;
            constraints.gridy = y;
            add(labels[i],constraints);
            y+=10;
        }
        y = 0;

        input.setSize(50,20);
        input.setPreferredSize(input.getSize());
        input.setMinimumSize(input.getSize());
        input.addChangeListener(this);

        labels[2] = new JLabel("0");
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,0,20,20);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 1;
        constraints.gridy = 10;
        add(labels[2],constraints);
        constraints.gridy = 0;
        add(input,constraints);


        pack();
        setResizable(true);
        setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent event) {
        Integer num = (Integer) input.getValue();
        labels[2].setText((double)((int)(num*1.609344*100))/100+"");

    }

    public static void main(String[] args)
    {
        MilesToKilos calc = new MilesToKilos();
    }
}