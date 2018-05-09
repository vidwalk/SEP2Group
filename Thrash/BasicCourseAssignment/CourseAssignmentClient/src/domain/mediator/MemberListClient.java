package domain.mediator;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import domain.model.Member;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class MemberListClient implements MemberListModel
{
   private RemoteMemberList list;

   public MemberListClient(String host) throws IOException, NotBoundException
   {
      list = (RemoteMemberList) Naming.lookup("rmi://localhost:1099/Member");
   }
   
   @Override
	public void addMember(Member member) {
		try
      {
         list.addMember(member);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
	}

	@Override
	public Member[] getNotPaidMembers() {
		Member[] members = null;
	   try
      {
         members = list.getNotPaidMembers();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
	   return members;
	}

	@Override
	public Member[] getPaidMembers() {
	   Member[] members = null;
	   try
      {
         members = list.getPaidMembers();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
	   return members;
	}

	@Override
	public Member removeMember(int index) {
	   Member member = null;
	   try
      {
         member = list.removeMember(index);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
	   return member;
	}

}
