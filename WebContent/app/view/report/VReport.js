Ext.define('app.view.report.VReport', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.report',
	title : 'Rapor',
	requires : ['app.view.report.VReportFieldTree',
	            'app.view.report.VReportFieldProperties'],
	
	layout: {
	    type: 'hbox',       
	    align: 'stretch'
	    	
	},
	
	items : [{
		xtype : 'reportFieldTree',
		flex : 1
		
	},{
		xtype : 'grid',
		columns: [],
		flex : 5
	},{
		xtype : 'reportFieldProperties',
		flex : 1
	}]
	
});