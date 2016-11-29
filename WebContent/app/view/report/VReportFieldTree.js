Ext.define('app.view.report.VReportFieldTree', {
	extend : 'Ext.tree.Panel',
	alias  : 'widget.reportFieldTree',
	//store : 'projects',
	useArrows : true,
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