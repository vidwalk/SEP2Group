package Domain.Mediator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Domain.Model.Member;





public class MemberListClient implements MemberListModel
{

   private RemoteMemberList list;

   public MemberListClient(String host) throws IOException, NotBoundException
   {
      list = (RemoteMemberList) Naming.lookup(host);
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
