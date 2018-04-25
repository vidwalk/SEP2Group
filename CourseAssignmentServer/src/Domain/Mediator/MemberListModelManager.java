package Domain.Mediator;

import Domain.Model.Member;
import Domain.Model.MemberList;
import Domain.Model.MemberModel;
import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteSubjectDelegate;

public class MemberListModelManager implements MemberModel {

	private MemberList list;
	private MemberListServer server;
	public MemberListModelManager()
	{
		list = new MemberList();
		MemberListServer server = new MemberListServer(this);
	}
	@Override
	public synchronized void addMember(Member member) {
		list.addMember(member);
		server.announce("A member has been added" + member);
	}

	@Override
	public synchronized Member[] getNotPaidMembers() {
		server.announce("A list of members that did not pay: " + list.getNotPaidMembers());
		return list.getNotPaidMembers();
	}

	@Override
	public synchronized Member[] getPaidMembers() {
		server.announce("A list of members that did pay: " + list.getPaidMembers());
		return list.getPaidMembers();
	}

	@Override
	public synchronized Member removeMember(int index) {
		server.announce("A member has been removed");
		return list.removeMember(index);
	}

}
