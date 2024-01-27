package com.Computer_Engineer_2020_CE_39;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Comparator;

public class GUI extends JFrame {
    public Formula1ChampionshipManager fcm1 = new Formula1ChampionshipManager(10, 10);
    GUI() {
        this.setTitle("F1 CHAMPIONSHIP 2022");
        JPanel p1=new JPanel();
        p1.setBounds(0,0,1366,80);
        JLabel l1= new JLabel("F1 CHAMPIONSHIP 2022");
        l1.setFont(new Font("Arial", Font.BOLD, 35));
        l1.setForeground(new Color(250, 2, 0));

        p1.add(l1,BorderLayout.CENTER );

        // create button
        JButton button1 = new JButton("ADD DRIVER");
        JButton button2 = new JButton("DELETE DRIVER");
        JButton button3 = new JButton("CHANGE DRIVER");
        JButton button4 = new JButton("STATS TABLE");
        JButton button5 = new JButton("STATS");
        JButton button6 = new JButton("ADD RACE");
        JButton button7 = new JButton("SAVE DATA");
        JButton button8 = new JButton("RECOVER DATA");
        JButton button9 = new JButton("SEARCH DRIVER");
        JButton button10 = new JButton("QUIT");

        button1.setBounds(200, 135, 200, 85);
        button2.setBounds(430, 135, 200, 85);
        button3.setBounds(660, 135, 200, 85);
        button4.setBounds(890, 135, 200, 85);
        button5.setBounds(200, 335, 200, 85);
        button6.setBounds(430, 335, 200, 85);
        button7.setBounds(660, 335, 200, 85);
        button8.setBounds(890, 335, 200, 85);
        button9.setBounds(200, 535, 200, 85);
        button10.setBounds(430, 535, 200, 85);

        button1.addActionListener(e -> new button1());
        button2.addActionListener(e -> new button2());
        button3.addActionListener(e -> new button3());
        button4.addActionListener(e -> new button4());
        button5.addActionListener(e -> new button5());
        button6.addActionListener(e-> new button6());
        button7.addActionListener(e-> new button7());
        button8.addActionListener(e-> new button8());
        button9.addActionListener(e-> new button9());
        button10.addActionListener(e->System.exit(0));





        // adding button on frame
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(button10);
        this.add(p1);

        ImageIcon image =new ImageIcon("logo.png");
        this.setIconImage(image.getImage());
        ImageIcon background=new ImageIcon("a.jpeg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1366,750,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,1366,750);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);


    }
    class button1  implements ActionListener {

        JFrame j1;
        JButton bu2;
        JTextField t2;
        JTextField t3;
        JTextField t4;

        button1(){
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,80);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Create a new driver");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );

            JLabel l2=new JLabel("Enter the new driver's name: ");
            l2.setBackground(Color.red);
            l2.setBounds(10,10,400,200);
            t2=new JTextField();
            t2.setBounds(10,130,250,40);

            JLabel l3=new JLabel("Enter team name:");
            l3.setBounds(10,100,400,200);
            t3=new JTextField();
            t3.setBounds(10,230,250,40);

            JLabel l4=new JLabel("Enter country: ");
            l4.setBounds(10,200,400,200);
            t4=new JTextField();
            t4.setBounds(10,330,250,40);

            bu2=new JButton("add");
            bu2.setBounds(300,430,250,40);
            bu2.addActionListener(this);
            bu2.setBackground(new Color(0xe8cdee));

            j1.add(bu2);
            j1.add(t2);
            j1.add(t3);
            j1.add(t4);
            j1.add(l4);
            j1.add(l3);
            j1.add(l2);
            j1.add(p1);
            j1.setTitle("create new driver");
            j1.setSize(600,600);
            j1.setLayout(null);
            j1.setResizable(false);
            j1.setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bu2){
                Formula1Driver newDriver = new Formula1Driver(t2.getText(), t4.getText(),t3.getText() ,
                        0, 0, 0, 0, 0);
                fcm1.driverList.add(newDriver);
                j1.dispose();



            }}



    }
    class button2  implements ActionListener {

        JFrame j1;
        JButton bu2;
        JTextField t2;


        button2(){
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,80);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Create a new driver");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );

            JLabel l2=new JLabel("Enter the name of the driver you want to delete:  ");
            l2.setBackground(Color.red);
            l2.setBounds(10,10,400,200);
            t2=new JTextField();
            t2.setBounds(10,130,250,40);

            bu2=new JButton("Delete");
            bu2.setBounds(300,430,250,40);
            bu2.addActionListener(this);
            bu2.setBackground(new Color(0xe8cdee));

            j1.add(bu2);
            j1.add(t2);

            j1.add(l2);
            j1.add(p1);
            j1.setTitle("Delete a driver");
            j1.setSize(600,600);
            j1.setLayout(null);
            j1.setResizable(false);
            j1.setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bu2){
                fcm1.driverList.removeIf(driver -> t2.getText().equals(driver.getDriverName()));

                j1.dispose();



            }}



    }
    class button3  implements ActionListener {

        JFrame j1;
        JButton bu2;
        JTextField t2;
        JTextField t3;

        button3(){
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,80);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Change driver");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );

            JLabel l2=new JLabel("Enter the team you wish to change the driver for:  ");
            l2.setBackground(Color.red);
            l2.setBounds(10,10,400,200);
            t2=new JTextField();
            t2.setBounds(10,130,250,40);

            JLabel l3=new JLabel("Enter the name of the new driver: ");
            l3.setBounds(10,100,400,200);
            t3=new JTextField();
            t3.setBounds(10,230,250,40);

            bu2=new JButton("Change");
            bu2.setBounds(300,430,250,40);
            bu2.addActionListener(this);
            bu2.setBackground(new Color(0xe8cdee));

            j1.add(bu2);
            j1.add(t2);
            j1.add(t3);

            j1.add(l3);
            j1.add(l2);
            j1.add(p1);
            j1.setTitle("Change driver");
            j1.setSize(600,600);
            j1.setLayout(null);
            j1.setResizable(false);
            j1.setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bu2){
                for (Formula1Driver driver : fcm1.driverList) {
                    if (t2.getText().equals(driver.getDriverTeam())) {
                        driver.setDriverName(t3.getText());
                    }
                    j1.dispose();



            }}



    }}
    class button4  implements ActionListener {

        JFrame j1;
        JButton bu2;
        JButton bu3;


        button4(){
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,500);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Stats Table");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );

            String[] header = {"DRIVER", "LOCATION",  "TEAM", "POINTS", "1ST POSITIONS", "RACES"};
            DefaultTableModel model = new DefaultTableModel(header, 0);

            fcm1.driverList.sort((Formula1Driver s1, Formula1Driver s2)->s2.getPositionNo1()-s1.getPositionNo1());
            fcm1.driverList.sort((Formula1Driver s1, Formula1Driver s2)->s2.getTotalPoints()-s1.getTotalPoints());
            for (Formula1Driver driver: fcm1.driverList)
            {
                model.addRow( new Object[]{ driver.getDriverName(), driver.getDriverLocation(),
                        driver.getDriverTeam(), driver.getTotalPoints(), driver.getPositionNo1(),
                        driver.getRaces()} );
            }

            JTable table = new JTable(model );


            bu2=new JButton("Sort Ascending to Points");
            bu2.setBounds(300,430,250,40);
            bu2.addActionListener(this);
            bu2.setBackground(new Color(0xe8cdee));
            bu3=new JButton("Sort Descending to Positions");
            bu3.setBounds(300,480,250,40);
            bu3.addActionListener(this);
            bu3.setBackground(new Color(0xe8cdee));


            p1.add(new JScrollPane(table) );

            j1.add(bu2);
            j1.add(bu3);
            j1.add(p1);
            j1.setTitle("create new driver");
            j1.setSize(600,600);
            j1.setResizable(false);
            j1.setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bu2){
                j1=new JFrame();
                j1.setForeground(new Color(0xcde4ee));
                Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

                JPanel p1=new JPanel();
                p1.setBounds(0,0,585,500);
                p1.setBorder(b1);
                JLabel l1= new JLabel("Stats Table");
                l1.setFont(new Font("Arial", Font.BOLD, 35));
                l1.setForeground(new Color(140, 52, 120));

                p1.add(l1,BorderLayout.CENTER );

                String[] header = {"DRIVER", "LOCATION",  "TEAM", "POINTS", "1ST POSITIONS", "RACES"};
                DefaultTableModel model = new DefaultTableModel(header, 0);

                fcm1.driverList.sort(Comparator.comparingInt(Formula1Driver::getTotalPoints));

                for (Formula1Driver driver: fcm1.driverList)
                {
                    model.addRow( new Object[]{ driver.getDriverName(), driver.getDriverLocation(),
                            driver.getDriverTeam(), driver.getTotalPoints(), driver.getPositionNo1(),
                            driver.getRaces()} );
                }

                JTable table = new JTable(model );
                p1.add(new JScrollPane(table) );

                j1.add(p1);
                j1.setTitle("create new driver");
                j1.setSize(600,600);
                j1.setResizable(false);
                j1.setVisible(true);
            }
            if (e.getSource()==bu3){
                j1=new JFrame();
                j1.setForeground(new Color(0xcde4ee));
                Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

                JPanel p1=new JPanel();
                p1.setBounds(0,0,585,500);
                p1.setBorder(b1);
                JLabel l1= new JLabel("Stats Table");
                l1.setFont(new Font("Arial", Font.BOLD, 35));
                l1.setForeground(new Color(140, 52, 120));

                p1.add(l1,BorderLayout.CENTER );

                String[] header = {"DRIVER", "LOCATION",  "TEAM", "POINTS", "1ST POSITIONS", "RACES"};
                DefaultTableModel model = new DefaultTableModel(header, 0);
                fcm1.driverList.sort((Formula1Driver s1, Formula1Driver s2)->s2.getTotalPoints()-s1.getTotalPoints());

                fcm1.driverList.sort((Formula1Driver s1, Formula1Driver s2)->s2.getPositionNo1()-s1.getPositionNo1());

                for (Formula1Driver driver: fcm1.driverList)
                {
                    model.addRow( new Object[]{ driver.getDriverName(), driver.getDriverLocation(),
                            driver.getDriverTeam(), driver.getTotalPoints(), driver.getPositionNo1(),
                            driver.getRaces()} );
                }

                JTable table = new JTable(model );
                p1.add(new JScrollPane(table) );

                j1.add(p1);
                j1.setTitle("create new driver");
                j1.setSize(600,600);
                j1.setResizable(false);
                j1.setVisible(true);
            }


        }
    }
    class button5  implements ActionListener {

        JFrame j1;
        JButton bu2;
        JTextField t2;

        button5(){
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,500);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Stats Table");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );

            JLabel l2=new JLabel("Enter the name of the driver you wish to see the statistics for:");
            l2.setBackground(Color.red);
            l2.setBounds(10,10,400,200);
            t2=new JTextField();
            t2.setBounds(10,130,250,40);


            bu2=new JButton("Show Stats");
            bu2.setBounds(300,430,250,40);
            bu2.addActionListener(this);
            bu2.setBackground(new Color(0xe8cdee));
            j1.add(l2);
            j1.add(t2);
            j1.add(bu2);
            j1.add(p1);
            j1.setTitle("Show Stats of a Specific Driver");
            j1.setSize(600,600);
            j1.setResizable(false);
            j1.setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bu2){
                for (Formula1Driver driver : fcm1.driverList) {
                    if (t2.getText().equals(driver.getDriverName())) {
                        j1=new JFrame();
                        j1.setForeground(new Color(0xcde4ee));
                        Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

                        JPanel p1=new JPanel();
                        p1.setBounds(0,0,585,500);
                        p1.setBorder(b1);
                        JLabel l1= new JLabel("Stats of "+ driver.getDriverName());
                        l1.setFont(new Font("Arial", Font.BOLD, 35));
                        l1.setForeground(new Color(140, 52, 120));

                        p1.add(l1,BorderLayout.CENTER );

                        String[] header = {"Sr.", "Val"};
                        DefaultTableModel model = new DefaultTableModel(header, 0);
                        model.addRow( new Object[]{"Races participated this season ", driver.getRaces()} );
                        model.addRow( new Object[]{ "Number of first positions ", driver.getPositionNo1()} );
                        model.addRow( new Object[]{ "Number of second positions ",driver.getPositionNo2()} );
                        model.addRow( new Object[]{ "Number of third positions ",driver.getPositionNo3()} );
                        model.addRow( new Object[]{ "Total number of points",driver.getTotalPoints()} );
                        JTable table = new JTable(model );
                        p1.add(new JScrollPane(table) );

                        j1.add(p1);
                        j1.setTitle("Show Stats of a Specific Driver");
                        j1.setSize(600,600);
                        j1.setResizable(false);
                        j1.setVisible(true);
                    }
                    }
                }
            }



    }
    class button6  implements ActionListener {

        JFrame j1;
        JButton bu2;
        JButton bu3;
        JTextField t2;
        JTextField t3;
        JTextField t4;

        button6(){
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,80);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Add a new race");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );
            t2=new JTextField();
            t2.setBounds(10,80,250,40);

            bu2=new JButton("Add race with user specifed date");
            bu2.setBounds(100,130,250,40);
            bu2.addActionListener(this);
            bu2.setBackground(new Color(0xe8cdee));

            bu3=new JButton("Add race with random generated date");
            bu3.setBounds(100,330,250,40);
            bu3.addActionListener(this);
            bu3.setBackground(new Color(0xe8cdee));
            j1.add(t2);
            j1.add(bu2);
            j1.add(bu3);
            j1.add(p1);
            j1.setTitle("create new race");
            j1.setSize(600,600);
            j1.setLayout(null);
            j1.setResizable(false);
            j1.setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bu2){

                fcm1.addRaceGui(t2.getText());
                for (Formula1Driver driver:fcm1.driverList ) {
                    j1 = new JFrame();
                    j1.setForeground(new Color(0xcde4ee));
                    Border b1 = BorderFactory.createLineBorder(new Color(0xEFF285), 3);

                    JPanel p1 = new JPanel();
                    p1.setBounds(0, 0, 585, 80);
                    p1.setBorder(b1);

                    JLabel l1 = new JLabel("A new race on " + driver.raceDateList.get(driver.raceDateList.size()-1) + " has been added!!!");
                    l1.setFont(new Font("Arial", Font.BOLD, 15));
                    l1.setForeground(new Color(140, 52, 120));
                    p1.add(l1, BorderLayout.CENTER);



                    j1.add(p1);
                    j1.setTitle("Random Race Added Successfully");
                    j1.setSize(600, 100);
                    j1.setLayout(null);
                    j1.setResizable(false);
                    j1.setLocationRelativeTo(null);
                    j1.setVisible(true);

                    break;
                }



            }
            if (e.getSource()==bu3){
                try {
                    fcm1.addRandRace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }


                for (Formula1Driver driver:fcm1.driverList ) {
                    j1 = new JFrame();
                    j1.setForeground(new Color(0xcde4ee));
                    Border b1 = BorderFactory.createLineBorder(new Color(0xEFF285), 3);

                    JPanel p1 = new JPanel();
                    p1.setBounds(0, 0, 585, 80);
                    p1.setBorder(b1);

                    JLabel l1 = new JLabel("A new race on " + driver.raceDateList.get(driver.raceDateList.size()-1) + " has been added!!!");
                    l1.setFont(new Font("Arial", Font.BOLD, 15));
                    l1.setForeground(new Color(140, 52, 120));
                    p1.add(l1, BorderLayout.CENTER);



                    j1.add(p1);
                    j1.setTitle("Random Race Added Successfully");
                    j1.setSize(600, 100);
                    j1.setLayout(null);
                    j1.setResizable(false);
                    j1.setLocationRelativeTo(null);
                    j1.setVisible(true);

                    break;
                }



            }
        }



    }
    class button7   {

        JFrame j1;


        button7(){
            fcm1.saveInfo();
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,80);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Data is being Saved");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );



            j1.add(p1);
            j1.setTitle("Success");
            j1.setSize(600,110);
            j1.setLayout(null);
            j1.setLocationRelativeTo(null);
            j1.setResizable(false);
            j1.setVisible(true);
        }




    }
    class button8   {

        JFrame j1;


        button8(){
            fcm1.recoverInfo();
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,80);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Data is being Recovered");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );



            j1.add(p1);
            j1.setTitle("Success");
            j1.setSize(600,110);
            j1.setLayout(null);
            j1.setLocationRelativeTo(null);

            j1.setResizable(false);
            j1.setVisible(true);
        }




    }
    class button9  implements ActionListener {

        JFrame j1;
        JButton bu2;
        JTextField t2;

        button9(){
            j1=new JFrame();
            j1.setForeground(new Color(0xcde4ee));
            Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,585,500);
            p1.setBorder(b1);
            JLabel l1= new JLabel("Search a driver");
            l1.setFont(new Font("Arial", Font.BOLD, 35));
            l1.setForeground(new Color(140, 52, 120));

            p1.add(l1,BorderLayout.CENTER );

            JLabel l2=new JLabel("Enter the name of the driver you wish to search for:");
            l2.setBackground(Color.red);
            l2.setBounds(10,10,400,200);
            t2=new JTextField();
            t2.setBounds(10,130,250,40);


            bu2=new JButton("Show Results");
            bu2.setBounds(300,430,250,40);
            bu2.addActionListener(this);
            bu2.setBackground(new Color(0xe8cdee));
            j1.add(l2);
            j1.add(t2);
            j1.add(bu2);
            j1.add(p1);
            j1.setTitle("Show Stats of a Specific Driver");
            j1.setSize(600,600);
            j1.setResizable(false);
            j1.setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bu2){
                try {
                    fcm1.searchGui(t2.getText());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                for (Formula1Driver driver : fcm1.driverList) {
                    if (t2.getText().equals(driver.getDriverName())) {
                        j1=new JFrame();
                        j1.setForeground(new Color(0xcde4ee));
                        Border b1=BorderFactory.createLineBorder(new Color(0xEFF285),3);

                        JPanel p1=new JPanel();
                        p1.setBounds(0,0,585,500);
                        p1.setBorder(b1);
                        JLabel l1= new JLabel("Race details of "+ driver.getDriverName());
                        l1.setFont(new Font("Arial", Font.BOLD, 35));
                        l1.setForeground(new Color(140, 52, 120));

                        p1.add(l1,BorderLayout.CENTER );

                        String[] header = {"Race Date", "Position"};
                        DefaultTableModel model = new DefaultTableModel(header, 0);
                        for(int i =0;i<driver.sortPositionList.size();i++) {
                            model.addRow(new Object[]{driver.sortRaceDateList.get(i), driver.sortPositionList.get(i)});
                        }
                        JTable table = new JTable(model );
                        p1.add(new JScrollPane(table) );

                        j1.add(p1);
                        j1.setTitle("Show Races of a Specific Driver");
                        j1.setSize(600,600);
                        j1.setResizable(false);
                        j1.setVisible(true);
                    }
                }
            }
        }



    }

    public static void main(String[]args){
        new GUI();
    }
}

