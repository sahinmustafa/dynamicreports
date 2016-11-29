Ext.define('app.controller.report.CSQLQuery', {
	extend : 'app.controller.CBaseController',
	views : ['report.VSQLQuery'],
	models : ['MSQLQuery'],
	
	refs : [{
		selector : 'sqlQuery',
		ref : 'sqlQuery'
	}],
	init : function(){
		this.control({
			'sqlQuery button[action=tamam]' : {
				click : function(){this.tamamClick();}
			},
			'sqlQuery button[action=temizle]' : {
				click : function(){this.temizleClick();}
			}
		});
	},
	
	tamamClick : function(){
		var sql = this.getSqlQuery().down('field[name=sqlQuery]').getValue();
		
	},
	
	temizleClick : function(){
		var params = {
				projects : {
					projectName : "Mustafa"
				}			
			}
			this.call('projectsService_saveProjects', params, function(resp){
				Ext.Msg.alert('Success');
			}, function(resp){
				Ext.Msg.alert('Failure');
			});

	},
	
	sqlParser : function(sql){
		if(sql == null)
			return [];
		
		sql = sql.trim().toLowerCase();
		
		if(sql.length < 8)
			return [];
		
		var fromIndex = sql.indexOf('from');
		var selectedString = sql.substring(7, fromIndex); // sql sorgusundan select ile from arası çıkarıldı
		var selectedList = selectedSrting.split(','); // her bir seleceted field listeye alındı
		
		var whereIndex = sql.indexOf('where');
		var whereClause = [];
		if(whereIndex != -1){
			
		}
		
		if(selectedList.length == 0)
			return [];
		
		for(var i = 0 ; i < selectedList.length ; i ++){
			
		}
		
	}
});