package Student_info;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
  


public class Roster {
	
	private static Map<String, Student> studentMap = new HashMap<String, Student>();

	public static void main(String[] args) {

		loadData();

		Scanner scan = new Scanner(System.in);
		
		//  simple println statement 

		System.out.println("Welcome to CityTech Command Info");
		System.out.println("------------------------------------");
		System.out.println("You can execute below command \n" + "------------------------------------ \n"
				+ "For get the total class average write ----- classaverage\n\n"
				+ "For Get the stat about How many  A and how many F write ---- aAndf \n\n"
				+ "For a Student ID show all the information about the student ---- get_record \n\n"
				+ "Given a Student Name show all the records of students with same name ---- get_record_by_name \n\n "
				+ "For get Student ID and grade for all students ---- get_id_get_grade \n\n "
				+ "For close the process please write ----- quit\n\n");

		System.out.println("Please write command : ");

		String userInp = scan.next();
		
		//For close the process

		while (!userInp.contains("quit")) {
			if (userInp.equals("classaverage")) {
		
				Roster.getClassAverage();

			}else if (userInp.equals("aAndf")) {

				Roster.countAAndF();

			}

			else if (userInp.equals("get_record")) {
				System.out.print("Enter Student ID: ");
				String inpId = scan.next();
				showStudentReocrd(inpId);
			}

			else if (userInp.equals("get_record_by_name")) {
				System.out.print("Enter Student Name: ");
				String name = scan.next();
				Roster.sameName(name);
			}

			else if (userInp.equals("get_id_get_grade")) {
				Roster.idAndGrade();
			}

			System.out.println("------------------------------------");
			System.out.println("You can execute below command \n" + "------------------------------------ \n"
					+ "For get the total class average write ----- classaverage\n\n"
					+ "For Get the stat about How many  A and how many F write ---- aAndf \n\n"
					+ "For a Student ID show all the information about the student ---- get_record \n\n"
					+ "Given a Student Name show all the records of students with same name ---- get_record_by_name \n\n "
					+ "For get Student ID and grade for all students ---- get_id_get_grade \n\n "
					+ "For close the process please write ----- quit\n\n");

			System.out.println("Please write command : ");

			userInp = scan.next();

		}

	}

	private static void loadData() {
		String line = "";
		String splintBy = ",";

		// read the input
		//path loading/reading data from the CSV file)
		String fileInput = "src/Student_info/class_roster_project.csv";

		
		//in order to read the file, you have to put the file using Keywork NEW), 
		//the word new you are initialing a new object into that class
		try {
			FileReader fileReader = new FileReader(fileInput);//openong the line 
			BufferedReader br = new BufferedReader(fileReader);//its start reading 
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] reader = line.split(splintBy);
				// getting into a variable
				String studentId = reader[0];
				String name = reader[1];
				double quiz = Double.parseDouble(reader[2]);
				double test1 = Double.parseDouble(reader[3]);
				double midTerm = Double.parseDouble(reader[4]);
				double test3 = Double.parseDouble(reader[5]);
				double finalTest = Double.parseDouble(reader[6]);
				double presentation = Double.parseDouble(reader[7]);
				double codingProject = Double.parseDouble(reader[8]);
				//Ends index 8

				// populate student object
				Student st = new Student(studentId, name);
				st.setQuiz(quiz);
				st.setTest1(test1);
				st.setMidTermTest(midTerm);
				st.setTest3(test3);
				st.setFinalTest(finalTest);
				st.setPresentation(presentation);
				st.setCodingProject(codingProject);

				studentMap.put(studentId, st);// put function add the data in dictonary

			}
			fileReader.close();//closing the file)
		} catch (Exception e) {
			e.printStackTrace();//will close the program if error occurs
		}
	}

	public static void showStudentReocrd(String id) {
		Student stRecord = studentMap.get(id); //fetch student ID map in the parameter
		System.out.println(stRecord);
	}

	public static void getClassAverage() { // Get the total class average
		double classAverage = 0;
		
		int num = 0; //define as an integer number and assign value 0

		for (String id : studentMap.keySet()) {

			Student stRecord = studentMap.get(id);
			double totalGrade = Grade.grade(stRecord.getQuiz(), stRecord.getTest1(), stRecord.getMidTermTest(),
					stRecord.getTest3(), stRecord.getFinalTest(), stRecord.getPresentation(),
					stRecord.getCodingProject());

			classAverage += totalGrade;
			num++;

		}

		double classAverages = (classAverage / num);
		System.out.println("The total class average: " + classAverages);

	}
 // get the total a and f 
	public static void countAAndF() {
		int a = 0;
		int f = 0;

		for (String id : studentMap.keySet()) {

			Student stRecord = studentMap.get(id);
			double totalGrade = Grade.grade(stRecord.getQuiz(), stRecord.getTest1(), stRecord.getMidTermTest(),
					stRecord.getTest3(), stRecord.getFinalTest(), stRecord.getPresentation(),
					stRecord.getCodingProject());

			if (totalGrade >= 93) {
				a++;
				//(++ add the value of a variable by 1
			} else if (totalGrade < 60) {
				f++;
			}

		}

		System.out.println("The number of student get A in the class: " + a);
		System.out.println("The number of student get F in the class: " + f);

	}
	//For a Student ID show all the information about the student

	public static void sameName(String name) {
		int record = 0;
		
		//(“keyset returns a set of keys in HashMap 
		for (String id : studentMap.keySet()) {
			Student stRecord = studentMap.get(id);
			if (stRecord.getName().contains(name)) {
				record++;
				System.out.println(stRecord);
			}

		}
		if (record == 0) {
			System.out.println("Record doesn't found with this name!");
		}
	}
	
	//For get Student ID and grade for all students
	

	public static void idAndGrade() {
        String grade="";
		for (String id : studentMap.keySet()) {
			Student stRecord = studentMap.get(id);
			double totalGrade = Grade.grade(stRecord.getQuiz(), stRecord.getTest1(), stRecord.getMidTermTest(),
					stRecord.getTest3(), stRecord.getFinalTest(), stRecord.getPresentation(),
					stRecord.getCodingProject());
                     if(totalGrade>=90.0 && totalGrade<=100.0){
                         grade= "A";
                     }
                     else if(totalGrade>=80.0 && totalGrade<90.0){
                         grade= "B";
                     }
                     else if(totalGrade>=70.0 && totalGrade<80.0){
                         grade= "C";
                     }
                     else if(totalGrade>=60.0 && totalGrade<70.0){
                         grade= "D";
                     }else{
                         grade= "F";
                     }

			
			System.out.println("ID: " + stRecord.getId() + " Grade: " + totalGrade+"  letterGrade: "+grade);



		}

	}
}


