Ext.define('app.view.datasources.VJsonDataSource', {
	extend : 'Ext.form.Panel',
	alias : 'widget.jsonDataSource',
	width : 600,
	height : 300,
	layout : 'fit',
	items : [{
		xtype  : 'textareafield',
		id : 'jsonData',
		name : 'jsonData'		
	}],
	
	buttons : [{
		text : 'Format',
		action : 'format'
	},{
		text : 'Tamam',
		action : 'tamam'
	},{
		text : 'Temizle',
		action : 'temizle'
	}]
});