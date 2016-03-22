package com.cisc181.core;
import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment(){
		this.EnrollmentID = UUID.randomUUID();
	}
	
	Enrollment(UUID StudentID, UUID SectionID){
		this();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
	}
	
	/**
	 * @return the sectionID
	 */
	public UUID getSectionID() {
		return this.SectionID;
	}

	/**
	 * @return the studentID
	 */
	public UUID getStudentID() {
		return this.StudentID;
	}

	/**
	 * @return the enrollmentID
	 */
	public UUID getEnrollmentID() {
		return this.EnrollmentID;
	}

	/**
	 * @return the grade
	 */
	public double getGrade() {
		return this.Grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(double grade) {
		this.Grade = grade;
	}
}