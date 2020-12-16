package task_24;

/** Represents a Invoice.
 * @author Kyle van der Merwe
 * @version 3.0
 * @since 1.0
*/
public class Invoice {	
	
	private int invoiceID;
	private Personel customer;
	private double feeDue;	
    /** Creates a Invoice with the specified details.
     * @param invoiceID The invoice's ID
     * @param customer The invoice's linked customer
     * @param feeDue The invoice's fee still payable amount     * 
    */ 
	public Invoice(int invoiceID,
					Personel customer,
					double feeDue) {
	 
		 this.invoiceID = invoiceID;
		 this.customer = customer;
		 this.feeDue = feeDue;
 
	}
	/**Returns a string representation of this project. 
	   *  Format suitable for saving and viewing data to a text file.
	   * @return A string containing a representation of this object
	   */
	public String toString() {
		String thisInvoice = "Invoice Number : " + invoiceID;
		thisInvoice += "\n\nCustomer Details \n\n"+ customer.toString();
		thisInvoice += "\n\nAmount to Pay : R"+ feeDue;
		return thisInvoice;
	}
	/** Gets the invoice's ID.
	  * @return An integer representing this invoice's ID
	*/
	public int getInvoiceID() {
	      return invoiceID;
	}
	/** Gets the invoice's linked customer.
	  * @return A personel object representing this invoice's linked customer
	*/
	public Personel getCustomer() {
	      return customer;
	}
	/** Gets the invoice's fee due amount.
	  * @return A double representing this invoice's total fee amount still due
	*/
	public double getFeeDue() {
	      return feeDue;
	}
	/** Sets the invoice's ID.
	  * @param invoiceID An integer containing this invoice's ID
	*/
	public void setInvoiceID(int invoiceID) {
		   this.invoiceID = invoiceID;
	}
	/** Sets the invoice's linked customer.
	  * @param customer A personel object representing this invoice's linked customer
	*/
	public void setCustomer(Personel customer) {
		   this.customer = customer;
	}
	/** Sets the invoice's fee due amount.
	  * @param feeDue A double representing this invoice's total fee amount still due
	*/
	public void setFeeDue(double feeDue) {
		   this.feeDue = feeDue;
	}
}
