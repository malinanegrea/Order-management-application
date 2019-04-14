package PT2018.Assignment3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import BussinessLogic.CustomerBL;
import BussinessLogic.OrderBL;
import BussinessLogic.ProductBL;
import Presentation.Controler;
import Presentation.MainFrame;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		CustomerBL cusBl = new CustomerBL();
		ProductBL proBL = new ProductBL();
		OrderBL ordBL = new OrderBL(proBL,cusBl);
		MainFrame mf = new MainFrame();
		Controler c= new Controler(mf, cusBl,ordBL, proBL);
		c.setVisible();
	}
	

}
