import java.rmi.RemoteException;

import controller.MemberController;
import domain.mediator.MemberListModelManager;
import domain.mediator.MemberListServer;
import domain.mediator.MemberModel;
import utility.observer.RemoteObserver;
import view.MemberConsole;
import view.MemberView;

public class ServerMain {

   public static void main(String[] args)
   {
      MemberModel model = new MemberListModelManager();
	   MemberView view = new MemberConsole();
	   MemberController controller = new MemberController(model,view);
	   view.startView(controller);
	}
}
