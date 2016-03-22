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
		cal.set(2016,  Calendar.SEPTEMBER, 1);
		Date startDate = cal.getTime();
		cal.set(2016,  Calendar.JANUARY, 1);
		Date endDate = cal.getTime();
		Semesters.add(new Semester(startDate, endDate));
		cal.set(2017,  Calendar.SEPTEMBER, 1);
		startDate = cal.getTime();
		cal.set(2017,  Calendar.JANUARY, 1);
		endDate = cal.getTime();
		Semesters.add(new Semester(startDate, endDate));
		UUID fallID = Semesters.get(0).getSemesterID();
		
		Sections = new ArrayList<Section>(6);
		for (Semester semester : Semesters) {
			for (Course course : Courses) {
				Sections.add(new Section(course.getCourseID(), semester.getSemesterID()));
			}
		}

	// Course Grade Average and Student's GPA TODO
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