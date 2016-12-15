Ext.define('app.controller.menu.CAnaMenu', {
	extend : 'Ext.app.Controller',
	views : [ 'app.view.menu.VAnaMenu' ],
	refs : [ {
		selector : 'anaMenu',
		ref : 'anaMenu'
	} ],
	init : function() {
		this.control({
			'anaMenu menuitem[action=yeni]' : {
				click : this.yeni
			},
			'anaMenu menuitem[action=json]' : {
				click : this.jsonSource
			}
		});
	},

	yeni : function() {
		var w = new Ext.Window({
			layout : 'fit',
			requires : [ 'app.view.project.VProject' ],
			items : [ {
				xtype : 'project',
				padding : '5px'	
			} ]
		});
		w.show();
	},
	
	jsonSource : function(){
		var w = new Ext.Window({
			layout : 'fit',
			title :  'JSON Veri Kaynağı',
			requires : [ 'app.view.datasources.VJsonDataSource' ],
			items : [ {
				xtype : 'jsonDataSource',
				padding : '5px'	
			} ]
		});
		w.show();
	}
});