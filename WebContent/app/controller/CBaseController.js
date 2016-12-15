Ext.define('app.controller.CBaseController', {
	extend : 'Ext.app.Controller',

	init : function(child) {
		this.control({
			'combobox' : {
				render : this.fillCombo
			}
		});
	},

	fillCombo : function(combobox) {
		var refData = combobox.refData;

		if (refData != undefined) {
			var params = {
				refData : refData
			};

			var store = new Ext.data.JsonStore({
				fields : [ 'text', 'key' ],
				autoDestroy : true,
				autoLoad : false,

				proxy : new Ext.data.proxy.Ajax({
					type : 'ajax',
					url : 'dispatcher',
					jsonData : true,
					headers : {
						'Content-Type' : 'application/json',
						"Accept" : "application/json"
					},
					actionMethods : {
						read : 'POST',
						create : 'POST',
						update : 'POST',
						destroy : 'POST'
					},
					reader : {
						type : 'json',
						root : 'data'
					},
					writer : {
						type : 'json'
					},
					extraParams : {
						serviceName : 'referenceDataService_fillRefData',
						params : params
					},

					doRequest: function(operation, callback, scope) {
		                var writer  = this.getWriter(),
		                    request = this.buildRequest(operation, callback, scope);
		                
		                if (operation.allowWrite()) {
		                    request = writer.write(request);
		                }
		                
		                Ext.apply(request, {
		                    headers       : this.headers,
		                    timeout       : this.timeout,
		                    scope         : this,
		                    callback      : this.createRequestCallback(request, operation, callback, scope),
		                    method        : this.getMethod(request),
		                    disableCaching: false 
		                });
		                
		                if(this.jsonData) {
		                    request.jsonData = Ext.encode(request.params);
		                    delete request.params;
		                }
		                
		                Ext.Ajax.request(request);
		                
		                return request;
		            }
				})
			});

			combobox.displayField = 'text';
			combobox.valueField = 'key';
			combobox.store = store;
			combobox.store.reload();
		}

	},

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
				var resp = JSON.parse(response.responseText);
				if (show_messages) {
					var msgStr = "";
					for (var i = 0; i < resp.msg.length; i++) {
						msgStr += resp.msg[i] + "</br>";
					}
					if (msgStr.length > 0)
						Ext.MessageBox.show({
							title : 'Hata',
							msg : msgStr,
							buttons : Ext.MessageBox.OK
						});
				}
				if (resp.error == false) {
					failure(resp.data);
				} else {
					success(resp.data);
				}

			}
		});
	}
});