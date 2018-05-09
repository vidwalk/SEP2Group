package Domain.View;

import Domain.Controller.MemberController;
import utility.observer.RemoteObserver;

public interface ViewInterface extends RemoteObserver<String>{

	public void startView(MemberController controller);
	public String get(String text);
	public void show(String text);
}
