import zair.controller.FlightController;
import zair.domain.mediator.FlightModel;
import zair.domain.mediator.FlightModelManager;
import zair.view.FlightGUI;
import zair.view.FlightView;

public class Main {

	public static void main(String[] args) {
		FlightModel model = new FlightModelManager();
		   FlightView view = new FlightGUI();
		   FlightController controller = new FlightController(model,view);
		   view.startController(controller);
	}

}
