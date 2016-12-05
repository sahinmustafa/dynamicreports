Ext.define('app.view.report.VReportFieldProperties', {
	extend : 'Ext.form.Panel',
	alias : 'widget.reportFieldProperties',
	title : 'Özellikler',
	collapsible : true,
	required : ['app.utils.FieldUtils'],
	
	refs :[{
		ref : 'fieldUtils',
		selector : 'fieldUtils'
	}],
	items : [{
		xtype : 'textfield',
		fieldLabel : 'Alan Adı',
		id : 'name',
		readOnly : true,
		margin : '5px'
	},{
		xtype : 'textfield',
		fieldLabel : 'Başlık',
		id : 'title',
		margin : '5px'
		//maxLength : this.getFieldUtils().TEXT_ALAN_UZUNLUGU
	},{
		xtype  :'combobox',
		fieldLabel : 'Alan Tipi',
		margin : '5px'
	},{
		xtype  : 'textfield',
		fieldLabel  : 'Referans Data',
		margin : '5px'
		//maxLength : this.getFieldUtils().TEXT_ALAN_UZUNLUGU
	}]
});