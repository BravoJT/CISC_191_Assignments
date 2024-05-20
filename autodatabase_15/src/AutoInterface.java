import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;


public class AutoInterface extends JFrame implements ActionListener, ChangeListener {

    private JLabel[] labels = new JLabel[4];
    private JSlider[] sliders = new JSlider[2];
    private JTextField input;
    private JTable table;
    private Object[][] autoData;
    private static int rowCount = 0;
    private static Connection connection;
    AutoInterface(Connection connection) throws SQLException
    {
        setTitle("Automotive Database Viewer");
        input = new JTextField();
        GridBagConstraints constraints;

        Statement statement = connection.createStatement();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2500,500);

        labels[0] = new JLabel("Search: ");
        labels[1] = new JLabel("MPG: 0     ");
        labels[2] = new JLabel("HP: 0     ");

        int y = 0;

        setLayout(new GridBagLayout());

            constraints = new GridBagConstraints();
            constraints.insets = new Insets(20,10,20,10);
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridx = 0;
            constraints.gridy = y;
            add(labels[0],constraints);
        input = new JTextField(15);

            input.addActionListener(this);
            input.setSize(250,100);

            constraints = new GridBagConstraints();
            constraints.insets = new Insets(20,10,20,10);
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridx = 1;
            constraints.gridy = y;
            add(input,constraints);
            y+=10;

            sliders[0] = new JSlider(0,100,0);
            sliders[1] = new JSlider(0,300,0);
            sliders[0].addChangeListener(this);
            sliders[1].addChangeListener(this);
            setLayout(new GridBagLayout());

            constraints = new GridBagConstraints();
            constraints.insets = new Insets(20,10,20,10);
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridx = 0;
            constraints.gridy = y;
            add(labels[1],constraints);
            constraints.gridx = 20;
            add(sliders[0],constraints);
            constraints.gridx = 0;
            y+=10;
            constraints.gridy = y;
            add(labels[2],constraints);
            constraints.gridx = 20;
            add(sliders[1],constraints);
            y+=10;

            constraints.gridx = 0;

        String[] colNames = {"mpg","cylinders","displacement","horsepower","weight","acceleration","modelYear","origin","carName"};
        autoData = new Object[rowCount][9];
        ResultSet resultSet = statement.executeQuery("select * from autodata");

        DefaultTableModel model = new DefaultTableModel(null,colNames);
        model.setColumnCount(9);
        for(int i = 0;i<rowCount;i++)
        {
            resultSet.next();
            for(int j = 0;j<9;j++)
            {
                autoData[i][j] = resultSet.getObject(j+1);
            }
            model.addRow(autoData[i]);
        }
        table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setAutoResizeMode(0);
        table.setAutoCreateRowSorter(true);
        TableColumnModel colMdl = table.getColumnModel();
        colMdl.getColumn(8).setPreferredWidth(250);
        JScrollPane scrollPane = new JScrollPane(table);



        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,10,20,10);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 1;
        constraints.gridy = y;
        add(scrollPane,constraints);

        pack();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
            //AutoInterface resultBox = new AutoInterface(input.getText(),autoData, sliders);
        try{
            AutoInterface resultBox = new AutoInterface(connection,input.getText(), sliders);}//Kept saying "Unhandled Exception even when it was being handled by both initializers"
        catch(Exception e){}

    }
    @Override
    public void stateChanged(ChangeEvent event)
    {
        labels[1].setText("MPG: "+(double)sliders[0].getValue()/2);
        labels[2].setText("HP: "+sliders[1].getValue());
    }
    AutoInterface(String text,Object[][] autoData,JSlider[] sliders)//No longer in use
    {
        setTitle("Results");
        GridBagConstraints constraints;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(2500,500);

        labels[3] = new JLabel("Results for \""+text+"\"");
        int y = 0;
        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,10,20,10);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 0;
        constraints.gridy = y;
        add(labels[3],constraints);
        y+=10;



        String[] colNames = {"mpg","cylinders","displacement","horsepower","weight","acceleration","modelYear","origin","carName"};

        DefaultTableModel model = new DefaultTableModel(null,colNames);
        model.setColumnCount(9);
        if(text.toLowerCase().equals("all"))
        {
            for(int i = 0; i<rowCount;i++)
            {
                    model.addRow(autoData[i]);
            }
        }
        else {
            for (int i = 0; i < rowCount; i++) {
                if (((String)autoData[i][8]).toLowerCase().contains(text)) {
                    if(sliders[0].getValue()==0||(double)autoData[i][0]==(double)sliders[0].getValue()/2)
                    {
                        if(sliders[1].getValue()==0||(int)autoData[i][3]==sliders[1].getValue()) {
                            model.addRow(autoData[i]);
                        }
                    }
                }
            }
        }
        JTable results = new JTable(model){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
        results.setAutoResizeMode(0);
        results.setAutoCreateRowSorter(true);
        TableColumnModel colMdl = results.getColumnModel();
        colMdl.getColumn(8).setPreferredWidth(250);

        JScrollPane scrollPane = new JScrollPane(results);



        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,10,20,10);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 1;
        constraints.gridy = y;
        add(scrollPane,constraints);

        pack();
        setResizable(false);
        setVisible(true);
    }
    AutoInterface(Connection connection,String text,JSlider[] sliders) throws SQLException
    {
        setTitle("Results");
        GridBagConstraints constraints;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(2500,500);

        labels[3] = new JLabel("Results for \""+text+"\"");
        int y = 0;
        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,10,20,10);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 0;
        constraints.gridy = y;
        add(labels[3],constraints);
        y+=10;



        String[] colNames = {"mpg","cylinders","displacement","horsepower","weight","acceleration","modelYear","origin","carName"};
        autoData = new Object[rowCount][9];
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        String query = "select * from autodata";
        DefaultTableModel model = new DefaultTableModel(null,colNames);
        model.setColumnCount(9);
        if(text.toLowerCase().equals("all"))
        {
            resultSet = statement.executeQuery(query);
            for(int i = 0;i<rowCount;i++)
            {
                resultSet.next();
                for(int j = 0;j<9;j++)
                {
                    autoData[i][j] = resultSet.getObject(j+1);
                }
                model.addRow(autoData[i]);
            }
        }
        else {
            query = query + " where carName like '%"+text+"%'";
            if(sliders[0].getValue()!=0)
            {
                query = query+" and mpg = "+(double)sliders[0].getValue()/2;
            }
            if(sliders[1].getValue()!=0)
            {
                query = query+" and horsepower = "+sliders[1].getValue();
            }
            resultSet = statement.executeQuery(query);
            int r = 0;
            while(resultSet.next()) {
                for (int j = 0; j < 9; j++) {
                    autoData[r][j] = resultSet.getObject(j + 1);
                }
                model.addRow(autoData[r]);
            }
        }
        JTable results = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        results.setAutoResizeMode(0);
        results.setAutoCreateRowSorter(true);
        TableColumnModel colMdl = results.getColumnModel();
        colMdl.getColumn(8).setPreferredWidth(250);

        JScrollPane scrollPane = new JScrollPane(results);



        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,10,20,10);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 1;
        constraints.gridy = y;
        add(scrollPane,constraints);

        pack();
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/auto",
                        "testuser","Pa$$word");
        System.out.println("Connection Established");
        Statement statement = connection.createStatement();
        statement.execute("delete from autodata;");
        System.out.println("Old data in autodata purged");
        Scanner seer;
        FileInputStream importLane = new FileInputStream("auto-mpg.txt");
        System.out.println("auto-mpg file loaded");
        seer = new Scanner(importLane);
        int ctr = 0;
        String query = "insert into autoData (mpg,cylinders,displacement,horsepower,weight,acceleration,modelYear,origin,carName) values (";
        String piece;
        double numPiece;
        while(seer.hasNext())
        {
            piece = seer.next();
            if(piece.equals("NA"))
                numPiece = 0;
            else
                numPiece = Double.parseDouble(piece);
            switch(ctr)
            {
                case 0,5 -> query = query + numPiece+",";
                case 1,2,3,4,6 -> query = query + (int)numPiece+",";
                case 7 -> query = query + (int)numPiece+",'";
            }

            ctr++;
            if(ctr%8==0)
            {
                piece = seer.next();
                while(piece.charAt(piece.length()-1)!='"'){
                    piece = piece + " " + seer.next();
                }
                if(piece.contains("'"))
                    piece = piece.substring(0,piece.indexOf("'"))+"'"+piece.substring(piece.indexOf("'"));
                query = query + piece + "');";
                rowCount++;
                ctr = 0;
                //System.out.println(query);
                try {
                    statement.execute(query);
                }
                catch(SQLIntegrityConstraintViolationException e){
                    System.out.println("An error has occurred, erred entry not uploaded");
                }
                query = "insert into autoData (mpg,cylinders,displacement,horsepower,weight,acceleration,modelYear,origin,carName) values (";
            }
        }
        System.out.println("Upload complete, initializing user window...");


        AutoInterface window = new AutoInterface(connection);
    }
}
