/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corgui;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class UpdateScheduleRecord extends javax.swing.JFrame {

    /**
     * Creates new form UpdateScheduleRecord
     */
    public UpdateScheduleRecord() {
        initComponents();
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
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        enrollmentCreate = new javax.swing.JButton();
        enrollmentcbb1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        enrollmentcbb3 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        gobackupmenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        updatecbb1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(112, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Update Schedule Record");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1260, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        jPanel6.setBackground(new java.awt.Color(112, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enrollmentCreate.setBackground(new java.awt.Color(51, 51, 51));
        enrollmentCreate.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        enrollmentCreate.setForeground(new java.awt.Color(255, 255, 255));
        enrollmentCreate.setText("CREATE");
        enrollmentCreate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(enrollmentCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 220, 80));

        enrollmentcbb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enrollmentcbb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(enrollmentcbb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 390, 40));

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel12.setText("STUDENT ID:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel13.setText("ENTER A.Y-TERM:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        enrollmentcbb3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enrollmentcbb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(enrollmentcbb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 390, 40));

        jPanel7.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 80, 200));

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1280, 570));

        gobackupmenu.setFont(new java.awt.Font("OldSansBlack", 0, 24)); // NOI18N
        gobackupmenu.setForeground(new java.awt.Color(255, 255, 255));
        gobackupmenu.setText("Go back to Update Menu");
        gobackupmenu.setBorderPainted(false);
        gobackupmenu.setContentAreaFilled(false);
        gobackupmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackupmenuActionPerformed(evt);
            }
        });
        jPanel6.add(gobackupmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 310, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 30, 50));

        back.setFont(new java.awt.Font("OldSansBlack", 0, 24)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("< BACK");
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel6.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 160, 50));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1290, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update.setBackground(new java.awt.Color(204, 102, 0));
        update.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 220, 80));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel3.setText("ENTER SCHEDULE ID:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        updatecbb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        updatecbb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(updatecbb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 450, 50));

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel15.setText("UPDATED SCHEDULE:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        scheduleArea.setColumns(20);
        scheduleArea.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        scheduleArea.setRows(5);
        jScrollPane1.setViewportView(scheduleArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 450, 130));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1280, 570));

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gobackupmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackupmenuActionPerformed
        UpdateWindow updateW = new UpdateWindow();
        updateW.show(); //display frame called

        dispose();
    }//GEN-LAST:event_gobackupmenuActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        UpdateStudentRecord USCR = new UpdateStudentRecord();
        USCR.show();

        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        UpdateStudentRecord USR = new UpdateStudentRecord();
        UpdateWindow updateW = new UpdateWindow();
        UpdateScheduleRecord USCR = new UpdateScheduleRecord();
        
        int res = JOptionPane.showConfirmDialog(this, "Are you sure you want to update record for Schedule", "Confirm", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Record for Schedule successfully updated!");
            int result = JOptionPane.showConfirmDialog(this, "Do you want to update another record for Schedule?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                USCR.show();
            } else if (result == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "You will now return to the update menu");
                updateW.show();
                
            }
        } else if (res == JOptionPane.NO_OPTION){
            USCR.show();
        }
        dispose();
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateScheduleRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateScheduleRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateScheduleRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateScheduleRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateScheduleRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton enrollmentCreate;
    private javax.swing.JComboBox<String> enrollmentcbb1;
    private javax.swing.JComboBox<String> enrollmentcbb3;
    private javax.swing.JButton gobackupmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea scheduleArea;
    private javax.swing.JButton update;
    private javax.swing.JComboBox<String> updatecbb1;
    // End of variables declaration//GEN-END:variables
}
