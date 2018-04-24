package Domain.Mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Domain.Model.Member;
import Domain.Model.MemberModel;

public class MemberListServer implements RemoteMemberList{
	private static final long serialVersionUID = 1L;
	private MemberModel list;

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
}
