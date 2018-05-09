package view;

import controller.MemberController;

public interface MemberView {

	public void startView(MemberController controller);
	public String get(String text);
	public void show(String text);
}
