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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.emergency.vo;

/**
 * Linked to emergency.Tracking business object (ID: 1086100005).
 */
public class TrackingForTimeAmendmentsVo extends ims.emergency.vo.TrackingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingForTimeAmendmentsVo()
	{
	}
	public TrackingForTimeAmendmentsVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingForTimeAmendmentsVo(ims.emergency.vo.beans.TrackingForTimeAmendmentsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : new ims.emergency.vo.TrackingAttendanceStatusRefVo(new Integer(bean.getCurrentStatus().getId()), bean.getCurrentStatus().getVersion());
		this.triagedetails = bean.getTriageDetails() == null ? null : bean.getTriageDetails().buildVo();
		this.episode = bean.getEpisode() == null ? null : bean.getEpisode().buildVo();
		this.associatedpendingemergencyadmission = bean.getAssociatedPendingEmergencyAdmission() == null ? null : bean.getAssociatedPendingEmergencyAdmission().buildVo();
		this.currentpartialadmission = bean.getCurrentPartialAdmission() == null ? null : bean.getCurrentPartialAdmission().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingForTimeAmendmentsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : new ims.emergency.vo.TrackingAttendanceStatusRefVo(new Integer(bean.getCurrentStatus().getId()), bean.getCurrentStatus().getVersion());
		this.triagedetails = bean.getTriageDetails() == null ? null : bean.getTriageDetails().buildVo(map);
		this.episode = bean.getEpisode() == null ? null : bean.getEpisode().buildVo(map);
		this.associatedpendingemergencyadmission = bean.getAssociatedPendingEmergencyAdmission() == null ? null : bean.getAssociatedPendingEmergencyAdmission().buildVo(map);
		this.currentpartialadmission = bean.getCurrentPartialAdmission() == null ? null : bean.getCurrentPartialAdmission().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingForTimeAmendmentsVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingForTimeAmendmentsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingForTimeAmendmentsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("TRIAGEDETAILS"))
			return getTriageDetails();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ASSOCIATEDPENDINGEMERGENCYADMISSION"))
			return getAssociatedPendingEmergencyAdmission();
		if(fieldName.equals("CURRENTPARTIALADMISSION"))
			return getCurrentPartialAdmission();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.emergency.vo.EmergencyAttendanceForTimeAmendmentsVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.EmergencyAttendanceForTimeAmendmentsVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.emergency.vo.TrackingAttendanceStatusRefVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.TrackingAttendanceStatusRefVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getTriageDetailsIsNotNull()
	{
		return this.triagedetails != null;
	}
	public ims.emergency.vo.TriageForTimeAmendmentsVo getTriageDetails()
	{
		return this.triagedetails;
	}
	public void setTriageDetails(ims.emergency.vo.TriageForTimeAmendmentsVo value)
	{
		this.isValidated = false;
		this.triagedetails = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.emergency.vo.EmergencyEpisodeForTimeAmendmentsVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.EmergencyEpisodeForTimeAmendmentsVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAssociatedPendingEmergencyAdmissionIsNotNull()
	{
		return this.associatedpendingemergencyadmission != null;
	}
	public ims.emergency.vo.PendingEmergencyAdmissionForTimeAmendsVo getAssociatedPendingEmergencyAdmission()
	{
		return this.associatedpendingemergencyadmission;
	}
	public void setAssociatedPendingEmergencyAdmission(ims.emergency.vo.PendingEmergencyAdmissionForTimeAmendsVo value)
	{
		this.isValidated = false;
		this.associatedpendingemergencyadmission = value;
	}
	public boolean getCurrentPartialAdmissionIsNotNull()
	{
		return this.currentpartialadmission != null;
	}
	public ims.emergency.vo.EDPartianAdmissionForTimeAmendsVo getCurrentPartialAdmission()
	{
		return this.currentpartialadmission;
	}
	public void setCurrentPartialAdmission(ims.emergency.vo.EDPartianAdmissionForTimeAmendsVo value)
	{
		this.isValidated = false;
		this.currentpartialadmission = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.attendance != null)
		{
			if(!this.attendance.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.triagedetails != null)
		{
			if(!this.triagedetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.episode != null)
		{
			if(!this.episode.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.associatedpendingemergencyadmission != null)
		{
			if(!this.associatedpendingemergencyadmission.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentpartialadmission != null)
		{
			if(!this.currentpartialadmission.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.attendance != null)
		{
			String[] listOfOtherErrors = this.attendance.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.triagedetails != null)
		{
			String[] listOfOtherErrors = this.triagedetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.episode != null)
		{
			String[] listOfOtherErrors = this.episode.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.associatedpendingemergencyadmission != null)
		{
			String[] listOfOtherErrors = this.associatedpendingemergencyadmission.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentpartialadmission != null)
		{
			String[] listOfOtherErrors = this.currentpartialadmission.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		TrackingForTimeAmendmentsVo clone = new TrackingForTimeAmendmentsVo(this.id, this.version);
		
		if(this.attendance == null)
			clone.attendance = null;
		else
			clone.attendance = (ims.emergency.vo.EmergencyAttendanceForTimeAmendmentsVo)this.attendance.clone();
		clone.currentstatus = this.currentstatus;
		if(this.triagedetails == null)
			clone.triagedetails = null;
		else
			clone.triagedetails = (ims.emergency.vo.TriageForTimeAmendmentsVo)this.triagedetails.clone();
		if(this.episode == null)
			clone.episode = null;
		else
			clone.episode = (ims.emergency.vo.EmergencyEpisodeForTimeAmendmentsVo)this.episode.clone();
		if(this.associatedpendingemergencyadmission == null)
			clone.associatedpendingemergencyadmission = null;
		else
			clone.associatedpendingemergencyadmission = (ims.emergency.vo.PendingEmergencyAdmissionForTimeAmendsVo)this.associatedpendingemergencyadmission.clone();
		if(this.currentpartialadmission == null)
			clone.currentpartialadmission = null;
		else
			clone.currentpartialadmission = (ims.emergency.vo.EDPartianAdmissionForTimeAmendsVo)this.currentpartialadmission.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(TrackingForTimeAmendmentsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingForTimeAmendmentsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingForTimeAmendmentsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingForTimeAmendmentsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.attendance != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.triagedetails != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.associatedpendingemergencyadmission != null)
			count++;
		if(this.currentpartialadmission != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.emergency.vo.EmergencyAttendanceForTimeAmendmentsVo attendance;
	protected ims.emergency.vo.TrackingAttendanceStatusRefVo currentstatus;
	protected ims.emergency.vo.TriageForTimeAmendmentsVo triagedetails;
	protected ims.emergency.vo.EmergencyEpisodeForTimeAmendmentsVo episode;
	protected ims.emergency.vo.PendingEmergencyAdmissionForTimeAmendsVo associatedpendingemergencyadmission;
	protected ims.emergency.vo.EDPartianAdmissionForTimeAmendsVo currentpartialadmission;
	private boolean isValidated = false;
	private boolean isBusy = false;
}