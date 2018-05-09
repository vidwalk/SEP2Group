package Domain.Model;

public interface MemberModel
{
   public void addMember(Member member);
   public Member[] getNotPaidMembers();
   public Member[] getPaidMembers();
   public Member removeMember(int index);
}
