Ext.define('app.store.SProjectTree', {
	extend : 'Ext.data.TreeStore',
	proxy : {
		type : 'ajax',
		url : 'Controller'
	},
	root : {
		text : 'Projeler',
		id  : 'projectTree',
		expanded : true
	},
	folderSort : true,
	sorters : [{
		property : 'text',
		direction : 'ASC'
	}] 
});