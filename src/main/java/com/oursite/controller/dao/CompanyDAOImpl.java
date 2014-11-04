package main.java.com.oursite.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.oursite.controller.dao.connection.DBConnection;
import main.java.com.oursite.model.Company;

public class CompanyDAOImpl implements CompanyDAO {

	public Connection connect() {
		DBConnection conn = new DBConnection();
		Connection dbConnection = null;
		try {
			dbConnection = conn.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbConnection;
	}

	@Override
	public Company get(int id) {
		Connection dbConnection = connect();
		PreparedStatement preparedStatement = null;
		String sql = "SELECT id, nameCompany, description, telephone, email, contactPerson"
				+ "FROM companies WHERE id=?;";
		Company result = new Company();
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {
				result.setId(Integer.parseInt(rs.getString("id")));
				result.setNameCompany(rs.getString("nameCompany"));
				result.setDescription(rs.getString("description"));
				result.setTelephone(rs.getString("telephone"));
				result.setEmail(rs.getString("email"));
				result.setContactPerson(rs.getString("contactPerson"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (dbConnection != null)
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return result;
	}

	@Override
	public List<Company> getAll() {
		Connection dbConnection = connect();
		Statement statement;
		String sql = "SELECT * FROM companies";
		List<Company> resultList = new ArrayList<>();
		try {
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Company result = new Company();
				result.setId(Integer.parseInt(rs.getString("id")));
				result.setNameCompany(rs.getString("nameCompany"));
				result.setDescription(rs.getString("description"));
				result.setTelephone(rs.getString("telephone"));
				result.setEmail(rs.getString("email"));
				result.setContactPerson(rs.getString("contactPerson"));
				resultList.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (dbConnection != null)
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return resultList;
	}

	@Override
	public int insert(Company object) {
		Connection dbConnection = connect();
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO companies(nameCompany, description, telephone, email, contactPerson) VALUES (?, ?, ?, ?, ?)";
		int result = 0;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, object.getNameCompany());
			preparedStatement.setString(2, object.getDescription());
			preparedStatement.setString(3, object.getTelephone());
			preparedStatement.setString(4, object.getEmail());
			preparedStatement.setString(5, object.getContactPerson());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (dbConnection != null)
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	@Override
	public int update(Company object) {
		Connection dbConnection = connect();
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE companies SET nameCompany=?, description=?, telephone=?, email=?,"
				+ "contactPerson=? WHERE id=?";
		int result = 0;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, object.getNameCompany());
			preparedStatement.setString(2, object.getDescription());
			preparedStatement.setString(3, object.getTelephone());
			preparedStatement.setString(4, object.getEmail());
			preparedStatement.setString(5, object.getContactPerson());
			preparedStatement.setInt(6, object.getId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (dbConnection != null)
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	@Override
	public int delete(int id) {
		Connection dbConnection = connect();
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM companies WHERE id=?";
		int result = 0;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (dbConnection != null)
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

}
