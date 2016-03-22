package com.cisc181.core;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import exceptions.PersonException;

public class Staff_Test {
	
	public static ArrayList<Staff> testStaff;

	@BeforeClass
	public static void setup() {
		testStaff = new ArrayList<Staff>(5);
		Calendar cal = Calendar.getInstance();
		Date dob = null;
		Date hired = null;
		Staff staff = null;
		
		cal.set(1996, Calendar.OCTOBER, 1, 0, 0, 0);
		dob = cal.getTime();
		cal.set(2015, Calendar.SEPTEMBER, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("Ryan", "Daniel", "Boedeker", dob, "96 Loblolly Lane Bear, DE", "(302)-918-5504","rboed@udel.edu", "Monday 1:00 to 2:00pm", 1, 100000, hired, eTitle.MR);
		testStaff.add(staff);
		
		cal.set(1995, Calendar.FEBRUARY, 1, 0, 0, 0);
		dob = cal.getTime();
		cal.set(2015, Calendar.SEPTEMBER, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("Rachel", "Marie", "Boedeker", dob, "96 Loblolly Lane Bear, DE", "(302)-111-1111","rachel@udel.edu", "Tuesday 1:00 to 2:00pm", 1, 200000, hired, eTitle.MS);
		testStaff.add(staff);
		
		cal.set(1994, Calendar.JUNE, 1, 0, 0, 0);
		dob = cal.getTime();
		cal.set(2015, Calendar.SEPTEMBER, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("Elizabeth", "Anne", "Boedeker", dob, "96 Loblolly Lane Bear, DE", "(302)-222-2222","elizabeth@udel.edu", "Wednesday 1:00 to 2:00pm", 1, 300000, hired, eTitle.MS);
		testStaff.add(staff);
		
		cal.set(1990, Calendar.OCTOBER, 1, 0, 0, 0);
		dob = cal.getTime();
		cal.set(2015, Calendar.SEPTEMBER, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("Rebecca", "Lee", "Boedeker", dob, "96 Loblolly Lane Bear, DE", "(302)-333-3333","rebecca@udel.edu", "Thursday 1:00 to 2:00pm", 1, 400000, hired, eTitle.MS);
		testStaff.add(staff);
		
		cal.set(0001, Calendar.JANUARY, 1, 0, 0, 0);
		dob = cal.getTime();
		cal.set(2015, Calendar.SEPTEMBER, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("John", "Awesome", "Cena", dob, "1241 East Main Street Stamford, CT", "(999)-999-9999","cena@gmail.com", "Friday 1:00 to 1:01pm", 1, 500000, hired, eTitle.MX);
		testStaff.add(staff);
	}

	@Test
	public void testStaffCount() {
		assertEquals(testStaff.size(), 5);
	}
	
	@Test
	public void testAverageSalary() {
		double sum = 0.0;
		int number = 0;
		for (Staff s : testStaff) {
			number++;
			sum += s.getSalary();
		}
		assertEquals(sum / (double) number, 300000.0, 1);
	}
	
	/**
	 * 
	 * @throws PersonException
	 */
	@Test(expected = exceptions.PersonException.class)
	public void dobExceptionTest() throws PersonException {
		Calendar cal = Calendar.getInstance();
		cal.set(2016,  Calendar.JANUARY, 1);
		Date dob = cal.getTime();
		Staff staff = new Staff("John", "", "Cena", dob, "", "(111)-111-1111", "", "", 0, 0, dob, eTitle.MR);
	}
	
	/**
	 * 
	 * @throws PersonException
	 */
	@Test(expected = exceptions.PersonException.class)
	public void phoneNumberExceptionTest() throws PersonException {
		Calendar cal = Calendar.getInstance();
		cal.set(2016,  Calendar.JANUARY, 1);
		Date dob = cal.getTime();
		Staff staff = new Staff("John", "", "Cena", dob, "", "111-1111", "", "", 0, 0, dob, eTitle.MR);
	}
}