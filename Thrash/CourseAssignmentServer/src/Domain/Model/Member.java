package Domain.Model;

import java.io.Serializable;

public class Member implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String email;

	private int paymentYear;

	private String phone;

	private AbstractPreference abstractPreference;

	public Member(String name, String email, String phone,int paymentYear ,String preference) {
		this.name = name;
		this.email = email;
		this.paymentYear = paymentYear;
		this.phone = phone;
		this.abstractPreference = PreferenceFactory.getPreference(preference);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPaymentYear(int paymentYear) {
		this.paymentYear = paymentYear;
	}

	public int getPaymentYear() {
		return paymentYear;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public AbstractPreference getAbstractPreference() {
		return abstractPreference;
	}

	public void setAbstractPreference(String name) {
		this.abstractPreference.setName(name);
	}

	public String toString()
	{
		return  "name=" + name + ", email=" + email + ", paymentYear=" + paymentYear + ", phone=" + phone
		+ ", abstractPreference=" + abstractPreference.toString();
	}

}
