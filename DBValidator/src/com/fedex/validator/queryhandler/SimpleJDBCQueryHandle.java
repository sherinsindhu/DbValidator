package com.fedex.validator.queryhandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fedex.validator.dbconnection.JDBCConnection;

public class SimpleJDBCQueryHandle implements IQueryHandler{

	@Override
	public int insert(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(String query) {
		Object obj = null;
		try {
		
		Connection  connection=JDBCConnection.getJDBCConnection();
		Statement stat = JDBCConnection.createJDBCStatement(connection);
		ResultSet rs = stat.executeQuery(query);
		obj =rs;
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
