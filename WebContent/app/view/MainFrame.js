Ext.define('app.view.MainFrame',{
    extend : 'Ext.tab.Panel',
    xtype : 'basic-tabs', 
    alias : 'widget.centerTabPanel',
    
    defaults: {
        bodyPadding: 10,
        autoScroll: true
    },
    requires : ['app.view.report.VReportTabPanel'],
    items : [{
    	xtype : 'reportTabPanel',
    	closable : true
    }]
});