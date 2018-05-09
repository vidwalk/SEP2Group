import java.io.IOException;
import java.rmi.NotBoundException;

import Domain.Controller.MemberController;
import Domain.Mediator.MemberListClient;
import Domain.Mediator.MemberListModelManager;
import Domain.Mediator.RemoteMemberList;
import Domain.Model.MemberModel;
import Domain.View.MemberView;
import Domain.View.ViewInterface;

public class main {
public static void main(String[] args) throws NotBoundException
{
	RemoteMemberList model;
	try {
		model = new MemberListModelManager();
		ViewInterface view = new MemberView();
		model.addObserver(view);
		MemberController controller = new MemberController(model,view);
		view.startView(controller);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
