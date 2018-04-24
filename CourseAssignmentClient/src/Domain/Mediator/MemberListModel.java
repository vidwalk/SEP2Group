package Domain.Mediator;

import java.rmi.RemoteException;

import Domain.Model.Member;

public interface MemberListModel
{
   public void addMember(Member member);

	public Member[] getNotPaidMembers() ;

	public Member[] getPaidMembers() ;

	public Member removeMember(int index);

}
