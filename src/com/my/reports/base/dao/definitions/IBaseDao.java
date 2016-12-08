/**
 * 
 */
package com.my.reports.base.dao.definitions;

import java.util.List;

import com.my.reports.base.dao.SorguNesnesi;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.base.enums.Status;

/**
 * @author MustafaS.
 *
 */
public interface IBaseDao {

	public void save(BaseEntity entity);
	public void update(BaseEntity entity);
	public <T extends BaseEntity> void delete(Class<T> clazz, String oid);
	public <T extends BaseEntity> T get(Class<T> clazz, String oid);
	public <T extends BaseEntity> List<T> list(SorguNesnesi<T> sorguNesnesi) throws Exception;
	public <T extends BaseEntity> List<T> list(SorguNesnesi<T> sorguNesnesi, Status s) throws Exception;
	
}
