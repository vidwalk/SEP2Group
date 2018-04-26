package domain.mediator;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.util.Observable;

import domain.model.Log;
import domain.model.Member;

public class MemberListModelManager extends Observable implements MemberListModel{
	private MemberListModel model;

	public MemberListModelManager() throws IOException {
		try
      {
         model = new MemberListClient("localhost");
      }
      catch (NotBoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
	}

	@Override
	public void addMember(Member member) {
		model.addMember(member);
		setChanged();
		notifyObservers(Log.getInstance().getTimestamp() + " Member added");
	}

	@Override
	public Member[] getNotPaidMembers() {
		return model.getNotPaidMembers();
	}

	@Override
	public Member[] getPaidMembers() {
		return model.getPaidMembers();
	}

	@Override
	public Member removeMember(int index) {
	   setChanged();
	   notifyObservers(Log.getInstance().getTimestamp() + " Member removed");
	   return model.removeMember(index);
	}
}
