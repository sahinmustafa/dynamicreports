Ext.define('app.store.report.SReportTable',{
	extend : 'Ext.data.Store',
	storeId:'simpsonsStore',
    fields:['name', 'email', 'phone'],
    data:{'items':[
        {"name":"Lisa", "email":"lisa@simpsons.com", "phone":"555-111-1224"},
        {"name":"Bart", "email":"bart@simpsons.com", "phone":"555--222-1234"},
        {"name":"Homer", "email":"home@simpsons.com", "phone":"555-222-1244"},                        
        {"name":"Marge", "email":"marge@simpsons.com", "phone":"555-222-1254"}            
    ]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});