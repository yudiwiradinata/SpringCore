package com.yudi.tutor.SpringCore.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement; 	 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import com.yudi.tutor.SpringCore.customer.dao.CustomerDao;
import com.yudi.tutor.SpringCore.customer.model.Customer;

@Repository
public class JdbcCustomerDao extends JdbcDaoSupport implements CustomerDao {

	@Autowired
	public JdbcCustomerDao(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		setDataSource(dataSource);
	}

	Connection connection = null;

	JdbcTemplate jdbcTemplate;

	/*
	 * public int insert(Customer customer) { // TODO Auto-generated method stub
	 * 
	 * String sqlInsert = "INSERT INTO customer VALUES (?,?,?)";
	 * 
	 * try { connection = dataSource.getConnection(); PreparedStatement ps =
	 * connection.prepareStatement(sqlInsert); ps.setInt(1,
	 * customer.getCustId()); ps.setString(2, customer.getName()); ps.setInt(3,
	 * customer.getAge());
	 * 
	 * int result = ps.executeUpdate(); ps.close();
	 * 
	 * return result;
	 * 
	 * } catch (SQLException e) { // TODO: handle exception throw new
	 * RuntimeException(e); } finally { if (connection != null) { try {
	 * connection.close(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } } } }
	 */

	/*
	 * public Customer findCustomerById(int custId) { // TODO Auto-generated
	 * method stub
	 * 
	 * String sql = "SELECT * FROM customer WHERE cust_id = ?"; Customer
	 * customer = null; try { connection = dataSource.getConnection();
	 * PreparedStatement ps = connection.prepareStatement(sql); ps.setInt(1,
	 * custId); ResultSet rs = ps.executeQuery(); if (rs.next()) { customer =
	 * new Customer(); customer.setCustId(rs.getInt("CUST_ID"));
	 * customer.setName(rs.getString(2)); customer.setAge(rs.getInt(3)); }
	 * 
	 * rs.close(); ps.close();
	 * 
	 * } catch (SQLException e) { // TODO: handle exception throw new
	 * RuntimeException(e); } finally { if (connection != null) { try {
	 * connection.close(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } } }
	 * 
	 * return customer; }
	 */

	public int insert(Customer customer) {
		// TODO Auto-generated method stub

		String sqlInsert = "INSERT INTO customer VALUES (?,?,?)";

		return getJdbcTemplate().update(
				sqlInsert,
				new Object[] { customer.getCustId(), customer.getName(),
						customer.getAge() });

	}

	public String findCustomerNameById(int id) {
		// TODO Auto-generated method stub
		// jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT name FROM customer WHERE cust_id = ?";

		String name = getJdbcTemplate().queryForObject(sql,
				new Object[] { id }, String.class);
		return name;
	}

	public Customer findCustomerById(int custId) {
		// TODO Auto-generated method stub
		// jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * FROM customer WHERE cust_id = ?";

		Customer customer = getJdbcTemplate().queryForObject(sql,
				new Object[] { custId },
				new BeanPropertyRowMapper<Customer>(Customer.class));

		return customer;
	}

	public Map<String, Object> find2ColumnById(int id) {
		// jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT name,age FROM customer WHERE cust_id = ?";

		Map<String, Object> result = new HashMap<String, Object>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,
				new Object[] { id });
		for (Map<String, Object> row : rows) {
			result.put("name", row.get("NAME"));
			result.put("age", row.get("AGE"));

		}

		return result;
	}

	public List<Customer> findbyIdList(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customer WHERE cust_id = ?";

		List<Customer> customers = new ArrayList<Customer>();

		// jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,
				new Object[] { id });
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			customer.setCustId(Integer.parseInt(String.valueOf(row.get(
					"CUST_ID").toString())));
			customer.setName((String) row.get("NAME"));
			customer.setAge(Integer.parseInt(String.valueOf(row.get("AGE")
					.toString())));
			customers.add(customer);

		}

		return customers;
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customer";

		List<Customer> customers = new ArrayList<Customer>();

		// jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			customer.setCustId(Integer.parseInt(String.valueOf(row.get(
					"CUST_ID").toString())));
			customer.setName((String) row.get("NAME"));
			customer.setAge(Integer.parseInt(String.valueOf(row.get("AGE")
					.toString())));
			customers.add(customer);

		}

		return customers;
	}

	public void insertBatch1(final List<Customer> customers) {
		// TODO Auto-generated method stub
		String sqlInsert = "INSERT INTO customer VALUES (?,?,?)";
		
		getJdbcTemplate().batchUpdate(sqlInsert, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				Customer customer = customers.get(i);
				ps.setInt(1,customer.getCustId());
				ps.setString(2,customer.getName());
				ps.setInt(3,customer.getAge());				
				
			}
			
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return customers.size();
			}
		});
	}

	public void insertBatch2(String sql) {
		// TODO Auto-generated method stub
	
		getJdbcTemplate().batchUpdate(new String[]{sql});
	}

}
