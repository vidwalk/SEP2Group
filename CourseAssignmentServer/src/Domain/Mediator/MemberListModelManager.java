package Domain.Mediator;

import Domain.Model.Member;
import Domain.Model.MemberList;
import Domain.Model.MemberModel;

public class MemberListModelManager implements MemberModel {

	private MemberList list;

	public MemberListModelManager()
	{
		list = new MemberList();
		MemberListServer server = new MemberListServer(this);
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
