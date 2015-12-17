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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4892.20548)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.edpartialadmissiondialog;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.EDPartialAdmissionVo;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.TrackingForEDPartialAdmissionVo;
import ims.emergency.vo.TrackingRefVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	private void updateControlsState()
	{
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && form.getLocalContext().getCurrentEDPartialAdmission()!=null);
		form.btnSave().setVisible(FormMode.EDIT.equals(form.getMode()));
		
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initializeControls();
		if (args != null && args.length == 1 && args[0] != null && args[0] instanceof TrackingRefVo)
		{
			form.getLocalContext().setCurrentTrackingForEdPartialAdmission(domain.getTrackingForEdPartialAdmission((TrackingRefVo) args[0]));
			open();
			
			if(form.getLocalContext().getCurrentTrackingForEdPartialAdmissionIsNotNull() && form.getLocalContext().getCurrentTrackingForEdPartialAdmission().getCurrentPartialAdmission()==null)
			{
				newInstance();
			}
		}
	}
	private void newInstance()
	{
		clearControls();
		
		form.getLocalContext().setCurrentEDPartialAdmission(null);
		form.dtimDecisionToAdmit().setValue(new DateTime());
		form.dtimBedAllocated().setValue(new DateTime());
		
		form.setMode(FormMode.EDIT);
	}
	private void clearControls()
	{
		form.dtimDecisionToAdmit().setValue(null);
		form.cmbSpecialty().setValue(null);
		form.cmbBedAllocationType().setValue(null);
		form.txtBedAllocationNote().setValue(null);
		form.dtimBedAllocated().setValue(null);
		form.cmbBedAllocatedWard().setValue(null);
		form.cmbAdmissionStatus().setValue(null);
		form.cmbPatientStatus().setValue(null);
		form.cmbRequestedBedType().setValue(null);
		
	}
	private void open()
	{
		form.getLocalContext().setCurrentTrackingForEdPartialAdmission(domain.getTrackingForEdPartialAdmission(form.getLocalContext().getCurrentTrackingForEdPartialAdmission()));
		form.getLocalContext().setCurrentEDPartialAdmission(form.getLocalContext().getCurrentTrackingForEdPartialAdmission()!=null ? form.getLocalContext().getCurrentTrackingForEdPartialAdmission().getCurrentPartialAdmission() : null);
		populateScreenFromData(form.getLocalContext().getCurrentEDPartialAdmission());
		form.setMode(FormMode.VIEW);
	}
	private void populateScreenFromData(EDPartialAdmissionVo edPartialAdmissionVo)
	{
		if (edPartialAdmissionVo==null)
			return;

		form.dtimDecisionToAdmit().setValue(edPartialAdmissionVo.getDecisionToAdmitDateTime());
		form.cmbConsultant().setValue(edPartialAdmissionVo.getAdmittingConsultant());
		form.cmbSpecialty().setValue(edPartialAdmissionVo.getSpecialty());
		form.cmbBedAllocationType().setValue(edPartialAdmissionVo.getAllocatedBedType());
		form.txtBedAllocationNote().setValue(edPartialAdmissionVo.getAllocatedBedNote());
		form.dtimBedAllocated().setValue(edPartialAdmissionVo.getAllocatedDateTime());
		form.cmbBedAllocatedWard().setValue(edPartialAdmissionVo.getAllocatedWard());
		form.cmbAdmissionStatus().setValue(edPartialAdmissionVo.getAllocatedStatus());
		//form.cmbPatientStatus().setValue(null);
		//form.cmbRequestedBedType().setValue(null);
	}
	private void initializeControls()
	{
		populateWardCombo();
	}
	private void populateWardCombo()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if (save())
		{
			engine.close(DialogResult.CANCEL);
		}
	}
	private boolean save()
	{
		EDPartialAdmissionVo edPartialAdmissionToSave = populateDataFromScreen(form.getLocalContext().getCurrentEDPartialAdmission());

		String[] errors = edPartialAdmissionToSave.validate(getUIErrors());
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		/*
		// Check SOE
		if (edPartialAdmissionToSave.getID_ReferralToSpecTeamIsNotNull() && domain.isStale(edPartialAdmissionToSave))
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			if (form.getLocalContext().getSelectedReferralToSpecialtyIsNotNull())
			{
				form.getLocalContext().setSelectedReferralToSpecialty(domain.getReferralToSpecialty(form.getLocalContext().getSelectedReferralToSpecialty()));
			}
			if (form.getLocalContext().getTrackingForReferralIsNotNull())
			{
				form.getLocalContext().setTrackingForReferral(domain.getTrackingForReferral(form.getLocalContext().getTrackingForReferral()));
			}
			open();
			return false;
		}

		 */
		TrackingForEDPartialAdmissionVo trackingToSave = null;

		// for a new EDPartialAdmissionVo set the current EdPartiqalAdmission in tracking and set Tracking.CurrentStatus
		if (edPartialAdmissionToSave.getID_EDPartialAdmission()==null)
		{
			trackingToSave = form.getLocalContext().getCurrentTrackingForEdPartialAdmission();
			
			//TrackingAttendanceStatusVo 	trackingStatusToSave = populateTrackingAttendanceStatus(TrackingStatus.REFERRED_TO_OTHER_SPECIALITY);

			trackingToSave.setCurrentPartialAdmission(edPartialAdmissionToSave);
			//trackingToSave.setCurrentStatus(trackingStatusToSave);
		}
			
		try
		{
			if (trackingToSave != null )
			{
				String[] errors1 = trackingToSave.validate();

				if (errors1 != null && errors1.length > 0)
				{
					engine.showErrors(errors1);
					return false;
				}
				
				
				form.getLocalContext().setCurrentEDPartialAdmission(domain.save(trackingToSave,null));
				
				form.getLocalContext().setCurrentTrackingForEdPartialAdmission(domain.getTrackingForEdPartialAdmission(trackingToSave));
			}
			else
				form.getLocalContext().setCurrentEDPartialAdmission(domain.save(null,edPartialAdmissionToSave));
			
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());

			return false;
		}

		return true;

	}
	private EDPartialAdmissionVo populateDataFromScreen(EDPartialAdmissionVo currentEDPartialAdmission)
	{
		if (currentEDPartialAdmission == null)
		{
			currentEDPartialAdmission = new EDPartialAdmissionVo();
		}
		else
			currentEDPartialAdmission=(EDPartialAdmissionVo) currentEDPartialAdmission.clone();

		currentEDPartialAdmission.setDecisionToAdmitDateTime(form.dtimDecisionToAdmit().getValue());
		currentEDPartialAdmission.setAdmittingConsultant(form.cmbConsultant().getValue());
		currentEDPartialAdmission.setSpecialty(form.cmbSpecialty().getValue());
		currentEDPartialAdmission.setAllocatedBedType(form.cmbBedAllocationType().getValue());
		currentEDPartialAdmission.setAllocatedBedNote(form.txtBedAllocationNote().getValue());
		currentEDPartialAdmission.setAllocatedDateTime(form.dtimBedAllocated().getValue());
		currentEDPartialAdmission.setAllocatedWard(form.cmbBedAllocatedWard().getValue());
		currentEDPartialAdmission.setAllocatedStatus(form.cmbAdmissionStatus().getValue());
		
		return currentEDPartialAdmission;
	}
	private String[] getUIErrors()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void onBtnCreatedInErrorClick() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
}