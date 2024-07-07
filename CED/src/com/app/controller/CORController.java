/*
 * The CORController class holds CORGenerator functionalities.
 * 
 * This class interconnects with the database thru SQL Queries defined in the QueryConstant class
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.controller;

import com.app.CED.DBConnection;

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

                System.out.printf("%-12s | %-50s | %-12s | %-12s | %-15s | %-20s%n",
                        "SubjectCode", "SubjectTitle", "SectionCode", "TuitionUnits", "CreditedUnits", "Schedule");

                while (result.next()) {
                    System.out.printf("%-12s | %-50s | %-12s | %-12.1f | %-15.1f | %-20s%n",
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

                float totalFees = 0; // Accumulates all Amount associated with the StudentID and AYTerm
                System.out.printf("%-35s | %10s%n", "FeeName", "Amount");
                while (result.next()) {
                    System.out.printf("%-35s | %10.2f%n",
                            result.getString("FeeName"),
                            result.getFloat("Amount"));
                    totalFees += result.getFloat("Amount");
                }

                // Fetch Tuition Details
                prep = con.prepareStatement(TUITION_DETAILS);
                prep.setInt(1, studentID);
                prep.setString(2, ayTerm);
                result = prep.executeQuery();

                float maxUnitsEnrolled = 0;
                float totalTuitionUnits = 0;
                float totalCreditedUnits = 0;
                float tuitionAmountInFloat = 0;
                float totalAssessmentInFloat = 0; // to solve for total assessment
                String tuitionAmount = "";
                String totalAssessment = "";

                if (result.next()) {                    
                    maxUnitsEnrolled = result.getFloat("MaxUnitsEnrolled");
                    totalTuitionUnits = result.getFloat("TotalTuitionUnits");
                    totalCreditedUnits = result.getFloat("TotalCreditedUnits");
                    tuitionAmountInFloat = totalTuitionUnits * 10;
                    if (scholarship.equals("FULL")) {
                        totalAssessment = "FREE"; // free if full scholar
                    }
                    if (scholarship.equals("PARTIAL")) {
                        totalAssessmentInFloat = (totalFees + tuitionAmountInFloat) / 2; // total is divided by 2                 
                        totalAssessment = String.format("%.2f", totalAssessmentInFloat);
                    }
                    if (scholarship.equals("NON-SCHOLAR")) {
                        totalAssessmentInFloat = totalFees + tuitionAmountInFloat; // calculate total assessment
                        totalAssessment = String.format("%.2f", totalAssessmentInFloat);
                    }
                }
                tuitionAmount = String.format("%.2f", tuitionAmountInFloat);
                System.out.println("Tuition Amount                      |     "+tuitionAmount);
                System.out.println();
                
                System.out.printf(
                        "MaxUnitsEnrolled: %-12.1f | TotalTuitionUnits: %-12.1f | TotalCreditedUnits: %-12.1f | TotalAssessment: %-20s%n",
                        maxUnitsEnrolled, totalTuitionUnits, totalCreditedUnits, totalAssessment);

                // Update the database with the calculated totals
                prep = con.prepareStatement(UPDATE_TOTALS);
                prep.setFloat(1, totalTuitionUnits);
                prep.setFloat(2, totalCreditedUnits);
                prep.setFloat(3, tuitionAmountInFloat);
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
