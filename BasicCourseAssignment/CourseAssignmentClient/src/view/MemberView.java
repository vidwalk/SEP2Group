package view;

import java.util.Observer;

import controller.MemberController;

public interface MemberView extends Observer{

	public void startView(MemberController controller);
	public String get(String text);
	public void show(String text);
}
