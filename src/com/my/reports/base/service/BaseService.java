/**
 * 
 */
package com.my.reports.base.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.my.reports.base.dao.definitions.IBaseDao;

/**
 * @author MustafaS.
 *
 */

public abstract class BaseService {

	@Autowired public IBaseDao dao;
}
