package com.yudi.tutor.SpringCore.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yudi.tutor.SpringCore.customer.dao.CustomerDao;
import com.yudi.tutor.SpringCore.customer.model.Customer;


@Service
public class JdbcCustomerDao implements CustomerDao {


	DataSource dataSource;
	
	Connection connection = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int insert(Customer customer) {
		// TODO Auto-generated method stub

		String sqlInsert = "INSERT INTO customer VALUES (?,?,?)";

		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sqlInsert);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());

			int result = ps.executeUpdate();
			ps.close();
			
			return result;
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);			
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Customer findCustomerById(int custId) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM customer WHERE cust_id = ?";
		Customer customer = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setCustId(rs.getInt("CUST_ID"));
				customer.setName(rs.getString(2));
				customer.setAge(rs.getInt(3));
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return customer;
	}

}
