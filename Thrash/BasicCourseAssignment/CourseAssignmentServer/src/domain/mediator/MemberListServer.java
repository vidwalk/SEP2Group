package domain.mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import domain.model.Member;
import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubjectDelegate;

public class MemberListServer implements RemoteMemberList{
	private MemberModel model;

	public MemberListServer(MemberModel model) {
	   this.model = model;
	   startRegistry();
		try {
			UnicastRemoteObject.exportObject(this, 0);
			Naming.rebind("Member", this);
			System.out.println("Server started...");
		}
		catch(RemoteException | MalformedURLException e)
		{
			System.out.println("Unable to started server!!! ");
			e.printStackTrace();
		}
	}
	private void startRegistry() {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			System.out.println("Registry started... ");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addMember(Member member) throws RemoteException {
		model.addMember(member);
	}

	@Override
	public Member[] getNotPaidMembers() throws RemoteException {
		return model.getNotPaidMembers();
	}

	@Override
	public Member[] getPaidMembers() throws RemoteException {
		return model.getPaidMembers();
	}

	@Override
	public Member removeMember(int index) throws RemoteException {
		return model.removeMember(index);
	}
}
