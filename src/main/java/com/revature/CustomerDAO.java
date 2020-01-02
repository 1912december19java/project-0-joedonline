package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CustomerDAO implements DAOCreateUpdateDelete, DAOCustomer {

	Connection connection;
	
	public CustomerDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Integer getCustomerId(String firstName, String lastName, String city, String state) {
		Integer id = 0;
		
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.GET_USER_ID())) {
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, city);
			statement.setString(4, state);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
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
		Integer customerId = this.size() + 1; // REPLACE WITH RANDOM GENERATOR
		String firstName = props.getProperty("firstName");
		String lastName = props.getProperty("lastName");
		String city = props.getProperty("city");
		String state = props.getProperty("state");
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.ADD_NEW_CUSTOMER())) {
			statement.setInt(1, customerId);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, city);
			statement.setString(5, state);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String customerId, String firstName) {
		try(PreparedStatement statement = this.connection.prepareStatement(Actions.DELETE_CUSTOMER())){
            statement.setString(1, customerId);
            statement.setString(2, firstName);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}
	
	@Override
	public Integer size() {
		Integer size = 0;
		
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.COUNT_CUSTOMERS())) {
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
		try {
			return this.findAll().get(id);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
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
		return "CustomerDAO [connection=" + connection + ", size()=" + size() + ", findAll()=" + findAll()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
