package Domain.Mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;

import Domain.Model.Member;
import Domain.Model.MemberModel;
import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubjectDelegate;

public class MemberListServer implements RemoteMemberList {
	private static final long serialVersionUID = 1L;
	private MemberModel list;
	private RemoteSubjectDelegate<String> rsd;
	public MemberListServer(MemberModel list) {
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
		this.list = list;
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
	public synchronized void addMember(Member member) throws RemoteException {
		list.addMember(member);
	}

	@Override
	public synchronized  Member[] getNotPaidMembers() throws RemoteException {

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
		rsd.addObserver(o);
		}
	@Override
	public void deleteObserver(RemoteObserver<String> o) throws RemoteException {
		rsd.deleteObserver(o);
	}
	public void announce(String msg)
	{
		System.out.println("Message: " + msg);
		rsd.notifyObservers(msg);
	}

}
