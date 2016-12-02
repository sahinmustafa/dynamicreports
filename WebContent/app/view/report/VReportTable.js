Ext.define('app.view.report.VReportTable', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.reportTable',
	columns : [],
	enableDragDrop  : true,
	viewConfig: {
		stripeRows:true,
        plugins: {
            ptype: 'gridviewdragdrop',
            ddGroup : 'fieldDragGroup'
        }
	}
});