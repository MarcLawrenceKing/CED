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
public class Schedule extends javax.swing.JFrame {

    /** Creates new form Schedule */
    public Schedule() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        tuitionfees = new javax.swing.JButton();
        ayterm = new javax.swing.JButton();
        student = new javax.swing.JButton();
        section = new javax.swing.JButton();
        schedule = new javax.swing.JButton();
        enrollment = new javax.swing.JButton();
        tuition = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        create = new javax.swing.JButton();
        schedulecbb1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        createscheduleField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        schedulecbb2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        enrollmentCreate = new javax.swing.JButton();
        enrollmentcbb1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        enrollmentcbb3 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        gobackmenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 110, 10));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 220, 80));

        schedulecbb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        schedulecbb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(schedulecbb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 390, 40));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel4.setText("SUBJECT CODE:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        createscheduleField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        createscheduleField.setToolTipText("");
        createscheduleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createscheduleFieldActionPerformed(evt);
            }
        });
        jPanel1.add(createscheduleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 390, 40));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel3.setText("ENTER SECTION CODE:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel5.setText("ENTER A.Y-TERM:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        schedulecbb2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        schedulecbb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(schedulecbb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 390, 40));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel6.setText("ENTER SCHEDULE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        scheduleArea1.setColumns(20);
        scheduleArea1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        scheduleArea1.setRows(5);
        jScrollPane1.setViewportView(scheduleArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 390, 130));

        jLabel2.setBackground(new java.awt.Color(112, 0, 0));
        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(112, 0, 0));
        jLabel2.setText("       S 10:00:00 - 12:00:00 LEC");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 380, -1, -1));

        jLabel7.setBackground(new java.awt.Color(112, 0, 0));
        jLabel7.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(112, 0, 0));
        jLabel7.setText("EX: W 09:00:00 - 12:00:00 LAB");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1280, 570));

        jPanel6.setBackground(new java.awt.Color(112, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enrollmentCreate.setBackground(new java.awt.Color(51, 51, 51));
        enrollmentCreate.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        enrollmentCreate.setForeground(new java.awt.Color(255, 255, 255));
        enrollmentCreate.setText("CREATE");
        enrollmentCreate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(enrollmentCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 220, 80));

        enrollmentcbb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enrollmentcbb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(enrollmentcbb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 390, 40));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel8.setText("STUDENT ID:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel9.setText("ENTER A.Y-TERM:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        enrollmentcbb3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enrollmentcbb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(enrollmentcbb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 390, 40));

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 80, 200));

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1280, 570));

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

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aytermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aytermActionPerformed
        AYTerm ayterm = new AYTerm();
        ayterm.show();
        dispose();
    }//GEN-LAST:event_aytermActionPerformed

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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Section sec = new Section();
        sec.show();
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        Enrollment enroll = new Enrollment();
        enroll.show();
        dispose();
    }//GEN-LAST:event_nextActionPerformed

    private void createscheduleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createscheduleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createscheduleFieldActionPerformed

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
        Schedule sched = new Schedule();
        Enrollment enroll = new Enrollment();
 
        int res = JOptionPane.showConfirmDialog(this, "Are you sure you want create record for Schedule?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Record for Schedule successfully created!");
            int result = JOptionPane.showConfirmDialog(this, "Do you want to create another record for Schedule?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
            sched.show();
            } else if (result == JOptionPane.NO_OPTION) {
            enroll.show();
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
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayterm;
    private javax.swing.JButton back;
    private javax.swing.JButton create;
    private javax.swing.JTextField createscheduleField;
    private javax.swing.JButton enrollment;
    private javax.swing.JButton enrollmentCreate;
    private javax.swing.JComboBox<String> enrollmentcbb1;
    private javax.swing.JComboBox<String> enrollmentcbb3;
    private javax.swing.JButton gobackmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JButton schedule;
    private javax.swing.JTextArea scheduleArea1;
    private javax.swing.JComboBox<String> schedulecbb1;
    private javax.swing.JComboBox<String> schedulecbb2;
    private javax.swing.JButton section;
    private javax.swing.JButton student;
    private javax.swing.JButton tuition;
    private javax.swing.JButton tuitionfees;
    // End of variables declaration//GEN-END:variables

}
