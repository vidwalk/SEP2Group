package domain.model;
import java.io.Serializable;

public class Member implements Serializable{

	private String name;
	private String email;
	private int paymentYear;
	private String phone;
	private AbstractPreference abstractPreference;

	public Member(String name, String email, String phone,int paymentYear, String preference) {
		this.name = name;
		this.email = email;
		this.paymentYear = paymentYear;
		this.phone = phone;
		this.abstractPreference = PreferenceFactory.getPreference(preference);
	}

	public String getName() {
		return name;
	}

	public void setPaymentYear(int paymentYear) {
		this.paymentYear = paymentYear;
	}

	public int getPaymentYear() {
		return paymentYear;
	}

	public String toString() //make it look better
	{
		return  "\nName: " + name + "\nEmail: " + email + "\nYear of payment: " + paymentYear + "\nPhone number: " + phone
		+ "\nPreference: " + abstractPreference.getEventType();
	}

}
