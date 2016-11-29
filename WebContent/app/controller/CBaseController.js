Ext.define('app.controller.CBaseController',{
	extend : 'Ext.app.Controller',
	
	call : function(service_name, params, success, failure){
		var request = {
				serviceName : service_name,
				params : params
		};
		Ext.Ajax.request({
			 url : 'dispatcher',
			 method : 'POST',
			 headers: { 
				 'Content-Type' : 'application/json',
				 "Accept": "application/json"},
			dataType : 'json',
			 jsonData : request,
				 

			 success : success,
			 failure : failure			 
		 });
	}
});