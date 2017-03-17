Ext.define('app.view.MainFrame',{
    extend : 'Ext.tab.Panel',
    id : 'mainFrame',
    alias : 'widget.centerTabPanel',
    
    defaults: {
        bodyPadding: 10,
        autoScroll: true
    },
    requires : ['app.view.report.VReportTabPanel'],
    items : [{
    	xtype : 'reportTabPanel',
    	title : 'rapor',
    	closable : true
    }]
});