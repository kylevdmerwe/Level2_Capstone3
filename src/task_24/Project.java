package task_24;
/** Represents a Project.
 * @author Kyle van der Merwe
 * @version 3.0
 * @since 1.0
*/
public class Project {
   // Attributes
   private int projectID;
   private String projectName;
   private String buildingType;
   private String projectAddress;
   private String ERF;
   private double projectFee;
   private double paidToDate;
   private int projectDeadline;
   private int projectDateCompleted;
   private int architectID;
   private int contractorID;
   private int customerID;
   private String projectStatus;
	
   /** Creates a project with the specified details.
    * @param projectID The project's ID
    * @param projectName The project's name
    * @param buildingType The project's building type
    * @param projectAddress The project's physical address
    * @param ERF The project's ERF number
    * @param projectFee The projects's total fee required
    * @param paidToDate The projects's currently paid to date fee amount
    * @param projectDeadline The projects's deadline (year)
    * @param projectDateCompleted The projects's finalization date (year)
    * @param architectID The projects's architect ID
    * @param contractorID The projects's contractor ID
    * @param customerID The projects's customer ID
    * @param projectStatus The projects's current status
    * 
   */
   public Project( int projectID,
				   String projectName,
				   String buildingType,
				   String projectAddress,
				   String ERF,
				   double projectFee,
				   double paidToDate,
				   int projectDeadline,
				   int projectDateCompleted,
				   int architectID,
				   int contractorID,
				   int customerID,
				   String projectStatus) {
	   this.projectID = projectID;
	   this.projectName = projectName;
	   this.buildingType = buildingType;
	   this.projectAddress = projectAddress;
	   this.ERF = ERF;
	   this.projectFee = projectFee;
	   this.paidToDate = paidToDate;
	   this.projectDeadline = projectDeadline;
	   this.projectDateCompleted = projectDateCompleted;
	   this.architectID = architectID;
	   this.contractorID = contractorID;
	   this.customerID = customerID;
	   this.projectStatus = projectStatus;
   }
   /** Returns a string representation of this project. 
    *  Format suitable for easy viewing of data by a user
    * @return A string containing a representation of this object
   */
   public String toStringForDisplay() {
	   String thisProject = "";
	   thisProject+= "\nProject ID:/t\t\t\t" + projectID;
	   thisProject+= "\nProject Name:\t\t\t" + projectName;
	   thisProject+= "\nBuilding Type:\t\t\t" + buildingType;
	   thisProject+= "\nProject Address:\t\t" + projectAddress;
	   thisProject+= "\nERF:\t\t\t\t" + ERF;
	   thisProject+= "\nProject Fee (R):\t\t" + projectFee;
	   thisProject+= "\nPaid to Date (R):\t\t" + paidToDate;
	   thisProject+= "\nProject Deadline:\t\t" + projectDeadline;
	   thisProject+= "\nProject Date Completed:\t\t" + projectDateCompleted;
	   thisProject+= "\nArchitect:\t\t\t" + architectID;
	   thisProject+= "\nContractor:\t\t\t" + contractorID;
	   thisProject+= "\nCustomer\t\t\t" + customerID;
	   thisProject+= "\nProject Status:\t\t\t" + projectStatus;	   
	   return thisProject;
   }
   /** Returns a string representation of this project. 
    *  Format suitable for saving and retrieving data from a text file.
    * @return A string containing a representation of this object
   */
   public String toStringForFile() {
	   String thisProject = "";
	   thisProject+= "" + projectID;
	   thisProject+= ";" + projectName;
	   thisProject+= ";" + buildingType;
	   thisProject+= ";" + projectAddress;
	   thisProject+= ";" + ERF;
	   thisProject+= ";" + projectFee;
	   thisProject+= ";" + paidToDate;
	   thisProject+= ";" + projectDeadline;
	   thisProject+= ";" + projectDateCompleted;
	   thisProject+= ";" + architectID;
	   thisProject+= ";" + contractorID;
	   thisProject+= ";" + customerID;
	   thisProject+= ";" + projectStatus;	   
	   return thisProject;
   }   
   /** Gets the project's ID.
    * @return An integer representing this project's ID
   */
   public int getProjectID() {
      return projectID;
   }
   /** Gets the project's name.
    * @return A string representing this project's name
   */
   public String getProjectName() {
      return projectName;
   }
   /** Gets the project's building type.
    * @return A string representing this project's building
   */
   public String getBuildingType() {
      return buildingType;
   }
   /** Gets the project's physical address.
    * @return A string representing this project's physical address
   */
   public String getProjectAddress() {
      return projectAddress;
   }
   /** Gets the project's ERF.
    * @return A string representing this project's ERF
   */
   public String getERF() {
      return ERF;
   }
   /** Gets the project's total fee.
    * @return A double representing this project's total fee
   */	   
   public double getProjectFee() {
      return projectFee;
   }
   /** Gets the project's paid to date amount.
    * @return A double representing this project's paid to date amount
   */
   public double getPaidToDate() {
      return paidToDate;
   }
   /** Gets the project's deadline (year).
    * @return An integer representing this project's deadline date (year)
   */
   public int getProjectDeadline() {
      return projectDeadline;
   }
   /** Gets the project's completion date (year).
    * @return An integer representing this project's completion date (year)
   */
   public int getProjectDateCompleted() {
      return projectDateCompleted;
   }
   /** Gets the project's architect ID.
    * @return An integer representing this project's architect ID
   */
   public int getArchitectID() {
      return architectID;
   }
   /** Gets the project's contractor ID.
    * @return An integer representing this project's contractor ID
   */
   public int getContractorID() {
      return contractorID;
   }
   /** Gets the project's customer ID.
    * @return An integer representing this project's customer ID
   */
   public int getCustomerID() {
      return customerID;
   }
   /** Gets the project's current status.
    * @return A string representing this project's current status
   */
   public String getProjectStatus() {
      return projectStatus;
   }
   
   /** Sets the project's ID.
    * @param projectID An integer containing this project's ID
   */
   public void setProjectID(int projectID) {
	   this.projectID = projectID;
   }
   /** Sets the project's name.
    * @param projectName A string containing this project's name
   */
   public void setProjectName(String projectName) {
	   this.projectName = projectName;
   }
   /** Sets the project's building type.
    * @param buildingType A string containing this project's building type
   */  
   public void setBuildingType(String buildingType) {
	   this.buildingType = buildingType;
   }
   /** Sets the project's physcal address.
    * @param projectAddress A string containing this project's physical address
   */
   public void setProjectAddress(String projectAddress) {
	   this.projectAddress = projectAddress;
   }
   /** Sets the project's ERF.
    * @param ERF A string containing this project's ERF
   */
   public void setERF(String ERF) {
	   this.ERF = ERF;
   }
   /** Sets the project's total fee.
    * @param projectFee A double containing this project's total fee
   */
   public void setProjectFee(double projectFee) {
	   this.projectFee = projectFee;
   }
   /** Sets the project's paid to date amount.
    * @param paidToDate A double containing this project's paid to date amount
   */
   public void setPaidToDate(double paidToDate) {
	   this.paidToDate = paidToDate;
   }
   /** Sets the project's deadline (year).
    * @param projectDeadline An integer containing this project's deadline (year)
   */
   public void setProjectDeadline(int projectDeadline) {
	   this.projectDeadline = projectDeadline;
   }
   /** Sets the project's completion date (year).
    * @param projectDateCompleted An integer containing this project's completion date (year)
   */
   public void setProjectDateCompleted(int projectDateCompleted) {
	   this.projectDateCompleted = projectDateCompleted;
   }
   /** Sets the project's architect ID.
    * @param architectID An integer containing this project's architect ID
   */
   public void setArchitectID(int architectID) {
	   this.architectID = architectID;
   }
   /** Sets the project's contractor ID.
    * @param contractorID An integer containing this project's contractor ID
   */
   public void setContractorID(int contractorID) {
	   this.contractorID = contractorID;
   }
   /** Sets the project's customer ID.
    * @param customerID An integer containing this project's customer ID
   */
   public void setCustomerID(int customerID) {
	   this.customerID = customerID;
   }
   /** Sets the project's current status.
    * @param projectStatus A string containing this project's current status
   */
   public void setProjectStatus(String projectStatus) {
	   this.projectStatus = projectStatus;
   }

}
