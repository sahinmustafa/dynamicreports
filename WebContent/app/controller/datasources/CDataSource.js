Ext.define('app.controller.datasources.CDataSource', {
	extend : 'Ext.app.Controller',
	views : [ 'app.view.datasources.VJsonDataSource' ],

	refs : [ {
		ref : 'jsonDataSource',
		selector : 'jsonDataSource'
	} ],

	init : function() {
		this.control({
			'jsonDataSource button[action=tamam]' : {
				click : this.jsonTamam
			},
			'jsonDataSource button[action=format]' : {
				click : this.jsonFormat
			}
		});
		this.callParent();
	},

	jsonTamam : function() {
		var treeNodes =  {
			text : "Kolonlar",
			expanded : true,
			leaf : false,
			checked : false,
			children : []
		};
		
		var jsonString = this.getJsonDataSource().getForm().findField(
				'jsonData').getValue();
		var jsonArr = eval("(" + jsonString + ")");

		if (jsonArr.constructor != Array) {
			Ext.MessageBox.show({
				title : 'Hata',
				msg : "Veri Kaynağı olarak JSON Array girmelisiniz",
				buttons : Ext.MessageBox.OK
			});
			return;
		}

		if (jsonArr.length == 0) {
			return;
		}

		var json = jsonArr[0];
		for ( var key in json) {
			var nodes = {
					text : key,
					leaf : true,
					checked : false
				};
			treeNodes.children.push(nodes);
		}
		
		var reportController = app.app.getController('report.CReportFieldTree');
		reportController.setTreeNode([treeNodes]);
		reportController.dataSource = jsonArr;
		this.getJsonDataSource().up("window").close();

	},

	jsonFormat : function() {
		debugger;
		var jsonString = this.getJsonDataSource().getForm().findField(
				'jsonData').getValue();
		jsonString = JSON.stringify(eval("(" + jsonString + ")"), null, "\t");
		this.getJsonDataSource().getForm().findField('jsonData').setValue(
				jsonString);

	}
});