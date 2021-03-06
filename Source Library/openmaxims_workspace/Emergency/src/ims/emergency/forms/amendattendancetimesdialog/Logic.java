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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.amendattendancetimesdialog;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.TrackingForTimeAmendmentsVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final String PARTIAL_ADMISSION = "PARTIAL";
	private static final String PENDING_ADMISSION = "PENDING";

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open()
	{
		form.getLocalContext().setCurrentRecord(domain.getTracking(form.getGlobalContext().Emergency.getAmendAttendanceTimes()));
		
		if(form.getLocalContext().getCurrentRecord() == null)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		populateScreenFromData(form.getLocalContext().getCurrentRecord());
		
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.dtimIncident().setEnabled(form.dtimIncident().getValue() != null);
		form.dtimArrival().setEnabled(form.dtimArrival().getValue() != null);
		form.dtimRegistration().setEnabled(form.dtimRegistration().getValue() != null);
		form.dtimTriage().setEnabled(form.dtimTriage().getValue() != null);
		form.dtimDischarge().setEnabled(form.dtimDischarge().getValue() != null);
		form.dtimAmbulanceArrival().setEnabled(form.dtimAmbulanceArrival().getValue() != null);
		//form.dtimExpectedArrival().setEnabled(form.dtimExpectedArrival().getValue() != null);
		form.dtimConclusion().setEnabled(form.dtimConclusion().getValue() != null);
		form.dtimTriageCompletion().setEnabled(form.dtimTriageCompletion().getValue() != null);
		
		form.dtimRegistrationEnd().setEnabled(form.dtimRegistrationEnd().getValue() != null);
		form.dtimDecisionToAdmit().setEnabled(form.dtimDecisionToAdmit().getValue() != null);
	}

	private void populateScreenFromData(TrackingForTimeAmendmentsVo trackingForTimeAmendmentsVo)
	{
		clearScreen();
		
		if(trackingForTimeAmendmentsVo == null)
			return;
		
		if(trackingForTimeAmendmentsVo.getAttendance() != null)
		{
    		form.dtimArrival().setValue(trackingForTimeAmendmentsVo.getAttendance().getArrivalDateTime());
    		form.dtimRegistration().setValue(trackingForTimeAmendmentsVo.getAttendance().getRegistrationDateTime());
    		form.dtimRegistrationEnd().setValue(trackingForTimeAmendmentsVo.getAttendance().getEndOfRegistrationDateTime());
    		form.dtimDischarge().setValue(trackingForTimeAmendmentsVo.getAttendance().getDischargeDateTime());
    		form.dtimAmbulanceArrival().setValue(trackingForTimeAmendmentsVo.getAttendance().getAmbulanceArrivalDateTime());
    		//form.dtimExpectedArrival().setValue(trackingForTimeAmendmentsVo.getAttendance().getExpectedArrivalDateTime());
    		form.dtimConclusion().setValue(trackingForTimeAmendmentsVo.getAttendance().getConclusionDateTime());
		}
		
		if(trackingForTimeAmendmentsVo.getTriageDetails() != null)
		{
			form.dtimTriage().setValue(trackingForTimeAmendmentsVo.getTriageDetails().getTriageStartDateTime());
			form.dtimTriageCompletion().setValue(trackingForTimeAmendmentsVo.getTriageDetails().getTriageCompletionTime());
		}
		
		if(trackingForTimeAmendmentsVo.getEpisode() != null)
		{
			form.dtimIncident().setValue(trackingForTimeAmendmentsVo.getEpisode().getInjuryDateTime());
		}
		
		if(ConfigFlag.GEN.ED_DTA_ADMISSION_FUNCTIONALITY.getValue().equals(PENDING_ADMISSION))
		{
			form.dtimDecisionToAdmit().setValue(trackingForTimeAmendmentsVo.getAssociatedPendingEmergencyAdmission() != null ? trackingForTimeAmendmentsVo.getAssociatedPendingEmergencyAdmission().getDTADateTime() : null);
		}
		else if(ConfigFlag.GEN.ED_DTA_ADMISSION_FUNCTIONALITY.getValue().equals(PARTIAL_ADMISSION))
		{
			form.dtimDecisionToAdmit().setValue(trackingForTimeAmendmentsVo.getCurrentPartialAdmission() != null ? trackingForTimeAmendmentsVo.getCurrentPartialAdmission().getDecisionToAdmitDateTime() : null);
		}
	}

	private void clearScreen()
	{
		form.dtimIncident().setValue(null);
		form.dtimArrival().setValue(null);
		form.dtimRegistration().setValue(null);
		form.dtimRegistrationEnd().setValue(null);
		form.dtimDischarge().setValue(null);
		form.dtimAmbulanceArrival().setValue(null);
		//form.dtimExpectedArrival().setValue(null);
		form.dtimConclusion().setValue(null);
		
		form.dtimTriageCompletion().setValue(null);
		form.dtimTriage().setValue(null);
		
		form.dtimDecisionToAdmit().setValue(null);
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
		TrackingForTimeAmendmentsVo record = populateDataFromScreen(form.getLocalContext().getCurrentRecord());
		
		String[] errors = validateUIRules();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		errors = record.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.save(record);
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		return true;
	}

	private String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		validateIncidentDate(uiErrors);
		validateAmbulanceArrivalDate(uiErrors);
		//validateExpectedArrivalDate(uiErrors);
		validateArrivalDate(uiErrors);
		validateRegistrationStartTime(uiErrors);
		validateRegistrationEndTime(uiErrors);
		validateTriageStartDate(uiErrors);
		validateTriageEndDate(uiErrors);
		validateDecisionToAdmitDate(uiErrors);
		validateConclusionDate(uiErrors);
		validateDischargeDate(uiErrors);
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private void validateConclusionDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime registrationDateTime = form.dtimRegistration().getValue();
		DateTime conclusionDate = form.dtimConclusion().getValue();
		
		if(form.dtimConclusion().isEnabled() && conclusionDate == null)
		{
			uiErrors.add("Conclusion Date/Time is mandatory.");
		}
		if (conclusionDate != null && conclusionDate.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Conclusion Date/Time is in the future.");
		}
		if (conclusionDate != null && !registrationDateTime.isLessOrEqualThan(conclusionDate))
		{
			uiErrors.add("Conclusion Date/Time must be set after Registration Start Time.");
		}
		
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(conclusionDate != null && dischargeDatetime != null && conclusionDate.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Conclusion Date/Time cannot be greater than Departed Date/Time.");
		}
	}

	/*
	private void validateExpectedArrivalDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		if(form.dtimExpectedArrival().isEnabled() && form.dtimExpectedArrival().getValue() == null)
		{
			uiErrors.add("Expected Arrival Date/Time is mandatory.");
		}
		
		if (form.dtimExpectedArrival().getValue() != null && form.dtimExpectedArrival().getValue().isGreaterThan(new DateTime()))
		{
			uiErrors.add("Expected Arrival Date/Time is in the future.");
		}
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(form.dtimExpectedArrival().getValue() != null && dischargeDatetime != null && form.dtimExpectedArrival().getValue().isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Expected Arrival Date/Time cannot be greater than Departed Date/Time.");
		}
	}
	*/

	private void validateAmbulanceArrivalDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime incidentDate = form.dtimIncident().getValue();
		DateTime ambulanceArrivalDate = form.dtimAmbulanceArrival().getValue();
		if(form.dtimAmbulanceArrival().isEnabled() && ambulanceArrivalDate == null)
		{
			uiErrors.add("Ambulance Arrival Date/Time is mandatory.");
		}
		
		if (ambulanceArrivalDate != null && incidentDate != null && incidentDate.isGreaterThan(ambulanceArrivalDate))
		{
			uiErrors.add("Ambulance Arrival Date/Time cannot be less than Incident Time.");
		}
		
		if (ambulanceArrivalDate != null && ambulanceArrivalDate.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Ambulance Arrival Date/Time is in the future.");
		}
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(ambulanceArrivalDate != null && dischargeDatetime != null && ambulanceArrivalDate.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Ambulance Arrival Date/Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateTriageEndDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime triageStartDate = form.dtimTriage().getValue();
		DateTime triageEndDate = form.dtimTriageCompletion().getValue();
		
		if(form.dtimTriageCompletion().isEnabled() && triageEndDate == null)
		{
			uiErrors.add("Triage Completion Date/Time is mandatory.");
		}
		if (triageEndDate != null && triageEndDate.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Triage Completion Date/Time is in the future.");
		}
		if (triageEndDate != null && triageStartDate != null && !triageStartDate.isLessOrEqualThan(triageEndDate))
		{
			uiErrors.add("Triage Completion Date/Time cannot be less than Triage Date/Time.");
		}
		
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(triageEndDate != null && dischargeDatetime != null && triageEndDate.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Triage Completion Date/Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateTriageStartDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime registrationDateTime = form.dtimRegistration().getValue();
		DateTime triageStartDate = form.dtimTriage().getValue();
		
		if(form.dtimTriage().isEnabled() && triageStartDate == null)
		{
			uiErrors.add("Triage Date/Time is mandatory.");
		}
		if (triageStartDate != null && triageStartDate.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Triage Date/Time is in the future.");
		}
		if (triageStartDate != null && registrationDateTime != null && !registrationDateTime.isLessOrEqualThan(triageStartDate))
		{
			uiErrors.add("Triage Date/Time must be set after Registration Start Time.");
		}
		
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(triageStartDate != null && dischargeDatetime != null && triageStartDate.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Triage Date/Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateDecisionToAdmitDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime registrationDateTime = form.dtimRegistration().getValue();
		DateTime decisionToAdmit = form.dtimDecisionToAdmit().getValue();
		
		if(form.dtimDecisionToAdmit().isEnabled() && decisionToAdmit == null)
		{
			uiErrors.add("Decision to Admit Date/Time is mandatory.");
		}
		if (decisionToAdmit != null && decisionToAdmit.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Decision to Admit Date/Time is in the future.");
		}
		if (decisionToAdmit != null && registrationDateTime != null && !registrationDateTime.isLessOrEqualThan(decisionToAdmit))
		{
			uiErrors.add("Decision to Admit Date/Time must be set after Registration Start Time.");
		}
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(decisionToAdmit != null && dischargeDatetime != null && decisionToAdmit.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Decision to Admit Date/Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateRegistrationEndTime(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		if(form.dtimRegistrationEnd().isEnabled() && form.dtimRegistrationEnd().getValue() == null)
		{
			uiErrors.add("Registration End Time is mandatory.");
		}
		if (form.dtimRegistrationEnd().getValue() != null && form.dtimRegistration().getValue() != null && form.dtimRegistrationEnd().getValue().isLessThan(form.dtimRegistration().getValue()))
		{
			uiErrors.add("Registration End Time cannot be less than Registration Time.");
		}
		if (form.dtimRegistrationEnd().getValue() != null && form.dtimRegistrationEnd().getValue().isGreaterThan(new DateTime()))
		{
			uiErrors.add("Registration End Time is in the future.");
		}
		
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(form.dtimRegistrationEnd().getValue() != null && dischargeDatetime != null && form.dtimRegistrationEnd().getValue().isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Registration End Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateArrivalDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime arrivalDateTime = form.dtimArrival().getValue();
		DateTime incidentDateTime = form.dtimIncident().getValue();
		DateTime ambulanceArrival = form.dtimAmbulanceArrival().getValue();
		
		boolean foundField = false;
		
		if(form.dtimArrival().isEnabled() && arrivalDateTime == null)
		{
			uiErrors.add("Arrival Date/Time is mandatory.");
		}
		
		if (arrivalDateTime != null && arrivalDateTime.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Arrival Time is in the future.");
		}
		
		if(!foundField)
		{
    		if (incidentDateTime != null && arrivalDateTime != null && arrivalDateTime.isLessThan(incidentDateTime))
    		{
    			uiErrors.add("Arrival Time cannot be less than Incident Time.");
    			foundField = true;
    		}
		}
		
		if(!foundField)
		{
    		if (arrivalDateTime != null && ambulanceArrival != null && ambulanceArrival.isGreaterThan(arrivalDateTime))
    		{
    			uiErrors.add("Arrival Time cannot be less than Ambulance Arrival Time.");
    			foundField = true;
    		}
		}
		
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(arrivalDateTime != null && dischargeDatetime != null && arrivalDateTime.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Arrival Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateIncidentDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime incidentDateTime = form.dtimIncident().getValue();
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		
		if(form.dtimIncident().isEnabled() && incidentDateTime == null)
		{
			uiErrors.add("Incident Date/Time is mandatory.");
		}
		
		if (incidentDateTime != null && incidentDateTime.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Incident Date/Time is in the future.");
		}
		
		if(incidentDateTime != null && dischargeDatetime != null && incidentDateTime.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Incident Date/Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateRegistrationStartTime(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime ambulanceArrival = form.dtimAmbulanceArrival().getValue();
		DateTime incidentDateTime = form.dtimIncident().getValue();
		DateTime arrivalDateTime = form.dtimArrival().getValue();
		DateTime registrationDateTime = form.dtimRegistration().getValue();
		
		boolean foundField = false;
		
		if(form.dtimRegistration().isEnabled() && registrationDateTime == null)
		{
			uiErrors.add("Registration Start Time is mandatory.");
		}
		
		if(!foundField)
		{
			if (registrationDateTime != null && ambulanceArrival != null && ambulanceArrival.isGreaterThan(form.dtimRegistration().getValue()))
			{
				uiErrors.add("Registration Start Time cannot be less than Ambulance Arrival Time.");
				foundField = true;
			}
		}
		
		if(!foundField)
		{
    		if (incidentDateTime != null && registrationDateTime != null && registrationDateTime.isLessThan(incidentDateTime))
    		{
    			uiErrors.add("Registration Start Time cannot be less than Incident Time.");
    			foundField = true;
    		}
		}

		if(!foundField)
		{
    		if (arrivalDateTime != null && registrationDateTime != null && registrationDateTime.isLessThan(arrivalDateTime))
    		{
    			uiErrors.add("Registration Start Time cannot be less than Arrival Time");
    			foundField = true;
    		}
		}
		
		if (registrationDateTime != null && registrationDateTime.isGreaterThan(new DateTime()))
		{
			uiErrors.add("Registration Start Time is in the future.");
		}
		
		DateTime dischargeDatetime = form.dtimDischarge().getValue();
		if(registrationDateTime != null && dischargeDatetime != null && registrationDateTime.isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Registration Start Time cannot be greater than Departed Date/Time.");
		}
	}

	private void validateDischargeDate(List<String> uiErrors)
	{
		if(uiErrors == null)
			uiErrors = new ArrayList<String>();
		
		DateTime conclusionDateTime = form.dtimConclusion().getValue();
		DateTime dischargeDateTime = form.dtimDischarge().getValue();
		DateTime registrationDateTime = form.dtimRegistration().getValue();
		
		boolean foundField = false;
		
		if(form.dtimDischarge().isEnabled() && dischargeDateTime == null)
			uiErrors.add("Departed Date/Time is mandatory.");
		
		if(!foundField)
		{
			if (dischargeDateTime != null && registrationDateTime != null && !registrationDateTime.isLessOrEqualThan(dischargeDateTime))
			{
				uiErrors.add("Departed Date/Time must be set after Registration Start Time.");
				foundField = true;
			}
		}
		
		if(!foundField)
		{
			if (conclusionDateTime != null && dischargeDateTime != null && !conclusionDateTime.isLessOrEqualThan(dischargeDateTime))
			{
				uiErrors.add("Departed Date/Time must be set after Conclusion Date/Time.");
				foundField = true;
			}
		}
		
		if (dischargeDateTime != null && dischargeDateTime.isGreaterThan(new DateTime()))
			uiErrors.add("Departed Date/Time is in the future.");		
	}

	private TrackingForTimeAmendmentsVo populateDataFromScreen(TrackingForTimeAmendmentsVo trackingForTimeAmendmentsVo)
	{
		if(trackingForTimeAmendmentsVo == null )
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		if(trackingForTimeAmendmentsVo.getAttendance() != null)
		{
    		trackingForTimeAmendmentsVo.getAttendance().setArrivalDateTime(form.dtimArrival().getValue());
    		trackingForTimeAmendmentsVo.getAttendance().setRegistrationDateTime(form.dtimRegistration().getValue());
    		trackingForTimeAmendmentsVo.getAttendance().setEndOfRegistrationDateTime(form.dtimRegistrationEnd().getValue());
    		trackingForTimeAmendmentsVo.getAttendance().setDischargeDateTime(form.dtimDischarge().getValue());
    		trackingForTimeAmendmentsVo.getAttendance().setAmbulanceArrivalDateTime(form.dtimAmbulanceArrival().getValue());
    		//trackingForTimeAmendmentsVo.getAttendance().setExpectedArrivalDateTime(form.dtimExpectedArrival().getValue());
    		trackingForTimeAmendmentsVo.getAttendance().setConclusionDateTime(form.dtimConclusion().getValue());
		}
		
		if(trackingForTimeAmendmentsVo.getTriageDetails() != null)
		{
			trackingForTimeAmendmentsVo.getTriageDetails().setTriageStartDateTime(form.dtimTriage().getValue());
			trackingForTimeAmendmentsVo.getTriageDetails().setTriageCompletionTime(form.dtimTriageCompletion().getValue());
		}
		
		if(trackingForTimeAmendmentsVo.getEpisode() != null)
		{
			trackingForTimeAmendmentsVo.getEpisode().setInjuryDateTime(form.dtimIncident().getValue());
		}
		
		if(ConfigFlag.GEN.ED_DTA_ADMISSION_FUNCTIONALITY.getValue().equals(PENDING_ADMISSION))
		{
    		if(trackingForTimeAmendmentsVo.getAssociatedPendingEmergencyAdmission() != null)
    		{
    			trackingForTimeAmendmentsVo.getAssociatedPendingEmergencyAdmission().setDTADateTime(form.dtimDecisionToAdmit().getValue());
    		}
		}
		else if(ConfigFlag.GEN.ED_DTA_ADMISSION_FUNCTIONALITY.getValue().equals(PARTIAL_ADMISSION))
		{
			if(trackingForTimeAmendmentsVo.getCurrentPartialAdmission() != null)
    		{
    			trackingForTimeAmendmentsVo.getCurrentPartialAdmission().setDecisionToAdmitDateTime(form.dtimDecisionToAdmit().getValue());
    		}
		}
		
		return trackingForTimeAmendmentsVo;
	}
}
