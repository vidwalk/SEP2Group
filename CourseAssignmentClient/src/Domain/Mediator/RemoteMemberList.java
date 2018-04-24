package Domain.Mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Domain.Model.Member;

import java.io.Serializable;

public interface RemoteMemberList extends Remote {
	public void addMember(Member member);

	public Member[] getNotPaidMembers();

	public Member[] getPaidMembers();

	public Member removeMember(int index);

}
