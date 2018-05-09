package controller;

import java.util.Observable;
import java.util.Observer;

import domain.mediator.MemberListModel;
import domain.model.Member;
import view.MemberView;

public class MemberController
{
   private MemberListModel model;
   private MemberView view;

   public MemberController(MemberListModel model, MemberView view)
   {
      this.model = model;
      this.view = view;
      Observable obs = (Observable) this.model;
      obs.addObserver(view);
   }

   public void execute(String what)
   {
      if (what.equalsIgnoreCase("add"))
      {
         String name = view.get("Type in the member's name: ");
         String email = view.get("Type in the member's email: ");
         int paymentYear = Integer.parseInt(view.get("Type in the payment year: "));
         String phone = view.get("Type in the member's phone number: ");
         view.show("NOTE!!! Legal names for preference: Astrology, Yoga, Trips, Meditation, Workshop,"
               + " Reincarnation, Karma and Alternative Health Care!");
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
