Ext.define('app.controller.report.CReportFieldTree', {
	extend : 'app.controller.CBaseController',
	
	views : ['app.view.report.VReportFieldTree'],
	refs : [{
		ref : 'reportFieldTree',
		selector : 'reportFieldTree'
	}],
	init : function(){
		 this.control({             
			 'reportFieldTree button[action=tumunuGenislet]' : {
	                click : this.expandAll   
	          },
	         'reportFieldTree button[action=tumunuDaralt]' : {
	                click : this.collapseAll   
	          }
         });
     },

     expandAll : function() {
         var tree = this.getProjectTree();
         tree.expandAll();
     },
     
     collapseAll : function() {
         var myTree = this.getProjectTree();
         myTree.collapseAll();
     },
     
     treeItemClick : function(view, record) {
         
    }
});