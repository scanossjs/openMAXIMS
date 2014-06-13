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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.resultcommentsdialog;

import java.util.ArrayList;

import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.enums.MosType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.ocrr.forms.resultcommentsdialog.GenForm.grdCommentsRow;
import ims.ocrr.orderingresults.vo.ResultConclusionAndActionCommentRefVo;
import ims.ocrr.vo.ResultCommentsVo;
import ims.ocrr.vo.ResultCommentsVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final Integer EDIT_MODE_ADD = -1;
	private static final Integer EDIT_MODE_CORRECT = -2;

	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handler functions
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Initialize the form
		initialize();
		// Present screen with data to user
		open();
	}

	@Override
	protected void onFormModeChanged()
	{
		// Reset EDIT mode
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.getLocalContext().setSelectedEditMode(null);
		}
		
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onGrdCommentsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		// Change selected instance
		changeSelectedInstance(null);
		
		// Update controls state
		updateControlsState();
	}

	@Override
	protected void onGrdCommentsSelectionChanged() throws PresentationLogicException
	{
		// Change selected instance to none
		changeSelectedInstance(form.grdComments().getValue());
		
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// If the save is successful then refresh the screen
		if (save())
			open();
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Refresh the screen
		open();
	}
	
	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		// Close dialog
		engine.close(DialogResult.OK);
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.OCRRNamespace.ResultsCommentsMenu.NEW:
				newInstance();
				break;
				
			case GenForm.ContextMenus.OCRRNamespace.ResultsCommentsMenu.CORRECT:
				correctInstance();
				break;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 *	Function used to initialize the form
	 *		- initialize local & global contexts
	 *		- initialize controls & custom controls
	 *		- hide all context menu options
	 */
	public void initialize() throws FormOpenException
	{
		// Perform initialization on local & global contexts
		form.getLocalContext().setSelectedComment(null);
		
		// Initialize authoring information component
		form.ctnDetails().ccAutoringInfo().setIsRequiredPropertyToControls(true);
		// Initialize correcting HCP query & mark it as mandatory
		form.ctnDetails().ccCorrectingHCP().initialize(MosType.HCP);
		form.ctnDetails().ccCorrectingHCP().isRequired(Boolean.TRUE);
		// Hide all context menu options
		form.getContextMenus().OCRR.hideAllResultsCommentsMenuMenuItems();
	}
	
	
	/**
	 *	Function used to populate/refresh the screen
	 *		- retrieve relevant comments from domain
	 *		- attempt to reselect & re-populate the previous selected record
	 *		- set form to VIEW mode 
	 */
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear screen
		clear();
		
		// Refresh investigation
		if (form.getGlobalContext().OCRR.getCurrentPathRadResultIsNotNull())
		{
			form.getGlobalContext().OCRR.getCurrentPathRadResult().setOrderInvestigation(domain.getOrderInvestigation(form.getGlobalContext().OCRR.getCurrentPathRadResult().getOrderInvestigation()));
		}
		
		// List all comments for current result
		populateCommentsGrid(domain.listComments(form.getGlobalContext().OCRR.getCurrentPathRadResult()));
		
		// Reselect previously selected record
		form.grdComments().setValue(form.getLocalContext().getSelectedComment());
		// Change selected instance
		changeSelectedInstance(form.grdComments().getValue());
		
		// Set form to VIEW mode - the event handler will take care of updating the controls state
		form.setMode(FormMode.VIEW);
	}


	/**
	 *	Function used to change selected instance
	 *		- retrieve new instance from domain based on id
	 *		- populate local context for selected record
	 *		- populate instance controls for selected record
	 * @throws PresentationLogicException 
	 */
	public void changeSelectedInstance(ResultConclusionAndActionCommentRefVo value) throws PresentationLogicException
	{
		// Get instance from domain
		form.getLocalContext().setSelectedComment(domain.getComment(value));
		
		// Check for StaleObject
		if (value != null && value.getID_ResultConclusionAndActionCommentIsNotNull() && !form.getLocalContext().getSelectedCommentIsNotNull())
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		
		// Populate instance controls with selected instance
		populateInstanceControls(form.getLocalContext().getSelectedComment());
	}


	/**
	 *	Function used to prepare the form for creating a new instance
	 *		- clear the local context for selected record
	 *		- clear instance controls
	 *		- initialize the controls
	 *		- set form to EDIT mode & ADD mode
	 */
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear local context for selected record
		form.getLocalContext().setSelectedComment(null);
		
		// Clear instance controls
		clearInstanceControls();
		
		// Initialize the authoring information
		form.ctnDetails().ccAutoringInfo().initializeComponent();
		
		// Set editing mode ADD of new comment
		form.getLocalContext().setSelectedEditMode(EDIT_MODE_ADD);
		
		// Set form mode to EDIT
		form.setMode(FormMode.EDIT);
	}

	/**
	 * Function used to prepare form for correcting a comment
	 * 		- set form to EDIT mode & CORRECT mode
	 */
	private void correctInstance()
	{
		// Set editing mode CORRECT of comment
		form.getLocalContext().setSelectedEditMode(EDIT_MODE_CORRECT);
		
		// Default the logged in user
		if (form.getLocalContext().getSelectedCommentIsNotNull() && !form.getLocalContext().getSelectedComment().getCorrectingHcpIsNotNull())
		{
			HcpLiteVo hcpUser = (HcpLiteVo) domain.getHcpLiteUser();
			
			if (hcpUser != null)
			{
				form.ctnDetails().ccCorrectingHCP().setValue(hcpUser);
			}
		}
		
		// Default correcting date time
		if (form.getLocalContext().getSelectedCommentIsNotNull() && !form.getLocalContext().getSelectedComment().getCorrectingDateTimeIsNotNull())
		{
			form.ctnDetails().dtimCorrectedDateTime().setValue(new DateTime());
		}
		
		// Set form mode to EDIT
		form.setMode(FormMode.EDIT);
	}

	/**
	 *	Function used to prepare the form for editing an instance
	 *		- set form to EDIT mode 
	 */
	public void updateInstance()
	{
		// Set form mode to EDIT
		form.setMode(FormMode.EDIT);
	}
	
	
	/**
	 *	Function used to commit to database the modified instance
	 *		- populate current / new record from screen
	 *		- validate instance record
	 *		- commit to database
	 *		- treat any exceptions that might arise
	 */
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			// Populate current / new record from screen
			form.getLocalContext().setSelectedComment(populateDataFromInstanceControls(form.getLocalContext().getSelectedComment()));

			// Validate instance record
			String[] errors = form.getLocalContext().getSelectedComment().validate(validateUI());
			// If validation errors occurs - terminate function as not successful
			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}

			// Determine if we create a new record or editing an existing one
			// If selected record has an ID - then it was committed to database already
			if (form.getLocalContext().getSelectedComment().getID_ResultConclusionAndActionCommentIsNotNull())
			{
				form.getLocalContext().setSelectedComment(domain.saveEdit(form.getLocalContext().getSelectedComment()));
			}
			else
			{
				// Otherwise the selected record must be associated to the result
				form.getLocalContext().setSelectedComment(domain.saveNew(form.getGlobalContext().OCRR.getCurrentPathRadResult(), form.getLocalContext().getSelectedComment()));
			}

			// At this point - assume that the save succeeded
			return true;
		}
		catch (StaleObjectException exception)
		{
			// Treat StaleObjectException
			exception.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
	}
	
	/**
	 * WDEV-13872
	 * Custom validation (for correcting comment notes)
	 */
	private String[] validateUI()
	{
		ArrayList<String> errorList = new ArrayList<String>();
		
		if (EDIT_MODE_CORRECT.equals(form.getLocalContext().getSelectedEditMode()))
		{
			if (form.ctnDetails().ccCorrectingHCP().getValue() == null)
			{
				errorList.add("Correcting HCP is mandatory.");
			}
			
			if (form.ctnDetails().dtimCorrectedDateTime().getValue() == null)
			{
				errorList.add("Correcting Date Time is mandatory.");
			}
			
			if (form.ctnDetails().txtCorrectionReason().getValue() == null)
			{
				errorList.add("Correction Reason is mandatory.");
			}
		}
		
		return errorList.toArray(new String[errorList.size()]);
	}

	/**
	 *	Function used to update the state of the controls 
	 */
	public void updateControlsState()
	{
		boolean viewMode = FormMode.VIEW.equals(form.getMode());
		boolean editMode = FormMode.EDIT.equals(form.getMode());

		boolean addingMode = EDIT_MODE_ADD.equals(form.getLocalContext().getSelectedEditMode());
		boolean slectedRecordIsCorrected = form.getLocalContext().getSelectedCommentIsNotNull() && form.getLocalContext().getSelectedComment().getCorrectingDateTimeIsNotNull();
		boolean correctingMode = EDIT_MODE_CORRECT.equals(form.getLocalContext().getSelectedEditMode());

		// Enable the Authoring Information 
		form.ctnDetails().ccAutoringInfo().setEnabledAuthoringHCP(editMode && addingMode);
		form.ctnDetails().ccAutoringInfo().setEnabledDateTime(editMode && addingMode);
		
		form.ctnDetails().lblCorrectingHCP().setVisible(viewMode && slectedRecordIsCorrected || editMode && correctingMode);
		form.ctnDetails().ccCorrectingHCP().setVisible(viewMode && slectedRecordIsCorrected || editMode && correctingMode);
		form.ctnDetails().ccCorrectingHCP().setEnabled(editMode && correctingMode);
		
		form.ctnDetails().lblCorrectingDateTime().setVisible(viewMode && slectedRecordIsCorrected || editMode && correctingMode);
		form.ctnDetails().dtimCorrectedDateTime().setVisible(viewMode && slectedRecordIsCorrected || editMode && correctingMode);
		form.ctnDetails().dtimCorrectedDateTime().setEnabled(editMode && correctingMode);

		form.ctnDetails().lblCorrectingReason().setVisible(viewMode && slectedRecordIsCorrected || editMode && correctingMode);
		form.ctnDetails().txtCorrectionReason().setVisible(viewMode && slectedRecordIsCorrected || editMode && correctingMode);
		form.ctnDetails().txtCorrectionReason().setEnabled(editMode && correctingMode);

		if (editMode)
		{
			form.ctnDetails().txtComments().setEnabled(addingMode);
		}

		// Update context menu state
		updateContextMenuState();
	}
	
	
	/**
	 * Function used to update the state of the context menu options
	 */
	private void updateContextMenuState()
	{
		boolean viewMode = FormMode.VIEW.equals(form.getMode());

		// VIEW Mode
		form.getContextMenus().OCRR.getResultsCommentsMenuNEWItem().setVisible(viewMode && engine.hasRight(AppRight.CAN_ADD_RESULT_ANNOTATIONS));
		// EDIT Mode
		form.getContextMenus().OCRR.getResultsCommentsMenuCORRECTItem().setVisible(viewMode && engine.hasRight(AppRight.CAN_CORRECT_RESULT_ANNOTATIONS) && form.grdComments().getSelectedRow() != null);
	}

	
	/**
	 *	Function used to clear the screen
	 */
	public void clear()
	{
		// Clear grid
		form.grdComments().getRows().clear();
		
		// Clear instance controls
		clearInstanceControls();
	}
	
	
	/**
	 *	Function used to clear the instance controls
	 */
	public void clearInstanceControls()
	{
		form.ctnDetails().ccAutoringInfo().setValue(null);
		
		form.ctnDetails().txtComments().setValue(null);
		
		form.ctnDetails().ccCorrectingHCP().clear();
		form.ctnDetails().dtimCorrectedDateTime().setValue(null);
		form.ctnDetails().txtCorrectionReason().setValue(null);
	}


	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Data exchange functions
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 *	Function used to populate the grid with comments from a collection
	 */
	private void populateCommentsGrid(ResultCommentsVoCollection commentCollection)
	{
		// Clear grid
		form.grdComments().getRows().clear();
		
		// Check parameter for null collection
		if (commentCollection == null)
			return;
		
		// Iterate comments collection and add each collection
		for (ResultCommentsVo comment : commentCollection)
		{
			grdCommentsRow row = form.grdComments().getRows().newRow();
			
			row.setColAuthorDate(comment.getAuthoringInformation().getAuthoringDateTime().toString());
			row.setColAuthorHCP(comment.getAuthoringInformation().getAuthoringHcp().toString());

			row.setColComment(comment.getComment());
			row.setTooltipForColComment(comment.getComment());

			if (comment.getCorrectingHcpIsNotNull() && comment.getCorrectingDateTimeIsNotNull())
			{
    			row.setTextColor(Color.Gray);
			}
			
			row.setValue(comment);
		}
	}

	
	/**
	 *	Function used to populate instance controls with data
	 */
	private void populateInstanceControls(ResultCommentsVo comment)
	{
		// Clear instance controls
		clearInstanceControls();
		
		// Check parameter for null value
		if (comment == null)
			return;

		// Set value into controls
		form.ctnDetails().ccAutoringInfo().setValue(comment.getAuthoringInformation());
		form.ctnDetails().txtComments().setValue(comment.getComment());
		
		form.ctnDetails().ccCorrectingHCP().setValue(comment.getCorrectingHcp());
		form.ctnDetails().dtimCorrectedDateTime().setValue(comment.getCorrectingDateTime());
		form.ctnDetails().txtCorrectionReason().setValue(comment.getCorrectionReason());
	}

	
	/**
	 *	Function used to populate record from instance controls 
	 */
	private ResultCommentsVo populateDataFromInstanceControls(ResultCommentsVo comment)
	{
		// If the current record is null create a new one
		if (comment == null)
			comment = new ResultCommentsVo();
		
		// Populate record with data from screen
		comment.setAuthoringInformation(form.ctnDetails().ccAutoringInfo().getValue());
		comment.setComment(form.ctnDetails().txtComments().getValue());
		
		comment.setCorrectingHcp((HcpLiteVo) form.ctnDetails().ccCorrectingHCP().getValue());
		comment.setCorrectingDateTime(form.ctnDetails().dtimCorrectedDateTime().getValue());
		comment.setCorrectionReason(form.ctnDetails().txtCorrectionReason().getValue());
		
		// Return the comment
		return comment;
	}
}