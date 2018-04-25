package Domain.Mediator;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;

import Domain.Model.Member;
import Domain.Model.MemberList;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class MemberListModelManager implements RemoteMemberList  {

	private RemoteMemberList list;
	public MemberListModelManager() throws IOException, NotBoundException {
		list= new MemberListClient("rmi://localhost:1099/Member");
	}

	@Override
	public void addMember(Member member) throws RemoteException {
		list.addMember(member);

	}

	@Override
	public Member[] getNotPaidMembers() throws RemoteException {
		return list.getNotPaidMembers();
	}

	@Override
	public Member[] getPaidMembers() throws RemoteException {
		return list.getPaidMembers();
	}

	@Override
	public Member removeMember(int index) throws RemoteException {
		return list.removeMember(index);
	}

	@Override
	public void addObserver(RemoteObserver<String> o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteObserver(RemoteObserver<String> o) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
