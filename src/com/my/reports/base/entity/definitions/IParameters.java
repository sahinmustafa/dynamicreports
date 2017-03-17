/**
 * 
 */
package com.my.reports.base.entity.definitions;

import java.util.Map;

/**
 * @author MustafaS.
 *
 */
public interface IParameters {

	public String getKey();
	public String getText();
	public Map<String, Object> extraParams();
}
