/**
 * 
 */
package com.my.reports.base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.json.JSONObject;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.enums.Status;
import com.my.reports.utility.EntityUtility;


/**
 * @author MustafaS.
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 9066792246466385491L;
	
	@Id
	@Column(name="OID", length = EntityUtility.OID_UZUNLUGU, nullable=false)
	private String oid;
	
	@Type(type = "com.my.reports.utility.EnumUserType", parameters = @Parameter(name = "type", value = "com.my.reports.base.enums.Status"))
	@Column(name="SILINMIS", length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU, nullable=false)
	private Status status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE", nullable=false, updatable=false)
	private Date createDate = new Date();
	
	@Column(name="CREATE_USER", nullable=false, updatable=false)
	private String createUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE", nullable=true, updatable=false)
	private Date updateDate = new Date();
	
	@Column(name="UPDATE_USER", nullable=true, updatable=false)
	private String updateUser;
	
	
	public abstract void entityKaydet(BaseEntity parent, IBaseDao dao);
	public abstract void entityGuncelle(BaseEntity parent, IBaseDao dao);
	public abstract void entitySil(BaseEntity parent, IBaseDao dao);
	public abstract void altSinifGetir(BaseEntity parent, IBaseDao dao);
	public abstract void ustSinifGetir(BaseEntity parent, IBaseDao dao);
	
	public BaseEntity fromJSON(Class<? extends BaseEntity> clazz, JSONObject json) throws Exception{
		return new ObjectMapper().readValue(json.toString(), clazz);
	}
	
	public JSONObject toJSON() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		JSONObject json =  new JSONObject(mapper.writeValueAsString(this));
		return json;
	}
	
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}
