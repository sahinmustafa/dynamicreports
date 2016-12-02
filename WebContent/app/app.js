Ext.application({
	extend : 'Ext.app.Application',
	name : 'app',
	mainView: 'app.view.Viewport',
	controllers : ['CBaseController', 
	               'CMainFrame', 
	               'report.CSQLQuery',
	               'menu.CAnaMenu',
	               'project.CProject',
	               'report.CReportFieldTree'],
	autoCreateViewport : true
});