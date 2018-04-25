package Domain.Model;

import java.io.Serializable;

public interface MemberModel extends Serializable
{
   public void addMember(Member member);
   public Member[] getNotPaidMembers();
   public Member[] getPaidMembers();
   public Member removeMember(int index);
}
