/**
 * 
 */
package com.my.reports.base.enums;

import com.my.reports.base.entity.definitions.IParameters;
import com.my.reports.base.enums.definitions.IReferenceData;
import com.my.reports.entity.enums.FieldType;

/**
 * @author MustafaS.
 *
 */
public enum ReferenceData implements IReferenceData{
	FIELD_TYPE("RF_FILED_TYPE", FieldType.class, null);
	
	private static final String DEFAULT_PARAMETRE_SERVIS = "referenceDataService_fillRefData";
	
	private String refData;
	private Class<? extends IParameters> clazz;
	private String serviceName;	
	
	private ReferenceData(String refData, Class<? extends IParameters> clazz, String serviceName) {
		this.refData = refData;
		this.clazz = clazz;
		this.serviceName = serviceName;
	}
	
	public static ReferenceData getFromRefData(String appRefData){
		for(ReferenceData refData : ReferenceData.values())
			if(refData.getRefData().equals(appRefData))
				return refData;
		return null;
	}

	@Override
	public String getRefData() {
		return refData;
	}

	@Override
	public Class<? extends IParameters> getClazz() {
		return clazz;
	}
	
	@Override
	public String getServiceName(){
		return serviceName;
	}
	
}
