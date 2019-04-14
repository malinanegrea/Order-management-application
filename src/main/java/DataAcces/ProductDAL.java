package DataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import Entites.Product;

public class ProductDAL extends AbstractDAO<Product>{

	private String createSelectQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("Select id ");
		sb.append(" FROM ");
		sb.append("Product ");
		sb.append("Where ");
		sb.append(" name = ? and ");
		sb.append(" price = ? and");
		sb.append( " quantity = ? ");
		
		return sb.toString();
	}
	
	
	public int selectId(String name, float price, int qunatity) {
		int id = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createSelectQuery();
		ResultSet resultSet = null;
		connection = ConnectionFactory.getConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setFloat(2, price);
			statement.setInt(3, qunatity);
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
