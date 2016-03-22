// Ryan Boedeker, 181 Midterm
package com.cisc181.core;

import java.util.UUID;

public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	private Section() {
		this.SectionID = UUID.randomUUID();
	}
	
	/**
	 * @param courseID
	 * @param semesterID
	 */
	public Section(UUID courseID, UUID semesterID) {
		this();
		this.CourseID = courseID;
		this.SemesterID = semesterID;
	}

	/**
	 * @param courseID
	 * @param semesterID
	 * @param roomID
	 */
	public Section(UUID courseID, UUID semesterID, int roomID) {
		this();
		this.CourseID = courseID;
		this.SemesterID = semesterID;
		this.RoomID = roomID;
	}
	
	/**
	 * @return the courseID
	 */
	public UUID getCourseID() {
		return this.CourseID;
	}

	/**
	 * @return the semesterID
	 */
	public UUID getSemesterID() {
		return this.SemesterID;
	}

	/**
	 * @return the sectionID
	 */
	public UUID getSectionID() {
		return this.SectionID;
	}

	/**
	 * @return the roomID
	 */
	public int getRoomID() {
		return this.RoomID;
	}

	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(int roomID) {
		this.RoomID = roomID;
	}
}