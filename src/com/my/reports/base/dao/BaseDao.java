package com.my.reports.base.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.base.enums.Status;
/**
 * @author MustafaS.
 *
 */

@Repository("dao")
@Transactional
public class BaseDao implements IBaseDao{

	@Autowired private SessionFactory sessionFactory;
	
	public void save(BaseEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
		this.flush();
	}
	
	public void update(BaseEntity entity){
		sessionFactory.getCurrentSession().update(entity);
		this.flush();
	}

	public <T extends BaseEntity> void delete(Class<T> clazz, String oid){
		T object = this.get(clazz, oid);
		object.setStatus(Status.PASIF);
		this.update(object);
		this.flush();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity> T get(Class<T> clazz, String oid){
		return (T) sessionFactory.getCurrentSession().get(clazz, oid);
	}
		
	private void flush(){
		sessionFactory.getCurrentSession().flush();
	}

	public <T extends BaseEntity> List<T> list(Status status) {
		return null;
	}
}
