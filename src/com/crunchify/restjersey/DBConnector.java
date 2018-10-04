package com.crunchify.restjersey;

import java.sql.*;

import org.apache.log4j.Logger;


class DBConnector {
	static Logger log = Logger.getLogger(DBConnector.class.getName());

	private DBConnector() {

	}

	public static void main(String[] args) throws SQLException {

		final String url = JGConstants.getUrlconnection();
		final String user = JGConstants.getUsername();
		final String password = JGConstants.getPassword();
		;

		// JDBC variables for opening and managing connection
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query = "select * from REGISTERUSER";

		try {
			// opening database connection to MySQL server
			con = DriverManager.getConnection(url, user, password);

			// getting Statement object to execute query
			stmt = con.createStatement();

			// executing SELECT query
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append(rs.getString("NAME").toUpperCase());
				sb.append(" ");
				sb.append(rs.getString("PASS").toUpperCase());
				sb.append(" ");
				sb.append(rs.getString("COUNTRY"));
			}
			// close connection ,stmt and resultset here

			con.close();
			stmt.close();
			rs.close();
		} finally {
			log.error("Something went wrong on the finally statement, connections not closed or something.");
		}
	}
}
