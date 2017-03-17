Ext.define('app.view.Viewport', {
	extend : 'Ext.Viewport',
	layout : 'border',
	renderTo : Ext.getBody(),
	
	requires : ['app.view.MainFrame',
	            'app.view.menu.VAnaMenu'],
	initComponent : function(){
		Ext.apply(this,{
			items : [{
				xtype : 'panel',
                region : 'center',
                layout : 'anchor',
                items : [{
                                xtype : 'anaMenu'
                            },{
                                xtype : 'centerTabPanel',
                                anchor : '100% 95%'
                            }]
			}]
		});
		
		this.callParent();
	}
	
});