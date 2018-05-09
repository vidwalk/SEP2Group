package Domain.Mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Domain.Model.Member;
import utility.observer.RemoteSubject;

public interface RemoteMemberList extends RemoteSubject<String> {
	public void addMember(Member member) throws RemoteException;

	public Member[] getNotPaidMembers() throws RemoteException;

	public Member[] getPaidMembers() throws RemoteException;

	public Member removeMember(int index) throws RemoteException;
}
