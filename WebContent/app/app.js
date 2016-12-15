Ext.application({
	extend : 'Ext.app.Application',
	name : 'app',
	mainView: 'app.view.Viewport',
	controllers : ['CBaseController', 
	               'CMainFrame',
	               'menu.CAnaMenu',
	               'project.CProject',
	               'report.CSQLQuery',
	               'report.CReportFieldTree',
	               'datasources.CDataSource'],
	autoCreateViewport : true
});