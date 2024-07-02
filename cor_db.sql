-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2024 at 09:11 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cor_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `ayterm`
--

CREATE TABLE `ayterm` (
  `AYTerm` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ayterm`
--

INSERT INTO `ayterm` (`AYTerm`) VALUES
('2022-2023 First Sem'),
('2023-2024 First Sem'),
('2023-2024 Second Sem'),
('2023-2024 Third Sem');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `EnrollmentID` int(11) NOT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `ScheduleID` int(11) DEFAULT NULL,
  `AYTerm` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`EnrollmentID`, `StudentID`, `ScheduleID`, `AYTerm`) VALUES
(1, 240001, 1, '2023-2024 Second Sem'),
(2, 240001, 2, '2023-2024 Second Sem'),
(3, 240002, 1, '2023-2024 Second Sem');

-- --------------------------------------------------------

--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `FeeName` varchar(50) NOT NULL,
  `Amount` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fees`
--

INSERT INTO `fees` (`FeeName`, `Amount`) VALUES
('CULTURAL FEE', '79.00'),
('GUIDANCE FEE', '50.00'),
('INSURANCE', '50.00'),
('LABORATORY FEE', '1268.00'),
('LIBRARY FEE', '213.00'),
('MEDICAL AND DENTAL FEE', '175.00'),
('PUBLICATION FEE', '100.00'),
('REGISTRATION FEE', '125.00'),
('SIS FEE', '383.00'),
('SPORTS DEV FEE', '150.00'),
('SPORTS PARTICIPATION FEE', '250.00'),
('SPORTS RELATED TRAINING FEE', '250.00');

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

CREATE TABLE `program` (
  `ProgramCode` varchar(10) NOT NULL,
  `ProgramDesc` varchar(25) DEFAULT NULL,
  `MaxUnitsEnrolled` decimal(5,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `program`
--

INSERT INTO `program` (`ProgramCode`, `ProgramDesc`, `MaxUnitsEnrolled`) VALUES
('BSCS', 'BS Computer Science', '23.0'),
('BSIT', 'BS Information Technology', '23.0');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `ScheduleID` int(11) NOT NULL,
  `SubjectCode` varchar(12) DEFAULT NULL,
  `SectionCode` varchar(15) DEFAULT NULL,
  `Schedule` varchar(255) DEFAULT NULL,
  `AYTerm` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`ScheduleID`, `SubjectCode`, `SectionCode`, `Schedule`, `AYTerm`) VALUES
(1, 'COMP 009', 'BSIT 2-3', 'W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC', '2023-2024 Second Sem'),
(2, 'COMP 010', 'BSIT 2-3', 'F 16:30:00-18:30:00 LEC T 16:30:00-19:30:00 LAB', '2023-2024 Second Sem'),
(4, 'COMP 006', 'BSIT 2-1', 'hehe', '2022-2023 First Sem');

-- --------------------------------------------------------

--
-- Table structure for table `scholarship`
--

CREATE TABLE `scholarship` (
  `Scholarship` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scholarship`
--

INSERT INTO `scholarship` (`Scholarship`) VALUES
('FULL'),
('NON-SCHOLAR'),
('PARTIAL');

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

CREATE TABLE `section` (
  `SectionCode` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`SectionCode`) VALUES
('BSIT 2-1'),
('BSIT 2-2'),
('BSIT 2-3');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `AYTerm` varchar(30) DEFAULT NULL,
  `Scholarship` varchar(20) DEFAULT NULL,
  `ProgramCode` varchar(15) DEFAULT NULL,
  `StudentName` varchar(50) DEFAULT NULL,
  `ContactNumber` varchar(11) DEFAULT NULL,
  `Address` varchar(120) DEFAULT NULL,
  `YearLevel` varchar(15) DEFAULT NULL,
  `Section` varchar(2) DEFAULT NULL,
  `Campus` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentID`, `AYTerm`, `Scholarship`, `ProgramCode`, `StudentName`, `ContactNumber`, `Address`, `YearLevel`, `Section`, `Campus`) VALUES
(240001, '2023-2024 Second Sem', 'NON-SCHOLAR', 'BSIT', 'Kyle Cedric Mangasi', '09157283461', '8700 McDollibee Street Brgy 177 Bagong Gising Quezon City', 'Second Year', '3', 'Manila'),
(240002, '2023-2024 Second Sem', 'FULL', 'BSIT', 'Sheila Mae Orapa', '09234567891', '234 Cornelia St Brgy San Miguel Manila City', 'Second Year', '3', 'Manila'),
(240003, '2023-2024 Second Sem', 'FULL', 'BSIT', 'Dominic Syd Aldas', '09887778888', '234 New Mexico Brgy 145 Gotham City', 'Second Year', '3', 'Manila'),
(240004, '2023-2024 First Sem', 'NON-SCHOLAR', 'BSCS', 'Baka Renejay To', '231231', 'Bataan', 'First Year', '2', 'Manila');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `SubjectCode` varchar(12) NOT NULL,
  `SubjectTitle` varchar(100) DEFAULT NULL,
  `TuitionUnits` decimal(5,1) DEFAULT NULL,
  `CreditedUnits` decimal(5,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`SubjectCode`, `SubjectTitle`, `TuitionUnits`, `CreditedUnits`) VALUES
('COMP 006', 'Data Structures and Algorithms', '3.0', '5.0'),
('COMP 007', 'Operating Systems', '3.0', '5.0'),
('COMP 008', 'Data Communications and Networking', '3.0', '5.0'),
('COMP 009', 'Object Oriented Programming', '5.0', '3.0'),
('COMP 010', 'Information Management', '5.0', '3.0'),
('COMP 012', 'Network Administration', '5.0', '3.0'),
('COMP 013', 'Human Computer Interaction', '3.0', '3.0'),
('COMP 014', 'Quantitative Methods with Modeling and Simulation', '3.0', '3.0'),
('COMP 20073', 'Discrete Structures 2', '3.0', NULL),
('COMP 20113', 'Technical Documentation and Presentation Skills in ICT', '3.0', NULL),
('COMP 30023', 'Logic Design and Digital Computer Circuits', '3.0', NULL),
('COSC 30013', 'Modeling and Simulation', '3.0', NULL),
('COSC 30033', 'Design and Analysis of Algorithms', '3.0', NULL),
('COSC-FE1', 'CS Free Elective 1', '3.0', NULL),
('COSC-FE2', 'CS Free Elective 2', '3.0', NULL),
('ELEC IT-FE1', 'BSIT Free Elective 1', '3.0', '5.0'),
('ELECT IT-FE2', 'BSIT Free Elective 2', '3.0', '3.0'),
('GEED 001', 'Understanding the Self/Pag-unawa sa Sarili', '3.0', '5.0'),
('GEED 028', 'Reading Visual Arts', '3.0', '5.0'),
('GEED 10073', 'Art Appreciation', '3.0', NULL),
('GEED 10093', 'Ethics', '3.0', NULL),
('GEED 10223', 'World Literature', '3.0', NULL),
('GEED 20113', 'People and the Earth`s Ecosystem', '3.0', NULL),
('INTE 201', 'Programming 3 (Structured Programming)', '3.0', '5.0'),
('INTE 202', 'Integrative Programming and Technologies', '5.0', '3.0'),
('PATHFIT 3', 'Physical Activity Towards Health and Fitness 3', '2.0', NULL),
('PATHFIT 4', 'Physical Activity Towards Health and Fitness', '2.0', '2.0'),
('PHED 03', 'Physical Education 3', '2.0', NULL),
('PHED 04', 'Physical Education 4', '2.0', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tuition`
--

CREATE TABLE `tuition` (
  `TuitionID` int(11) NOT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `AYTerm` varchar(30) DEFAULT NULL,
  `TotalTuitionUnits` decimal(5,1) DEFAULT NULL,
  `TotalCreditedUnits` decimal(5,1) DEFAULT NULL,
  `TuitionAmount` decimal(10,2) DEFAULT NULL,
  `TotalFees` decimal(10,2) DEFAULT NULL,
  `TotalAssessment` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tuition`
--

INSERT INTO `tuition` (`TuitionID`, `StudentID`, `AYTerm`, `TotalTuitionUnits`, `TotalCreditedUnits`, `TuitionAmount`, `TotalFees`, `TotalAssessment`) VALUES
(1, 240001, '2023-2024 Second Sem', '10.0', '6.0', '100.00', '129.00', '229.0'),
(2, 240003, '2023-2024 Second Sem', NULL, NULL, NULL, NULL, NULL),
(3, 240002, '2023-2024 Second Sem', '0.0', '0.0', '0.00', '0.00', '0.00');

-- --------------------------------------------------------

--
-- Table structure for table `tuitionfees`
--

CREATE TABLE `tuitionfees` (
  `TuitionFeesID` int(11) NOT NULL,
  `TuitionID` int(11) DEFAULT NULL,
  `FeeName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tuitionfees`
--

INSERT INTO `tuitionfees` (`TuitionFeesID`, `TuitionID`, `FeeName`) VALUES
(1, 1, 'CULTURAL FEE'),
(2, 1, 'GUIDANCE FEE'),
(4, 2, 'GUIDANCE FEE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ayterm`
--
ALTER TABLE `ayterm`
  ADD PRIMARY KEY (`AYTerm`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`EnrollmentID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `ScheduleID` (`ScheduleID`),
  ADD KEY `AYTerm` (`AYTerm`);

--
-- Indexes for table `fees`
--
ALTER TABLE `fees`
  ADD PRIMARY KEY (`FeeName`);

--
-- Indexes for table `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`ProgramCode`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`ScheduleID`),
  ADD KEY `SubjectCode` (`SubjectCode`),
  ADD KEY `SectionCode` (`SectionCode`),
  ADD KEY `schedule_ibfk_3` (`AYTerm`);

--
-- Indexes for table `scholarship`
--
ALTER TABLE `scholarship`
  ADD PRIMARY KEY (`Scholarship`);

--
-- Indexes for table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`SectionCode`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`),
  ADD KEY `AYTerm` (`AYTerm`),
  ADD KEY `Scholarship` (`Scholarship`),
  ADD KEY `ProgramCode` (`ProgramCode`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`SubjectCode`);

--
-- Indexes for table `tuition`
--
ALTER TABLE `tuition`
  ADD PRIMARY KEY (`TuitionID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `AYTerm` (`AYTerm`);

--
-- Indexes for table `tuitionfees`
--
ALTER TABLE `tuitionfees`
  ADD PRIMARY KEY (`TuitionFeesID`),
  ADD KEY `TuitionID` (`TuitionID`),
  ADD KEY `FeeName` (`FeeName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `EnrollmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `ScheduleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=240005;

--
-- AUTO_INCREMENT for table `tuition`
--
ALTER TABLE `tuition`
  MODIFY `TuitionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tuitionfees`
--
ALTER TABLE `tuitionfees`
  MODIFY `TuitionFeesID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`),
  ADD CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`ScheduleID`) REFERENCES `schedule` (`ScheduleID`),
  ADD CONSTRAINT `enrollment_ibfk_3` FOREIGN KEY (`AYTerm`) REFERENCES `ayterm` (`AYTerm`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`SubjectCode`) REFERENCES `subject` (`SubjectCode`),
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`SectionCode`) REFERENCES `section` (`SectionCode`),
  ADD CONSTRAINT `schedule_ibfk_3` FOREIGN KEY (`AYTerm`) REFERENCES `ayterm` (`AYTerm`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`AYTerm`) REFERENCES `ayterm` (`AYTerm`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`Scholarship`) REFERENCES `scholarship` (`Scholarship`),
  ADD CONSTRAINT `student_ibfk_3` FOREIGN KEY (`ProgramCode`) REFERENCES `program` (`ProgramCode`);

--
-- Constraints for table `tuition`
--
ALTER TABLE `tuition`
  ADD CONSTRAINT `tuition_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`),
  ADD CONSTRAINT `tuition_ibfk_2` FOREIGN KEY (`AYTerm`) REFERENCES `ayterm` (`AYTerm`);

--
-- Constraints for table `tuitionfees`
--
ALTER TABLE `tuitionfees`
  ADD CONSTRAINT `tuitionfees_ibfk_1` FOREIGN KEY (`TuitionID`) REFERENCES `tuition` (`TuitionID`),
  ADD CONSTRAINT `tuitionfees_ibfk_2` FOREIGN KEY (`FeeName`) REFERENCES `fees` (`FeeName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
