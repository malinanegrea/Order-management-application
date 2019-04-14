package DataAcces;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import Entites.Customer;

public class CustomerDAL  extends AbstractDAO<Customer>{

	private String createSelectQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("Select id ");
		sb.append(" FROM ");
		sb.append("Customer ");
		sb.append("Where ");
		sb.append(" name = ? and ");
		sb.append(" address= ? and");
		sb.append( " phoneNr = ? ");
		
		return sb.toString();
	}
	
	
	public int selectId(String name, String address, String phoneNr) {
		int id = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createSelectQuery();
		ResultSet resultSet = null;
		connection = ConnectionFactory.getConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, address);
			statement.setString(3, phoneNr);
			resultSet = statement.executeQuery();
			resultSet.next();
			id = resultSet.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
}
