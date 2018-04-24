import java.io.IOException;

import Domain.Controller.MemberController;
import Domain.Mediator.MemberListModel;
import Domain.Mediator.MemberListModelManager;
import Domain.Model.MemberModel;
import Domain.View.MemberView;
import Domain.View.ViewInterface;

public class main {
public static void main(String[] args)
{
	MemberListModel model;
	try {
		model = new MemberListModelManager();
		ViewInterface view = new MemberView();
		MemberController controller = new MemberController(model,view);
		view.startView(controller);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
