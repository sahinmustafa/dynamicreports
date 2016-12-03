Ext.define('app.view.report.VReportTable', {
	extend : 'Ext.grid.Panel',
	id : 'reportTable',
	alias : 'widget.reportTable',
	
	columns : [{
		header : 'ID',
		dataIndex : 'id',
		flex : 1
		
	}],
	viewConfig: {
		stripeRows:false,
        plugins: {
            ptype: 'gridviewdragdrop',
            ddGroup : 'fieldDragGroup',
            enableDrag : false,
        }
	}
});