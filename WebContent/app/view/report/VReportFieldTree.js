Ext.define('app.view.report.VReportFieldTree', {
	extend : 'Ext.tree.Panel',
    xtype: 'tree-reorder',
	alias  : 'widget.reportFieldTree',
	store : 'app.store.report.SReportFieldTree',
	useArrows : true,
	draggable  : true,
	
	requeires : ['Ext.dd.DropTarget'],
	
	viewConfig: {
		stripeRows:true,
        plugins: {
            ptype: 'treeviewdragdrop',
        	ddGroup : 'fieldDragGroup'
        }, copy : true
    },
	dockedItems: [{
        xtype: 'toolbar',
        items: [{
            text: 'Tümünü Genişlet',
            action : 'tumunuGenislet'
        }, {
            text: 'Tümünü Daralt',
            action : 'tumunuDaralt'
        }]
    }]
});