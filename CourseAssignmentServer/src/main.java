import Domain.Controller.MemberController;
import Domain.Mediator.MemberListModelManager;
import Domain.Model.MemberModel;
import Domain.View.MemberView;
import Domain.View.ViewInterface;

public class main {
public static void main(String[] args)
{
	MemberModel model = new MemberListModelManager();
	ViewInterface view = new MemberView();
	MemberController controller = new MemberController(model,view);
	view.startView(controller);
}
}
