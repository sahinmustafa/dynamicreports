Ext.define('app.controller.CBaseController', {
	extend : 'Ext.app.Controller',

	call : function(service_name, params, success, failure, show_messages) {
		var request = {
			serviceName : service_name,
			params : params
		};
		Ext.Ajax.request({
			url : 'dispatcher',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				"Accept" : "application/json"
			},
			dataType : 'json',
			jsonData : request,

			success : function(response) {
				debugger;
				var resp = JSON.parse(response.responseText);
				if (show_messages) {
					var msgStr = "";
					for (var i = 0; i < resp.msg.length; i++) {
						msgStr += resp.msg[i] + "</br>";
					}
					Ext.MessageBox.show({
						title : 'Hata',
						msg : msgStr,
						buttons : Ext.MessageBox.OK
					});
				}
				if (!resp.error) {
					failure(resp.data);
				} else {
					success(resp.data);
				}

			}
		});
	}
});