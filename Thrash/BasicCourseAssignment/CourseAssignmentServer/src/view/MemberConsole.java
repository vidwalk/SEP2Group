package view;
import java.rmi.RemoteException;
import java.util.Scanner;

import controller.MemberController;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;


public class MemberConsole implements MemberView, Runnable{

	private Scanner keyboard;
	private MemberController controller;

	public MemberConsole()
	{
		this.controller = null;
		keyboard = new Scanner(System.in);
	}

	public void startView(MemberController controller)
	{
		this.controller = controller;
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run()
	{
		boolean continueWorking = true;
	      while (continueWorking)
	      {
	        System.out.println("Please enter your choice: ");
	        System.out.println("0) Press 0 to EXIT.");
	        System.out.println("1) Press 1 to add a member.");
	        System.out.println("2) Press 2 to remove a member.");
	        System.out.println("3) Press 3 to get a list of unpaid members.");
	        System.out.println("4) Press 4 to get a list of paid members.");

	         int choice = keyboard.nextInt();
	         keyboard.nextLine();

	         String txt = "";

	         if(choice == 0)
	        	 txt = "exit";
	         if(choice == 1)
	        	 txt = "add";
	         if(choice == 2)
	        	 txt = "remove";
	         if(choice == 3)
	        	 txt = "unpaid";
	         if(choice == 4)
	        	 txt = "paid";


	         controller.execute(txt);

	         if (choice == 0)
	         {
	            continueWorking = false;
	         }


	      }
	      keyboard.close();
	}

	public String get(String text)
	{
		show(text);
		return keyboard.nextLine();
	}

	public void show(String text)
	{
		System.out.println(text);
	}
}
