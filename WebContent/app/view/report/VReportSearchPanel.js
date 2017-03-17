Ext.define('app.view.report.VReportSearchPanel', {
	extend : 'Ext.form.Panel',
	alias : 'widget.reportSearchPanel',
	title  : 'Arama Panel',
	bodyStyle: 'padding:5px 10px 0 10px;',
	
	collapsible : true,	
    draggable : true,
    autoHeight: true,
    autoScroll : true,
    
    layout : {
		type : 'table',
		columns : 2,
		tdAttrs: {
            style: 'width: 33%'
        }
	},
	
	buttons : [{
		text  : 'Ara',
		action : 'ara'
	},{
		text : 'Temizle',
		action : 'temizle'
	}]
});