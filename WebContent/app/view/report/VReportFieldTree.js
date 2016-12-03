Ext.define('app.view.report.VReportFieldTree', {
	extend : 'Ext.tree.Panel',
	alias  : 'widget.reportFieldTree',
	store : 'app.store.report.SReportFieldTree',
	renderTo : document.body,
	viewConfig: {
		stripeRows:true,
        plugins: {
            ptype: 'treeviewdragdrop',
        	ddGroup : 'fieldDragGroup',
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