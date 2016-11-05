/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb2;

/**
 *
 * @author rdfortes, modified 3:18 pm, 11/5/2016
 */
import java.io.Serializable;


public class Course implements Serializable {
	
	private String courseCode;
	private String courseDescription;
	
	public Course(String courseCode, String courseDescription) {
		this.courseCode = courseCode;
		this.courseDescription = courseDescription;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
}
