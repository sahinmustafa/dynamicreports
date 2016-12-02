Ext.define('app.view.Viewport', {
	extend : 'Ext.Viewport',
	enableTabScroll : true,
	layout : {
		type : 'border',
		collapsible: true
	},
	requires : ['app.view.MainFrame',
	            'app.view.menu.VAnaMenu'],
	initComponent : function(){
		Ext.apply(this,{
			items : [{
				xtype : 'panel',
                region : 'center',
                layout : 'anchor',
                items : [{
                                xtype : 'anaMenu',
                                width : '100%'
                            },{
                                xtype : 'centerTabPanel',
                                anchor : '100% 100'
                            }]
			}]
		});
		
		this.callParent();
	}
	
});