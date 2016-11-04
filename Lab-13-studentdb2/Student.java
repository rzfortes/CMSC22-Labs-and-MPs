import java.io.Serializable;


/*
 * 
 *  created by Christine Catubig and Rica Fortes, 10/14/2016 - 10/15/2016
 *
 */

// error checking: year level up until 6th only
// error checking: middle initial should be one character only, and doesn't need to have period

public class Student implements Serializable {
	
	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
	private String crushName;
	private Course faveSubject;
	
	
	public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course faveSubject) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.course = course;
		this.yearLevel = yearLevel;
		this.crushName = crushName;
		this.faveSubject = faveSubject;
	}
	
	
	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}


	public Course getFaveSubject() {
		return faveSubject;
	}



	public void setFaveSubject(Course faveSubject) {
		this.faveSubject = faveSubject;
	}



	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		if((middleInitial >= 'a' && middleInitial <= 'z') || (middleInitial >= 'A' && middleInitial <= 'Z')) {
			this.middleInitial = middleInitial;
		} else {
			throw new IllegalArgumentException("Invalid Middle Initial");
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		if(yearLevel >= 1 && yearLevel <= 6) {
			this.yearLevel = yearLevel;
		} else {
			throw new IllegalArgumentException("Invalid Year Level!");
		}
	}
	
}
