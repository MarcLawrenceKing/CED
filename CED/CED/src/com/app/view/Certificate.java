/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

/**
 *
 * @author Administrator
 */

import static com.app.model.QueryConstant.FEES_DETAILS;
import static com.app.model.QueryConstant.RESET_TOTALS;
import static com.app.model.QueryConstant.STUDENT_DETAILS;
import static com.app.model.QueryConstant.SUBJECT_DETAILS;
import static com.app.model.QueryConstant.TUITION_DETAILS;
import static com.app.model.QueryConstant.UPDATE_TOTALS;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Certificate extends JFrame {

    private static int studentID;

    /*
    public void PDFMaker() {
    try {
        
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.paint(img.getGraphics());

        String path = "C:\\Users\\marcl\\Downloads\\Certificate.jpg";;
        ImageIO.write(img, "jpg", new File(path));

        // Printing the file using the Desktop class
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.PRINT)) {
                desktop.print(new File(path));
            } else {
                JOptionPane.showMessageDialog(null, "Printing is not supported on your system.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Desktop class is not supported on your system.");
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
} */
    private void displayStudentDetails() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cor_db", "root", "");

            // Fetch Student Details
            PreparedStatement prep = con.prepareStatement(STUDENT_DETAILS);
            prep.setInt(1, studentID);
            ResultSet result = prep.executeQuery();

            if (result.next()) {
                StudentID.setText(result.getString("StudentID"));
                StudentName.setText(result.getString("StudentName"));
                AYTerm.setText(result.getString("AYTerm"));
                ProgDesc.setText(result.getString("ProgramDesc"));
                ProgCode.setText(result.getString("ProgramCode"));
                Campus.setText(result.getString("Campus"));
                YearLevel.setText(result.getString("YearLevel"));
                Section.setText(result.getString("Section"));
                Address.setText(result.getString("Address"));
                ContactNum.setText(result.getString("ContactNumber"));

                // Fetch Subject Details
                prep = con.prepareStatement(SUBJECT_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, AYTerm.getText());
                result = prep.executeQuery();

                StringBuilder subjectsText = new StringBuilder();

                prep = con.prepareStatement(SUBJECT_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, AYTerm.getText());
                result = prep.executeQuery();

                while (result.next()) {
                    String subjectLine = String.format("%-11s  %-54s  %-9s  %-4.1f  %-4.1f  %-20s",
                            result.getString("SubjectCode"),
                            result.getString("SubjectTitle"),
                            result.getString("SectionCode"),
                            result.getFloat("TuitionUnits"),
                            result.getFloat("CreditedUnits"),
                            result.getString("Schedule"));
                    subjectsText.append(subjectLine).append(System.lineSeparator());
                    subjectsText.append(System.lineSeparator());
                }

                SubjectToSchedArea.setFont(new Font("Consolas", Font.PLAIN, 12));
                SubjectToSchedArea.setText(subjectsText.toString());
                
                // Reset the totals to zero
                prep = con.prepareStatement(RESET_TOTALS);
                prep.setInt(1, studentID);
                prep.setString(2, AYTerm.getText());
                prep.executeUpdate();

                // Fetch Fees Details
                prep = con.prepareStatement(FEES_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, AYTerm.getText());
                result = prep.executeQuery();

                float totalFees = 0;
                StringBuilder feesText = new StringBuilder();
                while (result.next()) {
                    String feesLine = String.format("%-27s  %-4.2f",
                            result.getString("FeeName"),
                            result.getFloat("Amount"));
                    feesText.append(feesLine).append(System.lineSeparator());

                    totalFees += result.getFloat("Amount");
                }
                BillArea.setFont(new Font("Consolas", Font.PLAIN, 11));
                BillArea.setText(feesText.toString());

                // Fetch Tuition Details and calculate totals
                prep = con.prepareStatement(TUITION_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, AYTerm.getText());
                result = prep.executeQuery();

                float maxUnitsEnrolled = 0;
                float totalTuitionUnits = 0;
                float totalCreditedUnits = 0;
                float tuitionAmountInFloat = 0;
                float totalAssessmentInFloat = 0;
                String tuitionAmount = "";
                String totalAssessment = "";
                String maxUnitsEnrolledstr = "";
                String totalTuitionUnitsstr = "";
                String totalCreditedUnitsstr = "";

                if (result.next()) {
                    maxUnitsEnrolled = result.getFloat("MaxUnitsEnrolled");
                    totalTuitionUnits = result.getFloat("TotalTuitionUnits");
                    totalCreditedUnits = result.getFloat("TotalCreditedUnits");
                    tuitionAmountInFloat = totalTuitionUnits * 10;
                    totalAssessmentInFloat = totalFees + tuitionAmountInFloat;
                    totalAssessment = String.format("%.2f", totalAssessmentInFloat);
                }
                tuitionAmount = String.format("%.2f", tuitionAmountInFloat);
                maxUnitsEnrolledstr = String.format("%.1f", maxUnitsEnrolled);
                totalTuitionUnitsstr = String.format("%.1f", totalTuitionUnits);
                totalCreditedUnitsstr = String.format("%.1f", totalCreditedUnits);
                MaxUnitsField.setText(maxUnitsEnrolledstr);
                TotalTuitionField.setText(totalTuitionUnitsstr);
                TotalCreditedField.setText(totalCreditedUnitsstr);
                TuitionFeeField.setText(tuitionAmount);
                TotalAssessmentField.setText(totalAssessment);
                
                // Update the database with the calculated totals
                prep = con.prepareStatement(UPDATE_TOTALS);
                prep.setFloat(1, totalTuitionUnits);
                prep.setFloat(2, totalCreditedUnits);
                prep.setFloat(3, tuitionAmountInFloat);
                prep.setFloat(4, totalFees);
                prep.setString(5, totalAssessment);
                prep.setInt(6, studentID);
                prep.setString(7, AYTerm.getText());
                prep.executeUpdate();

                // Close connections
                result.close();
                prep.close();
                con.close();
                JOptionPane.showMessageDialog(null, "COR Generated successfully!");
            } else {
                dispose();
                JOptionPane.showMessageDialog(this, "Student records are not complete or does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form Certificate
     */
    public Certificate(int studentID) {
        initComponents();
        this.studentID = studentID;

        displayStudentDetails();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        StudentID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        StudentName = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        ProgCode = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        ContactNum = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        YearLevel = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        Section = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        ProgDesc = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        AYTerm = new javax.swing.JTextField();
        Campus = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        MaxUnitsField = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        TotalTuitionField = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jTextField28 = new javax.swing.JTextField();
        TotalAssessmentField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        TotalCreditedField = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        SubjectToSchedArea = new javax.swing.JTextArea();
        TuitionFeeField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        BillArea = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setMinimumSize(new java.awt.Dimension(1280, 700));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBackground(new java.awt.Color(206, 212, 218));
        jPanel35.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel20.setText("TOTAL UNITS ENROLLED:");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel17.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 660, 190, -1));

        jPanel18.setBackground(new java.awt.Color(112, 0, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CERTIFICATE OF REGISTRATION");
        jPanel18.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1240, -1));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1240, 40));

        StudentID.setEditable(false);
        StudentID.setBackground(new java.awt.Color(255, 255, 255));
        StudentID.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        StudentID.setForeground(new java.awt.Color(153, 0, 0));
        StudentID.setText("STUDENT ID");
        StudentID.setBorder(null);
        StudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentIDActionPerformed(evt);
            }
        });
        jPanel17.add(StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 570, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setText("CAMPUS:");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        StudentName.setEditable(false);
        StudentName.setBackground(new java.awt.Color(255, 255, 255));
        StudentName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        StudentName.setForeground(new java.awt.Color(153, 0, 0));
        StudentName.setText("NAME");
        StudentName.setBorder(null);
        StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentNameActionPerformed(evt);
            }
        });
        jPanel17.add(StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 570, -1));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setText("ADDRESS:");

        Address.setEditable(false);
        Address.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Address.setForeground(new java.awt.Color(153, 0, 0));
        Address.setText("ADDRESS");
        Address.setBorder(null);
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 520, 60));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel29.setText("PROGRAM CODE:");

        ProgCode.setEditable(false);
        ProgCode.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ProgCode.setForeground(new java.awt.Color(153, 0, 0));
        ProgCode.setText("PROGRAM CODE");
        ProgCode.setBorder(null);
        ProgCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProgCode, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(ProgCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel17.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, 290, 60));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setText("CONTACT NUMBER:");

        ContactNum.setEditable(false);
        ContactNum.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ContactNum.setForeground(new java.awt.Color(153, 0, 0));
        ContactNum.setText("CONTACT NUMBER");
        ContactNum.setBorder(null);
        ContactNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ContactNum, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ContactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 520, 60));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setText("YEAR LEVEL:");

        YearLevel.setEditable(false);
        YearLevel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        YearLevel.setForeground(new java.awt.Color(153, 0, 0));
        YearLevel.setText("Year Level");
        YearLevel.setBorder(null);
        YearLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearLevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(YearLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(YearLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 310, 60));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel19.setText("SECTION: ");

        Section.setEditable(false);
        Section.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Section.setForeground(new java.awt.Color(153, 0, 0));
        Section.setText("SECTION");
        Section.setBorder(null);
        Section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Section, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(Section, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 390, 60));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel17.setText("PROGRAM DESCRIPTION:");

        ProgDesc.setEditable(false);
        ProgDesc.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ProgDesc.setForeground(new java.awt.Color(153, 0, 0));
        ProgDesc.setText("PROGRAM DESCRIPTION");
        ProgDesc.setBorder(null);
        ProgDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(ProgDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProgDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel17.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 410, 60));

        jPanel27.setBackground(new java.awt.Color(206, 156, 32));

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("SCHEDULE");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(321, 321, 321))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 240, 40));

        jPanel25.setBackground(new java.awt.Color(206, 156, 32));
        jPanel25.setForeground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel34.setText("SUBJECT CODE");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 110, 40));

        jPanel26.setBackground(new java.awt.Color(206, 156, 32));

        jLabel21.setBackground(new java.awt.Color(206, 156, 32));
        jLabel21.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("SUBJECT TITLE");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1902, 1902, 1902))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 310, 40));

        jPanel28.setBackground(new java.awt.Color(206, 156, 32));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel23.setText("SECTION CODE");

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("TUITION");

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("UNITS");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        jPanel17.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 190, 40));

        jPanel29.setBackground(new java.awt.Color(206, 156, 32));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("UNITS");
        jPanel29.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, -1));

        jLabel41.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("CREDITED");
        jPanel29.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 10));

        jPanel17.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 70, 40));

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel28.setText("A.Y - TERM:");
        jPanel17.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        jPanel30.setBackground(new java.awt.Color(206, 156, 32));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel17.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 90, 40));

        jPanel31.setBackground(new java.awt.Color(206, 156, 32));

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("BREAKDOWN OF FEES");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 250, 160, 40));

        jPanel32.setBackground(new java.awt.Color(206, 156, 32));

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("AMOUNT");

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 250, 90, 40));

        AYTerm.setEditable(false);
        AYTerm.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        AYTerm.setForeground(new java.awt.Color(153, 0, 0));
        AYTerm.setText("A.Y - TERM:");
        AYTerm.setBorder(null);
        AYTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AYTermActionPerformed(evt);
            }
        });
        jPanel17.add(AYTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 550, -1));

        Campus.setEditable(false);
        Campus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Campus.setForeground(new java.awt.Color(153, 0, 0));
        Campus.setText("CAMPUS");
        Campus.setBorder(null);
        Campus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampusActionPerformed(evt);
            }
        });
        jPanel17.add(Campus, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 550, -1));

        jPanel33.setBackground(new java.awt.Color(206, 212, 218));
        jPanel33.setForeground(new java.awt.Color(255, 255, 255));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel34.setBackground(new java.awt.Color(206, 212, 218));
        jPanel34.setForeground(new java.awt.Color(255, 255, 255));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel35.setText("SUBJECT CODE");
        jPanel34.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, -1, 30));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 450, 40));

        jLabel36.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel36.setText("MAX UNITS ALLOWED");
        jPanel33.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 40));

        jPanel39.setBackground(new java.awt.Color(206, 212, 218));
        jPanel39.setForeground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBackground(new java.awt.Color(206, 212, 218));
        jPanel40.setForeground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel37.setText("SUBJECT CODE");
        jPanel40.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, -1, 30));

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 450, 40));

        jLabel38.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel38.setText("MAX UNITS ALLOWED");
        jPanel39.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 40));

        jPanel33.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 300, 40));

        jPanel17.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 300, 40));

        jLabel33.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Tuition Fee");
        jPanel17.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 630, 118, 20));

        jPanel36.setBackground(new java.awt.Color(206, 212, 218));
        jPanel36.setForeground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MaxUnitsField.setEditable(false);
        MaxUnitsField.setBackground(new java.awt.Color(206, 212, 218));
        MaxUnitsField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        MaxUnitsField.setForeground(new java.awt.Color(153, 0, 0));
        MaxUnitsField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MaxUnitsField.setText("23.0");
        MaxUnitsField.setBorder(null);
        MaxUnitsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxUnitsFieldActionPerformed(evt);
            }
        });
        jPanel36.add(MaxUnitsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        jPanel17.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 660, 100, 40));

        jPanel37.setBackground(new java.awt.Color(206, 212, 218));
        jPanel37.setForeground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel44.setBackground(new java.awt.Color(206, 212, 218));
        jPanel44.setForeground(new java.awt.Color(255, 255, 255));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel37.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 660, 90, 40));

        jPanel45.setBackground(new java.awt.Color(206, 212, 218));
        jPanel45.setForeground(new java.awt.Color(255, 255, 255));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel46.setBackground(new java.awt.Color(206, 212, 218));
        jPanel46.setForeground(new java.awt.Color(255, 255, 255));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel45.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 660, 90, 40));

        jPanel37.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, 90, 40));

        TotalTuitionField.setEditable(false);
        TotalTuitionField.setBackground(new java.awt.Color(206, 212, 218));
        TotalTuitionField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        TotalTuitionField.setForeground(new java.awt.Color(153, 0, 0));
        TotalTuitionField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalTuitionField.setText("31.0");
        TotalTuitionField.setBorder(null);
        TotalTuitionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalTuitionFieldActionPerformed(evt);
            }
        });
        jPanel37.add(TotalTuitionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jPanel17.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 660, 90, 40));

        jPanel41.setBackground(new java.awt.Color(206, 212, 218));
        jPanel41.setForeground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel39.setText("TOTAL ASSESSMENT:");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel17.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 660, 390, -1));

        jPanel42.setBackground(new java.awt.Color(206, 212, 218));
        jPanel42.setForeground(new java.awt.Color(255, 255, 255));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField28.setBackground(new java.awt.Color(206, 212, 218));
        jTextField28.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(153, 0, 0));
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setText("23.0");
        jTextField28.setBorder(null);
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jPanel42.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 620, 70, -1));

        TotalAssessmentField.setEditable(false);
        TotalAssessmentField.setBackground(new java.awt.Color(206, 212, 218));
        TotalAssessmentField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        TotalAssessmentField.setForeground(new java.awt.Color(153, 0, 0));
        TotalAssessmentField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalAssessmentField.setText("999,999.99");
        TotalAssessmentField.setBorder(null);
        TotalAssessmentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAssessmentFieldActionPerformed(evt);
            }
        });
        jPanel42.add(TotalAssessmentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel17.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 660, 90, 40));
        jPanel17.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, -1, -1));

        jPanel38.setBackground(new java.awt.Color(206, 212, 218));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TotalCreditedField.setEditable(false);
        TotalCreditedField.setBackground(new java.awt.Color(206, 212, 218));
        TotalCreditedField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        TotalCreditedField.setForeground(new java.awt.Color(153, 0, 0));
        TotalCreditedField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalCreditedField.setText("23.0");
        TotalCreditedField.setBorder(null);
        TotalCreditedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalCreditedFieldActionPerformed(evt);
            }
        });
        jPanel38.add(TotalCreditedField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, -1));

        jPanel17.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, 80, 40));

        SubjectToSchedArea.setEditable(false);
        SubjectToSchedArea.setColumns(20);
        SubjectToSchedArea.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        SubjectToSchedArea.setForeground(new java.awt.Color(204, 0, 0));
        SubjectToSchedArea.setRows(5);
        SubjectToSchedArea.setText("COMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0\t          W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\nCOMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0\t          W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\nCOMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0                 W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\nCOMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0                 W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\nCOMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0                 W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\nCOMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0                 W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\nCOMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0                 W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\nCOMP 009\t\tObject Oriented Programming\t\t                   BSIT 2-3\t           5.0\t               3.0\t          W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC\n\n");
        SubjectToSchedArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane7.setViewportView(SubjectToSchedArea);

        jPanel17.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 1000, 350));

        TuitionFeeField.setEditable(false);
        TuitionFeeField.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        TuitionFeeField.setForeground(new java.awt.Color(153, 0, 0));
        TuitionFeeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TuitionFeeField.setText("999,999.99");
        TuitionFeeField.setBorder(null);
        TuitionFeeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TuitionFeeFieldActionPerformed(evt);
            }
        });
        jPanel17.add(TuitionFeeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 630, 80, 20));

        BillArea.setEditable(false);
        BillArea.setColumns(20);
        BillArea.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        BillArea.setForeground(new java.awt.Color(204, 0, 0));
        BillArea.setRows(5);
        BillArea.setText("CULTURAL FEE (COLLEGE \t9,999.99\n& OU UNDERGRAD)\t9,999.99\nGUIDANCE FEE\t\t9,999.99\nINSURANCE\t\t9,999.99\nLABORATORY FEE \t9,999.99\n(COLLEGE & OU \t9,999.99\nUNDERGRAD)\t\t9,999.99\nLIBRARY FEE (COLLEGE & \t9,999.99\nOU UNDERGRAD)\t9,999.99\nMEDICAL AND DENTAL FEE \t9,999.99\n(COLLEGE & OU \t9,999.99\nUNDERGRAD)\t\t9,999.99\nPUBLICATION FEE \t9,999.99\n\n\n\n\n\n\n");
        BillArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(BillArea);

        jPanel17.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 300, 250, 320));

        jPanel12.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setText("A.Y - TERM:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setText("A.Y - TERM:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TuitionFeeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TuitionFeeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TuitionFeeFieldActionPerformed

    private void TotalCreditedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalCreditedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalCreditedFieldActionPerformed

    private void TotalAssessmentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAssessmentFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAssessmentFieldActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void TotalTuitionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalTuitionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalTuitionFieldActionPerformed

    private void MaxUnitsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxUnitsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaxUnitsFieldActionPerformed

    private void CampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampusActionPerformed

    private void AYTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AYTermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AYTermActionPerformed

    private void ProgDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProgDescActionPerformed

    private void SectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SectionActionPerformed

    private void YearLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearLevelActionPerformed

    private void ContactNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactNumActionPerformed

    private void ProgCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProgCodeActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void StudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentIDActionPerformed

    private void StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentNameActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Certificate(studentID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AYTerm;
    private javax.swing.JTextField Address;
    private javax.swing.JTextArea BillArea;
    private javax.swing.JTextField Campus;
    private javax.swing.JTextField ContactNum;
    private javax.swing.JTextField MaxUnitsField;
    private javax.swing.JTextField ProgCode;
    private javax.swing.JTextField ProgDesc;
    private javax.swing.JTextField Section;
    private javax.swing.JTextField StudentID;
    private javax.swing.JTextField StudentName;
    private javax.swing.JTextArea SubjectToSchedArea;
    private javax.swing.JTextField TotalAssessmentField;
    private javax.swing.JTextField TotalCreditedField;
    private javax.swing.JTextField TotalTuitionField;
    private javax.swing.JTextField TuitionFeeField;
    private javax.swing.JTextField YearLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField28;
    // End of variables declaration//GEN-END:variables
}
