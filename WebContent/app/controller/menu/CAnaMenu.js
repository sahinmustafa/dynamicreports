Ext.define('app.controller.menu.CAnaMenu',{
	extend : 'Ext.app.Controller',
	views : ['app.view.menu.VAnaMenu'],
	refs : [{
		selector : 'anaMenu',
		ref : 'anaMenu'
	}],
	init : function(){
		this.control({
			'anaMenu menuitem[action=yeni]': {
				click : this.yeni
			}
		});
	},
	
	yeni : function(){
		Ext.create('app.view.project.VProject').show();
	}
});