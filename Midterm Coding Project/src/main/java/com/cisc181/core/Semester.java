package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

public class Semester {
	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;
	
	/**
	 * @param startDate
	 * @param endDate
	 */
	public Semester(Date startDate, Date endDate) {
		super();
		this.SemesterID = UUID.randomUUID();
		this.StartDate = startDate;
		this.EndDate = endDate;
	}

	/**
	 * @return the semesterID
	 */
	public UUID getSemesterID() {
		return this.SemesterID;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return this.StartDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return this.EndDate;
	}
}