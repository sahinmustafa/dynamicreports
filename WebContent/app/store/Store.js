Ext.define('app.store.Store', {
	extend : 'Ext.data.Store',
	model : 'app.model.MSQLQuery',
	remoteSort : true,
	
	proxy : {
		type : 'ajax',
		url : 'dispatcher',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			root : 'data',
			totalProperty: 'totalCount',
			successProperty : 'success'
		}
	}
});