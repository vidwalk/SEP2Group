package domain.mediator;

import java.rmi.RemoteException;

import domain.model.Member;
import domain.model.MemberList;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubjectDelegate;

public class MemberListModelManager implements MemberModel {

	private MemberList list;
	private MemberListServer server;

	public MemberListModelManager()
	{
	   server = new MemberListServer(this);
		list = new MemberList();
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
