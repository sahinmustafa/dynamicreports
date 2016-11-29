Ext.define('app.view.report.VSQLQuery',{
	extend : 'Ext.form.Panel',
	title : 'SQL Sorgusu',
	alias : 'widget.sqlQuery',
	items : [{
		xtype : 'textareafield',
		fieldLabel : 'SQL',
		width : 800,
		name : 'sqlQuery'
	},{
		xtype : 'button',
		text : 'Tamam',
		action : 'tamam'
	},{
		xtype : 'button',
		text : 'Temizle',
		action : 'temizle'
	}]
	
});