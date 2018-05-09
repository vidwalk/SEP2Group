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
import utility.observer.RemoteSubjectDelegate;

public class MemberListClient implements RemoteMemberList, RemoteObserver<String> {
	private RemoteMemberList list;
	private RemoteSubjectDelegate<String> rsd;
	public MemberListClient(String host) throws IOException, NotBoundException {
		super();
		list = (RemoteMemberList) Naming.lookup(host);
		rsd = new RemoteSubjectDelegate<String>(this);
		UnicastRemoteObject.exportObject(this, 0);
		list.addObserver(this);
	}

	@Override
	public void addMember(Member member) throws RemoteException {
		list.addMember(member);
		announce("A member has been added " + member);
	}

	@Override
	public  Member[] getNotPaidMembers() throws RemoteException {
		announce("A list of members that did not pay: " + list.getNotPaidMembers());
		return list.getNotPaidMembers();
	}

	@Override
	public  Member[] getPaidMembers() throws RemoteException {
		announce("A list of members that did pay: " + list.getPaidMembers());
		return list.getPaidMembers();
	}

	@Override
	public synchronized Member removeMember(int index) throws RemoteException {
		announce("A member has been removed");
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

	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		System.out.println(updateMsg);
	}


}
