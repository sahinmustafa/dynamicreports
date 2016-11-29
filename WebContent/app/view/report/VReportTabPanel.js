Ext.define('app.view.report.VReportTabPanel', {
	extend : 'Ext.tab.Panel',
	alias : 'widget.reportTabPanel',
    xtype : 'basic-tabs', 
	tabPosition : 'left',
	requires : ['app.view.report.VSQLQuery', 
	            'app.view.report.VReport', 
	            'app.view.report.VReportPreview'
	            ],
	            
	items : [{
		xtype : 'sqlQuery',
		title : 'Rapor SQL Sorgusu'
	}, {
		xtype : 'report',
		title : 'Rapor'
	}, {
		xtype : 'reportPreview',
		title : 'Önizle'
	}]
});