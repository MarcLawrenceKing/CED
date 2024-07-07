-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2024 at 10:16 AM
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
('2023-2024 First Sem'),
('2023-2024 Second Sem');

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
(7, 240006, 5, '2023-2024 First Sem'),
(8, 240006, 6, '2023-2024 First Sem'),
(9, 240006, 7, '2023-2024 First Sem'),
(10, 240006, 8, '2023-2024 First Sem'),
(11, 240006, 9, '2023-2024 First Sem'),
(12, 240006, 10, '2023-2024 First Sem'),
(13, 240006, 11, '2023-2024 First Sem'),
(14, 240006, 12, '2023-2024 First Sem'),
(15, 240006, 13, '2023-2024 First Sem'),
(16, 240006, 14, '2023-2024 Second Sem'),
(17, 240006, 15, '2023-2024 Second Sem'),
(18, 240006, 16, '2023-2024 Second Sem'),
(19, 240006, 17, '2023-2024 Second Sem'),
(20, 240006, 18, '2023-2024 Second Sem'),
(21, 240006, 19, '2023-2024 Second Sem'),
(23, 240006, 21, '2023-2024 Second Sem'),
(24, 240006, 22, '2023-2024 Second Sem'),
(25, 240003, 24, '2023-2024 Second Sem'),
(26, 240003, 23, '2023-2024 Second Sem'),
(27, 240003, 16, '2023-2024 Second Sem'),
(28, 240003, 17, '2023-2024 Second Sem'),
(29, 240003, 18, '2023-2024 Second Sem'),
(30, 240003, 19, '2023-2024 Second Sem'),
(31, 240003, 22, '2023-2024 Second Sem'),
(32, 240003, 21, '2023-2024 Second Sem'),
(33, 240002, 25, '2023-2024 First Sem'),
(34, 240002, 26, '2023-2024 First Sem'),
(35, 240002, 27, '2023-2024 First Sem'),
(36, 240002, 28, '2023-2024 First Sem'),
(37, 240002, 29, '2023-2024 First Sem'),
(38, 240002, 30, '2023-2024 First Sem'),
(39, 240002, 31, '2023-2024 First Sem'),
(40, 240002, 32, '2023-2024 First Sem'),
(41, 240002, 33, '2023-2024 Second Sem'),
(42, 240002, 34, '2023-2024 Second Sem'),
(43, 240002, 35, '2023-2024 Second Sem'),
(44, 240002, 36, '2023-2024 Second Sem'),
(45, 240002, 37, '2023-2024 Second Sem'),
(46, 240002, 38, '2023-2024 Second Sem'),
(47, 240002, 39, '2023-2024 Second Sem'),
(48, 240002, 40, '2023-2024 Second Sem'),
(49, 240001, 35, '2023-2024 Second Sem'),
(50, 240001, 36, '2023-2024 Second Sem'),
(51, 240001, 37, '2023-2024 Second Sem'),
(52, 240001, 38, '2023-2024 Second Sem'),
(53, 240001, 39, '2023-2024 Second Sem'),
(54, 240001, 40, '2023-2024 Second Sem'),
(55, 240001, 41, '2023-2024 Second Sem');

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
('SPORTS RELATED TRAINING FEE', '250.00'),
('STUDENT COUNCIL FEE', '53.00');

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
(5, 'COSC-FE1', 'BSCS 2-1', 'W/S 19:30:00-21:00:00 LEC', '2023-2024 First Sem'),
(6, 'COMP 20063', 'BSCS 2-1', 'F 10:30:00-13:30:00 LAB F/T 19:30:00-20:30:00 LEC', '2023-2024 First Sem'),
(7, 'COMP 20073', 'BSCS 2-1', 'T 15:00:00-18:00:00 LEC', '2023-2024 First Sem'),
(8, 'GEED 10093', 'BSCS 2-1', 'W/S 13:30:00-15:00:00 LEC', '2023-2024 First Sem'),
(9, 'COSC 30023', 'BSCS 2-1', 'W 09:00:00-12:00:00 LEC', '2023-2024 First Sem'),
(10, 'COSC 30013', 'BSCS 2-1', 'F 15:00:00-18:00:00 LEC', '2023-2024 First Sem'),
(11, 'COMP 20083', 'BSCS 2-1', 'S 07:30:00-10:30:00 LAB S 10:30:00-12:30:00 LEC', '2023-2024 First Sem'),
(12, 'PHED 10032', 'BSCS 2-1', 'T 10:00:00-12:00:00 LEC', '2023-2024 First Sem'),
(13, 'GEED 10223', 'BSCS 2-1', 'S 15:00:00-18:00:00 LEC', '2023-2024 First Sem'),
(14, 'COMP 20093', 'BSCS 2-1', 'F 12:00:00-14:00:00 LEC T 12:00:00-15:00:00 LAB', '2023-2024 Second Sem'),
(15, 'COMP 20103', 'BSCS 2-1', 'F 07:30:00-09:30:00 LEC T 07:30:00-10:30:00 LAB', '2023-2024 Second Sem'),
(16, 'COMP 20113', 'BSCS 2-1', 'M/TH 10:30:00-12:00:00 LEC', '2023-2024 Second Sem'),
(17, 'COSC 30033', 'BSCS 2-1', 'M 16:30:00-19:30:00 LEC', '2023-2024 Second Sem'),
(18, 'COSC-FE2', 'BSCS 2-1', 'M 12:00:00-15:00:00 LEC', '2023-2024 Second Sem'),
(19, 'GEED 10073', 'BSCS 2-1', 'TH 12:00:00-15:00:00 LEC', '2023-2024 Second Sem'),
(21, 'PHED 10042', 'BSCS 2-1', 'W 14:00:00-16:00:00 LEC', '2023-2024 Second Sem'),
(22, 'GEED 20113', 'BSCS 2-1', 'TH 16:30:00-19:30:00 LEC', '2023-2024 Second Sem'),
(23, 'COMP 20093', 'BSCS 2-2', 'M 12:00:00-14:00:00 LEC W 12:00:00-15:00:00 LAB', '2023-2024 Second Sem'),
(24, 'COMP 20103', 'BSCS 2-2', 'M 07:30:00-09:30:00 LEC W 07:30:00-10:30:00 LAB', '2023-2024 Second Sem'),
(25, 'COMP 006', 'BSIT 2-3', 'W 07:30:00-09:30:00 LEC W 10:30:00-13:30:00 LAB', '2023-2024 First Sem'),
(26, 'COMP 007', 'BSIT 2-3', 'F 13:30:00-16:30:00 LAB T 14:30:00-16:30:00 LEC', '2023-2024 First Sem'),
(27, 'COMP 008', 'BSIT 2-3', 'W 13:30:00-16:30:00 LAB S 16:30:00-18:30:00 LEC', '2023-2024 First Sem'),
(28, 'ELEC IT-FE1', 'BSIT 2-3', 'T 10:30:00-13:30:00 LEC', '2023-2024 First Sem'),
(29, 'GEED 001', 'BSIT 2-3', 'T 07:30:00-10:30:00 LEC', '2023-2024 First Sem'),
(30, 'GEED 028', 'BSIT 2-3', 'F 07:30:00-10:30:00 LEC', '2023-2024 First Sem'),
(31, 'INTE 201', 'BSIT 2-3', 'S 07:30:00-10:30:00 LAB S 10:30:00-12:30:00 LEC', '2023-2024 First Sem'),
(32, 'PATHFIT 3', 'BSIT 2-3', 'S 13:00:00-15:00:00 LEC', '2023-2024 First Sem'),
(33, 'COMP 009', 'BSIT 2-3', 'W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC', '2023-2024 Second Sem'),
(34, 'COMP 010', 'BSIT 2-3', 'F 16:30:00-18:30:00 LEC T 16:30:00-19:30:00 LAB', '2023-2024 Second Sem'),
(35, 'COMP 012', 'BSIT 2-3', 'F 12:00:00-14:00:00 LEC T 12:00:00-15:00:00 LAB', '2023-2024 Second Sem'),
(36, 'COMP 013', 'BSIT 2-3', 'S 18:00:00-21:00:00 LEC', '2023-2024 Second Sem'),
(37, 'COMP 014', 'BSIT 2-3', 'S 15:00:00-18:00:00 LEC', '2023-2024 Second Sem'),
(38, 'ELEC IT-FE2', 'BSIT 2-3', 'T/F 19:30:00-21:00:00 LEC', '2023-2024 Second Sem'),
(39, 'INTE 202', 'BSIT 2-3', 'F 09:00:00-11:00:00 LEC T 09:00:00-12:00:00 LAB', '2023-2024 Second Sem'),
(40, 'PATHFIT 4', 'BSIT 2-3', 'W 13:00:00-15:00:00 LEC', '2023-2024 Second Sem'),
(41, 'COMP 003', 'BSIT 1-3', 'W 09:00:00-12:00:00 LAB S 10:00:00-12:00:00 LEC', '2023-2024 Second Sem');

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
('BSCS 2-1'),
('BSCS 2-2'),
('BSIT 1-3'),
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
(240002, '2023-2024 First Sem', 'FULL', 'BSIT', 'Sheila Mae Orapa', '09234567891', '234 Cornelia St Brgy San Miguel Manila City', 'Second Year', '3', 'Manila'),
(240003, '2023-2024 Second Sem', 'NON-SCHOLAR', 'BSCS', 'Dominic Syd Aldas', '09887778888', '234 New Mexico Brgy 145 Gotham City', 'Second Year', '3', 'Manila'),
(240006, '2023-2024 Second Sem', 'NON-SCHOLAR', 'BSCS', 'Norjanah A. King', '09876543219', '69th Street Tanza Market Imus Cavite', 'Second Year', '1', 'Manila');

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
('COMP 003', 'Computer Programming 2', '5.0', '3.0'),
('COMP 006', 'Data Structures and Algorithms', '5.0', '3.0'),
('COMP 007', 'Operating Systems', '5.0', '3.0'),
('COMP 008', 'Data Communications and Networking', '5.0', '3.0'),
('COMP 009', 'Object Oriented Programming', '5.0', '3.0'),
('COMP 010', 'Information Management', '5.0', '3.0'),
('COMP 012', 'Network Administration', '5.0', '3.0'),
('COMP 013', 'Human Computer Interaction', '3.0', '3.0'),
('COMP 014', 'Quantitative Methods with Modeling and Simulation', '3.0', '3.0'),
('COMP 20063', 'Data Structures and Algorithms', '5.0', '3.0'),
('COMP 20073', 'Discrete Structures 2', '3.0', '3.0'),
('COMP 20083', 'Object Oriented Programming', '5.0', '3.0'),
('COMP 20093', 'Information Management', '5.0', '3.0'),
('COMP 20103', 'Operating Systems', '5.0', '3.0'),
('COMP 20113', 'Technical Documentation and Presentation Skills in ICT', '3.0', '3.0'),
('COSC 30013', 'Modeling and Simulation', '3.0', '3.0'),
('COSC 30023', 'Logic Design and Digital Computer Circuits', '3.0', '3.0'),
('COSC 30033', 'Design and Analysis of Algorithms', '3.0', '3.0'),
('COSC-FE1', 'CS Free Elective 1', '3.0', '3.0'),
('COSC-FE2', 'CS Free Elective 2', '3.0', '3.0'),
('ELEC IT-FE1', 'BSIT Free Elective 1', '3.0', '3.0'),
('ELEC IT-FE2', 'BSIT Free Elective 2', '3.0', '3.0'),
('GEED 001', 'Understanding the Self/Pag-unawa sa Sarili', '3.0', '3.0'),
('GEED 028', 'Reading Visual Arts', '3.0', '3.0'),
('GEED 10073', 'Art Appreciation', '3.0', '3.0'),
('GEED 10093', 'Ethics', '3.0', '3.0'),
('GEED 10223', 'World Literature', '3.0', '3.0'),
('GEED 20113', 'People and the Earth`s Ecosystem', '3.0', '3.0'),
('INTE 201', 'Programming 3 (Structured Programming)', '5.0', '3.0'),
('INTE 202', 'Integrative Programming and Technologies', '5.0', '3.0'),
('PATHFIT 3', 'Physical Activity Towards Health and Fitness 3', '2.0', '2.0'),
('PATHFIT 4', 'Physical Activity Towards Health and Fitness', '2.0', '2.0'),
('PHED 10032', 'Individual/Dual/Combative Sports', '2.0', '2.0'),
('PHED 10042', 'Team Sports', '2.0', '2.0');

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
(1, 240001, '2023-2024 Second Sem', '26.0', '20.0', '260.00', '3146.00', '3406.00'),
(2, 240003, '2023-2024 Second Sem', '27.0', '23.0', '270.00', '3146.00', '3416.00'),
(3, 240002, '2023-2024 First Sem', '31.0', '23.0', '310.00', '3146.00', 'FREE'),
(4, 240006, '2023-2024 First Sem', '30.0', '26.0', '300.00', '3146.00', '3446.00'),
(5, 240006, '2023-2024 Second Sem', '27.0', '23.0', '270.00', '3146.00', '3416.00'),
(6, 240002, '2023-2024 Second Sem', '31.0', '23.0', '310.00', '3146.00', 'FREE');

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
(1, 4, 'CULTURAL FEE'),
(2, 4, 'GUIDANCE FEE'),
(4, 4, 'INSURANCE'),
(5, 4, 'LABORATORY FEE'),
(6, 4, 'LIBRARY FEE'),
(7, 4, 'MEDICAL AND DENTAL FEE'),
(8, 4, 'PUBLICATION FEE'),
(9, 4, 'REGISTRATION FEE'),
(10, 4, 'SIS FEE'),
(11, 4, 'SPORTS DEV FEE'),
(12, 4, 'SPORTS PARTICIPATION FEE'),
(13, 4, 'SPORTS RELATED TRAINING FEE'),
(14, 4, 'STUDENT COUNCIL FEE'),
(15, 5, 'CULTURAL FEE'),
(16, 5, 'GUIDANCE FEE'),
(17, 5, 'INSURANCE'),
(18, 5, 'LABORATORY FEE'),
(19, 5, 'LIBRARY FEE'),
(20, 5, 'MEDICAL AND DENTAL FEE'),
(21, 5, 'PUBLICATION FEE'),
(22, 5, 'REGISTRATION FEE'),
(23, 5, 'SIS FEE'),
(24, 5, 'SPORTS DEV FEE'),
(25, 5, 'SPORTS PARTICIPATION FEE'),
(27, 5, 'STUDENT COUNCIL FEE'),
(29, 5, 'SPORTS RELATED TRAINING FEE'),
(30, 2, 'CULTURAL FEE'),
(31, 2, 'GUIDANCE FEE'),
(32, 2, 'INSURANCE'),
(33, 2, 'LABORATORY FEE'),
(34, 2, 'LIBRARY FEE'),
(35, 2, 'MEDICAL AND DENTAL FEE'),
(36, 2, 'PUBLICATION FEE'),
(37, 2, 'REGISTRATION FEE'),
(38, 2, 'SIS FEE'),
(39, 2, 'SPORTS DEV FEE'),
(40, 2, 'SPORTS PARTICIPATION FEE'),
(41, 2, 'SPORTS RELATED TRAINING FEE'),
(42, 2, 'STUDENT COUNCIL FEE'),
(43, 3, 'CULTURAL FEE'),
(44, 3, 'GUIDANCE FEE'),
(45, 3, 'INSURANCE'),
(46, 3, 'LABORATORY FEE'),
(47, 3, 'LIBRARY FEE'),
(48, 3, 'MEDICAL AND DENTAL FEE'),
(49, 3, 'PUBLICATION FEE'),
(50, 3, 'REGISTRATION FEE'),
(51, 3, 'SIS FEE'),
(52, 3, 'SPORTS DEV FEE'),
(53, 3, 'SPORTS PARTICIPATION FEE'),
(54, 3, 'SPORTS RELATED TRAINING FEE'),
(55, 3, 'STUDENT COUNCIL FEE'),
(56, 6, 'CULTURAL FEE'),
(57, 6, 'GUIDANCE FEE'),
(58, 6, 'INSURANCE'),
(59, 6, 'LABORATORY FEE'),
(60, 6, 'LIBRARY FEE'),
(61, 6, 'MEDICAL AND DENTAL FEE'),
(62, 6, 'PUBLICATION FEE'),
(63, 6, 'REGISTRATION FEE'),
(64, 6, 'SIS FEE'),
(65, 6, 'SPORTS DEV FEE'),
(66, 6, 'SPORTS PARTICIPATION FEE'),
(67, 6, 'SPORTS RELATED TRAINING FEE'),
(68, 6, 'STUDENT COUNCIL FEE'),
(69, 1, 'CULTURAL FEE'),
(70, 1, 'GUIDANCE FEE'),
(71, 1, 'INSURANCE'),
(72, 1, 'LABORATORY FEE'),
(73, 1, 'LIBRARY FEE'),
(74, 1, 'MEDICAL AND DENTAL FEE'),
(75, 1, 'PUBLICATION FEE'),
(76, 1, 'REGISTRATION FEE'),
(77, 1, 'SIS FEE'),
(78, 1, 'SPORTS DEV FEE'),
(79, 1, 'SPORTS PARTICIPATION FEE'),
(80, 1, 'SPORTS RELATED TRAINING FEE'),
(81, 1, 'STUDENT COUNCIL FEE');

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
  MODIFY `EnrollmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `ScheduleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=240007;

--
-- AUTO_INCREMENT for table `tuition`
--
ALTER TABLE `tuition`
  MODIFY `TuitionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tuitionfees`
--
ALTER TABLE `tuitionfees`
  MODIFY `TuitionFeesID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

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
