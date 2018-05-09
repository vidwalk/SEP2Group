import java.io.IOException;
import controller.MemberController;
import domain.mediator.MemberListModel;
import domain.mediator.MemberListModelManager;
import view.MemberConsole;
import view.MemberView;

public class ClientMain {
public static void main(String[] args)
{
	try {
		MemberListModel model = new MemberListModelManager();
		MemberView view = new MemberConsole();
		MemberController controller = new MemberController(model,view);
		view.startView(controller);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
