Ext.define('app.controller.report.CReportFieldTree', {
	extend : 'app.controller.CBaseController',
	
	views : ['report.VReportFieldTree',
	         'report.VReport',
	         'report.VReportTable'],
	stores : ['app.store.report.SReportFieldTree'],

	refs : [{
		ref : 'reportFieldTree',
		selector : 'reportFieldTree'
	},{
		ref : 'report',
		selector : 'report'
	},{
		ref  :'reportTable',
		selector : 'reportTable'
	}],
	
	init : function(){
		 this.control({             
			 'reportFieldTree' : {
	                render : this.reportRender   
	          },
	          'reportFieldTree button[action=tumunuGenislet]' : {
	                click : this.expandAll   
	          },
	         'reportFieldTree button[action=tumunuDaralt]' : {
	                click : this.collapseAll   
	          },
	          'reportTable' : {
	        	  afterrender : this.afterRenderReportTable
	          }
         });
		 
     },

     reportRender : function(){
    	 this.sqlParser();	 
     },
     
     expandAll : function() {    
         var tree = this.getProjectTree();
         tree.expandAll();
     },
     
     collapseAll : function() { 
    	 debugger;
    	 Ext.getCmp('mainFrame').doComponentLayout()
         //var myTree = this.getProjectTree();
         //myTree.collapseAll();
     },
     
     afterRenderReportTable : function(view, record) {
    	 view.view.on('drop',this.onDrop,this);  
    	 view.view.on('afterDrop', this.afterDrop, this);
     },
     
     afterDrop : function(view, record){
    	debugger; 
     },
        
     onDrop : function(view,record){
    	var grid = Ext.ComponentQuery.query('report gridpanel')[0];
    	var items = view.getDragData(record.event).records;

    	if(items[0].childNodes.length > 0)
    		items = items[0].childNodes;
    	
    	for(var i = 0 ; i < items.length ; i ++){
	    	var column = Ext.create('Ext.grid.column.Column', {
	    		text : items[i].data.text,
	    		flex : 1,
	    		autoSizeColumn : true
	    	});
	    	grid.headerCt.insert(grid.columns.length - 1, column);
    	}
    	
        grid.getView().refresh(true);
        
     },
    
     sqlParser : function(){
		var dumpy =  [{ 
			        text: "Kolonlar", 
			        expanded: true, 
			        leaf: false, 
			        checked: false, 
			        children: [{ 
				        	text: "tc", 
				        	leaf: true, 
				        	checked: false
			        	},{ 
			        		text: "ad", 
			        		leaf: true, 
			        		checked: false 
		        		},{ 
			        		text: "soyad", 
			        		leaf: true, 
			        		checked: false 
		        		},{ 
			        		text: "dogumTarihi", 
			        		leaf: true, 
			        		checked: false 
		        		}]
					},{ 
			            text: "Arama Kriterleri", 
			            expanded: true, 
			            leaf: false, 
			            checked: false, 
			            children: [{ 
				            	text: "tc", 
				            	leaf: true, 
				            	checked: false
			            	},{ 
			            		text: "dogumTarihi", 
			            		leaf: true, 
			            		checked: false
		            		}]
		            }];
		
		var store = this.getReportFieldTree().getStore();
		store.getRootNode().appendChild(dumpy);
	}

});