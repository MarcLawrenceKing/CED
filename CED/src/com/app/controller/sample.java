import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sample {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        String studentID = "2022-08057-MN-0";  // Example student ID
        generateCOR(studentID);
    }

    public static void generateCOR(String studentID) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Fetch Student Details
            String studentDetailsQuery = "SELECT s.StudentID, s.StudentName, s.AYTerm, p.ProgramDesc, p.ProgramCode, " +
                                         "s.Campus, s.YearLevel, s.Section, s.Address, s.ContactNumber " +
                                         "FROM Student s " +
                                         "JOIN Program p ON s.ProgramCode = p.ProgramCode " +
                                         "WHERE s.StudentID = ?";
            PreparedStatement studentDetailsStmt = connection.prepareStatement(studentDetailsQuery);
            studentDetailsStmt.setString(1, studentID);
            ResultSet studentDetailsRs = studentDetailsStmt.executeQuery();

            if (studentDetailsRs.next()) {
                String studentName = studentDetailsRs.getString("StudentName");
                String ayTerm = studentDetailsRs.getString("AYTerm");
                String programDesc = studentDetailsRs.getString("ProgramDesc");
                String programCode = studentDetailsRs.getString("ProgramCode");
                String campus = studentDetailsRs.getString("Campus");
                String yearLevel = studentDetailsRs.getString("YearLevel");
                String section = studentDetailsRs.getString("Section");
                String address = studentDetailsRs.getString("Address");
                String contactNumber = studentDetailsRs.getString("ContactNumber");

                System.out.println("COR");
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
                String subjectDetailsQuery = "SELECT sc.SubjectCode, su.SubjectTitle, sc.SectionCode, su.TuitionUnits, su.CreditedUnits, sc.Schedule " +
                                             "FROM Schedule sc " +
                                             "JOIN Subject su ON sc.SubjectCode = su.SubjectCode " +
                                             "WHERE sc.StudentID = ? AND sc.AYTerm = ?";
                PreparedStatement subjectDetailsStmt = connection.prepareStatement(subjectDetailsQuery);
                subjectDetailsStmt.setString(1, studentID);
                subjectDetailsStmt.setString(2, ayTerm);
                ResultSet subjectDetailsRs = subjectDetailsStmt.executeQuery();

                System.out.println("SubjectCode | SubjectTitle | SectionCode | TuitionUnits | CreditedUnits | Schedule");
                while (subjectDetailsRs.next()) {
                    System.out.printf("%s | %s | %s | %s | %s | %s%n",
                            subjectDetailsRs.getString("SubjectCode"),
                            subjectDetailsRs.getString("SubjectTitle"),
                            subjectDetailsRs.getString("SectionCode"),
                            subjectDetailsRs.getDouble("TuitionUnits"),
                            subjectDetailsRs.getDouble("CreditedUnits"),
                            subjectDetailsRs.getString("Schedule"));
                }
                System.out.println();

                // Fetch Fees Details
                String feesDetailsQuery = "SELECT f.FeeName, f.Amount " +
                                          "FROM TuitionFees tf " +
                                          "JOIN Fees f ON tf.FeeName = f.FeeName " +
                                          "WHERE tf.StudentID = ? AND tf.AYTerm = ?";
                PreparedStatement feesDetailsStmt = connection.prepareStatement(feesDetailsQuery);
                feesDetailsStmt.setString(1, studentID);
                feesDetailsStmt.setString(2, ayTerm);
                ResultSet feesDetailsRs = feesDetailsStmt.executeQuery();

                System.out.println("FeesName | Amount");
                while (feesDetailsRs.next()) {
                    System.out.printf("%s | %s%n", 
                            feesDetailsRs.getString("FeeName"), 
                            feesDetailsRs.getDouble("Amount"));
                }
                System.out.println();

                // Fetch Tuition Details
                String tuitionDetailsQuery = "SELECT t.MaxUnitsAllowed, t.TotalTuitionUnits, t.TotalCreditedUnits, t.TotalAssessment " +
                                             "FROM Tuition t " +
                                             "WHERE t.StudentID = ? AND t.AYTerm = ?";
                PreparedStatement tuitionDetailsStmt = connection.prepareStatement(tuitionDetailsQuery);
                tuitionDetailsStmt.setString(1, studentID);
                tuitionDetailsStmt.setString(2, ayTerm);
                ResultSet tuitionDetailsRs = tuitionDetailsStmt.executeQuery();

                if (tuitionDetailsRs.next()) {
                    System.out.printf("MaxUnitsAllowed: %s | TotalTuitionUnits: %s | TotalCreditedUnits: %s | TotalAssessment: %s%n",
                            tuitionDetailsRs.getDouble("MaxUnitsAllowed"),
                            tuitionDetailsRs.getDouble("TotalTuitionUnits"),
                            tuitionDetailsRs.getDouble("TotalCreditedUnits"),
                            tuitionDetailsRs.getDouble("TotalAssessment"));
                }
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
