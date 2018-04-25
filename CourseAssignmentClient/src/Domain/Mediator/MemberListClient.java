package Domain.Mediator;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;
import java.util.Observer;

import Domain.Model.Member;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;





public class MemberListClient implements MemberListModel, RemoteObserver<String>{

   private RemoteMemberList list;
   private MemberListModelManager manager;
   public MemberListClient(String host, MemberListModelManager manager) throws IOException, NotBoundException
   {
      list = (RemoteMemberList) Naming.lookup(host);
      list.addObserver(this);
      this.manager = manager;
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



	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		manager.annouce(updateMsg);
	}






}
