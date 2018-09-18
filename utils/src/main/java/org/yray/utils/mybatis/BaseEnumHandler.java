package org.yray.utils.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@SuppressWarnings({"rawtypes","unchecked"})
public class BaseEnumHandler<E extends BaseEnum>  extends BaseTypeHandler<E> {
	private Class<E> type;
	private E [] enums;
	
	public BaseEnumHandler(Class type) {
		 if (type == null) throw new IllegalArgumentException("Type argument cannot be null");
		    this.type = type;
		    this.enums = this.type.getEnumConstants();
	}
	private E [] getEnums()
	{
		this.enums = this.type.getEnumConstants();
		return this.enums;
	}
	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		 String s = cs.getString(columnIndex);

		 if(this.getEnums() != null){
				for(BaseEnum e : getEnums()){
					if(s != null && e.getValue().equals(s)){
						return (E)e;
					}
				}
			}
		 return null;
	}
	
	@Override
	public E getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String s = rs.getString(columnIndex);
		if(this.getEnums() != null){
			for(BaseEnum e : getEnums()){
				if(s != null && e.getValue().equals(s)){
					return (E)e;
				}
			}
		}
		return null;
	}
	
	@Override
	public E getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		 String s = rs.getString(columnName);
		 
		 if(this.getEnums() != null){
				for(BaseEnum e : getEnums()){
					if(s != null && e.getValue().equals(s)){
						return (E)e;
					}
				}
			}
		    return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter,
			JdbcType jdbcType) throws SQLException {
		if(parameter instanceof BaseEnum){
			BaseEnum en = parameter;
			if (jdbcType == null) {
		      ps.setString(i, (String)en.getValue());
		    } else {
		      ps.setObject(i, en.getValue(), jdbcType.TYPE_CODE); // see r3589
		    }
		}
	}

}
