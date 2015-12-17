//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4696.13908)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.forms.dementiaamtsfieldandhelpconfig;

import ims.admin.forms.edischargehintconfig.GenForm;
import ims.clinicaladmin.forms.dementiaamtsfieldandhelpconfig.GenForm.grdDetailsRow;
import ims.clinicaladmin.vo.DementiaTermConfigVo;
import ims.clinicaladmin.vo.DementiaTermConfigVoCollection;
import ims.clinicaladmin.vo.lookups.DementiaTermConfigCollection;
import ims.clinicaladmin.vo.lookups.LookupHelper;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	private void open()
	{
		populateScreenFromData();
		form.setMode(FormMode.VIEW);
	}

	private void populateScreenFromData()
	{
		DementiaTermConfigVoCollection collDementiaTermConfig = domain.listAllDementiaTermConfig();
		populateGrid(collDementiaTermConfig);// populate grid
		populateInstanceControlsFromData(form.getLocalContext().getSelectedRecord());// populate details container if a row is selected
	}

	private void populateInstanceControlsFromData(DementiaTermConfigVo selectedRecord)
	{
		form.txtTermText().setValue(null);

		if (selectedRecord == null)
			return;

		form.txtTermText().setValue(selectedRecord.getHelpText());
	}

	private void populateGrid(DementiaTermConfigVoCollection collDementiaTermConfig)
	{
		//form.grdDetails().getRows().clear();

		if (collDementiaTermConfig == null)
			return;

		for (int i = 0; collDementiaTermConfig != null && i < collDementiaTermConfig.size(); i++)
		{
			grdDetailsRow row = findDementiaTermRow(collDementiaTermConfig.get(i));
			if (row != null)
			{
				row.setColTermText(collDementiaTermConfig.get(i).getHelpText());
				row.setValue(collDementiaTermConfig.get(i));
			}
		}

		if (form.getLocalContext().getSelectedRecordIsNotNull())
			form.getLocalContext().setSelectedRecord(domain.getDementiaTermConfig(form.grdDetails().getValue()));
	}

	private grdDetailsRow findDementiaTermRow(DementiaTermConfigVo dementiaTermConfigVo)
	{
		for (int i = 0; i < form.grdDetails().getRows().size(); i++)
		{
			if (dementiaTermConfigVo.getField().getID() == form.grdDetails().getRows().get(i).getColLookupValue().getID())
				return form.grdDetails().getRows().get(i);
		}
		return null;
	}

	private void initialize()
	{
		loadDementiaTermConfigLookup();
	}

	private void loadDementiaTermConfigLookup()
	{
		form.grdDetails().getRows().clear();

		DementiaTermConfigCollection coll = LookupHelper.getDementiaTermConfig(domain.getLookupService());

		if (coll == null)
			return;

		for (int i = 0; coll != null && i < coll.size(); i++)
		{
			if (coll.get(i).isActive())
			{
				grdDetailsRow row = form.grdDetails().getRows().newRow();
				row.setColAMTSTerms(coll.get(i).getText());
				row.setColLookupValue(coll.get(i));
				row.setColTermText(null);
			}
		}

	}

	@Override
	protected void onGrdDetailsSelectionChanged()
	{
		getSelectedInstance();
		updateControlsState();
	}

	private void getSelectedInstance()
	{
		form.getLocalContext().setSelectedRecord(form.grdDetails().getValue()!=null?domain.getDementiaTermConfig(form.grdDetails().getValue()):null);
		populateInstanceControlsFromData(form.getLocalContext().getSelectedRecord());
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		editDementiaTermConfig();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	private boolean save()
	{
		DementiaTermConfigVo dementiaTermConfigToSave = populateDataFromScreen(form.getLocalContext().getSelectedRecord());
		
		String[] errors = dementiaTermConfigToSave.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors); 
			return false;
		}
		
		try
		{	
			form.getLocalContext().setSelectedRecord(domain.save(dementiaTermConfigToSave));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		return true;
	}

	private DementiaTermConfigVo populateDataFromScreen(DementiaTermConfigVo selectedRecord)
	{
		if (selectedRecord==null)
			selectedRecord=new DementiaTermConfigVo();
		else
			selectedRecord=(DementiaTermConfigVo) selectedRecord.clone();
		
		selectedRecord.setField(form.grdDetails().getSelectedRow().getColLookupValue());
		selectedRecord.setHelpText(form.txtTermText().getValue());
		
		return selectedRecord;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Update:
				editDementiaTermConfig();
				break;

		}
	}

	private void editDementiaTermConfig()
	{
		form.getLocalContext().setSelectedRecord(form.grdDetails().getValue()!=null?domain.getDementiaTermConfig(form.grdDetails().getValue()):null);
		populateInstanceControlsFromData(form.getLocalContext().getSelectedRecord());
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.btnEdit().setVisible(form.getMode().equals(FormMode.VIEW) && form.grdDetails().getSelectedRow() != null);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.getMode().equals(FormMode.VIEW) && form.grdDetails().getSelectedRow() != null);
	}
}