import java.io.IOException;
import java.util.Scanner;

import zair.controller.CustomerController;
import zair.domain.mediator.FlightModel;
import zair.domain.mediator.FlightModelManager;
import zair.domain.mediator.Init;
import zair.view.CustomerGUI;
import zair.view.CustomerView;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String[] connectionData = scan.nextLine().split(" ");
		Init.getInstance().setIp(connectionData[0]);
		Init.getInstance().setPort(Integer.parseInt(connectionData[1]));
		FlightModel model = new FlightModelManager();
		CustomerView view = new CustomerGUI();
		CustomerController controller = new CustomerController(model,view);
		   view.startController(controller);
	}

}
