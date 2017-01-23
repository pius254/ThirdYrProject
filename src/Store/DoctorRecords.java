/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author AnonymousHacker
 */
public class DoctorRecords extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form DoctorRecords
     */
    public DoctorRecords() {
        initComponents();
        conn=DBConnection.ConnecrDB();
        DocTable();
        CurrentDateAndTime();
    }
    
    public void CurrentDateAndTime(){
        Thread clock= new Thread(){
            public void run(){
                for(;;){
        Calendar cal=new GregorianCalendar();
        int yr=cal.get(Calendar.YEAR);
        int mnth=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        drdate.setText("Date "+yr+"/"+(mnth + 1)+"/"+day);
        
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hr=cal.get(Calendar.HOUR);
        drtime.setText("Time "+hr+":"+min+":"+sec); 
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
    
    public void DocTable(){
        try{
            String sql="select * from doctors";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            dtable.setModel(DbUtils.resultSetToTableModel(rs));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        dtable = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ddno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dsch = new javax.swing.JTextField();
        cmdsrc = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        dn = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        sp = new javax.swing.JComboBox();
        gd = new javax.swing.JComboBox();
        Cmd_update = new javax.swing.JButton();
        clr = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bt_delete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        de = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        drdate = new javax.swing.JMenu();
        drtime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DOCTOR RECORDS");

        dtable.setModel(new javax.swing.table.DefaultTableModel(
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
        dtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dtable);

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/File-Delete-icon.png"))); // NOI18N
        jButton2.setToolTipText("Delete a doctor from the records");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Printer-icon2.png"))); // NOI18N
        jButton4.setToolTipText("Print the record");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        jButton5.setToolTipText("Logout");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        ddno.setText("enter the doctors number if you want to delete");
        ddno.setToolTipText("enter the doctors number if you want to delete");
        ddno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ddnoMouseClicked(evt);
            }
        });

        jLabel1.setText("Doctor Number");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Gender");

        dsch.setText("Enter Doctor's Number to Search");
        dsch.setToolTipText("Enter Doctor's Number to Search");
        dsch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dschMouseClicked(evt);
            }
        });

        cmdsrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/search-icon.png"))); // NOI18N
        cmdsrc.setText("Search");
        cmdsrc.setToolTipText("Search");
        cmdsrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsrcActionPerformed(evt);
            }
        });

        jLabel5.setText("Specialization");

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnKeyTyped(evt);
            }
        });

        ln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnKeyTyped(evt);
            }
        });

        jLabel6.setText("Phone Number");

        pn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pnKeyTyped(evt);
            }
        });

        sp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "diabetes", "body fitness", "asthma", "allergies" }));

        gd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        Cmd_update.setText("Update");
        Cmd_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmd_updateActionPerformed(evt);
            }
        });

        clr.setText("Clear");
        clr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrActionPerformed(evt);
            }
        });

        jLabel7.setText("Edit/Update");

        bt_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/File-Delete-icon.png"))); // NOI18N
        bt_delete.setText("Delete");
        bt_delete.setToolTipText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        jLabel8.setText("ID Number");

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel9.setText("Date Employed");

        de.setMaxSelectableDate(new java.util.Date(1484085712000L));

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

        drdate.setText("Date");
        jMenuBar1.add(drdate);

        drtime.setText("Time");
        jMenuBar1.add(drtime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pn)
                            .addComponent(ln)
                            .addComponent(fn)
                            .addComponent(dn)
                            .addComponent(gd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sp, 0, 167, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cmd_update)
                                .addGap(18, 18, 18)
                                .addComponent(clr))
                            .addComponent(id)
                            .addComponent(de, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dsch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdsrc)
                        .addGap(283, 283, 283)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ddno, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_delete)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dsch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdsrc))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ddno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_delete))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cmd_update)
                            .addComponent(clr))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1436, 763));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from doctors where Doc_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, ddno.getText());
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
       DocTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ddnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddnoMouseClicked
        ddno.setText("");
    }//GEN-LAST:event_ddnoMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from doctors where Doc_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, ddno.getText());
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
       DocTable();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         MessageFormat header= new MessageFormat("Doctor Report");
        MessageFormat footer= new MessageFormat("page{0,number,integer}");
        try{
            dtable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException pe){
            System.err.format("Cannot Print",pe.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new Admin().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        MessageFormat header= new MessageFormat("Doctor Report");
        MessageFormat footer= new MessageFormat("page{0,number,integer}");
        try{
            dtable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException pe){
            System.err.format("Cannot Print",pe.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void cmdsrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsrcActionPerformed
        try{
            
            String src="select * from doctors where Doc_No=?";
            pst=conn.prepareStatement(src);
            pst.setString(1, dsch.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                String pnos=rs.getString("Doc_No");
                dn.setText(pnos);
                String fnm=rs.getString("Fname");
                fn.setText(fnm);
                String lnm=rs.getString("Lname");
                ln.setText(lnm);
                String id_no=rs.getString("ID_No");
                id.setText(id_no);
                String d_emp=rs.getString("Date_Employed");
                ((JTextField)de.getDateEditor().getUiComponent()).setText(d_emp);
                String gdr=rs.getString("Gender");
                gd.setSelectedItem(gdr);
                String spec=rs.getString("Specialization");
                sp.setSelectedItem(spec);
                String phone=rs.getString("Phone_number");
                pn.setText(phone);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        DocTable();
    }//GEN-LAST:event_cmdsrcActionPerformed

    private void clrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrActionPerformed
        dn.setText("");
        fn.setText("");
        ln.setText("");
        id.setText("");
        pn.setText("");
    }//GEN-LAST:event_clrActionPerformed

    private void Cmd_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmd_updateActionPerformed
       try{
           String doc= dn.getText().trim();
            String fname=fn.getText().trim();
            String lname= ln.getText().trim();
            String id_no= id.getText().trim();
            String date=((JTextField)de.getDateEditor().getUiComponent()).getText();
            String gender= gd.getSelectedItem().toString().trim();
            String specs= sp.getSelectedItem().toString().trim();
            String phone= pn.getText().trim();
           //int row=ptable.getSelectedRow();
            //String T_click=(ptable.getModel().getValueAt(row, 0).toString());
            String sql="update doctors set Doc_No='"+doc+"' ,Fname='"+fname+"' ,Lname='"+lname+"',Gender='"+gender+"' ,Specialization='"+specs+"' ,Phone_Number='"+phone+"' where Doc_No='"+doc+"'";
            pst=conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Successfully Updated");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       DocTable();
    }//GEN-LAST:event_Cmd_updateActionPerformed

    private void dtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtableMouseClicked
         try{
            int row=dtable.getSelectedRow();
            String T_click=(dtable.getModel().getValueAt(row, 0).toString());
            String sql="select * from doctors where Doc_No='"+T_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String pnos=rs.getString("Doc_No");
                dn.setText(pnos);
                String fnm=rs.getString("Fname");
                fn.setText(fnm);
                String lnm=rs.getString("Lname");
                ln.setText(lnm);
                String id_no=rs.getString("ID_No");
                id.setText(id_no);
                String d_emp=rs.getString("Date_Employed");
                ((JTextField)de.getDateEditor().getUiComponent()).setText(d_emp);
                String ged=rs.getString("Gender");
                gd.setSelectedItem(ged);
                String spe=rs.getString("Specialization");
                sp.setSelectedItem(spe);
                String phone=rs.getString("Phone_Number");
                pn.setText(phone);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         DocTable();
    }//GEN-LAST:event_dtableMouseClicked

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from doctors where Doc_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, ddno.getText());
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
       DocTable();
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void dschMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dschMouseClicked
        dsch.setText("");
    }//GEN-LAST:event_dschMouseClicked

    private void fnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnKeyTyped
         char c=evt.getKeyChar();
       if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_fnKeyTyped

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_idKeyTyped

    private void pnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnKeyTyped
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_pnKeyTyped

    private void lnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnKeyTyped
         char c=evt.getKeyChar();
       if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_lnKeyTyped

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
            java.util.logging.Logger.getLogger(DoctorRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cmd_update;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton clr;
    private javax.swing.JButton cmdsrc;
    private javax.swing.JTextField ddno;
    private com.toedter.calendar.JDateChooser de;
    private javax.swing.JTextField dn;
    private javax.swing.JMenu drdate;
    private javax.swing.JMenu drtime;
    private javax.swing.JTextField dsch;
    private javax.swing.JTable dtable;
    private javax.swing.JTextField fn;
    private javax.swing.JComboBox gd;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTextField ln;
    private javax.swing.JTextField pn;
    private javax.swing.JComboBox sp;
    // End of variables declaration//GEN-END:variables
}
