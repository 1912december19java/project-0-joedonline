package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerDAO implements DataAccessObject {

	Connection connection;
	
	public CustomerDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void update(Properties props) {
//		System.out.println("VALUES: " + props.values().toArray()[4]);
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.UPDATE(props))) {
			statement.setString(1, props.getProperty("firstname"));
			statement.setString(2, props.getProperty("lastname"));
			statement.setString(3, props.getProperty("city"));
			statement.setString(4, props.getProperty("state"));
//			statement.setDouble(5, props.getProperty("balance"));
			statement.setDouble(5, 800.25);
//			statement.setInt(6, props.getProperty("customer_id"));
			statement.setInt(6, 21);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addNew(Properties props) {
		Integer customerId = this.size() + 1;
		String firstName = props.getProperty("firstName");
		String lastName = props.getProperty("lastName");
		String city = props.getProperty("city");
		String state = props.getProperty("state");
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.INSERT())) {
			statement.setInt(1, customerId);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, city);
			statement.setString(5, state);
			statement.setDouble(6, 0.0);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id, String str) {
		try(PreparedStatement statement = this.connection.prepareStatement(Actions.DELETE());){
            statement.setInt(1, id);
            statement.setString(2, str);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}
	
	@Override
	public Integer size() {
		Integer size = 0;
		
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.COUNT())) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				size = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return size;
	}
	
	public Customer lookup(Integer id) {
		return this.findAll().get(id);
	}

	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
//		Map<Integer, Customer> customers = new HashMap<Integer, Customer>(); 
		
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.GET_ALL());) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Customer c = new Customer();
				c.setCustomerId(resultSet.getInt(1));
				c.setFirstName(resultSet.getString(2));
				c.setLastName(resultSet.getString(3));
				c.setCity(resultSet.getString(4));
				c.setState(resultSet.getString(5));
				c.setBalance(resultSet.getDouble(6));
				customers.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public String toString() {
		return "CustomerDAO [connection=" + connection + ", size()=" + size() + "]";
	}
	
}
