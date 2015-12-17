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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.20 build 40811.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.forms.patientarrival;

import ims.alerts.PatientAlertCCO;
import ims.ccosched.Helper.PatientShortHelper;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.PatientFilter;
import ims.core.vo.PatientId;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.dto.Result;
import ims.dto.client.Patient;
import ims.dto.client.Sd_appt_dts;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.DateTime;
import ims.framework.utils.PartialDate;
import ims.framework.utils.Time;
import ims.framework.utils.TimeFormat;

import java.text.ParseException;

public class Logic extends BaseLogic
{
	private final String NEW_LINE = "<br>";
	
	protected void onAllAppointmentsValueChanged()	throws PresentationLogicException
	{
		clearPIDAndPatient();
		
		int curSel = form.AppointmentsGrid().getSelectedRowIndex();

		//If Apply to all appointments is checked then enable Arrival button if appropriate
		if(form.AllAppointments().getValue())
		{
			if(curSel >= 0 && RecordsToBeArrived())
				form.Arrival().setEnabled(true); 
		}
		else
		{	//disable arrival button
			if(curSel >= 0 && RecordsNotToBeArrived(curSel))
				form.Arrival().setEnabled(false); 
		}
	}
	
	private void clearPIDAndPatient()
	{
		engine.clearAlertsByType(PatientAlertCCO.class);
		form.getGlobalContext().Core.setPatientShort(null);
	}
	
	private boolean RecordsNotToBeArrived(int curSel)
	{
		if(form.AppointmentsGrid().getRows().get(curSel).getValue().Appt_stat.equals("-2190") || //Cancel reallocate
				form.AppointmentsGrid().getRows().get(curSel).getValue().Appt_stat.equals("-2193"))	 //Cancel no reallocate
					return true;

		return false;
	}
	protected void onAppointmentsGridSelectionChanged()	throws PresentationLogicException
	{
		Sd_appt_dts.Sd_appt_dtsRecord apptRecord = form.AppointmentsGrid().getValue();
		form.getGlobalContext().CcoSched.ClinicView.setBookingComment(apptRecord.Appt_cmts);
		form.getGlobalContext().CcoSched.ClinicView.setAppointmentHeaderID(apptRecord.Appt_head_id);
		form.getGlobalContext().CcoSched.ClinicView.setAppointmentID(apptRecord.Appt_id);
		form.getLocalContext().setPatientArrivalStatus(apptRecord.Appt_stat);
		
		//25/02/2005 - If the record has appt status = -2199 then disable the buttons
		if(apptRecord.Appt_stat.equals("-2199"))
			EnableButtons(false);
		else
			EnableButtons(true);
		//05/06/2003
		DisplayArrivalDetails();
	}
	private void DisplayArrivalDetails()
	{
        form.Comment().setValue(form.getGlobalContext().CcoSched.ClinicView.getBookingComment());
		
		//10/06/2003 - Do a Get in Sd_appt_dtsDTO (instead of sd_appt)
		Sd_appt_dts appts = null;
		try
		{
			appts = domain.getArrivalDetails(form.getGlobalContext().CcoSched.ClinicView.getAppointmentHeaderID(), form.getGlobalContext().CcoSched.ClinicView.getAppointmentID());
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		
		form.getLocalContext().setappt_dts(appts);
		
		EnableArrivalControls(true);
		//If Unarrival was pressed don't default the Time to now.
		boolean defaultTime = (form.getLocalContext().getUnArrival() != null && form.getLocalContext().getUnArrival() == Boolean.TRUE) ? false : true;
		
		if(appts.DataCollection.count()  > 0)
		{
			Time arrivalTime = getTimeFromString(appts.DataCollection.get(0).Arr_tme);
			
			if(arrivalTime != null)
				form.Time().setEnabled(false);
			
			DateTime dateTime = domain.getDateTime();
			Time now = new Time(dateTime.getTime().getHour(), dateTime.getTime().getMinute(), dateTime.getTime().getSecond());
			if(defaultTime)
				form.Time().setValue(arrivalTime == null ? now : arrivalTime);
			else
				form.Time().setValue(null);

			this.setActionLookupValue(getIntFromString(appts.DataCollection.get(0).Att_stat));
		}

		form.getLocalContext().setUnArrival(Boolean.FALSE);
	}
	protected void onArrivalClick() throws PresentationLogicException
	{
		if(form.Time().getValue() == null)
		{
			engine.showMessage("Please select a time.");
			return;
		}

		if(form.Action().getValue() == null)
		{
			engine.showMessage("Please select a Location.");
			return;
		}

		//Update all the records - apply to all appointments
		//except Cancelled reallocate, Cancel not Reallocate & Arrived
		if(form.AllAppointments().getValue())
		{
			for(int i=0; i<form.AppointmentsGrid().getRows().size(); i++)
			{
				//12/06/2003 - Allow only
				if(form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2189") || //Open
						form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2194") || //Rebooked
						form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2195") || //Moved
						form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2197"))   //Cancel Died
				{
					
					Sd_appt_dts appts = null;
					try
					{
						appts = domain.getArrivalDetails(form.AppointmentsGrid().getRows().get(i).getValue().Appt_head_id, form.AppointmentsGrid().getRows().get(i).getValue().Appt_id);
					}
					catch (DomainInterfaceException e)
					{
						engine.showMessage(e.getMessage());
						return;
					}
					
					try
					{
						appts = domain.getForUpdateArrivalDetails(appts);
					}
					catch (StaleObjectException e)
					{
						engine.showMessage(e.getMessage());
						return;
					}

					appts.DataCollection.get(0).Arr_tme = form.Time().getValue().toString(TimeFormat.FLAT6);
					appts.DataCollection.get(0).Att_stat = form.Action().getValue() != null?Integer.toString(form.Action().getValue().getID()):"";
					//appts.Sd_appt_dtsCollection[0].attHcp_booking1 = Context.UserID;
					appts.DataCollection.get(0).Appt_stat = "-2196"; // Arrived
					//19/01/2005 - Inpatient logic
					appts.DataCollection.get(0).Appinpatstat = isInpatient(appts.DataCollection.get(0).Ploc)?"Y":"N";
					//----------------------------
					try
					{
						appts = domain.updateArrivalDetails(appts);
					}
					catch (DomainInterfaceException e)
					{
						engine.showMessage(e.getMessage());
						return;
					}
				}
			}

			getAppointments(form.DateSelected().getValue());
			form.getLocalContext().setUnArrival(Boolean.FALSE);
		}
		else
		{
			//10/06/2003 - Update the Sd_appt_dtsDTO
			if(form.getLocalContext().getappt_dts() != null)
			{
				Sd_appt_dts appts = form.getLocalContext().getappt_dts();
								
				Result result = appts.getForUpdate();
				if (result != null)
				{
					engine.showMessage(result.getMessage());
					return;
				}
				
				appts.DataCollection.get(0).Arr_tme = form.Time().getValue().toString(TimeFormat.FLAT6);
				appts.DataCollection.get(0).Att_stat = form.Action().getValue() != null?Integer.toString(form.Action().getValue().getID()):"";
				//appts.Sd_appt_dtsCollection[0].attHcp_booking1 = Context.UserID;
				appts.DataCollection.get(0).Appt_stat = "-2196"; // Arrived
				//19/01/2005 - Inpatient logic
				appts.DataCollection.get(0).Appinpatstat = isInpatient(appts.DataCollection.get(0).Ploc)?"Y":"N";
				//----------------------------
				result = appts.update();
				if (result != null)
				{
					engine.showMessage(result.getMessage());
					return;
				}

				getAppointments(form.DateSelected().getValue());
				form.getLocalContext().setUnArrival(Boolean.FALSE);
			}
		}
	}
	protected void onClearFieldsClick() throws PresentationLogicException
	{
		form.getGlobalContext().Core.setPatientShort(null);

		form.Surname().setValue("");
		form.Name().setValue("");
		form.HospitalNumber().setValue("");
		form.DOB().setValue(null);			
		form.PatientsGrid().getRows().clear();
		form.AppointmentsGrid().getRows().clear();
		form.Time().setValue(null);
		this.setActionLookupValue(-1);
		form.Comment().setValue("");
		form.AllAppointments().setValue(false);

		form.LeftDate().setEnabled(false);
		form.RightDate().setEnabled(false);
		form.Date().setValue(null);
		EnableArrivalControls(false);
		EnableButtons(false);
		
		form.Action().setValue(null);//WDEV-16946
		form.DateSelected().setValue(form.Date().getValue() == null ? null : new Date(form.Date().getValue()));
	}
	protected void onDateValueChanged() throws PresentationLogicException
	{
		if (form.Date().getValue() != null)
			form.DateSelected().setValue(form.Date().getValue());

		if (form.Date().getValue()!=null)  //WDEV-15524
		{
			form.getLocalContext().setPatientArrivalDate(form.Date().getValue().toString(DateFormat.ISO));
		}
		
		if(form.PatientsGrid().getSelectedRowIndex() >= 0)
			onPatientsGridSelectionChanged();
	}
	protected void onFormDialogClosed(FormName formName, DialogResult result)	throws PresentationLogicException
	{
		EnableButtons(false);
		getAppointments(form.DateSelected().getValue());
	}
	private void getAppointments(Date date) throws PresentationLogicException
	{
		form.AppointmentsGrid().getRows().clear();	
		EnableArrivalControls(false);
		//Clear the arrival controls
		ClearArrivalControls();

		if(date == null)
			return;

		String pkey = getPkey();
			
		Sd_appt_dts appDetails;
		try
		{
			appDetails = domain.listAppointmentDetails(pkey, date.toString(DateFormat.ISO));
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		
		Result result = appDetails.list();
		if (result != null)
		{
			engine.showMessage(result.getMessage());
			return;
		}
		
		for (int i = 0; i < appDetails.DataCollection.count(); ++i)
		{
			GenForm.AppointmentsGridRow row = form.AppointmentsGrid().getRows().newRow();
			
			if (appDetails.DataCollection.get(i).First_appt_id == appDetails.DataCollection.get(i).Appt_id)
				row.setBooking(form.getImages().CcoSched.First);
			else if (appDetails.DataCollection.get(i).Last_appt_id == appDetails.DataCollection.get(i).Appt_id)
				row.setBooking(form.getImages().CcoSched.Last);
			Time dt = getTimeFromString(appDetails.DataCollection.get(i).Stm);
			row.setAppointmentTime(dt == null ? "" : dt.toString());
			row.setClinicName(appDetails.DataCollection.get(i).Prfile_sess_idtxt);
			row.setConsultant(appDetails.DataCollection.get(i).Act_consulttxt);
			row.setStatus(appDetails.DataCollection.get(i).Appt_stattxt);

			row.setValue(appDetails.DataCollection.get(i));
		}

		int nCount = form.AppointmentsGrid().getRows().size();
		if (nCount == 0)
			engine.showMessage("No records.");			

		//05/06/2003 - Kevin's improvement - select the first record (or the previous selected one)
		if(nCount > 0)
		{
			form.AppointmentsGrid().setValue(form.AppointmentsGrid().getRows().get(GetPrevSelIndex()).getValue());

			if(form.AppointmentsGrid().getSelectedRowIndex() >= 0)
				onAppointmentsGridSelectionChanged();
			
			//If only one record - disable
			if(nCount == 1)
				form.AllAppointments().setEnabled(false);
		}
	}
	
	private String getPkey()
	{	
		if (form.PatientsGrid().getValue() != null)
			return (form.PatientsGrid().getValue().getPatId(PatIdType.PKEY) != null && form.PatientsGrid().getValue().getPatId(PatIdType.PKEY).getValue() != null) ? form.PatientsGrid().getValue().getPatId(PatIdType.PKEY).getValue().toString() : null;

		//Pkey
		if (form.getGlobalContext().Core.getPatientShortIsNotNull()
			&& form.getGlobalContext().Core.getPatientShort().getPkey() != null)
			return form.getGlobalContext().Core.getPatientShort().getPkey().getValue();
		
		return null;
	}
	
	private int GetPrevSelIndex()
	{
		if(form.getGlobalContext().CcoSched.ClinicView.getAppointmentHeaderID() != null)
		{
			for(int x=0; x<form.AppointmentsGrid().getRows().size(); x++)
			{
				if(form.AppointmentsGrid().getRows().get(x).getValue().Appt_head_id.equals(form.getGlobalContext().CcoSched.ClinicView.getAppointmentHeaderID()))
					return x;
			}
		}

		return 0;
	}
	private void ClearArrivalControls()
	{
		form.Time().setValue(null);
		this.setActionLookupValue(-1);
		form.Comment().setValue("");
		form.AllAppointments().setValue(false);
		form.Action().setValue(null);//WDEV-16946
	}
	protected void onFormOpen() throws FormOpenException
	{
		form.Date().setValue(new Date());
		if (form.PatientsGrid().getSelectedRowIndex() < 0)
		{
			form.LeftDate().setEnabled(false);
			form.RightDate().setEnabled(false);
		}
		if (form.AppointmentsGrid().getSelectedRowIndex() < 0)
		{
			EnableButtons(false);
		}

		
		if(form.AppointmentsGrid().getRows().size() == 0)
			EnableArrivalControls(false);

		if(form.Date().getValue() != null)
			form.getLocalContext().setPatientArrivalDate(form.Date().getValue().toString(DateFormat.ISO));
		
		form.Surname().setFocus();
	}
	private void EnableArrivalControls(boolean bEnable)
	{
		form.Time().setEnabled(bEnable);
		form.Action().setEnabled(bEnable);
		form.AllAppointments().setEnabled(bEnable); 
	}
	
	private boolean EnableButtons(boolean flag)
	{
		boolean arrivalEnabled = false;
		if (flag == true)
		{
			if (form.getLocalContext().getPatientArrivalStatus() == null)
			{
				form.Arrival().setEnabled(true);
				form.UnArrival().setEnabled(false);
				arrivalEnabled = true;
			}
			else if (form.getLocalContext().getPatientArrivalStatus().equals("-2191")) // DNA
			{
				form.Arrival().setEnabled(false);
				form.UnArrival().setEnabled(false);
			}
			else if (form.getLocalContext().getPatientArrivalStatus().equals("-2190") || // Cancelled
					form.getLocalContext().getPatientArrivalStatus().equals("-2193")) 
			{
				form.Arrival().setEnabled(false);
				form.UnArrival().setEnabled(false);
			}
			else if (form.getLocalContext().getPatientArrivalStatus().equals("-2192")) //Attended
			{
				form.Arrival().setEnabled(false);
				form.UnArrival().setEnabled(false);
			}
			else if (form.getLocalContext().getPatientArrivalStatus().equals("-2195")) //Moved
			{
				form.Arrival().setEnabled(true);
				form.UnArrival().setEnabled(false);
				arrivalEnabled = true;
			}
			else if (form.getLocalContext().getPatientArrivalStatus().equals("-2194")) //Rebooked
			{
				form.Arrival().setEnabled(true);
				form.UnArrival().setEnabled(false);
				arrivalEnabled = true;
			}
			else if (form.getLocalContext().getPatientArrivalStatus().equals("-2196")) //Arrived
			{
				form.Arrival().setEnabled(false);
				form.UnArrival().setEnabled(true);
			}
			else
			{
				form.Arrival().setEnabled(true);
				form.UnArrival().setEnabled(false);
				arrivalEnabled = true;
			}

			Date today = domain.getDateTime().getDate();
			//Date date  = new Date(form.DateSelected().getValue());				
			if(form.DateSelected().getValue().isGreaterThan(today))
				form.Arrival().setEnabled(false);

			//Kevin's Requirement - Arrival button always open
			//18/08/2003 - Don't arrive 'Cancelled Appointment'
			if(form.getLocalContext().getPatientArrivalStatus().equals("-2190") || //Cancel reallocate
					form.getLocalContext().getPatientArrivalStatus().equals("-2193"))   //Cancel no reallocate
			{
				if(form.AllAppointments().getValue())
				{
					if(form.AppointmentsGrid().getSelectedRowIndex() >= 0 && RecordsToBeArrived())
						form.Arrival().setEnabled(true); 
					else
						form.Arrival().setEnabled(false); 
				}
				else
					form.Arrival().setEnabled(false);
			}
			else
				form.Arrival().setEnabled(true);
		}
		else
		{
			form.Arrival().setEnabled(false);
			form.UnArrival().setEnabled(false);
		}

		return arrivalEnabled;
	}
	private boolean RecordsToBeArrived()
	{
		for(int i=0; i<form.AppointmentsGrid().getRows().size(); i++)
		{
			if(form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2189") || //Open
			form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2194") || //Rebooked
			form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2195") || //Moved
			form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2197"))   //Cancel Died
				return true;
		}

		return false;
	}
	protected void onLeftDateClick() throws PresentationLogicException
	{
		if (form.Date().getValue() != null)
		{
			Date date = null;
			if (form.getLocalContext().getPatientArrivalDateIsNotNull() && form.getLocalContext().getPatientArrivalDate().equals("") == false)
			{
				try
				{
					date = new Date(form.getLocalContext().getPatientArrivalDate(), DateFormat.ISO);
				} catch (ParseException e)
				{
					e.printStackTrace();
				}
			}
			date.addDay(-1);
			EnableButtons(false);
			getAppointments(date);

			form.DateSelected().setValue(date);
			form.getLocalContext().setPatientArrivalDate(date.toString(DateFormat.ISO));
		}
	}
	protected void onPatientsGridSelectionChanged()	throws PresentationLogicException
	{
		form.getGlobalContext().CcoSched.PatientSearch.setAlive(Boolean.TRUE);

		form.AppointmentsGrid().getRows().clear();
		form.LeftDate().setEnabled(true);
		form.RightDate().setEnabled(true);
		form.DateSelected().setValue(form.Date().getValue() == null ? null : new Date(form.Date().getValue()));
		EnableButtons(false);
		getAppointments(form.Date().getValue());
//		setPatientIntoContext(form.PatientsGrid().getValue());
		form.getGlobalContext().Core.setPatientShort(form.PatientsGrid().getValue());

		setPIDTooltip();
	}
	
	private void setPIDTooltip()
	{
		engine.clearAlertsByType(ims.alerts.PatientAlertCCO.class);
		engine.addAlert(new ims.alerts.PatientAlertCCO(new ims.ccosched.Helper.PIDTooltip().getTooltip(form.getGlobalContext().Core.getPatientShort(), null, null)));
	}
	private void setPatientIntoContext(Patient.PatientRecord patient)
	{
		PatientShort patientShort = new PatientShortHelper().getPatientShort(patient);
		
		ims.core.vo.Patient voPatient = null;

		if(patientShort != null)
		{
			try
			{
				voPatient = domain.getPatient(patientShort);
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(e.getMessage());
			}
			catch (DomainInterfaceException exc)
			{
				engine.showMessage(exc.getMessage());
			}
		}
		
		form.getGlobalContext().Core.setPatientShort(voPatient);
	}
	protected void onRightDateClick() throws PresentationLogicException
	{
		if (form.Date().getValue() != null)
		{
			Date date = null;
			try
			{
				date = new Date(form.getLocalContext().getPatientArrivalDate(), DateFormat.ISO);
			} catch (ParseException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
			date.addDay(1);
			EnableButtons(false);
			getAppointments(date);

			form.DateSelected().setValue(date);
			form.getLocalContext().setPatientArrivalDate(date.toString(DateFormat.ISO));
		}
	}
	protected void onSearchClick() throws PresentationLogicException
	{
		form.PatientsGrid().getRows().clear();
		form.AppointmentsGrid().getRows().clear();			
		form.LeftDate().setEnabled(false);
		form.RightDate().setEnabled(false);
		form.DateSelected().setValue(form.Date().getValue());

		ClearArrivalControls();
		EnableButtons(false);
		EnableArrivalControls(false);

		PatientShortCollection voPatients = null;

		String surname = form.Surname().getValue();
		String forname = form.Name().getValue();
		String hospNum = form.HospitalNumber().getValue();

		Date dob = form.DOB().getValue();
		if((surname == null || surname.length() == 0) && 
		   (forname == null || forname.length() == 0) &&
		   (hospNum == null || hospNum.length() == 0) && 
		   (dob == null))
		{
			engine.showMessage("Please enter a partial Surname, Name, \nHospital number OR a Date of birth and Search again.");
			return;
		}

		//08/04/2003 - Do a Get when Hospital Number provided - ignore the rest
		if (hospNum != null && hospNum.length() > 0)
		{
			//Clear the Patient name, surname, dob
			form.Surname().setValue("");
			form.Name().setValue("");
			form.DOB().setValue(null);
		}			

		try
		{
			PatientFilter voFilter = new PatientFilter();
				
			voFilter.setSurname(surname != null?surname.toUpperCase():null);
			voFilter.setForename(forname != null?forname.toUpperCase():null);
			voFilter.setDob(dob != null? new PartialDate(dob.toString(DateFormat.ISO)) : null);
				
			PatientId pid = new PatientId();
			pid.setType(PatIdType.HOSPNUM);	
			pid.setValue(form.HospitalNumber().getValue());			
			voFilter.setPersId(pid);
				
			voPatients = domain.listPatients(voFilter);
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}

		if(voPatients.size() == 0)
		{
			engine.showMessage("There is no patient matching this search criteria.");
			return;
		}

		for (int i = 0; i < voPatients.size(); ++i)
			addPatientRow(voPatients.get(i));
	}
	
	private void addPatientRow(PatientShort voPat)
	{
		if (voPat == null)
			return;
		
		GenForm.PatientsGridRow row = form.PatientsGrid().getRows().newRow();
		row.setValue(voPat);
		
		row.setSurname(voPat.getNameIsNotNull() ? voPat.getName().getSurname() : "");
		row.setTooltipForSurname(voPat.getNameIsNotNull() ? voPat.getName().getSurname() : "");
		row.setName(voPat.getNameIsNotNull() ? voPat.getName().getForename() : "");
		row.setTooltipForName(voPat.getNameIsNotNull() ? voPat.getName().getForename() : "");
		row.setHospitalNumber(voPat.getDisplayId() != null ? voPat.getDisplayId().getValue() : "");				
		row.setDOB(voPat.getDobIsNotNull() ? voPat.getDob().toString(DateFormat.STANDARD) : "");

		if (voPat.getIsDead().booleanValue())
			row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());			

		//WDEV-14440
		if (voPat.getAddress()!=null)
			row.setTooltip("<b>"+ "Address: " + "</b>" + NEW_LINE  + voPat.getAddress().toDisplayString());
	}

	protected void onUnArrivalClick() throws PresentationLogicException
	{
		//Apply to all appointments
		if(form.AllAppointments().getValue())
		{
			for(int i=0; i<form.AppointmentsGrid().getRows().size(); i++)
			{
				//Apply to arrived only
				if(form.AppointmentsGrid().getRows().get(i).getValue().Appt_stat.equals("-2196"))
				{
					//10/06/2003 - Update the Sd_appt_dtsDTO
					Sd_appt_dts appts;
					try
					{
						appts = domain.getArrivalDetails(form.AppointmentsGrid().getRows().get(i).getValue().Appt_head_id, form.AppointmentsGrid().getRows().get(i).getValue().Appt_id);
					}
					catch (DomainInterfaceException e)
					{
						engine.showMessage(e.getMessage());
						return;
					}
					
					try
					{
						appts = domain.getForUpdateArrivalDetails(appts);
					}
					catch (StaleObjectException e)
					{
						engine.showMessage(e.getMessage());
						return;
					}
			
					appts.DataCollection.get(0).Arr_tme = "";
					appts.DataCollection.get(0).Att_stat = "";
					appts.DataCollection.get(0).Appt_stat = "-2189";
					//appts.Sd_appt_apdtsCollection[0].attHcp_booking1 = Context.UserID;
					//20/01/2005 - Clear Inpatient value if Appt_stat = "-2189";
					appts.DataCollection.get(0).Appinpatstat = null;

					try
					{
						domain.updateArrivalDetails(appts);
					}
					catch (DomainInterfaceException e)
					{
						engine.showMessage(e.getMessage());
						return;
					}

					form.getLocalContext().setUnArrival(Boolean.TRUE);
				}
			}

			getAppointments(form.DateSelected().getValue());
			form.getLocalContext().setUnArrival(Boolean.FALSE);
		}
		else
		{
			//10/06/2003 - Update the Sd_appt_dtsDTO
			if(form.getLocalContext().getappt_dts() != null)
			{
				Sd_appt_dts appts = form.getLocalContext().getappt_dts();
			
				Result result = appts.getForUpdate();
				if (result != null)
				{
					engine.showMessage(result.getMessage());
					return;
				}
				
				appts.DataCollection.get(0).Arr_tme = "";
				appts.DataCollection.get(0).Att_stat = "";
				appts.DataCollection.get(0).Appt_stat = "-2189";
				//appts.Sd_appt_apdtsCollection[0].attHcp_booking1 = Context.UserID;
				//20/01/2005 - Clear Inapatient value if Appt_stat = "-2189";
				appts.DataCollection.get(0).Appinpatstat = null;

				result = appts.update();
				if (result != null)
				{
					engine.showMessage(result.getMessage());
					return;
				}

				form.getLocalContext().setUnArrival(Boolean.TRUE);
				// Refresh
				EnableButtons(false);
				getAppointments(form.DateSelected().getValue());
			}
		}
	}
	
	private boolean isInpatient(String Ploc)
	{
		Integer ploc = GetInteger(Ploc);
		if(ploc == null || ploc.intValue() == 0)
			return false;

        return true;
	}
	private Integer GetInteger(String val)
	{
		Integer newVal = null;
		if(val != null && !val.equals(""))
		{
			try{newVal = Integer.valueOf(val);}
			catch(NumberFormatException e)
			{engine.showMessage(e.getMessage());}
		}

		return newVal;	
	}
	private int getIntFromString(String val)
	{
		Integer intVal = GetInteger(val);
		return intVal != null?intVal.intValue():-1;
	}
	
	private Time getTimeFromString(String time)
	{
		try
		{
			return new Time(time, TimeFormat.FLAT6);
		}
		catch (Exception e)
		{
			return null;
		}
	}
}