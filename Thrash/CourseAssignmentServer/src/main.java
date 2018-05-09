import java.rmi.RemoteException;

import Domain.Controller.MemberController;
import Domain.Mediator.MemberListModelManager;
import Domain.Mediator.MemberListServer;
import Domain.Mediator.RemoteMemberList;
import Domain.Model.MemberModel;
import Domain.View.MemberView;
import Domain.View.ViewInterface;

public class main {
	public static void main(String[] args) {

		try {
			RemoteMemberList model = new MemberListModelManager();
			RemoteMemberList server = new MemberListServer(model);
			ViewInterface view = new MemberView();
			server.addObserver(view);
			MemberController controller = new MemberController(server, view);
			view.startView(controller);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
