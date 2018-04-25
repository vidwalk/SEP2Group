import Domain.Controller.MemberController;
import Domain.Mediator.MemberListModelManager;
import Domain.Mediator.MemberListServer;
import Domain.Mediator.RemoteMemberList;
import Domain.Model.MemberModel;
import Domain.View.MemberView;
import Domain.View.ViewInterface;

public class main {
public static void main(String[] args)
{
	RemoteMemberList model = new MemberListModelManager();
	MemberListServer server = new MemberListServer(model);
	ViewInterface view = new MemberView();
	MemberController controller = new MemberController(server,view);
	view.startView(controller);
}
}
