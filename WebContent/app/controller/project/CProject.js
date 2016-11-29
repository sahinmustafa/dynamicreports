Ext.define('app.controller.project.CProject',{
	extend : 'app.controller.CBaseController',
	views : ['app.view.project.VProject'],
	refs : [{
		selector : 'project',
		ref : 'project'
	}],
	
	init : function(){
		this.control({             
            'project button[action=kaydet]' : {
            	click : this.kaydet
            },
            'project button[action=temizle]' : {
            	click : this.temizle
            }
            
        });
	},
	     
    kaydet : function(){
    	var params = {
    		project : this.getProject().getForm().getValues()	
    	};
    	this.call('projectsService_saveProjects', params,
    			function(resp){
    				Ext.msg.alert('Proje başarı ile kayıt edildi');
    				this.getProject().close();
    			},function(resp){
    				Ext.MessageBox.show({
    					title : 'Hata',
    					msg  : 'Proje kayıt sırasında hata oluştu!',
    					buttons : Ext.MessageBox.OK
    				});
    			});
    },
    
    temizle : function(){
    	
    }
});