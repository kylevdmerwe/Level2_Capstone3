package task_24;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.Year;
import java.util.*;
/**Main Project Manager Program.
 * @author Kyle van der Merwe
 * @version 3.0
 * @since 1.0
*/
public class ProjectManager {
	
	// Create Arrays of the classes to store. 
	// Later these arrays to be stored in txt files
	static Personel[] personel = new Personel[0];
	static List<Project> projectList = new ArrayList<>();
	static Invoice[] invoices = new Invoice[0];
	static String projectFile = "src\\task_24\\projects.txt";
	static String personelFile = "src\\task_24\\personel.txt";
	/**
	 * This is the main method for the Project Manager Program. 
	 * Loop through a menu until exited by user 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		
		// Main Menu printing, creating scanner and using a switch case. 
		// Store the Menu options in an array
		Scanner scanIn = new Scanner(System.in);
		String[] arrMenuItem = {"Create new Personel",
								"Create new Project",
								"Update existing Project",
								"Load Projects from file",
								"Projects to be completed",
								"Projects that are past due date",
								"Find a project",
								"Finalise a Project",
								"Quit"};
		

        // print menu
		// handle user commands
        boolean quit = false;
        
        int menuItem;
        retrieveProjects(projectFile);
        retrievePersonel(personelFile);
        // Do while loop to print Menu, receive users inputs and call relevant methods
        do {
        	try {
        		
        		for (int i = 0; i < arrMenuItem.length; i++)
           		 System.out.println((i+1) + ". " + arrMenuItem[i]);           	
                 System.out.println("Choose menu item: ");

             	 menuItem = scanIn.nextInt();
             	 int projectID = -1;
                 switch (menuItem) {

                 case 1:
                	 createNewPersonel(scanIn);
                	 break;

                 case 2:
                	 createNewProject(scanIn);
                	 break;

                 case 3:  
                	projectID = selectProject(scanIn);
	               	updateExistingProject(scanIn, projectID);
	               	break;

                 case 4:
	               	if(retrieveProjects(projectFile))
	               		System.out.println("Project Loaded from File");
	               	else
	               		System.out.println("Error: Project Not Loaded");
	                 	if(retrievePersonel(personelFile))
	               		System.out.println("Personel Loaded from File");
	               	else
	               		System.out.println("Error: Personel Not Loaded");
                 	break;
             	  	

                 case 5:
                 	if(printUnCompletedProjects(scanIn)) {
                 		
                 	}
                 	break;
                 case 6:
                 	if(printLateProjects(scanIn)) {
                 		
                 	}
                 	break;
                 case 7:																																																																																																										scanIn.nextLine();
	               	boolean valid = false;
	                   String strChoice;
	               	do {
	               		System.out.println("Would you like to search Project Id or Project Name? ( I / N)");
	               		strChoice = scanIn.nextLine().toLowerCase();
	               		if(strChoice.equals("i")){
	           		        valid = false;
	           	        	do {
	           	        		try {
	           	        			System.out.println("What is the Project ID?");
	           	        			int intChoice = scanIn.nextInt();
	           	        			scanIn.nextLine();
	           	        			if (findProjectWithID(intChoice))
		                        		System.out.println("Project found");
		                        	else
		                        		System.out.println("Project not found");
		                        	valid = true;
								} catch (Exception e) {
									System.out.println("Input is not a valid Int"); 
								}
	                        	
	           	  	        }while(!valid);
	               		}else if(strChoice.equals("n")) {
	               			valid = false;
	           	        	do {
	           		        	System.out.println("What is the Project Name?");
	           					try {  					
	           		  		        strChoice = scanIn.nextLine();
	           		  		        if (findProjectWithName(strChoice))
	           		  		        	System.out.println("Project found");
	           		  		        else
           		  		        		System.out.println("Project not found");
	           		  		        valid = true;
	           					} catch (Exception e) {
	           						       		
	           					}
	           	  	        }while(!valid);      			
	               		}else {
	               			valid = false;
	               			System.out.println("Invalid Selection");
	               		}
	               	}while(!valid);
	               	break;
	               		
                 case 8:
	               	scanIn.nextLine();
	               	finaliseProject(scanIn);
	                   break;
	                     
                 case 9:
	               	savePersonel(personelFile);
	               	saveProjects(projectFile);
	                   quit = true;
	                   break;

                 default:
	               	System.out.println("Invalid choice.");
	               	scanIn.nextLine();

                 }
				
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid election, Choose an Integer.\n");
				scanIn.nextLine();
			}
    	  

        } while (!quit);
        
        scanIn.close();

        System.out.println("Bye-bye!");

	}
	/**Returns a boolean result for a print personel method
	 * Prints the specific type of personel required
	 * Prints personelID and personel name
	 * @param scanIn A scanner to allow reading input from console
	 * @param personelType A String containing the search parameter
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean printPersonel(Scanner scanIn, String personelType) {
		
		System.out.println("Who is the project " + personelType + "?" );
		if ((personel.length==0)) {
    		System.out.println("No recorded Personel yet.");
    		return false;
    	}
    	
    	
    	boolean present = false;
    	for(int i = 0; i < personel.length; i++) {
			
    		if(personel[i].getPersonelType().equals(personelType)) {
				present = true;
				System.out.println("Personel ID : " + personel[i].getPersonelID());
    			System.out.println("Personel Name : " + personel[i].getFirstName() + "\n");
			
    		}
    		
    	}
    	if(!present) {
			System.out.println("No recorded " + personelType + " yet.");
    		return false;
		}
		return true;
		
	}
	/**Returns a boolean result for a print projects method
	 * Prints all projects
	 * Prints projectID and project name
	 * @param scanIn A scanner to allow reading input from console
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean printProjects(Scanner scanIn) {
		if ((projectList.size()==0)) {
    		System.out.println("No recorded Projects Yet.");
    		return false;
    	}
    	for (Project p: projectList) {
      		System.out.println("Project ID : " + p.getProjectID() + "\n" + "Project Name : " + p.getProjectName() + "\n");
      	}
    	return true;
	}
	/**Returns a boolean result for a print uncompleted projects method
	 * Prints all uncompleted projects
	 * Prints projectID and project name
	 * @param scanIn A scanner to allow reading input from console
	 * @return A boolean indicating success or failure of this method
	 */	
	public static boolean printUnCompletedProjects(Scanner scanIn) {
		boolean present = false;
		if ((projectList.size()==0)) {
    		System.out.println("No recorded Projects Yet.");
    		return present;
    	}
    	for (Project p: projectList) {
    		if (!(p.getProjectStatus().equals("finalised"))) {
    			present = true;
    			System.out.println("Project ID : " + p.getProjectID() + "\n" + "Project Name : " + p.getProjectName() + "\n");
    		}
      			
      	}
    	if (present)
    		return present;
    	else {
    		System.out.println("No Completed Projects Yet.");
    		return present;
    	}
	}
	/**Returns a boolean result for a print late projects method
	 * Prints all overdue projects
	 * Prints projectID and project name
	 * @param scanIn A scanner to allow reading input from console
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean printLateProjects(Scanner scanIn) {
		boolean present = false;
		if ((projectList.size()==0)) {
    		System.out.println("No recorded Projects Yet.");
    		return present;
    	}
    	for (Project p: projectList) {
    		if (p.getProjectDeadline()<Year.now().getValue()) {
    			present = true;
    			System.out.println("Project ID : " + p.getProjectID() + "\n" + "Project Name : " + p.getProjectName() + "\n");
    		}
      			
      	}
    	if (present)
    		return present;
    	else {
    		System.out.println("No Late Projects Yet.");
    		return present;
    	}
	}
	/**Returns a boolean result for a find projects method
	 * Finds a specific project, prints out that projects details
	 * @param projectID An integer containing the projectID searched for
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean findProjectWithID(int projectID) {
		boolean present = false;
		if ((projectList.size()==0)) {
    		System.out.println("No recorded Projects Yet.");
    		return present;
    	}
    	for (Project p: projectList) {
    		if (p.getProjectID() == projectID) {
    			present = true;
    			System.out.println(p.toStringForDisplay());
    		}
      			
      	}
    	if (present)
    		return present;
    	else {
    		System.out.println("Project not found.");
    		return present;
    	}
	}
	/**Returns a boolean result for a find projects method
	 * Finds a specific project, prints out that projects details
	 * @param projectName A string containing the project name searched for
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean findProjectWithName(String projectName) {
		boolean present = false;
		if ((projectList.size()==0)) {
    		System.out.println("No recorded Projects Yet.");
    		return present;
    	}
    	for (Project p: projectList) {
    		if (p.getProjectName().equals(projectName)) {
    			present = true;
    			System.out.println(p.toStringForDisplay());
    		}
      			
      	}
    	if (present)
    		return present;
    	else {
    		System.out.println("Project not found.");
    		return present;
    	}
	}
	/**Creates a new personel object in the current project manager
	 * Method interacts with user, requesting detail needed for new personel creation
	 * Adds the new personel to the personel array
	 * @param scanIn A scanner to allow reading input from console
	 */
	public static void createNewPersonel(Scanner scanIn) {
		String personelType  = "";
	    int personelID = 0;
	    String firstName = "";
	    String surname = "";
	    String email = "";
	    String personelAddress = "";
	    String personelTelephone = "";
		
	    personel = Arrays.copyOf(personel, personel.length + 1);
        personelID = personel.length;
        boolean valid = false;
        int menuItem2;
        System.out.println("Creating new Personel");
        do {
			System.out.println("Please enter Personel Type.");
			System.out.println("1: Customer");
			System.out.println("2: Contractor");
			System.out.println("3: Architect");
			try {
				menuItem2 = scanIn.nextInt();
				scanIn.nextLine();
				switch (menuItem2) {
		    		case 1:		
		    			personelType = "Customer";
		    			valid = true;
		                break;
		            case 2:
		            	personelType = "Contractor";
		            	valid = true;
		                break;
		            case 3:
		            	personelType = "Architect";
		            	valid = true;
		                break;
		            default:
		                System.out.println("Invalid choice");
				}
				
			} catch (InputMismatchException e) {
				valid = false;
				System.out.println("Input is not a valid Integer"); 
				scanIn.nextLine();
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter First Name of " +personelType+ ".");
			try {
				firstName = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");        		
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Surname of " +personelType+ ".");
			try {
				surname = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");        		
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Email Address of " +personelType+ ".");
			try {
				email = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");        		
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Physical Address of "+personelType+ ".");
			try {
				personelAddress = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");        		
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Telephone Number of "+personelType+ ".");
			try {
				personelTelephone = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");        		
			}
        }while(!valid);
        
        
        personel[personel.length-1] = new Personel(personelType, personelID, firstName, surname, email, personelAddress, personelTelephone);
        
        
        
	}
	/**Creates a new project object in the current project manager
	 * Method interacts with user, requesting detail needed for new project creation
	 * Adds the new project to the project list
	 * @param scanIn A scanner to allow reading input from console
	 */
	public static void createNewProject(Scanner scanIn) {
		int projectID = 0;
		String projectName = "";
		String buildingType = "";
		String projectAddress = "";
		String ERF = "";
		double projectFee = 0;
		int projectDeadline = 0;
		Personel architect = null;
		Personel contractor = null;
		Personel customer = null;
		projectID = projectList.size();
		boolean valid = false;
        
        System.out.println("Creating new Project");
        do {
			System.out.println("Please enter Project Name.");
			try {
				projectName = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");  
				scanIn.nextLine();
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Building Type.");
			try {
				buildingType = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");
				scanIn.nextLine();
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Project Address.");
			try {
				projectAddress = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String"); 
				scanIn.nextLine();
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Project ERF Number.");
			try {
				ERF = scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid String");
				scanIn.nextLine();
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Project Fee.");
			try {
				projectFee = scanIn.nextDouble();
				scanIn.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Input is not a valid Double");  
				scanIn.nextLine();
			}
        }while(!valid); 
        valid = false;
        do {
			System.out.println("Please enter Project Due Date (Year).");
			try {
				projectDeadline = scanIn.nextInt();
				scanIn.nextLine();
				if(projectDeadline <= Year.now().getValue())
					valid = true;
				else {
					System.out.println("Year is before current Date");
					
				}
			} catch (Exception e) {
				System.out.println("Input is not a valid Integer");
				scanIn.nextLine();
			}
        }while(!valid); 
        valid = false;
        do {
			
			if(printPersonel(scanIn, "Architect")) {
				
			}
			System.out.println("Please enter the Personel ID of the Architect, or for a new architect enter 0..");
			
			try {
				int intChoice = scanIn.nextInt();
				scanIn.nextLine();
				if(intChoice == 0) {
					createNewPersonel(scanIn);
					architect = personel[personel.length-1];
				} else {
					architect = personel[intChoice -1];
				}
				valid = true;
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Selection"); 
				scanIn.nextLine();
				valid = false;
			}
			
        }while(!valid);
        valid = false;
        do {
        	if(printPersonel(scanIn, "Contractor")) {
        		
        	}
			
			System.out.println("Please enter the Personel ID of the Contract, or for a new contractor enter 0..");
			
			try {
				int intChoice = scanIn.nextInt();
				scanIn.nextLine();
				if(intChoice == 0) {
					createNewPersonel(scanIn);
					contractor = personel[personel.length-1];
				} else {
					contractor = personel[intChoice -1];
				}
				valid = true;
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Selection");
				scanIn.nextLine();
				valid = false;
			}
        }while(!valid); 
        valid = false;
        do {
			
			if(printPersonel(scanIn, "Customer")) {
				
			}
			
			System.out.println("Please enter the Personel ID of the Customer, or for a new customer enter 0..");
			
			try {
				int intChoice = scanIn.nextInt();
				scanIn.nextLine();
				if(intChoice == 0) {
					createNewPersonel(scanIn);
					customer = personel[personel.length-1];
				} else {
					customer = personel[intChoice -1];
				}
				valid = true;
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Selection");  
				scanIn.nextLine();
				valid = false;
			}
        }while(!valid);
        projectList.add(new Project(projectID, projectName, buildingType, projectAddress, ERF, projectFee, 0, projectDeadline, 0, architect.getPersonelID(), contractor.getPersonelID(), customer.getPersonelID(), "Active"));
        
	}
	/**Finalizes a project
	 * Method finalizes the requested project 
	 * Invoicing customer if required, sets completed date
	 * Saves invoice to text file if generated
	 * @param scanIn A scanner to allow reading input from console
	 */
	public static void finaliseProject(Scanner scanIn) {		
		
        int projectChoice;

        Project workingProject;
        if(printProjects(scanIn)) {
	    	System.out.println("Which Project are you finalising? ");
	
	    	projectChoice = scanIn.nextInt();
	    	workingProject = projectList.get(projectChoice);
	        scanIn.nextLine();
	        if(workingProject.getProjectFee() == workingProject.getPaidToDate()) {
	        	workingProject.setProjectStatus("finalised");
		    	workingProject.setProjectDateCompleted(Year.now().getValue());
	        } else {
	        	int intInvoiceID;
	        	Personel customer;
	        	double dblFeeDue;
	        	invoices = Arrays.copyOf(invoices, invoices.length + 1);
	        	intInvoiceID = invoices.length;
	        	customer = personel[workingProject.getCustomerID()-1];
	        	dblFeeDue = workingProject.getProjectFee() - workingProject.getPaidToDate();
	        	invoices[invoices.length - 1] = new Invoice(intInvoiceID, customer, dblFeeDue);
	        	System.out.println("Current Invoice" + invoices[invoices.length - 1].toString());
	        	if(saveInvoice("src\\task_24\\Invoice_" + intInvoiceID+ ".txt", invoices[invoices.length - 1]))
	        		System.out.println("Invoice " +intInvoiceID+ " saved to file: " +"src\\task_24\\Invoice_" + intInvoiceID+ ".txt");
	        	else
	        		System.out.println("Invoice " +intInvoiceID+ " not saved.");
	        	
	        	workingProject.setProjectStatus("finalised");
	        	workingProject.setProjectDateCompleted(Year.now().getValue());
	        	projectList.set(projectChoice, workingProject);
	        }
	        if(saveCompletedProject("src\\task_24\\CompletedProject_" + projectChoice+ ".txt", workingProject)) {
	        	System.out.println("Project ID " +projectChoice+ " saved to file: " +"src\\task_24\\CompletedProject_ID_" + projectChoice+ ".txt");
	        }else
	        	System.out.println("Project ID " +projectChoice+ " not saved.");
        }else return;
        
	}
	/**Returns a boolean result from a retrieve projects method
	 * Loads all projects from a text file
	 * Saves the retrieved projects in a project list
	 * @param ProjectFileName A string containing the required file location
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean retrieveProjects(String ProjectFileName) {
		
		String input;
		Project tempProject;
		
		//Scanner can fail, method therefore in try - catch
		try {
			//Scans input file, and creates formatter linked to output file.
			File x = new File(ProjectFileName);
			if(x.length()==0) {
				System.out.println("Project file is empty;");
				return false;
			}
			Scanner sc = new Scanner(x);	
			 
			//Loops through input file as long as there is a next line.
			while (sc.hasNextLine()) {
				input = sc.nextLine();
				String[] strArray = input.split(";");
				tempProject = new Project(
										Integer.parseInt(strArray[0]), 
										strArray[1], 
										strArray[2], 
										strArray[3], 
										strArray[4], 
										Double.parseDouble(strArray[5]),
										Double.parseDouble(strArray[6]),
										Integer.parseInt(strArray[7]), 
										Integer.parseInt(strArray[8]), 
										Integer.parseInt(strArray[9]), 
										Integer.parseInt(strArray[10]),
										Integer.parseInt(strArray[11]),
										strArray[12]);
				projectList.add(tempProject);
			}
			sc.close();
			System.out.println("Project File loaded");
	 
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	/**Returns a boolean result from a retrieve personel method
	 * Loads all personel from a text file
	 * Saves the retrieved personel in a personel array
	 * @param PersonelFileName A string containing the required file location
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean retrievePersonel(String PersonelFileName) {
		
		String input;
		personel = new Personel[0]; 
		
		//Scanner can fail, method therefore in try - catch
		try {
			//Scans input file, and creates formatter linked to output file.
			File x = new File(PersonelFileName);
			if(x.length()==0) {
				System.out.println("Personel file is empty;");
				return false;
			}
			Scanner sc = new Scanner(x);	
			//Loops through input file as long as there is a next line.
			while (sc.hasNextLine()) {
				input = sc.nextLine();
				String[] strArray = input.split(";");
				personel = Arrays.copyOf(personel, personel.length + 1);
				personel[Integer.parseInt(strArray[1])-1] = new Personel(
																	strArray[0], 
																	Integer.parseInt(strArray[1]), 
																	strArray[2], 
																	strArray[3], 
																	strArray[4], 
																	strArray[5], 
																	strArray[6]);
				
			}
			
			sc.close();
			System.out.println("Personel File Loaded");
			
	 
		}
		catch (FileNotFoundException e) {
			System.out.println("Personel FIle Load failed, :" + e.getMessage() );
			return false;
		}
		return true;
	}
	/**Returns a boolean result from a save invoice method
	 * Saves an Invoice to a text file
	 * @param ProjectFileName A string containing the required file location
	 * @param CurrentInvoice A invoice object containing the invoice to be saved
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean saveInvoice(String ProjectFileName, Invoice CurrentInvoice) {
		File f = new File(ProjectFileName);
		FileWriter fr = null;
		Invoice tempInvoice = CurrentInvoice;
		try {
			fr = new FileWriter(f);
			fr.write(tempInvoice.toString());			
			fr.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	/**Returns a boolean result from a save completed project method
	 * Saves an completed project to its own text file
	 * @param ProjectFileName A string containing the required file location
	 * @param CurrentProject A project object containing the project to be saved
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean saveCompletedProject(String ProjectFileName, Project CurrentProject) {
		File f = new File(ProjectFileName);
		FileWriter fr = null;
		Project tempProject = CurrentProject;
		try {
			fr = new FileWriter(f);
			fr.write(tempProject.toStringForFile() + "\n");			
			fr.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	/**Returns a boolean result from a save all projects method
	 * Saves all projects to a text file
	 * @param ProjectFileName A string containing the required file location
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean saveProjects(String ProjectFileName) {
		File f = new File(ProjectFileName);
		FileWriter fr = null;
		try {
			fr = new FileWriter(f);
			for (Project p: projectList) {
				fr.write(p.toStringForFile() + "\n");
			}
			fr.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	/**Returns a boolean result from a save all personel method
	 * Saves all personel to a text file
	 * @param PersonelFileName A string containing the required file location
	 * @return A boolean indicating success or failure of this method
	 */
	public static boolean savePersonel(String PersonelFileName) {
		
		try {
			Formatter f = new Formatter(PersonelFileName);
			for (Personel p: personel) {
				f.format("%s%n",p.toStringForFile(), "\r\n");
			}
			f.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	/**Method to update an existing projects details
	 * Loops a menu, allowing editing of specific project details
	 * @param scanIn A scanner to allow reading input from console
	 * @param ProjectID An integer containing the project to be updated
	 */
	public static void updateExistingProject(Scanner scanIn, int ProjectID) {
		
		String[] arrMenuItem = {"Update Name",
								"Update Building Type",
								"Update Address",
								"Update ERF",
								"Update Project Fee",
								"Update Fee Paid to Date",
								"Update Due Date",
								"Update Architect",
								"Update Contractor",
								"Update Customer",
								"Change project being Edited",
								"Main Menu"};
		boolean quit = false;
        int menuItem;
        Project tempProject = projectList.get(ProjectID);
        
        // Do while loop to print Menu, receive users inputs and call relevant methods
        do {
        	
          System.out.println("Current Project Selected: ");
	      findProjectWithID(ProjectID);
    	  for (int i = 0; i < arrMenuItem.length; i++)
    		 System.out.println((i+1) + ". " + arrMenuItem[i]);
    	
          System.out.print("Choose menu item: ");
          menuItem = scanIn.nextInt();
          scanIn.nextLine();
          boolean valid = false;
          String strChoice = "";
          double dblChoice = 0;
          int intChoice = 0;
          switch (menuItem) {
          
	          case 1:
	        	
  		        do {
	  	        	System.out.print("What is the new Project Name for Project : " + tempProject.getProjectName() + " ?");
	  				try {  					
	  	  		        strChoice = scanIn.nextLine();         
	  	  		        valid = true;
	  				} catch (Exception e) {
	  					valid = false;
	  					System.out.println("Input is not a valid String");        		
	  				}
	  	        }while(!valid);	  	        
  	        	tempProject.setProjectName(strChoice);
  		        projectList.set(ProjectID, tempProject);
  		        break;
	          	
	          case 2: 	        
		        do {
	  	        	System.out.print("What is the new Building Type for Project : " + tempProject.getProjectName() + " ?");
	  				try {  					
	  	  		        strChoice = scanIn.nextLine();         
	  	  		        valid = true;
	  				} catch (Exception e) {
	  					valid = false;
	  					System.out.println("Input is not a valid String");        		
	  				}
	  	        }while(!valid);
	  	        
	  	        tempProject.setBuildingType(strChoice);
		        projectList.set(ProjectID, tempProject);
		        break;
	          case 3:
  		        do {
	  	        	System.out.println("What is the new Address for Project : " + tempProject.getProjectName() + " ?");
	  				try {  					
	  	  		        strChoice = scanIn.nextLine();         
	  	  		        valid = true;
	  				} catch (Exception e) {
	  					valid = false; 
	  					System.out.println("Input is not a valid String");        		
	  				}
  	        	}while(!valid);
	  	                        
  		        tempProject.setProjectAddress(strChoice);
  		        projectList.set(ProjectID, tempProject);
  		        break;
	          case 4:
  		        do {
	  	        	System.out.println("What is the new ERF for Project : " + tempProject.getProjectName() + " ?");
	  				try {  					
	  	  		        strChoice = scanIn.nextLine();         
	  	  		        valid = true;
	  				} catch (Exception e) {
	  		  	        valid = false; 
	  					System.out.println("Input is not a valid String");        		
	  				}
	  	        }while(!valid);                
  		        tempProject.setERF(strChoice);
  		        projectList.set(ProjectID, tempProject);
  		        break; 	
	          case 5:
	        	tempProject = projectList.get(menuItem);
  		        do {
	  	        	System.out.println("What is the new Project Fee for Project : " + tempProject.getProjectName() + " ?");
	  				try {
	  	  	        	dblChoice = scanIn.nextDouble();          
	  	  		        valid = true;
	  				} catch (Exception e) {
	  		  	        valid = false; 
	  					System.out.println("Input is not a valid Double");   
	  					scanIn.nextLine();
	  				}
	  	        }while(!valid);                  
  		        tempProject.setProjectFee(dblChoice);
  		        projectList.set(ProjectID, tempProject);
  		        break;
	          case 6:
  		        do {
	  	        	System.out.println("What is the new Fee Paid to Date for Project : " + tempProject.getProjectName() + " ?");
	  				try {
	  	  	        	dblChoice = scanIn.nextDouble();          
	  	  		        valid = true;
	  				} catch (Exception e) {
	  		  	        valid = false; 
	  					System.out.println("Input is not a valid Double");   
	  					scanIn.nextLine();
	  				}
	  	        }while(!valid);                    
  		        tempProject.setPaidToDate(dblChoice);
  		        projectList.set(ProjectID, tempProject);
  		        break;              
	          case 7:  
  		        do {
	  	        	System.out.println("What is the new Due Date for Project : " + tempProject.getProjectName() + " ?");
	  				try {  					
	  	  		        intChoice = scanIn.nextInt();
		  	  		    if(intChoice >= Year.now().getValue())
							valid = true;
						else {
						System.out.println("Year is before current Date");
					}
	  	  		        valid = true;
	  				} catch (Exception e) {
	  		  	        valid = false; 
	  					System.out.println("Input is not a valid Int");
	  					scanIn.nextLine();
	  				}
	  	        }while(!valid);                  
  		        tempProject.setProjectDeadline(intChoice);
  		        projectList.set(ProjectID, tempProject);
  		        break;
	          case 8:
	        	replacePersonel(scanIn,tempProject, ProjectID, "Architect");
  		        break;
	          case 9:
	        	replacePersonel(scanIn,tempProject, ProjectID, "Contractor");
		        break;
	          case 10:
	        	replacePersonel(scanIn,tempProject, ProjectID, "Customer");
  		        break;
	          case 11:
	        	int newProjectID = selectProject(scanIn);
	        	tempProject = projectList.get(newProjectID);
	          	break;
	          case 12:
		         quit = true;
		         break;
	
	          default:
	        	System.out.println("Invalid choice.");
	
	          }
          
	
        } while (!quit);
     }
	/**Returns a integer result from a select project method
	 * Requests feedback from user, after displaying all projects
	 * @param scanIn A scanner to allow reading input from console
	 * @return An integer containing the specific project user want to interact with
	 */
	public static int selectProject(Scanner scanIn) {
		int selection = -1;
		boolean present = false;
		if(printProjects(scanIn)) {  
			while(!present) {
				System.out.println("Which Project are you editing? ");
				try {
					selection = scanIn.nextInt();
					scanIn.nextLine();
					
					if (0 <= selection && selection < projectList.size() ) {
			        	present = true;
			        	System.out.println("Valid project selection.");
			        }else {
			        	present = false;
			        	System.out.println("Invalid project selection.");
			        }
				} catch (Exception e) {
					scanIn.nextLine();
					System.out.println("Invalid Selection, Not an integer");
					present = false;
				}
			}
		}
		return selection;
	}
	/**Replace a personel ID inside a project
	 * Method interacts with user, requesting detail needed for new project creation
	 * Adds the new project to the project list
	 * @param scanIn A scanner to allow reading input from console
	 * @param tempProject the current project object the user wants to change
	 * @param ProjectID A integer containing the project ID the user wants to make changes to
	 * @param Type A string containing the specific personel type the user wants to change
	 */
	public static void replacePersonel(Scanner scanIn, Project tempProject, int ProjectID, String Type) {
		int tempID = -1;
		boolean valid = false;
		do {
	  			
	  			if(printPersonel(scanIn, Type)) {
	  				
	  			}
	  			System.out.println("Please enter the Personel ID of the " +Type + ", or for a new " +Type + " enter 0..");
	  			int intChoice = 0;	
	  			try {
	  				intChoice = scanIn.nextInt();
	  				scanIn.nextLine();
	  				if(intChoice == 0) {
	  					createNewPersonel(scanIn);
  	  				if (personel[personel.length-1].getPersonelType().equals(Type)){
	  						tempID = personel[personel.length-1].getPersonelID();
	  						valid = true;
	  					}else {
	  						System.out.println("Selected personel is not a " +Type);
	  						valid = false;
	  					}
	  				} else {
	  					if (personel[intChoice -1].getPersonelType().equals(Type)){
	  						tempID = personel[intChoice -1].getPersonelID();
	  						valid = true;
	  					}else {
	  						System.out.println("Selected personel is not a " +Type);
	  						valid = false;
	  					}
	  					
	  				}
	  				
	  			} catch (NumberFormatException e) {
	          		valid = false;  
	  				System.out.println("Invalid Selection"); 
	  				scanIn.nextLine();
	  			}
			
        	}while(!valid);   

			switch (Type) {
			case "Architect": {
				tempProject.setArchitectID(tempID);
				break;
			}
			case "Contractor": {
				tempProject.setContractorID(tempID);
				break;
			}
			case "Customer": {
				tempProject.setCustomerID(tempID);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Type);
			}
				        
	        projectList.set(ProjectID, tempProject);
		
	}
}
