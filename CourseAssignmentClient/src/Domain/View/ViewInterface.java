package Domain.View;

import Domain.Controller.MemberController;

public interface ViewInterface {

	public void startView(MemberController controller);
	public String get(String text);
	public void show(String text);
}
