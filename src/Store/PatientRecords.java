/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author AnonymousHacker
 */
public class PatientRecords extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public static String hold;
    /**
     * Creates new form PatientRecords
     */
    
    //    pre-populates Sub-counties
    public void prefillSubCounty(){   
        try {
            String county=(String)txt_county.getItemAt(0);
//            String[] kksubs = new String[]{"Wamumu","Thiba","Nyangati","Mahigaini","Mutithi","Nguka","Kutus","Karira"};
            txt_sub.addItem("Wamumu");
            txt_sub.addItem("Thiba");
            txt_sub.addItem("Nyangati");
            txt_sub.addItem("Mahigaini");
            txt_sub.addItem("Mutithi");
            txt_sub.addItem("Nguka");
            txt_sub.addItem("Kutus");
            txt_sub.addItem("Karira");
        } catch (Exception e1) {
        }
    }
    
    public PatientRecords() {
        initComponents();
        conn=DBConnection.ConnecrDB();
        String dn = Empnumber.getEno2();
        test.setText(dn);
        TableUpdate();
        CurrentDateAndTime();
        prefillSubCounty();
        
        date.setMaxSelectableDate(new java.util.Date());
        
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Store/icons/H-2-icon.png"));
        setIconImage(img);
        
        //        Handle County and sub-county Selection
           txt_county.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
        try {
            String county = txt_county.getSelectedItem().toString().trim();
            if (county.equalsIgnoreCase("Kakamega")) {
               txt_sub.removeAllItems();
               txt_sub.addItem("Lurambi");
               txt_sub.addItem("Lugari");
               txt_sub.addItem("Likunyani");
               txt_sub.addItem("Navakholo");
               txt_sub.addItem("Butere");
               txt_sub.addItem("Mumias East");
               txt_sub.addItem("Mumias West");
               txt_sub.addItem("Matungu");
               txt_sub.addItem("Khwisero");
               txt_sub.addItem("Ikolomani");
               txt_sub.addItem("Malava");
               txt_sub.addItem("Shinyalu");
            }else{
                txt_sub.removeAllItems();
                txt_sub.addItem("Wamumu");
                txt_sub.addItem("Thiba");
                txt_sub.addItem("Nyangati");
                txt_sub.addItem("Mahigaini");
                txt_sub.addItem("Mutithi");
                txt_sub.addItem("Nguka");
                txt_sub.addItem("Kutus");
                txt_sub.addItem("Karira");
            }
        } catch (Exception e1) {
        }
            }
        });
    }
    
    public void CurrentDateAndTime(){
        Thread clock= new Thread(){
            public void run(){
                for(;;){
        Calendar cal=new GregorianCalendar();
        int yr=cal.get(Calendar.YEAR);
        int mnth=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        prdate.setText("Date "+yr+"/"+(mnth + 1)+"/"+day);
        
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hr=cal.get(Calendar.HOUR);
        prtime.setText("Time "+hr+":"+min+":"+sec); 
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.start();
    }
    
    public void TableUpdate(){
        try{
            String no = test.getText();
            String sql="select * from patients where Assigned_To='"+no+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            ptable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
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

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ptable = new javax.swing.JTable();
        dpno = new javax.swing.JTextField();
        srch = new javax.swing.JTextField();
        cmd_srch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nop = new javax.swing.JTextField();
        namef = new javax.swing.JTextField();
        namel = new javax.swing.JTextField();
        gcombo = new javax.swing.JComboBox();
        pno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Cmdupdate = new javax.swing.JButton();
        cmdclr = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        test = new javax.swing.JLabel();
        txt_county = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txt_sub = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        prdate = new javax.swing.JMenu();
        prtime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PATIENT RECORDS");

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/lightbox-prev.png"))); // NOI18N
        jButton1.setToolTipText("Back");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Printer-icon2.png"))); // NOI18N
        jButton3.setToolTipText("Print");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/File-Delete-icon.png"))); // NOI18N
        jButton2.setToolTipText("Delete");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        jButton4.setToolTipText("Log Out");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        ptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ptableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ptable);

        dpno.setText("Enter patient number to delete");
        dpno.setToolTipText("Enter patient number to delete");
        dpno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dpnoMouseClicked(evt);
            }
        });

        srch.setText("Enter Patient Number To Search");
        srch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srchMouseClicked(evt);
            }
        });

        cmd_srch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/search-icon.png"))); // NOI18N
        cmd_srch.setText("Search");
        cmd_srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_srchActionPerformed(evt);
            }
        });

        jLabel1.setText("Patient Number");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("DOB");

        jLabel5.setText("Gender");

        jLabel6.setText("Phone Number");

        namef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namefActionPerformed(evt);
            }
        });
        namef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namefKeyTyped(evt);
            }
        });

        namel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namelKeyTyped(evt);
            }
        });

        gcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        gcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcomboActionPerformed(evt);
            }
        });

        pno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pnoKeyTyped(evt);
            }
        });

        jLabel7.setText("County");

        Cmdupdate.setText("Update");
        Cmdupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdupdateActionPerformed(evt);
            }
        });

        cmdclr.setText("Clear");
        cmdclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdclrActionPerformed(evt);
            }
        });

        jLabel8.setText("Edit/Update");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/File-Delete-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        date.setDateFormatString(" yyyy/MM/d");
        date.setMaxSelectableDate(new java.util.Date(1484085680000L));

        txt_county.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kirinyaga", "Kakamega" }));

        jLabel9.setText("Sub County");

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/File-Delete-icon.png"))); // NOI18N
        jMenuItem1.setText("Delete");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Printer-icon2.png"))); // NOI18N
        jMenuItem2.setText("Print Report");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        jMenuItem3.setText("Log Out");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        prdate.setText("Date");
        jMenuBar1.add(prdate);

        prtime.setText("Time");
        jMenuBar1.add(prtime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cmdupdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdclr))
                            .addComponent(namel)
                            .addComponent(pno)
                            .addComponent(gcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namef)
                            .addComponent(nop)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txt_county, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmd_srch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 528, Short.MAX_VALUE)
                .addComponent(dpno, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(276, 276, 276))
            .addGroup(layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dpno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmd_srch))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_county, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cmdupdate)
                            .addComponent(cmdclr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
        );

        setSize(new java.awt.Dimension(1440, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MessageFormat header= new MessageFormat("Medical Report");
        MessageFormat footer= new MessageFormat("page{0,number,integer}");
        try{
            ptable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException pe){
            System.err.format("Cannot Print",pe.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from patients where Patient_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, dpno.getText());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Deleted");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
       }
       TableUpdate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from patients where Patient_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, dpno.getText());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Deleted");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Couldn't Delete");
       }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
       }
       TableUpdate();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void dpnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dpnoMouseClicked
        dpno.setText("");
    }//GEN-LAST:event_dpnoMouseClicked

    private void namefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namefActionPerformed

    private void cmd_srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_srchActionPerformed
        try{
            
            String src="select * from patients where Patient_No=?";
            pst=conn.prepareStatement(src);
            pst.setString(1, srch.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                String pnos=rs.getString("Patient_No");
                nop.setText(pnos);
                String fn=rs.getString("Fname");
                namef.setText(fn);
                String ln=rs.getString("Lname");
                namel.setText(ln);
                String dob=rs.getString("DOB");
                ((JTextField)date.getDateEditor().getUiComponent()).setText(dob);
                String gd=rs.getString("Gender");
                gcombo.setSelectedItem(gd);
                String phone=rs.getString("Phone_Number");
                pno.setText(phone);
                String county=rs.getString("County");
                txt_county.setSelectedItem(county);
                String subcounty=rs.getString("Sub_County");
                txt_sub.setSelectedItem(subcounty);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        TableUpdate();
    }//GEN-LAST:event_cmd_srchActionPerformed

    private void srchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srchMouseClicked
        srch.setText("");
    }//GEN-LAST:event_srchMouseClicked

    private void CmdupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdupdateActionPerformed
       try{
           String pn= nop.getText().trim();
            String fname=namef.getText().trim();
            String lname= namel.getText().trim();
            String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String gender= gcombo.getSelectedItem().toString().trim();
            String phone= pno.getText().trim();
            String area=txt_county.getSelectedItem().toString().trim(); 
            String sub=txt_sub.getSelectedItem().toString().trim();
           //int row=ptable.getSelectedRow();
            //String T_click=(ptable.getModel().getValueAt(row, 0).toString());
            String sql="update patients set Patient_No='"+pn+"' ,Fname='"+fname+"' ,Lname='"+lname+"' ,DOB='"+dob+"' "
                    + ",Gender='"+gender+"' ,Phone_Number='"+phone+"' ,County='"+area+"' ,Sub_County='"+area+"' where Patient_No='"+pn+"'";
            pst=conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Successfully Updated");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       TableUpdate();
    }//GEN-LAST:event_CmdupdateActionPerformed

    private void cmdclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdclrActionPerformed
        nop.setText("");
        namef.setText("");
        namel.setText("");
        pno.setText("");
    }//GEN-LAST:event_cmdclrActionPerformed

    private void ptableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptableMouseClicked
        try{
            int row=ptable.getSelectedRow();
            String T_click=(ptable.getModel().getValueAt(row, 0).toString());
            String sql="select * from patients where Patient_No='"+T_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String pnos=rs.getString("Patient_No");
                nop.setText(pnos);
                hold = nop.getText();
                String fn=rs.getString("Fname");
                namef.setText(fn);
                String ln=rs.getString("Lname");
                namel.setText(ln);
                String dob=rs.getString("DOB");
                ((JTextField)date.getDateEditor().getUiComponent()).setText(dob);
                String gd=rs.getString("Gender");
                gcombo.setSelectedItem(gd);
                String phone=rs.getString("Phone_Number");
                pno.setText(phone);
                String area=rs.getString("County");
                txt_county.setSelectedItem(area);
                String sub=rs.getString("Sub_County");
                txt_sub.setSelectedItem(sub);
                new SelectedPatient().setVisible(true);
                dispose();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        TableUpdate();
    }//GEN-LAST:event_ptableMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from patients where Patient_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, dpno.getText());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Deleted");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Couldn't Delete");
       }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
       }
       TableUpdate();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        MessageFormat header= new MessageFormat("Medical Report");
        MessageFormat footer= new MessageFormat("page{0,number,integer}");
        try{
            ptable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException pe){
            System.err.format("Cannot Print",pe.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void gcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gcomboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AdmPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void namefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namefKeyTyped
         char c=evt.getKeyChar();
       if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_namefKeyTyped

    private void namelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namelKeyTyped
         char c=evt.getKeyChar();
       if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_namelKeyTyped

    private void pnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnoKeyTyped
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_pnoKeyTyped

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
            java.util.logging.Logger.getLogger(PatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cmdupdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton cmd_srch;
    private javax.swing.JButton cmdclr;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField dpno;
    private javax.swing.JComboBox gcombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JTextField namef;
    public static javax.swing.JTextField namel;
    public static javax.swing.JTextField nop;
    private javax.swing.JTextField pno;
    private javax.swing.JMenu prdate;
    private javax.swing.JMenu prtime;
    private javax.swing.JTable ptable;
    private javax.swing.JTextField srch;
    private javax.swing.JLabel test;
    private javax.swing.JComboBox txt_county;
    private javax.swing.JComboBox txt_sub;
    // End of variables declaration//GEN-END:variables
}
