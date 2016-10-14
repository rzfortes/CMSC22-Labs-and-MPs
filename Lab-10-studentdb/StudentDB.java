import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

// look for imports for file reading and writing then replace 'import java.io.*' :)
//import java.io.File;
//import java.io.IOException;
//import java.io.BufferedWriter;


public class StudentDB {
	public static void main(String[] args) throws IOException, InterruptedException {
		List<Student> list = new ArrayList<Student>();
		
		//initial students
		//Student a = new Student("201418167", "Christine Anne", 'I', "CaH2O", "BS Komsai", 3);
		//Student b = new Student("201460013", "Ricafelle Dorothy", 'Z', "Fortes", "BS CompSci", 3);
		//list.add(a);
		//list.add(b);
		
		int choice = 0;
		while(choice != 5){
			System.out.println("\n\t1. Register a student\n\t2. Retrieve student information\n\t3. Unenroll a student\n\t4. Save file\n\t5. Exit");
			System.out.print("\n\n\tUser enter your choice: ");
			
			Scanner sc = new Scanner(System.in);
			choice = Integer.parseInt(sc.nextLine());
			System.out.println();
			//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
			String studNum, fName, lName, curse;
			int yrLevel;
			char midIn;
			
			switch(choice){
			
			// register a student
			case 1:
				
				System.out.print("Student Number: ");
				studNum = sc.nextLine();
				System.out.println(studNum);
				
				if(!list.contains(studNum)){
					System.out.print("First Name: ");
					fName = sc.nextLine();
					System.out.println();
					System.out.print("Middle Initial: ");
					midIn = sc.nextLine().charAt(0);
					System.out.println();
					System.out.print("Last Name: ");
					lName = sc.nextLine();
					System.out.println();
					System.out.print("Program: ");
					curse = sc.nextLine();
					System.out.println();
					System.out.print("Year Level: ");
					yrLevel = Integer.parseInt(sc.nextLine());
					System.out.println();
					
					Student student = new Student(studNum, fName, midIn, lName, curse, yrLevel);
					if(list.add(student)){
					System.out.println("\nStudent added!"); //yeeyyy
					
					for(int i = 0; i < list.size(); i++) {
						if(list.get(i).getStudentNumber() == studNum) {
							for(Student s: list) {
								System.out.println("Student Number: " + s.getStudentNumber());
								System.out.println("Name: " + s.getLastName() + ", " + s.getFirstName() + " " + s.getMiddleInitial() + ".");
								System.out.println("Program: " + s.getCourse());
								System.out.println("Year Level: " + s.getYearLevel());
							}
						}
					}
					}
				}else{
					System.out.println("Student already enrolled!");
				}
				break;
				
			// retrieve student information using student number
			case 2:
				int flag = 0;
				System.out.print("Search Student: ");
				studNum = sc.nextLine();
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getStudentNumber().compareTo(studNum) == 0) {
						Student s = list.get(i);
						System.out.println("Student Number: " + s.getStudentNumber());
						System.out.println("Name: " + s.getLastName() + ", " + s.getFirstName() + " " + s.getMiddleInitial() + ".");
						System.out.println("Program: " + s.getCourse());
						System.out.println("Year Level: " + s.getYearLevel());
						flag = 1;
						break;
					}
				}
				if(flag == 0){
				System.out.println("Student is not enrolled");
				}
				break;
				
			// delete a student using student number
			case 3:
				
				System.out.print("Delete Student: ");
				studNum = sc.nextLine();
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getStudentNumber().compareTo(studNum) == 0) {
						list.remove(list.get(i));
						break;
					}
				}
				System.out.println("Student " + studNum + " deleted!");
				break;
				
			// save info to a file
			case 4:
				try{
					File file = new File("C:\\Users\\Franz Pasulohan\\Workspace\\studentdb.txt");
					
					if(!file.exists()){
						file.createNewFile();
					}
					
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					for(Student s: list){
						bw.write(s.getStudentNumber());
						bw.newLine();
						bw.write(s.getLastName());
						bw.newLine();
						bw.write(s.getMiddleInitial());
						bw.newLine();
						bw.write(s.getFirstName());
						bw.newLine();
						bw.write(s.getCourse());
						bw.newLine();
						bw.write(s.getYearLevel());
						bw.newLine();
					}
					bw.close();
				} catch(IOException e){
					e.printStackTrace();
				}
				sc.close();
				break;
				
			// use student getter for update yeeyy
				
			default:
				System.out.println("Please enter again.");
			}
      
		}	
    
	}
	
}
