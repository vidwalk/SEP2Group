package Domain.Controller;

import java.rmi.RemoteException;

import Domain.Mediator.RemoteMemberList;
import Domain.Model.Member;
import Domain.Model.MemberModel;
import Domain.View.MemberView;
import Domain.View.ViewInterface;

public class MemberController
{
   private RemoteMemberList model;
   private ViewInterface view;

   public MemberController(RemoteMemberList model, ViewInterface view)
   {
      this.model = model;
      this.view = view;
   }

   public void execute(String what) throws RemoteException
   {
      if (what.equalsIgnoreCase("add"))
      {
         String name = view.get("Type in the member's name: ");
         String email = view.get("Type in the member's email: ");
         int paymentYear = Integer.parseInt(view.get("Type in the payment year: "));
         String phone = view.get("Type in the member's phone number: ");
         String preference = view.get("Type in the member's preference: ");
         Member member = new Member(name, email, phone, paymentYear, preference);
         model.addMember(member);
      }
      else if (what.equalsIgnoreCase("remove"))
      {
         int index = Integer.parseInt(view.get("Type in the index of the member you want to remove: "));
         model.removeMember(index);
      }
      else if (what.equalsIgnoreCase("unpaid"))
      {
         Member[] members = model.getNotPaidMembers();
         for (int i = 0; i < members.length; i++)
         {
            view.show(members[i].toString());
         }
      }
      else if (what.equalsIgnoreCase("paid"))
      {
         Member[] members = model.getPaidMembers();
         for (int i = 0; i < members.length; i++)
         {
            view.show(members[i].toString());
         }
      }
      else if (what.equalsIgnoreCase("exit"))
      {
         System.exit(1);
      }
   }
}
