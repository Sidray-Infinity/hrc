Ext.define('Employee', {
    extend: 'Ext.data.Model',
    fields: [ 'name', 'emp_id' ]
});

var empStore = Ext.create('Ext.data.Store', {
    model: 'Employee',
    data: [
        { name: 'A', emp_id: 1},
        { name: 'B', emp_id: 2},
        { name: 'C', emp_id: 3},
        { name: 'D', emp_id: 4}
    ]
});


Ext.onReady(function() {
    Ext.create('Ext.panel.Panel', {
        renderTo: Ext.getBody(),
        bodyPadding: 5,
		width: '100%',
        border: false,
		
		layout: {
			type: 'vbox',
			align: 'middle',
			pack: 'center',
		},
        items: [{
            xtype: 'form',
            height: 120,
			width: "100%",
            title: "Employee List",
			bodyStyle: 'background-color: #f8f8f8;',

            layout: {
                type: 'hbox',
                align: 'middle',
                pack: 'center',
            },
            items: [{
                xtype: 'textfield',
                fieldLabel: 'Name',
                margin: 10
            }, {
                xtype: 'textfield',
                fieldLabel: 'Employee Id',
                margin: 10,
            }]
        }, {
            xtype: 'panel',
            border: false,
            layout: {
                type: 'hbox',
                pack: 'middle',
            },
            items: [{
	            xtype: 'button',
				scale: 'medium',
	            text: 'Add',
	            margin: 10,
	        }, {
	            xtype: 'button',
				scale: 'medium',
	            text: 'Update',
	            margin: 10,
	        }, {
	            xtype: 'button',
				scale: 'medium',
	            text: 'Delete',
	            margin: 10,
        	}]
        }, {
			xtype: 'gridpanel',
			selModel: {
			    selType: 'checkboxmodel',
			    mode   : 'MULTI'
			},
			store: empStore,
			width: '100%',
			title: 'List of Employees',
			columns: [{
				text: 'Name',
				width: '50%',
				style: {fontWeight: 'bold', background: 'e8e8e8', fontSize: 16},
				dataIndex: 'name'
			}, {
				text: 'Employee Id',
				width: '50%',
				style: {fontWeight: 'bold', background: 'e8e8e8', fontSize: 16},
				dataIndex: 'emp_id'
			}]
		}],
    })
})