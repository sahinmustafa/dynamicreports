/**
 * 
 */
package com.my.reports.entity.projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.utility.DataUtility;
import com.my.reports.utility.EntityUtility;

/**
 * @author MustafaS.
 *
 */
@Entity
@Table(name="DATABASE_SETTINGS")
public class DatabaseSettings extends BaseEntity{

	private static final long serialVersionUID = 117586959463784619L;

	@Column(name="FK_PROJECT_OID", length=EntityUtility.OID_UZUNLUGU, nullable=false)
	private String projectOid;
	
	@Column(name="DATABASE_NAME", length=EntityUtility.TEXT_ALAN_UZUNLUGU, nullable=true)
	private String databaseName;
	
	@Column(name="DATABASE_TYPE", length=EntityUtility.TEXT_ALAN_UZUNLUGU, nullable=true)
	private String databaseType;
	
	@Column(name="USER_NAME", length=EntityUtility.TEXT_ALAN_UZUNLUGU, nullable=false)
	private String userName;
	
	@Column(name="PASSWORD", length=EntityUtility.TEXT_ALAN_UZUNLUGU, nullable=true)
	private String password;
	
	@Column(name="IP", length=EntityUtility.TEXT_ALAN_UZUNLUGU, nullable=false)
	private String ip;
	
	@Column(name="PORT", length=EntityUtility.KOD_ALAN_UZUNLUGU, nullable=false)
	private int port;
	
	@Override
	public void entityKaydet(BaseEntity parent, IBaseDao dao) throws Exception {
		DataUtility.isNullOrEmpty(this.getUserName(), true, "Veritabanı kullanıcı adı bilgisini boş bırakamzsınız!");
		DataUtility.isNullOrEmpty(this.getIp(), true, "Veritabanı IP bilgisini boş bırakamzsınız!");
		
		this.setProjectOid(parent.getOid());
		
		dao.save(this);
				
	}

	@Override
	public void entityGuncelle(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entitySil(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altSinifGetir(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ustSinifGetir(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	
	public String getProjectOid() {
		return projectOid;
	}

	public void setProjectOid(String projectOid) {
		this.projectOid = projectOid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	
}
