// Ryan Boedeker, 181 Midterm
package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;
	
	
	public Course(String name, int gradePoints, eMajor major) {
		this.CourseID = UUID.randomUUID();
		this.CourseName = name;
		this.GradePoints = gradePoints;
		this.Major = major;
	}

	/**
	 * @return the courseID
	 */
	public UUID getCourseID() {
		return this.CourseID;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return this.CourseName;
	}

	/**
	 * @return the gradePoints
	 */
	public int getGradePoints() {
		return this.GradePoints;
	}

	/**
	 * @return the major
	 */
	public eMajor getMajor() {
		return this.Major;
	}
}