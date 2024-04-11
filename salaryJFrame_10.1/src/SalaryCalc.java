import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class SalaryCalc extends JFrame implements ActionListener {
    private JTextField out;
    private JLabel[] labels;
    private JTextField[] inputs;
    SalaryCalc(){
        setTitle("Salary Calculator! (press 'enter' in a text box to calculate)");
        out = new JTextField();
        labels = new JLabel[4];
        inputs = new JTextField[2];
        GridBagConstraints constraints;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,500);
        labels[0] = new JLabel("Select your hourly rate in dollars: ");
        labels[1] = new JLabel("Select the number of hours worked per week: ");
        labels[2] = new JLabel("Yearly salary output (~52.18 weeks): ");

        int y = 0;

        setLayout(new GridBagLayout());
        for(byte i = 0;i<3;i++)
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
        inputs[0] = new JTextField(15);
        inputs[1] = new JTextField(15);
        for(byte i = 0; i< inputs.length; i++)
        {

            inputs[i].addActionListener(this);
            inputs[i].setSize(250,100);

            constraints = new GridBagConstraints();
            constraints.insets = new Insets(20,10,20,10);
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridx = 1;
            constraints.gridy = y;
            add(inputs[i],constraints);
            y+=10;
        }
        labels[3] = new JLabel("0");
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,0,20,20);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 1;
        constraints.gridy = 20;
        add(labels[3],constraints);


        pack();
        setResizable(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        Scanner overseer;
        double[] dubs = new double[2];
        for(byte i = 0;i<inputs.length;i++)
        {
            overseer = new Scanner(inputs[i].getText());
            if(overseer.hasNextDouble())
                dubs[i] = overseer.nextDouble();
            else
                dubs[i]=0;
        }
        labels[3].setText(((double)((int)(dubs[0]*dubs[1]*52.17857*100))/100)+"");
        //forgot how to use formatter so just set this abomination up
    }

    public static void main(String[] args)
    {
        SalaryCalc calc = new SalaryCalc();
    }
}