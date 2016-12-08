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
    	debugger;
    	var params = {
    		projects : {
    			projectName : this.getProject().getForm().findField("projectName").getValue(),
    			databaseSettings : {
    				userName : this.getProject().getForm().findField("userName").getValue(),
    				password : this.getProject().getForm().findField("password").getValue(),
    				ip : this.getProject().getForm().findField("ip").getValue(),
    				port : this.getProject().getForm().findField("port").getValue()
    			}
    		}
    	};
    	var thizz = this;
    	this.call('projectsService_saveProjects', params,
    			function(resp){
    				Ext.Msg.alert('Proje başarı ile kayıt edildi');
    				thizz.getProject().up('window').close()
    			},function(resp){
    				
    			}, true);
    },
    
    temizle : function(){
    	
    }
});