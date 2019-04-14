package BussinessLogic.Validators;

import java.util.regex.Pattern;

import Entites.Customer;


public class ClientValidator {

	static String regexStr = "^[0-9]{10}$";
	
	public static boolean phoneNrValidator(Customer c)
	{
		Pattern pattern = Pattern.compile(regexStr);
		if (pattern.matcher(c.getPhoneNr()).matches()) {
			return true; 
		}
		return false;
	}
}
