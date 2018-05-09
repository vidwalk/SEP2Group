package domain.mediator;
import java.rmi.Remote;
import java.rmi.RemoteException;
import domain.model.Member;
import utility.observer.RemoteSubject;

public interface RemoteMemberList extends Remote
{
   public void addMember(Member member) throws RemoteException;
   public Member[] getNotPaidMembers() throws RemoteException;
   public Member[] getPaidMembers() throws RemoteException;
   public Member removeMember(int index) throws RemoteException;
}
