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
public class AYTerm extends javax.swing.JFrame {

    /**
     * Creates new form CreateRecord
     */
    public AYTerm() {
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
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tuitionfees = new javax.swing.JButton();
        ayterm = new javax.swing.JButton();
        student = new javax.swing.JButton();
        section = new javax.swing.JButton();
        schedule = new javax.swing.JButton();
        enrollment = new javax.swing.JButton();
        tuition = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        next = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        enrollmentCreate = new javax.swing.JButton();
        enrollmentcbb1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        enrollmentcbb3 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        gobackmenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createAYTermField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        create = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(112, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        jPanel4.setBackground(new java.awt.Color(112, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tuitionfees.setFont(new java.awt.Font("OldSansBlack", 0, 18)); // NOI18N
        tuitionfees.setForeground(new java.awt.Color(255, 255, 255));
        tuitionfees.setText("TUITION FEES");
        tuitionfees.setBorder(null);
        tuitionfees.setContentAreaFilled(false);
        tuitionfees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuitionfeesActionPerformed(evt);
            }
        });
        jPanel4.add(tuitionfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 40, -1, -1));

        ayterm.setFont(new java.awt.Font("OldSansBlack", 0, 18)); // NOI18N
        ayterm.setForeground(new java.awt.Color(255, 255, 255));
        ayterm.setText("A.Y-TERM");
        ayterm.setBorder(null);
        ayterm.setContentAreaFilled(false);
        ayterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aytermActionPerformed(evt);
            }
        });
        jPanel4.add(ayterm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        student.setFont(new java.awt.Font("OldSansBlack", 0, 18)); // NOI18N
        student.setForeground(new java.awt.Color(255, 255, 255));
        student.setText("STUDENT");
        student.setBorder(null);
        student.setContentAreaFilled(false);
        student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentActionPerformed(evt);
            }
        });
        jPanel4.add(student, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        section.setFont(new java.awt.Font("OldSansBlack", 0, 18)); // NOI18N
        section.setForeground(new java.awt.Color(255, 255, 255));
        section.setText("SECTION");
        section.setBorder(null);
        section.setContentAreaFilled(false);
        section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionActionPerformed(evt);
            }
        });
        jPanel4.add(section, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        schedule.setFont(new java.awt.Font("OldSansBlack", 0, 18)); // NOI18N
        schedule.setForeground(new java.awt.Color(255, 255, 255));
        schedule.setText("SCHEDULE");
        schedule.setBorder(null);
        schedule.setContentAreaFilled(false);
        schedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleActionPerformed(evt);
            }
        });
        jPanel4.add(schedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        enrollment.setFont(new java.awt.Font("OldSansBlack", 0, 18)); // NOI18N
        enrollment.setForeground(new java.awt.Color(255, 255, 255));
        enrollment.setText("ENROLLMENT");
        enrollment.setBorder(null);
        enrollment.setContentAreaFilled(false);
        enrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollmentActionPerformed(evt);
            }
        });
        jPanel4.add(enrollment, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        tuition.setFont(new java.awt.Font("OldSansBlack", 0, 18)); // NOI18N
        tuition.setForeground(new java.awt.Color(255, 255, 255));
        tuition.setText("TUITION");
        tuition.setBorder(null);
        tuition.setContentAreaFilled(false);
        tuition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuitionActionPerformed(evt);
            }
        });
        jPanel4.add(tuition, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 10));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        jPanel6.setBackground(new java.awt.Color(112, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next.setFont(new java.awt.Font("OldSansBlack", 0, 24)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("NEXT >");
        next.setBorder(null);
        next.setBorderPainted(false);
        next.setContentAreaFilled(false);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel6.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 160, 50));

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

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enrollmentCreate.setBackground(new java.awt.Color(51, 51, 51));
        enrollmentCreate.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        enrollmentCreate.setForeground(new java.awt.Color(255, 255, 255));
        enrollmentCreate.setText("CREATE");
        enrollmentCreate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.add(enrollmentCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 220, 80));

        enrollmentcbb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enrollmentcbb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(enrollmentcbb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 390, 40));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel4.setText("STUDENT ID:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel5.setText("ENTER A.Y-TERM:");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        enrollmentcbb3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enrollmentcbb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(enrollmentcbb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 390, 40));

        jPanel9.setLayout(new java.awt.BorderLayout());
        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 80, 200));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1280, 570));

        gobackmenu.setFont(new java.awt.Font("OldSansBlack", 0, 24)); // NOI18N
        gobackmenu.setForeground(new java.awt.Color(255, 255, 255));
        gobackmenu.setText("Go back to Menu");
        gobackmenu.setBorderPainted(false);
        gobackmenu.setContentAreaFilled(false);
        gobackmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackmenuActionPerformed(evt);
            }
        });
        jPanel6.add(gobackmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 220, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 30, 50));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1290, 50));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(112, 0, 0));
        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(112, 0, 0));
        jLabel2.setText("EX: 2022-2023 First Sem");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        createAYTermField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        createAYTermField.setToolTipText("");
        jPanel7.add(createAYTermField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 590, 60));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel3.setText("ENTER ACADEMIC YEAR AND TERM:");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        create.setBackground(new java.awt.Color(51, 51, 51));
        create.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setText("CREATE");
        create.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel7.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 220, 80));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1280, 570));

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        Student stud = new Student();
        stud.show();
        
        dispose();
    }//GEN-LAST:event_nextActionPerformed

    private void studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentActionPerformed
        Student stud = new Student();
        stud.show();
        
        dispose();
    }//GEN-LAST:event_studentActionPerformed

    private void sectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionActionPerformed
        Section sec = new Section();
        sec.show();
        dispose();
    }//GEN-LAST:event_sectionActionPerformed

    private void tuitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuitionActionPerformed
        Tuition tuition = new Tuition();
        tuition.show();
        dispose();
    }//GEN-LAST:event_tuitionActionPerformed

    private void aytermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aytermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aytermActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.show(); //display frame called
        
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleActionPerformed
        Schedule sched = new Schedule();
        sched.show();
        
        dispose();
    }//GEN-LAST:event_scheduleActionPerformed

    private void enrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollmentActionPerformed
        Enrollment enroll = new Enrollment();
        enroll.show();
        dispose();
    }//GEN-LAST:event_enrollmentActionPerformed

    private void gobackmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackmenuActionPerformed
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.show(); //display frame called

        dispose();
    }//GEN-LAST:event_gobackmenuActionPerformed

    private void tuitionfeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuitionfeesActionPerformed
        TuitionFees tFees = new TuitionFees();
        tFees.show();
        dispose();
    }//GEN-LAST:event_tuitionfeesActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        AYTerm ayterm = new AYTerm();
        Student stud = new Student();
 
        int res = JOptionPane.showConfirmDialog(this, "Are you sure you want create record for A.Y - Term?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Record for AY - Term successfully created!");
            int result = JOptionPane.showConfirmDialog(this, "Do you want to create another record for A.Y - Term?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
            ayterm.show();
            } else if (result == JOptionPane.NO_OPTION) {
            stud.show();
            }
        } else if (res == JOptionPane.NO_OPTION){
            
        }
        
        
    }//GEN-LAST:event_createActionPerformed

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
            java.util.logging.Logger.getLogger(AYTerm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AYTerm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AYTerm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AYTerm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AYTerm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayterm;
    private javax.swing.JButton back;
    private javax.swing.JButton create;
    private javax.swing.JTextField createAYTermField;
    private javax.swing.JButton enrollment;
    private javax.swing.JButton enrollmentCreate;
    private javax.swing.JComboBox<String> enrollmentcbb1;
    private javax.swing.JComboBox<String> enrollmentcbb3;
    private javax.swing.JButton gobackmenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton next;
    private javax.swing.JButton schedule;
    private javax.swing.JButton section;
    private javax.swing.JButton student;
    private javax.swing.JButton tuition;
    private javax.swing.JButton tuitionfees;
    // End of variables declaration//GEN-END:variables
}
