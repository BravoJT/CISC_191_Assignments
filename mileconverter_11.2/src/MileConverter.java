import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MileConverter extends JFrame implements ActionListener {
    private JTextField out;
    private JLabel[] labels;
    private JFormattedTextField input;
    MileConverter(){
        setTitle("Mile Converter! (press 'enter' in a text box to calculate)");
        out = new JTextField();
        labels = new JLabel[5];
        GridBagConstraints constraints;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,250);
        labels[0] = new JLabel("Select the number of miles: ");
        labels[1] = new JLabel("Results: ");

        int y = 0;

        setLayout(new GridBagLayout());
        for(byte i = 0;i<2;i++)
        {
            constraints = new GridBagConstraints();
            constraints.insets = new Insets(20,10,0,10);
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridx = 0;
            constraints.gridy = y;
            add(labels[i],constraints);
            y+=10;
        }
        input = new JFormattedTextField(0);
        input.setText("0");
        input.addActionListener(this);
        input.setSize(40,20);
        input.setPreferredSize(input.getSize());
        input.setMinimumSize(input.getPreferredSize());
        input.setMaximumSize(input.getPreferredSize());
        input.setColumns(10);
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,0,0,10);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(input,constraints);

        String type = "";
        byte x = 1;
        for(byte i = 2;i<5;i++)
        {
            switch(i){
                case 2:type = "Kilometer(s)";
                    break;
                case 3:type = "Meter(s)";
                    break;
                case 4:type = "Feet";
                    break;
            }
            labels[i] = new JLabel("<html>"+type+"<br>0</html>");
            constraints = new GridBagConstraints();
            constraints.insets = new Insets(0,0,20,20);
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridx = x;
            constraints.gridy = 20;
            add(labels[i],constraints);
            x++;
        }

        //pack();
        setResizable(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        Scanner overseer;
        double num;
        overseer = new Scanner(input.getText());
        if(overseer.hasNextDouble())
            num = overseer.nextDouble();
        else
            num=0;

        double result;
        String type = "";
        GridBagConstraints constraints;
        for(byte i = 2;i<5;i++)
        {
            result = num;
            switch(i){
                case 2:type = "Kilometer(s)";
                result*=1.609344;
                    break;
                case 3:type = "Meter(s)";
                result*=1.609344*1000;

                    break;
                case 4:type = "Feet";
                result*=5280;
                    break;
            }
            result = (double)((int)(result*100))/100;
            labels[i].setText("<html>"+type+"<br>"+result+"</html>");
        }
    }

    public static void main(String[] args)
    {
        MileConverter calc = new MileConverter();
    }
}