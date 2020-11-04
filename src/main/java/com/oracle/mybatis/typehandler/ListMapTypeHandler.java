package com.oracle.mybatis.typehandler;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListMapTypeHandler implements TypeHandler<Object> {
	
	private static final Logger log = LoggerFactory.getLogger(ListMapTypeHandler.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		
		List<Map> objects = (List<Map>) parameter;

        StructDescriptor structDescriptor = new StructDescriptor("EMP_MAP", ps.getConnection());

        STRUCT[] structs = new STRUCT[objects.size()];

        log.debug("List Size --------> {}",objects.size());

        for (int index = 0; index < objects.size(); index++) {

            Map map = objects.get(index);

            Object[] params = new Object[map.keySet().size()];
            Iterator<String> iterator = map.keySet().iterator();
            int keyIndex = 0;
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                params[keyIndex] = map.get(key);
                log.debug("{}:{}:{} -----> {}",index,keyIndex,key,map.get(key));
                keyIndex++;
            }

            log.debug("params -----> {}, length -----> {}",params,params.length);

            STRUCT struct = new STRUCT(structDescriptor, ps.getConnection(),params);
            structs[index] = struct;
         
      }

      ArrayDescriptor desc = ArrayDescriptor.createDescriptor("EMP_List",ps.getConnection());
      Array array = new ARRAY(desc, ps.getConnection(),structs);
      ps.setArray(i, array);

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
