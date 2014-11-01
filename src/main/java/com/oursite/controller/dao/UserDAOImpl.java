package main.java.com.oursite.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.oursite.controller.dao.connection.DBConnection;
import main.java.com.oursite.model.User;

public class UserDAOImpl implements UserDAO {

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
	public User get(int id) {
		Connection dbConnection = connect();
		PreparedStatement preparedStatement = null;
		String sql = "SELECT users.id, users.email, users.password, "
				+ "users.role FROM users WHERE users.id=?;";
		User result = new User();
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {
				result.setId(Integer.parseInt(rs.getString("id")));
				result.setEmail(rs.getString("email"));
				result.setPassword(rs.getString("password"));
				result.setId(Integer.parseInt(rs.getString("role")));
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
	public List<User> getAll() {
		Connection dbConnection = connect();
		Statement statement;
		String sql = "SELECT * FROM users";
		List<User> resultList = new ArrayList<>();
		try {
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				User result = new User();
				result.setId(Integer.parseInt(rs.getString("id")));
				result.setEmail(rs.getString("email"));
				result.setPassword(rs.getString("password"));
				result.setId(Integer.parseInt(rs.getString("role")));
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
	public int insert(User object) {
		Connection dbConnection = connect();
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO users(email, password, role) VALUES (?, ?, ?)";
		int result = 0;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, object.getEmail());
			preparedStatement.setString(2, object.getPassword());
			preparedStatement.setInt(3, object.getRole());
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
	public int update(User object) {
		Connection dbConnection = connect();
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE users SET email=?, password=?, role=? WHERE id=?";
		int result = 0;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, object.getEmail());
			preparedStatement.setString(2, object.getPassword());
			preparedStatement.setInt(3, object.getRole());
			preparedStatement.setInt(4, object.getId());
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
		String sql = "DELETE FROM users WHERE id=?";
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
