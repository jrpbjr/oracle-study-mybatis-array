package com.oracle.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.ARRAY; 
import oracle.sql.ArrayDescriptor; 
import oracle.sql.STRUCT; 
import oracle.sql.StructDescriptor;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class ArrayTypeOra implements TypeHandler {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ArrayDescriptor desc = ArrayDescriptor.createDescriptor("STRARRAY ", ps.getConnection());
		   ARRAY oracleArray = new ARRAY(desc, ps.getConnection(), parameter);
		   ps.setArray(i, oracleArray);
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
