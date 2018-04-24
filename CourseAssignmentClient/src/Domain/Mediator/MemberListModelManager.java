package Domain.Mediator;

import java.io.IOException;
import java.rmi.NotBoundException;

import Domain.Model.Member;
import Domain.Model.MemberList;

public class MemberListModelManager implements MemberListModel {

	private MemberList list;

	public MemberListModelManager() throws IOException {
		list = new MemberList();
		try {
			MemberListClient client = new MemberListClient("rmi://localhost:1099/Member");
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addMember(Member member) {
		list.addMember(member);
	}

	@Override
	public Member[] getNotPaidMembers() {
		return list.getNotPaidMembers();
	}

	@Override
	public Member[] getPaidMembers() {
		return list.getPaidMembers();
	}

	@Override
	public Member removeMember(int index) {
		return list.removeMember(index);
	}
}
