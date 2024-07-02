/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;

/**
 *
 * @author marcl
 */
public class CORController extends DBConnection {

    public void generateCOR(int studentID) {

        try {
            connect();

            // Fetch Student Details           
            prep = con.prepareStatement(STUDENT_DETAILS);
            prep.setInt(1, studentID);
            result = prep.executeQuery();

            if (result.next()) {
                String studentName = result.getString("StudentName");
                String ayTerm = result.getString("AYTerm");
                String programDesc = result.getString("ProgramDesc");
                String programCode = result.getString("ProgramCode");
                String campus = result.getString("Campus");
                String yearLevel = result.getString("YearLevel");
                String section = result.getString("Section");
                String address = result.getString("Address");
                String contactNumber = result.getString("ContactNumber");
                String scholarship = result.getString("Scholarship");

                System.out.println("**Certificate of Registration**");
                System.out.println();
                System.out.println("StudentID: " + studentID);
                System.out.println("StudentName: " + studentName);
                System.out.println("AYTerm: " + ayTerm);
                System.out.println("ProgramDescription: " + programDesc);
                System.out.println("ProgramCode: " + programCode);
                System.out.println("Campus: " + campus);
                System.out.println("YearLevel: " + yearLevel);
                System.out.println("Section: " + section);
                System.out.println("Address: " + address);
                System.out.println("ContactNumber: " + contactNumber);
                System.out.println();

                // Fetch Subject Details                
                prep = con.prepareStatement(SUBJECT_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, ayTerm);
                result = prep.executeQuery();

                System.out.printf("%-12s | %-30s | %-12s | %-12s | %-15s | %-20s%n",
                        "SubjectCode", "SubjectTitle", "SectionCode", "TuitionUnits", "CreditedUnits", "Schedule");

                while (result.next()) {
                    System.out.printf("%-12s | %-30s | %-12s | %-12.2f | %-15.2f | %-20s%n",
                            result.getString("SubjectCode"),
                            result.getString("SubjectTitle"),
                            result.getString("SectionCode"),
                            result.getFloat("TuitionUnits"),
                            result.getFloat("CreditedUnits"),
                            result.getString("Schedule"));
                }

                System.out.println();

                // Reset the totals to zero               
                prep = con.prepareStatement(RESET_TOTALS);
                prep.setInt(1, studentID);
                prep.setString(2, ayTerm);
                prep.executeUpdate();

                // Fetch Fees Details                
                prep = con.prepareStatement(FEES_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, ayTerm);
                result = prep.executeQuery();

                float totalFees = 0;
                System.out.printf("%-15s | %10s%n", "FeeName", "Amount");
                while (result.next()) {
                    System.out.printf("%-15s | %10.2f%n",
                            result.getString("FeeName"),
                            result.getDouble("Amount"));
                    totalFees += result.getFloat("Amount");
                }

                System.out.println();

                // Fetch Tuition Details               
                prep = con.prepareStatement(TUITION_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, ayTerm);
                result = prep.executeQuery();

                float maxUnitsEnrolled = 0;
                float totalTuitionUnits = 0;
                float totalCreditedUnits = 0;
                float tuitionAmount = 0;
                float totalAssessmentInFloat = 0; //to solve for total assessment
                String totalAssessment = "";

                if (result.next()) {
                    maxUnitsEnrolled = result.getFloat("MaxUnitsEnrolled");
                    totalTuitionUnits = result.getFloat("TotalTuitionUnits");
                    totalCreditedUnits = result.getFloat("TotalCreditedUnits");
                    tuitionAmount = totalTuitionUnits * 10;
                    if (scholarship.equals("FULL")) {
                        totalAssessment = "FREE"; // free if full scholar
                    }
                    if (scholarship.equals("PARTIAL")) {
                        totalAssessmentInFloat = (totalFees + tuitionAmount)/ 2; // total is divided by 2
                        totalAssessment = Float.toString(totalAssessmentInFloat);
                    }
                    if (scholarship.equals("NON-SCHOLAR")) {
                        totalAssessmentInFloat = totalFees + tuitionAmount; //calculate total assessment
                        totalAssessment = Float.toString(totalAssessmentInFloat);
                    }
                }

                System.out.printf("MaxUnitsEnrolled: %-12.1f | TotalTuitionUnits: %-12.1f | TotalCreditedUnits: %-12.1f | TotalAssessment: %-20s%n",
                        maxUnitsEnrolled, totalTuitionUnits, totalCreditedUnits, totalAssessment);

                // Update the database with the calculated totals               
                prep = con.prepareStatement(UPDATE_TOTALS);
                prep.setFloat(1, totalTuitionUnits);
                prep.setFloat(2, totalCreditedUnits);
                prep.setFloat(3, tuitionAmount);
                prep.setFloat(4, totalFees);
                prep.setString(5, totalAssessment);
                prep.setInt(6, studentID);
                prep.setString(7, ayTerm);
                prep.executeUpdate();

            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
