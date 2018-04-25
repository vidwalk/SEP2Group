package Domain.Mediator;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;

import Domain.Model.Member;
import Domain.Model.MemberList;
import utility.observer.RemoteSubject;

public class MemberListModelManager extends Observable implements MemberListModel  {

	private MemberList list;

	public MemberListModelManager() throws IOException {
		list = new MemberList();
		try {
			MemberListClient client = new MemberListClient("rmi://localhost:1099/Member", this);
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

	public void annouce(String msg) {
		notifyObservers(msg);
	}

}
