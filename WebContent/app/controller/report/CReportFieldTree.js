Ext.define('app.controller.report.CReportFieldTree', {
	extend : 'app.controller.CBaseController',
	dataSource : [],
	views : [ 'report.VReportFieldTree', 'report.VReport', 'report.VReportFieldProperties',
			'report.VReportTable', 'report.VReportSearchPanel' ],
	stores : [ 'app.store.report.SReportFieldTree' ],

	refs : [ {
		ref : 'reportFieldTree',
		selector : 'reportFieldTree'
	}, {
		ref : 'report',
		selector : 'report'
	}, {
		ref : 'reportFieldProperties',
		selector : 'reportFieldProperties'
	},{
		ref : 'reportTable',
		selector : 'reportTable'
	}, {
		ref : 'reportSearchPanel',
		selector : 'reportSearchPanel'
	} ],

	init : function() {
		this.control({
			'reportFieldTree' : {
				render : this.reportTreeRender
			},
			'reportFieldTree button[action=tumunuGenislet]' : {
				click : this.expandAll
			},
			'reportFieldTree button[action=tumunuDaralt]' : {
				click : this.collapseAll
			},
			'reportTable' : {
				afterrender : this.afterRenderReportTable,
				cellclick : this.columnItemSelected
			},
			'reportSearchPanel' : {
				render : this.reportSearchPanelRender
			},
			'reportSearchPanel button[action=ara]' : {
				click : this.reportSearch
			},
			'reportFieldProperties > fieldset > field' : {
				change : this.reportPropertiesChanged
			}
			
		});
		

	},

	//**************Tree Event****************
	reportTreeRender : function() {
		//this.sqlParser();
	},

	expandAll : function() {
		var tree = this.getProjectTree();
		tree.expandAll();
	},

	collapseAll : function() {
		var myTree = this.getProjectTree();
		myTree.collapseAll();
	},
	
	setTreeNode : function(treeNode){
		var store = this.getReportFieldTree().getStore();
		store.getRootNode().removeAll();		
		store.getRootNode().appendChild(treeNode);
	},

	
	//****************Table Event*****************
	afterRenderReportTable : function(view, record) {
		view.view.on('drop', this.onDrop, this);
	},

	onDrop : function(view, record) {
		var grid = Ext.ComponentQuery.query('report gridpanel')[0];
		var items = view.getDragData(record.event).records;

		if (items[0].childNodes.length > 0)
			items = items[0].childNodes;

		debugger;
		for (var i = 0; i < items.length; i++) {
			
			var column = Ext.create('Ext.grid.column.Column', {
				name : items[i].data.text,
				text : items[i].data.text,
				flex : 1,
				autoSizeColumn : true
			});
			debugger;
			var fields = grid.getStore().model.getFields();
			fields.push(items[i].data.text);
			grid.getStore().model.setFields(fields);
			grid.headerCt.insert(grid.columns.length - 1, column);
		}

		grid.getView().refresh(true);

	},
	
	columnItemSelected : function(event, item, columnIndex, store, view){
		debugger;
		var thizz = app.app.getController('report.CReportFieldTree');
		thizz.getReportFieldProperties().items.map.columnProperties.setVisible(true);
		thizz.getReportFieldProperties().items.map.searchProperties.setVisible(false);
		var selectedComponent = this.getReportTable().headerCt.getHeaderAtIndex(columnIndex);
		selectedComponent.parentType = "grid";
		thizz.getReportFieldProperties().selectedComponent = selectedComponent;
		
		if(selectedComponent.properties == null)
			selectedComponent.properties = {
					name : selectedComponent.name,
					title : selectedComponent.name
			};			
		thizz.getReportFieldProperties().getForm().setValues(selectedComponent.properties);
	},

	
	//***********Properties Event**************
	
	reportPropertiesChanged : function(item, newValue, oldValue){
		debugger;
		var selectedComponent = this.getReportFieldProperties().selectedComponent;
		if(selectedComponent == null)
			return ;
		
		var properties = this.getReportFieldProperties().getForm().getValues();
		selectedComponent.properties = properties;
		
		if(item.name == "title"){
			if(selectedComponent.parentType == "searchPanel")
				selectedComponent.setFieldLabel(properties.title);
			if(selectedComponent.parentType == "grid")
				selectedComponent.setText(properties.title);
			
		}
	},
	
	
	//***********Search Event*******************
	searchPanelItemSelected : function(event, item){
		var thizz = app.app.getController('report.CReportFieldTree');
		thizz.getReportFieldProperties().items.map.columnProperties.setVisible(false);
		thizz.getReportFieldProperties().items.map.searchProperties.setVisible(true);
		var selectedComponent = thizz.getReportSearchPanel().getForm().findField(item.name);
		selectedComponent.parentType = "searchPanel";
		thizz.getReportFieldProperties().selectedComponent = selectedComponent;
		
		if(selectedComponent.properties == null)
			selectedComponent.properties = {
					name : selectedComponent.name,
					title : selectedComponent.name
			};			
		thizz.getReportFieldProperties().getForm().setValues(selectedComponent.properties);
	},
	
	
	reportSearchPanelRender : function() {
		var el = this.getReportSearchPanel().body.dom;
		var formPanelDropTarget = Ext.create('Ext.dd.DropTarget', el, {
			ddGroup : 'fieldDragGroup',
			enableDrag : false,

			notifyDrop : function(ddSource, e, data) {
				var searchPanel = Ext.ComponentQuery.query(
						'reportSearchPanel')[0];
				var index = searchPanel.items.length;

				for (var i = 0; i < data.records.length; i++) {
					var field = Ext.create('Ext.form.TextField', {
						name : data.records[i].data.text,
						id : data.records[i].data.text,
						fieldLabel : data.records[i].data.text,
						handleMouseEvents: true,
						listeners: {
						   'render': function(cmp) { 
							   var callBack = app.app.getController('report.CReportFieldTree').searchPanelItemSelected;
							   cmp.getEl().on('click', callBack); 
							   }
						}

					});
					searchPanel.insert(index, field);
				}
				searchPanel.doLayout();
				return true;
			}
		});
	},

	reportSearch : function(){
		var dataSource = this.dataSource;
		var searchValues = this.getReportSearchPanel().getForm().getValues();
		
		if(dataSource == null || searchValues == null)
			return ;
		
		var result = [];
		for(var i = 0 ; i < dataSource.length ; i ++){
			var isAdd = true;
			for(var key in searchValues){
				if(searchValues[key] == "")
					continue;
				if(dataSource[i][key] != searchValues[key]){
					isAdd = false;
					break;
				}
			}
			if(isAdd)
				result.push(dataSource[i]);
		}
		this.getReportTable().getStore().add(result);
		
	}

});