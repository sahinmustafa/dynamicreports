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
		this.sqlParser(sql);
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
		/*
		if(sql == null)
			return [];
		
		sql = sql.trim().toLowerCase();
		
		if(sql.length < 8)
			return [];
		
		var fromIndex = sql.indexOf('from');
		var selectedString = sql.substring(7, fromIndex); // sql sorgusundan select ile from arası çıkarıldı
		var selectedList = selectedSrting.split(','); // her bir seleceted field listeye alındı
		
		var whereIndex = sql.indexOf('where');
		var tableNames = "";
		var whereClause = [];
		if(whereIndex == -1){
			tableNames = sql.substring(fromIndexIndex + 5);
		}else{
			tableNames = sql.substring(fromIndexIndex + 5, whereIndex);
			
		}
		
		if(selectedList.length == 0)
			return [];
		
		for(var i = 0 ; i < selectedList.length ; i ++){
			
		}
		*/
		var dumpy = {
				children: [{ 
			        text: "Kolonlar", 
			        expanded: true, 
			        leaf: false, 
			        checked: false, 
			        children: [{ 
				        	text: "tc", 
				        	leaf: true, 
				        	checked: true
			        	},{ 
			        		text: "ad", 
			        		leaf: true, 
			        		checked: true 
		        		},{ 
			        		text: "soyad", 
			        		leaf: true, 
			        		checked: true 
		        		},{ 
			        		text: "dogumTarihi", 
			        		leaf: true, 
			        		checked: true 
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
		            }]
		};
		
		//var store = this.getReportFieldTree().getStore();
		debugger;
	}
});