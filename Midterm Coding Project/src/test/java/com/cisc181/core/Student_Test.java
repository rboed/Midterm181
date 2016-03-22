package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eMajor;

public class Student_Test {
	static ArrayList<Student> Students;
	static ArrayList<Course> Courses;
	static ArrayList<Semester> Semesters;
	static ArrayList<Section> Sections;
	static ArrayList<Enrollment> EnrollmentDesignation;
	
	@BeforeClass
	public static void setup() {
		Students = new ArrayList<Student>(10);
		Calendar cal = Calendar.getInstance();
		Date dob = null;
		Student student = null;
		
		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Ryan", "Daniel", "Boedeker", dob, eMajor.COMPUTERSCIENCE, 
				"96 Loblolly Lane, Bear, DE", "(302) 918-5504", "rboed@udel.edu");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Adam", "John", "Black", dob, eMajor.BUSINESS, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Ben", "Cena", "Black", dob, eMajor.BUSINESS, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Carl", "John", "Black", dob, eMajor.CHEM, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Daniel", "Cena", "Black", dob, eMajor.CHEM, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Ezra", "John", "Black", dob, eMajor.PHYSICS, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Fred", "Cena", "Black", dob, eMajor.PHYSICS, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("George", "John", "Black", dob, eMajor.NURSING, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Harry", "Cena", "Black", dob, eMajor.NURSING, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);

		cal.set(1900, Calendar.JANUARY, 1);
		dob = cal.getTime();
		student = new Student("Israel", "Your-time-is-up-my-time-is-now", "Black", dob, eMajor.COMPUTERSCIENCE, "1241 East Main Street, Stamford, CT", "(111) 111-1111", "Jcena@gmail.com");
		Students.add(student);
		
		Courses = new ArrayList<Course>(3);
		Courses.add(new Course("Chem101", 3, eMajor.CHEM));
		Courses.add(new Course("Chem102", 3, eMajor.CHEM));
		Courses.add(new Course("Chem103", 3, eMajor.CHEM));
		
		Semesters = new ArrayList<Semester>(2);
		cal.set(2015,  Calendar.SEPTEMBER, 1);
		Date startDate = cal.getTime();
		cal.set(2015,  Calendar.DECEMBER, 19);
		Date endDate = cal.getTime();
		Semesters.add(new Semester(startDate, endDate));
		cal.set(2016,  Calendar.FEBRUARY, 8);
		startDate = cal.getTime();
		cal.set(2016,  Calendar.MAY, 26);
		endDate = cal.getTime();
		Semesters.add(new Semester(startDate, endDate));
		UUID fallID = Semesters.get(0).getSemesterID();
		
		Sections = new ArrayList<Section>(6);
		for (Semester s : Semesters) {
			for (Course c : Courses) {
				Sections.add(new Section(c.getCourseID(), s.getSemesterID()));
			}
		}
		
		int i = 0;
		double[] grades = { 4.0, 3.0, 2.0 };
		Enrollment enr = null;
		EnrollmentDesignation = new ArrayList<Enrollment>(60);
		for (Section s: Sections) {
			for (Student stnt : Students) {
				enr = new Enrollment(stnt.getStudentID(), s.getSectionID());
				if (s.getSemesterID() == fallID) {
					enr.setGrade(grades[i % 3]);
				} else {
					enr.setGrade(grades[i % 2]);
				}
				EnrollmentDesignation.add(enr);
				i++;
			}}}

	@Test
	public void testSizes() {
		assertEquals(Students.size(), 10);
		assertEquals(Courses.size(),   3);
		assertEquals(Semesters.size(), 2);
		assertEquals(Sections.size(),  6);
		assertEquals(EnrollmentDesignation.size(),  60);
	}
	
	@Test
	public void testStudentGrades() {
		System.out.println("\nTest of average student grades");
		double[] grades = new double[10];
		int idx = 0;
		for (Student s : Students) {
			System.out.print(s.getFirstName() + " " + s.getLastName());
			int pointSum = 0;
			double gradePointSum = 0.0;
			for (Course c : Courses) { 
				for (Section sec : Sections) {
					if (sec.getCourseID() != c.getCourseID()) {
						continue;
					}
					for (Enrollment e : EnrollmentDesignation) {
						if (e.getStudentID() == s.getStudentID()) {
							pointSum += c.getGradePoints();
							gradePointSum += e.getGrade() * c.getGradePoints();
						}
					}
				}
			}
			double avg = gradePointSum / (double) pointSum;
			grades[idx++] = avg;
		}
		assertEquals(grades[0], 3.5, 0.0001);
		assertEquals(grades[1], 3.0, 0.0001);
		assertEquals(grades[2], 3.5, 0.0001);
		assertEquals(grades[3], 3.0, 0.0001);
		assertEquals(grades[4], 3.5, 0.0001);
		assertEquals(grades[5], 3.0, 0.0001);
		assertEquals(grades[6], 3.5, 0.0001);
		assertEquals(grades[7], 3.0, 0.0001);
		assertEquals(grades[8], 3.5, 0.0001);
		assertEquals(grades[9], 3.0, 0.0001);
	}
	
	// Course Grade Average TODO
	//Could not do
	
	@Test
	public void testMajorChange() {
		System.out.println("\nThe change the major test");
		Student s = Students.get(0);
		System.out.println(s.getFirstName() + " " + s.getMajor());
		assertEquals(s.getMajor(), eMajor.COMPUTERSCIENCE);
		s.setMajor(eMajor.UNDER_WATER_BASKET_WEAVING);
		assertEquals(s.getMajor(), eMajor.UNDER_WATER_BASKET_WEAVING);
		System.out.println(s.getFirstName() + " " + s.getMajor());
	}
}