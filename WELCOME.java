/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author gagne
 */
class mymodel extends javax.swing.table.AbstractTableModel{
    ResultSet rs;
    ResultSetMetaData rsmd;
    mymodel(ResultSet rs1)
    {
        try
        {
            rs=rs1;
            rsmd=rs.getMetaData();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    @Override
    public int getRowCount()
    {
        try
        {
            rs.last();
            int rows = rs.getRow();
           rs.beforeFirst();
            return rows;
        }
        catch(Exception e)
        {
            System.out.print(e);
            return -1;
        }
    }
    @Override
    public int getColumnCount()
    {
        try
        {
            return (rsmd.getColumnCount());
        }
        catch(Exception e)
        {
            System.out.print(e);
            return -1;
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        try
        {
            rs.absolute(rowIndex+1);
            return rs.getObject(columnIndex+1);
        }
        catch(Exception e)
        {
            System.out.print(e);
            return -1;
        }
    }
    @Override
    public  String getColumnName(int n)
    {
        try
        {
            return rsmd.getColumnName(n+1);
        }
        catch(Exception e)
        {
            System.out.print(e);
            return null;
        }
    }
    }
public class WELCOME extends javax.swing.JFrame {

    /**
     * Creates new form WELCOME
     */
    public WELCOME() {
        initComponents();
        setTitle("KBC GAME");
        this.setBounds(1, 1, 1880, 870);
    }
    public WELCOME(String name) {
        initComponents();
        setTitle("KBC GAME");
        c1.add("SELECT");
        c1.add("ADD NEW");
        c2.add("SELECT");
        c2.add("ADD NEW");
        t6.setVisible(false);
        t7.setVisible(false);
        t1.setEditable(false);
        t3.setEditable(false);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/kbc_game","root","");
            Statement st1=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet RS=st1.executeQuery("Select * from register where Email='"+name+"'");
            if(RS.next())
            {
                t1.setText(RS.getString("Email"));
                t2.setText(RS.getString("Password"));
                t3.setText(RS.getString("Name"));
                t4.setText(RS.getString("Mobile_no"));
                t5.setText(RS.getString("Age"));
                t6.setText(RS.getString("City"));
                t7.setText(RS.getString("State"));
                t8.setText(RS.getString("Aadhar_no"));
                byte[] imageData = RS.getBytes("Photo");
                if(imageData != null)
                {
                    ImageIcon icon = new ImageIcon(imageData);
                    Image img = icon.getImage().getScaledInstance(
                            jLabel11.getWidth(),
                            jLabel11.getHeight(),
                            Image.SCALE_SMOOTH);
    jLabel11.setIcon(new ImageIcon(img));
}
                Statement stCity = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet cityRS = stCity.executeQuery("SELECT DISTINCT City FROM register");
                while(cityRS.next())
                {
                    String cityName = cityRS.getString("City");
                    if(cityName != null && !cityName.trim().equals(""))
                    {
                        c1.add(cityName);
                    }
                }
                Statement stState = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet stateRS = stState.executeQuery("SELECT DISTINCT State FROM register");
                while(stateRS.next())
                {
                    String stateName = stateRS.getString("State");
                    if(stateName != null && !stateName.trim().equals(""))
                    {
                        c2.add(stateName);
                    }
                }
                String city = RS.getString("City");
                String state = RS.getString("State");
                c1.select(city);
                c2.select(state);
                Statement stHistory = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs2 = stHistory.executeQuery("SELECT Email,Name,Score,Prize_Money FROM player_history WHERE Email='"+ name + "'");
                mymodel m1 = new mymodel(rs2);
                jt1.setModel(m1);
            }
        }
        catch(Exception e2)
        {
            System.out.print(e2);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        t8 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        b3 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        c2 = new java.awt.Choice();
        c1 = new java.awt.Choice();
        t6 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(null);

        l1.setBackground(new java.awt.Color(153, 255, 153));
        l1.setFont(new java.awt.Font("Lucida Fax", 1, 40)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 0));
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/welcome1.png"))); // NOI18N
        jPanel1.add(l1);
        l1.setBounds(640, 20, 710, 160);

        l9.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l9.setForeground(new java.awt.Color(255, 255, 255));
        l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l9.setText("AADHAR NO.");
        jPanel1.add(l9);
        l9.setBounds(80, 640, 210, 60);

        l2.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("EMAIL");
        jPanel1.add(l2);
        l2.setBounds(80, 120, 120, 60);

        l3.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l3.setForeground(new java.awt.Color(255, 255, 255));
        l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l3.setText("PASSWORD");
        jPanel1.add(l3);
        l3.setBounds(90, 190, 180, 60);

        l4.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l4.setForeground(new java.awt.Color(255, 255, 255));
        l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l4.setText("NAME");
        jPanel1.add(l4);
        l4.setBounds(80, 260, 120, 60);

        l5.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l5.setForeground(new java.awt.Color(255, 255, 255));
        l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l5.setText("MOBILE NO.");
        jPanel1.add(l5);
        l5.setBounds(80, 330, 210, 60);

        l6.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l6.setForeground(new java.awt.Color(255, 255, 255));
        l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l6.setText("AGE");
        jPanel1.add(l6);
        l6.setBounds(80, 400, 90, 60);

        l7.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l7.setForeground(new java.awt.Color(255, 255, 255));
        l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l7.setText("CITY");
        jPanel1.add(l7);
        l7.setBounds(80, 470, 100, 60);

        l8.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        l8.setForeground(new java.awt.Color(255, 255, 255));
        l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l8.setText("STATE");
        jPanel1.add(l8);
        l8.setBounds(80, 540, 120, 60);

        t8.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t8ActionPerformed(evt);
            }
        });
        t8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t8KeyTyped(evt);
            }
        });
        jPanel1.add(t8);
        t8.setBounds(290, 650, 400, 50);

        t1.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t1KeyTyped(evt);
            }
        });
        jPanel1.add(t1);
        t1.setBounds(290, 130, 400, 50);

        t2.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t2KeyTyped(evt);
            }
        });
        jPanel1.add(t2);
        t2.setBounds(290, 200, 400, 50);

        t3.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t3KeyTyped(evt);
            }
        });
        jPanel1.add(t3);
        t3.setBounds(290, 270, 400, 50);

        t4.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        t4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t4KeyTyped(evt);
            }
        });
        jPanel1.add(t4);
        t4.setBounds(290, 340, 400, 50);

        t5.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        t5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t5KeyTyped(evt);
            }
        });
        jPanel1.add(t5);
        t5.setBounds(290, 410, 400, 50);

        b3.setBackground(new java.awt.Color(51, 255, 51));
        b3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 40)); // NOI18N
        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/play3.png"))); // NOI18N
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel1.add(b3);
        b3.setBounds(1250, 730, 270, 70);

        b1.setBackground(new java.awt.Color(153, 153, 255));
        b1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 40)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/save3.png"))); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel1.add(b1);
        b1.setBounds(660, 730, 270, 70);

        b2.setBackground(new java.awt.Color(255, 102, 102));
        b2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 40)); // NOI18N
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/close4.png"))); // NOI18N
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel1.add(b2);
        b2.setBounds(950, 730, 270, 70);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/girl1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1460, 160, 480, 520);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/mail.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 130, 50, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/password.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 190, 50, 60);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/name.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 260, 50, 50);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/mobile.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 320, 50, 80);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/age.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 400, 90, 60);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/city.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 470, 70, 60);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/state.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 530, 70, 80);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/aadharno.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 640, 70, 70);

        jPanel2.setBackground(new java.awt.Color(10, 25, 70));
        jPanel2.setLayout(null);

        jt1.setBackground(new java.awt.Color(10, 25, 70));
        jt1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jt1.setForeground(new java.awt.Color(255, 255, 255));
        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PLAYER ID", "NAME", "SCORE", "PRIZE MONEY"
            }
        ));
        jt1.setToolTipText("");
        jt1.setRowHeight(35);
        jScrollPane1.setViewportView(jt1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 670, 420);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/ph.png"))); // NOI18N
        jPanel2.add(jLabel12);
        jLabel12.setBounds(240, 30, 360, 90);
        jPanel2.add(jLabel11);
        jLabel11.setBounds(100, 10, 100, 90);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(760, 140, 710, 550);

        c2.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        c2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c2ItemStateChanged(evt);
            }
        });
        jPanel1.add(c2);
        c2.setBounds(290, 560, 400, 40);

        c1.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        c1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c1ItemStateChanged(evt);
            }
        });
        jPanel1.add(c1);
        c1.setBounds(290, 480, 400, 40);

        t6.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        t6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t6ActionPerformed(evt);
            }
        });
        jPanel1.add(t6);
        t6.setBounds(290, 520, 400, 30);

        t7.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        jPanel1.add(t7);
        t7.setBounds(290, 600, 400, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/bgwel.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, 0, 1880, 840);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1940, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
       t1.setText("");
       t2.setText("");
       LOGIN I= new LOGIN();
       I.setVisible(true);
       I.setSize(1880,870);
       this.dispose();
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
                String city;
                String state;
                if(c1.getSelectedItem().equals("ADD NEW"))
        {
            city = t6.getText().trim();
        }
        else
        {
            city = c1.getSelectedItem();
        }
        if(c2.getSelectedItem().equals("ADD NEW"))
        {
            state = t7.getText().trim();
        }
        else
        {
            state = c2.getSelectedItem();
        }
        if(t1.getText().trim().length()==0 || t2.getText().trim().length()==0 || t3.getText().trim().length()==0 || t4.getText().trim().length()==0 || t5.getText().trim().length()==0 || city.length()==0 || state.length()==0 || t8.getText().trim().length()==0)
    {
        JOptionPane.showMessageDialog(this,"Please Enter Your Details !");
    }
    else
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection C=DriverManager.getConnection("jdbc:mysql://localhost:3306/kbc_game","root","");
            Statement St = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            int i=St.executeUpdate("UPDATE register SET " + "Password='"+t2.getText()+"', "+"Name='"+t3.getText()+"', "+"Mobile_no='"+t4.getText()+"', "+"Age='"+t5.getText()+"', "+"City='"+city+"', "+"State='"+state+"', "+"Aadhar_no='"+t8.getText()+"' "+"WHERE Email='"+t1.getText()+"'");
            if(i==1)
            {
            JOptionPane.showMessageDialog(this, "Updated Successfully !");
        }
        }
        catch(Exception e1)
        {
            System.out.print(e1);
        }
    }
    }//GEN-LAST:event_b1ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection C=DriverManager.getConnection("jdbc:mysql://localhost:3306/kbc_game","root","");
            Statement St = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet RS=St.executeQuery("Select * from register where Email='"+t1.getText()+"'");
            if(RS.next())
            {
                if(RS.getString("Password").trim().length()==0 || RS.getString("Name").trim().length()==0 || RS.getString("Mobile_no").trim().length()==0 || RS.getString("Age").trim().length()==0 || RS.getString("City").trim().length()==0 || RS.getString("State").trim().length()==0 || RS.getString("Aadhar_no").trim().length()==0)
            {
                JOptionPane.showMessageDialog(this,"PLEASE SAVE YOUR DETAILS FIRST !");
            }
            else
            {
        String pname = t3.getText();
        String email = t1.getText();
        play p1=new play(pname,email);
        p1.setSize(1880,870);
        p1.setVisible(true);
            }
            }
        }
        catch(Exception e3)
        {
            System.out.print(e3);
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t1KeyTyped

    private void t3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t3KeyTyped

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
        // TODO add your handling code here:
        t2.setEditable(true);
        char c = evt.getKeyChar();
        if(!Character.isDigit(c))
    {
        evt.consume();
    }
        if(t2.getText().length() >= 4)
    {
        evt.consume();
    }
    }//GEN-LAST:event_t2KeyTyped

    private void t4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyTyped
        // TODO add your handling code here:
        t4.setEditable(true);
        char m = evt.getKeyChar();
        if(!Character.isDigit(m))
    {
        evt.consume();
    }
        if(t4.getText().length() >= 10)
    {
        evt.consume();
    }
    }//GEN-LAST:event_t4KeyTyped

    private void t5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t5KeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
    {
        evt.consume();
    }
        if(t5.getText().length() >= 2)
    {
        evt.consume();
    }
    }//GEN-LAST:event_t5KeyTyped

    private void t8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t8KeyTyped
        // TODO add your handling code here:
        char b = evt.getKeyChar();
        if(!Character.isDigit(b))
    {
        evt.consume();
    }
        if(t8.getText().length() >= 12)
    {
        evt.consume();
    }
    }//GEN-LAST:event_t8KeyTyped

    private void t6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t6ActionPerformed

    private void t8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t8ActionPerformed

    private void c1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c1ItemStateChanged
        // TODO add your handling code here:
        String s1=c1.getSelectedItem();
        if(s1.equals("ADD NEW"))
        {
            t6.setVisible(true);
        }
        else
        {
            t6.setVisible(false);
        }
        repaint();
    }//GEN-LAST:event_c1ItemStateChanged

    private void c2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c2ItemStateChanged
        // TODO add your handling code here:
        String s2=c2.getSelectedItem();
        if(s2.equals("ADD NEW"))
        {
            t7.setVisible(true);
        }
        else
        {
            t7.setVisible(false);
        }
        repaint();
    }//GEN-LAST:event_c2ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WELCOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WELCOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WELCOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WELCOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WELCOME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private java.awt.Choice c1;
    private java.awt.Choice c2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t8;
    // End of variables declaration//GEN-END:variables
}
