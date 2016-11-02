import java.io.*;
import java.util.*;
import patpackages.input.*;

public class GradeRecorder {
	private static ArrayList<Class> classes = new ArrayList<Class>();
	public static Class currentClass;
	public static Student currentStudent;
	public static Assignment currentAssignment;
	
	public static void main(String[] args) throws IOException {
		//classes.add(Class.newClass(1,1));
		RunRecorder();
	}
	
	public static void RunRecorder() throws IOException{
		// $/Class/Student/Assignment
		do{
			System.out.println(GetLocationPath());
			
			if(currentClass == null){
				RunCohort();
			}else{
				if(currentStudent != null){
					RunStudent(currentClass, currentStudent);
				}else if(currentAssignment != null){

				}else{
					RunClass(currentClass);
				}
			}
		}while (true);
	}
	
	public static void RunCohort() throws IOException{
		int op = ConsoleUI.promptForMenuSelection(new String[]{
				"1-Add Class",
				"2-Remove Class by name",
				"3-Enter Class by name",
			}, true);

    	ArrayList<String> clss = new ArrayList<String>();
    	for(int i = 0; i < classes.size(); i++){
    		clss.add("" + (i+1) + "-" + classes.get(i).getName());
    	}
    	String[] classSelection = clss.toArray(new String[clss.size()]);
    	
        switch (op) {
	        case 1:
	        	classes.add(Class.newClass(
	        			ConsoleUI.promptForInt("How many Students?", 0, 1000),
	        			ConsoleUI.promptForInt("How many Initial Assignments?", 0, 1000)));
	        	break;
	        case 2:
	        	if(clss.size() <= 0){
	        		System.out.println("No Classes to remove!");
	        	}else{
	        		classes.remove(ConsoleUI.promptForMenuSelection(classSelection, false));
	        	}
	        	break;
	        case 3:
	        	if(clss.size() <= 0){
	        		System.out.println("No Classes to enter!");
	        	}else{
	        		currentClass = classes.get(ConsoleUI.promptForMenuSelection(classSelection, false));
	        	}
	        	break;
	        default:
	        	return;
		}
	}
	public static void RunClass(Class thisClass) throws IOException{
		int op = ConsoleUI.promptForMenuSelection(new String[]{
				"1-Add Student",
				"2-Remove Student by name",
				"3-Enter Student by name",
				"4-Add Assignment",
				"5-Get Class average grade on Assignment",
				"6-Remove current Class",
				"7-Exit Class",
			}, true);


    	ArrayList<String> clss = new ArrayList<String>();
    	for(int i = 0; i < thisClass.students.size(); i++){
    		clss.add("" + (i+1) + "-" + thisClass.students.get(i).getName());
    	}
    	String[] studentSelection = clss.toArray(new String[clss.size()]);

    	ArrayList<String> alss = new ArrayList<String>();
    	for(int i = 0; i < thisClass.assignments.size(); i++){
    		alss.add("" + (i+1) + "-" + thisClass.assignments.get(i).getName());
    	}
    	String[] assignmentSelection = alss.toArray(new String[alss.size()]);
    	
        switch (op) {
	        case 1:
	        	Student stu = Student.newStudent();
	        	for(int i = 0; i < alss.size(); i++){
	        		stu.grades.add(null);
	        	}
	        	thisClass.students.add(stu);
	        	break;
	        case 2:
	        	if(clss.size() <= 0){
	        		System.out.println("No Students to remove!");
	        	}else{
	        		thisClass.students.remove(ConsoleUI.promptForMenuSelection(studentSelection, false));
	        	}
	        	break;
	        case 3:
	        	if(clss.size() <= 0){
	        		System.out.println("No Students to enter!");
	        	}else{
	        		currentStudent = thisClass.students.get(ConsoleUI.promptForMenuSelection(studentSelection, false));
	        	}
	        	break;
	        case 4:
	        	thisClass.assignments.add(Assignment.newAssignment());
	        	for(int i = 0 ; i < thisClass.students.size(); i++){
	        		thisClass.students.get(i).grades.add(null);
	        	}
	        	break;
	        case 5:
	        	if(alss.size() <= 0){
	        		System.out.println("No Assignments to check!");
	        	}else{
	        		int index = ConsoleUI.promptForMenuSelection(assignmentSelection, false);
	        		Double avrg = 0.0, count = 0.0;
	    			for(int i = 0 ; i < thisClass.students.size(); i++){
	    				Double dou = thisClass.students.get(i).GetGrade(index);
	    				if(dou != null){
	    					avrg += dou;
	    					count++;
	    				}
	    			}
	    			avrg /= count;
	    			System.out.println("Class average grade on " + thisClass.assignments.get(index).getName() + ": " + avrg + " " + Class.mapNumberToLetterGrade(avrg));
	        	}
	        	break;
	        case 6:
	        	classes.remove(thisClass);
	        	currentClass = null;
	        	return;
	        case 7:
	        	currentClass = null;
	        	return;
	        default:
	        	return;
		}
	}
	public static void RunStudent(Class thisClass, Student thisStudent) throws IOException{
		int op = ConsoleUI.promptForMenuSelection(new String[]{
				"1-Get grade for Class",
				"2-Get grade for Assignment",
				"3-Set grade for Assignment",
				"4-Exit Student",
			}, true);
		

		ArrayList<String> alss = new ArrayList<String>();
    	for(int i = 0; i < thisClass.assignments.size(); i++){
    		alss.add("" + (i+1) + "-" + thisClass.assignments.get(i).getName());
    	}
    	String[] assignmentSelection = alss.toArray(new String[alss.size()]);
    	
        switch (op) {
	        case 1:
	        	System.out.println("Class grade: " + thisStudent.AverageGrade() + " " + Class.mapNumberToLetterGrade(thisStudent.AverageGrade()));
	        	break;
	        case 2:
        		int index = ConsoleUI.promptForMenuSelection(assignmentSelection, false);
        		System.out.println("Assignment grade: " + thisStudent.GetGrade(index) + " " + Class.mapNumberToLetterGrade(thisStudent.GetGrade(index)));
	        	break;
	        case 3:
        		int ind = ConsoleUI.promptForMenuSelection(assignmentSelection, false);
        		thisStudent.ChangeGrade(ConsoleUI.promptForDouble("What is the student's new grade?", 0.0, 100.0), ind);
	        	break;
	        case 4:
	        	currentStudent = null;
	        	break;
	        default:
	        	return;
		}
	}
	/*public static void RunStudent(Class thisClass, Student thisStudent) throws IOException{
		int op = ConsoleUI.promptForMenuSelection(new String[]{
				"1-Get this student's class grade",
				"2-Get this student's grade on an assignment",
				"3-Remove this Student",
				"4-Exit Student",
			}, true);

    	ArrayList<String> clss = new ArrayList<String>();
    	for(int i = 0; i < thisClass.assignments.size(); i++){
    		clss.add("" + (i+1) + "-" + thisClass.assignments.get(i).getName());
    	}
    	String[] assignmentsSelection = clss.toArray(new String[clss.size()]);
    	
        switch (op) {
	        case 1:
	        	Double gr = thisStudent.AverageGrade();
	        	System.out.println("" + gr + " - " + Class.mapNumberToLetterGrade(gr));
	        	break;
	        case 2:
	        	Double ad = thisStudent.GetGrade(ConsoleUI.promptForMenuSelection(assignmentsSelection, false));
	        	System.out.println(""  + ad + " - " + Class.mapNumberToLetterGrade(ad));
	        	break;
	        case 3:
	        	thisClass.students.remove(thisStudent);
	        	thisStudent = null;
	        	break;
	        case 4:
	        	thisStudent = null;
	        	break;
	        default:
	        	return;
		}
	}*/

	private static String GetLocationPath(){
		String path = "$/";
		if(currentClass == null){
			return path;
		}else{
			path += currentClass.getName() + "/";
			if(currentStudent != null){
				path += currentStudent.getName();
				return path;
			}else if(currentAssignment != null){
				path += currentAssignment.getName();
				return path;
			}else{
				return path;
			}
		}
	}
	
	private static void PrintAllString(List<String> list){
		for(String str : list){
			System.out.println(str);
		}
	}
	
	private static Class getClassByName(String name){
		for(Class cls : classes){
			if(cls.getName().equals(name)){
				return cls;
			}
		}
		System.out.println("No student by that name!");
		return null;
	}
	
	private static class Class{
		public static final Map<Double, String> GRADE_LETTER_MAP;
		static {
	        Map<Double, String> aMap = new HashMap<Double, String>();
	        //index is floor of range for associated letter
	        aMap.put(0.0, "F");
	        aMap.put(60.0, "D-");
	        aMap.put(63.0, "D");
	        aMap.put(67.0, "D+");
	        aMap.put(70.0, "C-");
	        aMap.put(73.0, "C");
	        aMap.put(77.0, "C+");
	        aMap.put(80.0, "B-");
	        aMap.put(83.0, "B");
	        aMap.put(87.0, "B+");
	        aMap.put(90.0, "A-");
	        aMap.put(93.0, "A");
	        aMap.put(100.0, "A+");
	        GRADE_LETTER_MAP = Collections.unmodifiableMap(aMap);
	    }
		
		private String className = "";
		private ArrayList<Student> students = new ArrayList<Student>();
		private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		
		public String getName(){
			return className;
		}
		
		public static Class newClass(int studentPopulation, int initialAssignments) throws IOException{
			Class cls = new Class();

			cls.className = ConsoleUI.promptForInput("Please input the the class name",false);
			
			for(int i = 0; i < studentPopulation; i++){
				System.out.println("Adding student " + i);
				cls.students.add(Student.newStudent());
			}
			for(int i = 0; i < initialAssignments; i++){
				System.out.println("Adding assignment " + i);
				cls.assignments.add(Assignment.newAssignment());
				
				for(int j = 0; j < studentPopulation; j++){
					cls.students.get(j).AddGrade(null);
				}
			}
			return cls;
		}
		
		public Double getAssignmentClassGrade(String name){
			int index = assignments.indexOf(getAssignmentByName(name));
			Double avrg = 0.0, count = 0.0;
			for(Student stu : students){
				Double dou = stu.grades.get(index);
				if(dou != null){
					avrg += dou;
					count++;
				}
			}
			avrg /= count;
			return avrg;
		}
		
		public Double getStudentClassGrade(String name){
			Student stu = getStudentByName(name);
			return stu.AverageGrade();
		}
		public Double getStudentAssignmentGrade(String name, String assignName){
			Student stu = getStudentByName(name);
			int as = assignments.indexOf(getAssignmentByName(assignName));
			return stu.grades.get(as);
		}
		
		private static String mapNumberToLetterGrade(Double numberGrade){
			String grade = "";
			for (Map.Entry<Double, String> entry : GRADE_LETTER_MAP.entrySet()){
				if(numberGrade > entry.getKey()){
					grade = entry.getValue();
				}else{
					break;
				}
			}
			return grade;
		}
	
		private Assignment getAssignmentByName(String name){
			for(Assignment as : assignments){
				if(as.getName().equals(name)){
					return as;
				}
			}
			System.out.println("No assignment by that name!");
			return null;
		}
		private Student getStudentByName(String name){
			for(Student stu : students){
				if(stu.getName().equals(name)){
					return stu;
				}
			}
			System.out.println("No student by that name!");
			return null;
		}
	}
	
	private static class Student{
		private String name = "", firstName = "", lastName = "";
		private ArrayList<Double> grades = new ArrayList<Double>();
		
		public static Student newStudent() throws IOException{
			Student stu = new Student();
			boolean correctName;
			do{
				correctName = false;
				stu.firstName = ConsoleUI.promptForInput("Please input the student's first name",false);
				stu.lastName = ConsoleUI.promptForInput("Please input the student's last name",false);
				stu.name = stu.firstName + " " + stu.lastName;

				String check;
				boolean correctInput;
				do{
					correctInput = false;
					check = ConsoleUI.promptForInput("So the student's name is " + stu.name + ". Is this correct? (Type 'Yes' or 'No')",false);
					if(check.equals("Yes") || check.equals("No")){
						correctInput = true;
						if(check.equals("Yes")){
							correctName = true;
						}else{
							correctName = false;
						}
					}
				}while (!correctInput);
			} while(!correctName);
			return stu;
		}
		
		public String getName(){
			return name;
		}
		
		public void AddGrade(Double input){
			grades.add(input);
		}
		public void ChangeGrade(Double input, int index){
			grades.set(index, input);
		}
		public Double GetGrade(int index){
			return grades.get(index);
		}
		
		public String ToString(){
			return "" + name + ", " + AverageGrade();
		}
		public Double AverageGrade(){
			Double avrg = 0.0, count = 0.0;
			for(Double dou : grades){
				if(dou != null){
					avrg += dou;
					count++;
				}
			}
			avrg /= count;
			return avrg;
		}
	}

	private static class Assignment{
		private String name = "";
		
		public String getName(){
			return name;
		}
		
		public static Assignment newAssignment() throws IOException{
			Assignment asgn = new Assignment();

			asgn.name = ConsoleUI.promptForInput("Please input the the assignment name", false);
			
			return asgn;
		}
	}
}
