Ext.define('app.view.project.VProject',{
	extend : 'Ext.form.Panel',
	alias : 'widget.project',
	width : 300,
	height : 500,
	items : [{
		xtype : 'textfield',
		fieldLabel : 'Proje Adı',
		name :'projectName'
	},{
		xtype : 'textfield',
		fieldLabel : 'Kullanıcı Adı',
		name : 'userName'
	},{
		xtype : 'textfield',
		fieldLabel : 'Şifre',
		inputType : 'password',
		name : 'password'
	},{
		xtype : 'textfield',
		fieldLabel : 'IP',
		name : 'ip'
	},{
		xtype : 'numberfield',
		fieldLabel : 'Port',
		name : 'port'
	}],
	buttons : [{
		text : 'Kaydet',
		action : 'kaydet'
	},{
		text : 'Temizle',
		action : 'temizle'
	}]
});