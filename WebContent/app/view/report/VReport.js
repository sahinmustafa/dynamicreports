Ext.define('app.view.report.VReport', {
	extend : 'Ext.container.Container',
	id : 'report',
	alias : 'widget.report',
	title : 'Rapor',
	requires : [ 'app.view.report.VReportFieldTree',
			'app.view.report.VReportFieldProperties',
			'app.view.report.VReportTable',
			'app.view.report.VReportSearchPanel' ],

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
			xtype : 'panel',
			region : 'center',
			layout: {
			    type: 'vbox',
			    align : 'stretch',
			    pack  : 'start',
			},
			items : [ {
				xtype : 'reportSearchPanel',
				flex  : 1
			},{
				xtype  :'reportTable',
				title  : 'Rapor Tablo',
				collapsible : true,
				flex  : 2
			} ]
		}, {
			xtype : 'reportFieldProperties',
			region : 'east',
			width : '20%'
		} ];

		this.callParent();
	}

});