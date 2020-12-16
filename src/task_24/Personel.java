package task_24;

/** Represents a Personel linked to a project.
 * @author Kyle van der Merwe
 * @version 3.0
 * @since 1.0
*/
public class Personel {
	
   // Attributes
   private String personelType;
   private int personelID;
   private String firstName;
   private String surname;
   private String email;
   private String personelAddress;
   private String personelTelephone;


	
   /** Creates a personel with the specified details.
    * @param personelType The personel's type (Architect, Contractor, Customer)
    * @param personelID The personel's personelID number
    * @param firstName The personel's first name
    * @param surname The personel's last name
    * @param email The personel's email address
    * @param personelAddress The personel's physical address
    * @param personelTelephone The personel's telephone number
   */
   public Personel(String personelType,
				   int personelID,
				   String firstName,
				   String surname,
				   String email,
				   String personelAddress,
				   String personelTelephone) {
	   this.personelType = personelType;
	   this.personelID = personelID;
	   this.firstName = firstName;
	   this.surname = surname;
	   this.email = email;
	   this.personelAddress = personelAddress;
	   this.personelTelephone = personelTelephone;
	   
   }
   /** Returns a string representation of this object. 
    *  Format suitable for saving and retrieving data from a text file.
    * @return A string containing a representation of this object
   */
   public String toStringForFile() {
	   String thisPersonel = "";
	   thisPersonel+= "" + personelType;
	   thisPersonel+= ";" + personelID;
	   thisPersonel+= ";" + firstName;
	   thisPersonel+= ";" + surname;
	   thisPersonel+= ";" + email;
	   thisPersonel+= ";" + personelAddress;
	   thisPersonel+= ";" + personelTelephone;	   
	   return thisPersonel;
   }


   /** Gets the personel's type.
    * @return A string representing this personel's type
   */
   public String getPersonelType() {
      return personelType;
   }
   /** Gets the personel's personelID.
    * @return An integer representing this personel's personelID
   */
   public int getPersonelID() {
      return personelID;
   }
   /** Gets the personel's first name.
    * @return A string representing this personel's first name
   */
   public String getFirstName() {
      return firstName;
   }
   /** Gets the personel's last name.
    * @return A string representing this personel's last name
   */
   public String getSurname() {
      return surname;
   }
   /** Gets the personel's email address.
    * @return A string representing this personel's email address
   */
   public String getEmail() {
      return email;
   }
   /** Gets the personel's physical address.
    * @return A string representing this personel's physical address
   */
   public String getPersonelAddress() {
      return personelAddress;
   }
   /** Gets the personel's telephone number.
    * @return A string representing this personel's telephone number
   */
   public String getPersonelTelephone() {
      return personelTelephone;
   }
   
   /** Sets the personel's type.
    * @param personelType A string containing this personel's type
   */
   public void setPersonelType(String personelType) {
	   this.personelType = personelType;
   }
   /** Sets the personel's personelID.
    * @param personelID An integer containing this personel's personelID
   */
   public void setPersonelID(int personelID) {
	   this.personelID = personelID;
   }
   /** Sets the personel's first name.
    * @param firstName A string containing this personel's first name
   */
   public void setFirstName(String firstName) {
	   this.firstName = firstName;
   }
   /** Sets the personel's last name.
    * @param surname A string containing this personel's last name
   */   
   public void setSurname(String surname) {
	   this.surname = surname;
   }
   /** Sets the personel's email address.
    * @param email A string containing this personel's email address
   */
   public void setEmail(String email) {
	   this.email = email;
   }
   /** Sets the personel's physical address.
    * @param personelAddress A string containing this personel's physical address
   */
   public void setPersonelAddress(String personelAddress) {
	   this.personelAddress = personelAddress;
   }
   /** Sets the personel's telephone number.
    * @param personelTelephone A string containing this personel's telephone number
   */
   public void setPersonelTelephone(String personelTelephone) {
	   this.personelTelephone = personelTelephone;
   }   
   /** Returns a string representation of this object. 
    *  Easy to read when printed to console or text file.
    * @return A string containing a representation of this object
   */
   public String toString() {
	   
	   String output = "\nPersonel Type: " + personelType;
	   output += "\nPersonel ID: " + personelID;
	   output += "\nFirst Name: " + firstName;
	   output += "\nSurname: " + surname;
	   output += "\nEmail: " + email;
	   output += "\nPhysical Address: " + personelAddress;
	   output += "\nTelephone: " + personelTelephone;
	   
	   return output;
   }

}
