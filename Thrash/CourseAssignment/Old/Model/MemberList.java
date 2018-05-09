package Domain.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MemberList implements MemberModel{

	private ArrayList<Member> member;

	public MemberList() {
		member = new ArrayList<Member>();
	}

	public ArrayList<Member> getMember() {
		return member;
	}

	public void setMember(ArrayList<Member> member) {
		this.member = member;
	}

	public void addMember(Member member) {
		this.member.add(member);
		System.out.println(Log.getInstance().getTimestamp());
	}

	public Member removeMember(int index) {
		Member result = member.get(index);
		this.member.remove(index);
		return result;
	}

	public Member removeMember(Member member) {
		Member result = null;
		for (int i = 0; i < this.member.size(); i++)
			if (this.member.get(i).equals(member)) {
				result = this.member.get(i);
				this.member.remove(i);
			}
		return result;
	}

	public Member[] getNotPaidMembers() { // get an array of members that did not pay
		Member[] result = new Member[member.size()];
		int counter = 0;
		Calendar currentDate = GregorianCalendar.getInstance();
		int year = currentDate.get(Calendar.YEAR);
		for (int i = 0; i < member.size(); i++)
			if (member.get(i).getPaymentYear() != year) {
				result[counter] = member.get(i);
				counter++;
			}
		return result;
	}

	public Member[] getPaidMembers() { // get an array of members that did pay
		Member[] result = new Member[member.size()];
		int counter = 0;
		Calendar currentDate = GregorianCalendar.getInstance();
		int year = currentDate.get(Calendar.YEAR);
		for (int i = 0; i < member.size(); i++)
			if (member.get(i).getPaymentYear() == year) {
				result[counter] = member.get(i);
				counter++;
			}
		return result;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < member.size(); i++)
			result = member.get(i).toString() + " ";
		return result;
	}
}
