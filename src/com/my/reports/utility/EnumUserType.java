/**
 * 
 */
package com.my.reports.utility;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

import com.my.reports.base.enums.definitions.INumericEnumType;

/**
 * @author MustafaS.
 *
 */
public class EnumUserType implements UserType, ParameterizedType {

	private Class<INumericEnumType> clazz;
	private static final int[] SQLTYPES = { Types.TINYINT };

	@SuppressWarnings("unchecked")
	public void setParameterValues(Properties params) {
		String className = (String) params.get("type");
		try {
			this.clazz = (Class<INumericEnumType>) Class.forName(className);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("Couldn't get the class for name [" + className + "].", ex);
		}
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) {
			return true;
		} else if (x == null || y == null) {
			return false;
		}
		return x.equals(y);

	}

	public int hashCode(Object arg0) throws HibernateException {
		return arg0.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
		int value = rs.getInt(names[0]);
		Object result = null;
		if (!rs.wasNull()) {
			result = getEnumByKod(value);
		}
		return result;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
		if (null == value) {
			st.setNull(index, Types.TINYINT);
		} else {
			st.setInt(index, ((INumericEnumType) value).getCode());
		}
	}

	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
		return arg0;
	}

	public Class<INumericEnumType> returnedClass() {
		return clazz;
	}

	public int[] sqlTypes() {
		return SQLTYPES;
	}
	
	public Object getEnumByKod(int code) {
		Object result = null;
		for (INumericEnumType o : clazz.getEnumConstants()) {
			if (o.getCode() == code) {
				result = o;
				break;
			}
		}
		if (result == null) {
			throw new RuntimeException(String.format("Kod: %d %s ' de bulunamadı.", code, clazz.getName()));
		}
		return result;
	}

}
