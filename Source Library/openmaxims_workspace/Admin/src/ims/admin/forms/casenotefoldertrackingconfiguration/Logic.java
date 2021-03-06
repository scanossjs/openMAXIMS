//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5214.17710)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.forms.casenotefoldertrackingconfiguration;

import ims.admin.vo.CaseNoteTrackingConfigVo;
import ims.admin.vo.LocationShortVo;
import ims.admin.vo.LocationShortVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.Lookup;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnNewEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getSelectedRecord() == null)
			 	clearScreen();		 
		form.setMode(FormMode.EDIT);		
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
		
	}
	private void open()
	{
		form.getLocalContext().setSelectedRecord(domain.getTrackingConfig());
		if (form.getLocalContext().getSelectedRecordIsNotNull())
			form.btnNewEdit().setText("Edit");
		
		populateScreenFromData(form.getLocalContext().getSelectedRecord());
		form.setMode(FormMode.VIEW);
		
	}
	private void populateScreenFromData(CaseNoteTrackingConfigVo selectedRecord)
	{
		clearScreen();

		if (selectedRecord != null)
		{	
			form.intCloseDays().setValue(selectedRecord.getRequestsOlderThan());
			form.intHoursOffset().setValue(selectedRecord.getCaseNoteRequestOffset());
			form.intTrackingIDLen().setValue(selectedRecord.getTrackingIdNoOfDigits());
			form.cmbDefaultFolderVal().setValue(selectedRecord.getDefaultFolderForAutomaticCaseNote());	
			//WDEV-21207
			if(selectedRecord.getDefaultCaseNoteFolderLocation() != null)
			{
				form.qmbDCNFL().newRow(selectedRecord.getDefaultCaseNoteFolderLocation(), selectedRecord.getDefaultCaseNoteFolderLocation().getName());
				form.qmbDCNFL().setValue(selectedRecord.getDefaultCaseNoteFolderLocation());
			}		
			
		}

	}
	private void clearScreen()
	{
		form.intCloseDays().setValue(null);
		form.intHoursOffset().setValue(null);
		form.intTrackingIDLen().setValue(null);
		form.cmbDefaultFolderVal().setValue(null);
				
	}
	private boolean save()
	{
		CaseNoteTrackingConfigVo configRecordToSaveVo = populateDataFromScreen(form.getLocalContext().getSelectedRecord());
		
		String[] errors = configRecordToSaveVo.validate(getUIErrors());
		
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try 
		{
			form.getLocalContext().setSelectedRecord(domain.saveCaseNoteTrackingConfig(configRecordToSaveVo));
		}
		catch (DomainInterfaceException ex)
		{
			engine.showMessage(ex.getMessage());
			return false;
		}
		catch (StaleObjectException exc)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		return true;
	}
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		//WDEV-21207
		if(form.qmbDCNFL().getValue() == null)
		{
			errors.add("Default Case Note Folder Location for case notes that require creation is mandatory.");
		}
		if (form.intCloseDays().getValue() != null && form.intCloseDays().getValue().intValue() == 0)
		{
			errors.add("Close Requests Older Than must be greater than 0.");
		}
		if (form.intHoursOffset().getValue() != null && form.intHoursOffset().getValue().intValue() == 0)
		{
			errors.add("Case Note Request Offset must be greater than 0.");
		}
		if (errors.size() > 0)
			return errors.toArray(new String[errors.size()]);
		
		return null;
	}
	private CaseNoteTrackingConfigVo populateDataFromScreen(CaseNoteTrackingConfigVo recVo)
	{
		if (recVo == null)
			recVo = new CaseNoteTrackingConfigVo();
		recVo.setRequestsOlderThan(form.intCloseDays().getValue());
		recVo.setCaseNoteRequestOffset(form.intHoursOffset().getValue());
		recVo.setTrackingIdNoOfDigits(form.intTrackingIDLen().getValue());
		recVo.setDefaultFolderForAutomaticCaseNote(form.cmbDefaultFolderVal().getValue());
		recVo.setDefaultCaseNoteFolderLocation(form.qmbDCNFL().getValue());//WDEV-21207
						
		return recVo;
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onFormModeChanged()
	{

		
	}
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		open();
	}
	
	//WDEV-21207
	private void showMedicalRecordLocations(String value)
	{
		form.qmbDCNFL().clear();
		
		LocationShortVoCollection locations = domain.listMedicalRecordLocations(value);
		if (locations != null)
		{
			for (LocationShortVo item: locations)
			{
				form.qmbDCNFL().newRow(item, item.getName());
			}
		}

		form.qmbDCNFL().showOpened();
	}

	//WDEV-21207
	protected void onQmbDCNFLTextSubmited(String value) throws PresentationLogicException {
		
		showMedicalRecordLocations(value);	
	}
}
