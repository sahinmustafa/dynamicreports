Ext.define('app.view.report.VReportFieldProperties', {
	extend : 'Ext.form.Panel',
	alias : 'widget.reportFieldProperties',
	title : 'Özellikler',
	collapsible : true,
	required : [ 'app.utils.FieldUtils' ],

	refs : [ {
		ref : 'fieldUtils',
		selector : 'fieldUtils'
	} ],
	items : [ {
		xtype : 'fieldset',
		collapsible : true,
		title : 'Genel Özellikler',
		margin : '5px',
		items : [ {
			xtype : 'textfield',
			fieldLabel : 'Alan Adı',
			id : 'name',
			name : 'name',
			readOnly : true
		}, {
			xtype : 'textfield',
			fieldLabel : 'Başlık',
			id : 'title',
			name : 'title'
		// maxLength : this.getFieldUtils().TEXT_ALAN_UZUNLUGU
		}, {
			xtype : 'combobox',
			fieldLabel : 'Alan Tipi',
			id : 'fieldType',
			name : 'fieldType',
			refData : 'RF_FIELD_TYPE'
		}, {
			xtype : 'textfield',
			fieldLabel : 'Referans Data',
			id : 'refData',
			name : 'refData'

		// maxLength : this.getFieldUtils().TEXT_ALAN_UZUNLUGU
		}, {
			xtype : 'numberfield',
			fieldLabel : 'Genişlik',
			id : 'width',
			name  :'width'
		} ]
	}, {
		xtype : 'fieldset',
		collapsible : true,
		title : 'Font',
		id : 'font',
		name : 'font',
		margin : '5px',
		items : [ {
			xtype : 'combobox',
			fieldLabel : 'Font Stil',
			id : 'fontStil',
			refData : 'RF_FONT_TYPE',
			name : 'fontStil'
		}, {
			xtype : 'numberfield',
			fieldLabel : 'Font Boyutu',
			id : 'fontSize',
			name : 'fontSize'
		}, {
			xtype : 'panel',
			border : false,
			layout : 'hbox',
			items : [ {
				xtype : 'textfield',
				fieldLabel : 'Yazı Rengi',
				id : 'fontColor',
				name : 'fontColor'
			}, {
				xtype : 'button',
				action : 'openColorPicker',
				text : '...'
			} ]
		}, {
			xtype : 'checkbox',
			fieldLabel : 'Kalın',
			id : 'bold',
			name  :'bold'
		}, {
			xtype : 'checkbox',
			fieldLabel : 'İtalik',
			id : 'italic',
			name : 'italic'
		}, {
			xtype : 'checkbox',
			fieldLabel : 'Altı çizili',
			id : 'underline',
			name : 'underline'
		} ]
	}, {
		xtype : 'fieldset',
		title : 'Kolon Özellikleri',
		collapsible : true,
		hidden : true,
		id : 'columnProperties',
		name : 'columnProperties',
		margin : '5px',
		items : [ {
			xtype : 'checkbox',
			fieldLabel : 'Görünür',
			id : 'visible',
			name : 'visible'
		}, {
			xtype : 'panel',
			border : false,
			layout : 'hbox',
			items : [ {
				xtype : 'textfield',
				fieldLabel : 'Formül',
				id : 'addFormula',
				name : 'addFormula'
			}, {
				xtype : 'button',
				action : 'openFormula',
				text : '...'
			} ]
		}, {
			xtype : 'panel',
			border : false,
			layout : 'hbox',
			items : [ {
				xtype : 'textfield',
				fieldLabel : 'Koşullu Format',
				id : 'conditionalFormat',
				name : 'contionalFormat'
			}, {
				xtype : 'button',
				action : 'openConditionalFormat',
				text : '...'
			} ]
		} ]
	},{
		xtype : 'fieldset',
		title  : 'Arama Özellikleri',
		collapsible : true,
		hidden : true,
		id : 'searchProperties',
		name : 'searchProperties',
		margin : '5px',
		items : [{
			xtype : 'combobox',
			fieldLabel : 'Filtreleme Koşulu',
			id  : 'filterType',
			name  :'filterType'
		},{
			xtype  : 'checkbox',
			fieldLabel  : 'Rapora Ekle',
			id : 'addReport',
			name : 'addReport'
		},{
			xtype : 'checkbox',
			fieldLabel : 'Zorunlu',
			id : 'required',
			name : 'required'
		}]
	} ]
});