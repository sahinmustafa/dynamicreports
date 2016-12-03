Ext.define('app.view.report.VReport', {
	extend : 'Ext.container.Container',
	id : 'report',
	alias : 'widget.report',
	title : 'Rapor',
	requires : ['app.view.report.VReportFieldTree',
	            'app.view.report.VReportFieldProperties',
	            'app.view.report.VReportTable'
	            ],
	
	layout: {
	    type: 'hbox',       
	    align: 'stretch'
	    	
	},
	initComponent : function(){
		this.items = [{
			xtype : 'reportFieldTree',
			id : 'reportFieldTree',
			flex : 1,
			
			
		},{
			xtype : 'reportTable',
			flex : 5			
		},{
			xtype : 'reportFieldProperties',
			flex : 1
		}];
		
		this.callParent();
	}
		
});