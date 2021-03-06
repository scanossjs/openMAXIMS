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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.triagenotedialog;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.vo.TriageNotesVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

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
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.chkDefaultTriageNote().setVisible(form.getLocalContext().getDefaultTriageNoteIsNotNull());
		
		form.ccAuthoring().setEnabledAuthoringHCP(form.getGlobalContext().Emergency.getTriageNote() != null && form.getGlobalContext().Emergency.getTriageNote().getID_TriageNotes() == null);
		form.ccAuthoring().setEnabledDateTime(form.getGlobalContext().Emergency.getTriageNote() != null && form.getGlobalContext().Emergency.getTriageNote().getID_TriageNotes() == null);
	}

	private void populateScreenFromData() 
	{
		if(form.getGlobalContext().Emergency.getTriageNote() == null)
			return;
		
		if(form.getGlobalContext().Emergency.getTriageNote().getID_TriageNotesIsNotNull())
		{
			form.ccAuthoring().setValue(form.getGlobalContext().Emergency.getTriageNote().getAuthoringInformation());
			form.richTextNote().setValue(form.getGlobalContext().Emergency.getTriageNote().getTriageNote());
		}
	}

	private void initialize() 
	{
		form.ccAuthoring().initializeComponent();
		form.ccAuthoring().setIsRequiredPropertyToControls(true);
		
		if(form.getGlobalContext().Emergency.getTriageNoteIsNotNull() && form.getGlobalContext().Emergency.getTriageNote().getPresentingProblemIsNotNull())
		{
			form.getLocalContext().setDefaultTriageNote(domain.getDefaultTriageNote(form.getGlobalContext().Emergency.getTriageNote().getPresentingProblem()));
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}

	private boolean save() 
	{
		TriageNotesVo note = populateDatafromScreen();
		
		String[] errors = note.validate();
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try 
		{
			form.getGlobalContext().Emergency.setTriageNote(domain.save(note));
		} 
		catch (StaleObjectException e) 
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return false;
		}
		
		return true;
	}

	private TriageNotesVo populateDatafromScreen() 
	{
		TriageNotesVo note = null;
		
		if(form.getGlobalContext().Emergency.getTriageNote() == null)
		{
			note = new TriageNotesVo();
		}
		else
		{
			note = (TriageNotesVo) form.getGlobalContext().Emergency.getTriageNote().clone();
		}
		
		note.setAuthoringInformation(form.ccAuthoring().getValue());
		note.setTriageNote(form.richTextNote().getValue());
		
		return note;
	}

	@Override
	protected void onChkDefaultTriageNoteValueChanged()	throws PresentationLogicException 
	{
		if(form.chkDefaultTriageNote().getValue())
		{
			form.richTextNote().pasteText(form.getLocalContext().getDefaultTriageNote().getDefaultTriageNote());
		}
	}
}
