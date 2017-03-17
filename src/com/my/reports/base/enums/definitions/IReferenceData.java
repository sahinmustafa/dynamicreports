/**
 * 
 */
package com.my.reports.base.enums.definitions;

import com.my.reports.base.entity.definitions.IParameters;

/**
 * @author MustafaS.
 *
 */
public interface IReferenceData {

	
	public String getRefData();
	public Class<? extends IParameters> getClazz();
	public String getServiceName();
	
}
