package com.lz.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.lz.domain.Users;
import com.lz.form.UserForm;
import com.lz.utils.OracleSQLHelper;

public class UserService {

	OracleSQLHelper sqlHelper = new OracleSQLHelper();

	public boolean checkUser(Users users) {
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (PreparedStatement statement = sqlHelper.getconn().prepareStatement(query)) {
//			statement.setInt(1, users.getUser_id());
			statement.setString(1, users.getUsername());
			statement.setString(2, users.getPassword());
//			statement.setString(4, users.getEmail());
//			statement.setTimestamp(5, users.getCreated_at());

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
}
