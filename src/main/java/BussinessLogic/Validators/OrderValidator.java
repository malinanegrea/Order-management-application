package BussinessLogic.Validators;

import java.util.List;

import Entites.Orderr;
import Entites.Product;

public class OrderValidator {

	public static boolean stocValidator(List<Product> pr, Orderr o) {
		Product p= null;
		for (Product product : pr) {
			if (product.getId() == o.getIdProuct()) {
				p = product;
			}
		}
		if (p.getQuantity() >= o.getQuantity()) {
			//System.out.println(p.getQuantity() + " " + o.getQuantity());
			return true;
		}
		return false;
	}
}
