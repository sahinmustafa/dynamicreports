Ext.define('app.view.menu.VAnaMenu',{
	extend : 'Ext.toolbar.Toolbar',
	alias : 'widget.anaMenu',
	initComponent : function(){
		this.items = [{
			text : 'Dosya',
			menu : [{
				text : 'Yeni',
				action : 'yeni'				
			},{
				text : 'Aç',
				action : 'ac'
			},{
				text : 'Kaydet',
				action : 'kaydet'
			},{
				text : 'Farklı Kaydet',
				action : 'farkliKaydet'
			},{
				text : 'Kapat',
				action : 'kapat'
			}]
		},{
			text : 'Veri Kaynağı',
			menu : [{
				text : 'JSON',
				action : 'json'
			},{
				text : 'Excel',
				action : 'excel'
			},{
				text : 'XML',
				action : 'xml'
			},{
				text : 'Veri Tabanı',
				action : 'database'
			}]
		}];
		
		this.callParent();
	}
});