Ext.define('app.view.report.VReport', {
	extend : 'Ext.container.Container',
	id : 'report',
	alias : 'widget.report',
	title : 'Rapor',
	requires : [ 'app.view.report.VReportFieldTree',
			'app.view.report.VReportFieldProperties',
			'app.view.report.VReportTable' ],

	layout : {
		type : 'border',
		collapsible : true
	},

	initComponent : function() {
		this.items = [ {
			xtype : 'reportFieldTree',
			region : 'west',
			width : '15%'
		}, {
			xtype : 'reportTable',
			region : 'center'
		}, {
			xtype : 'reportFieldProperties',
			region : 'east',
			width  : '20%'
		} ];

		this.callParent();
	}

});