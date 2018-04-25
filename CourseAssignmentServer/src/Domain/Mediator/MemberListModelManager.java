package Domain.Mediator;

import java.rmi.RemoteException;

import Domain.Model.Member;
import Domain.Model.MemberList;
import Domain.Model.MemberModel;
import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubjectDelegate;

public class MemberListModelManager implements RemoteMemberList {

	private MemberList list;

	public MemberListModelManager() {
		list = new MemberList();
	}

	@Override
	public synchronized void addMember(Member member) throws RemoteException {
		list.addMember(member);

	}

	@Override
	public synchronized Member[] getNotPaidMembers() throws RemoteException {

		return list.getNotPaidMembers();
	}

	@Override
	public synchronized Member[] getPaidMembers() throws RemoteException {

		return list.getPaidMembers();
	}

	@Override
	public synchronized Member removeMember(int index) throws RemoteException {

		return list.removeMember(index);
	}

	@Override
	public void addObserver(RemoteObserver<String> o) throws RemoteException {

	}

	@Override
	public void deleteObserver(RemoteObserver<String> o) throws RemoteException {

	}

}
