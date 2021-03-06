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

package ims.dtomove.vo;

/**
 * Linked to dto_move.Dummy business object (ID: 1105100015).
 */
public class DummyVo extends ims.dto_move.vo.DummyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DummyVo()
	{
	}
	public DummyVo(Integer id, int version)
	{
		super(id, version);
	}
	public DummyVo(ims.dtomove.vo.beans.DummyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.active = bean.getActive();
		this.priority = bean.getPriority() == null ? null : ims.ccosched.vo.lookups.Priority.buildLookup(bean.getPriority());
		this.specialtycode = bean.getSpecialtyCode() == null ? null : ims.dtomove.vo.lookups.SpecialtyCode.buildLookup(bean.getSpecialtyCode());
		this.servicetype = bean.getServiceType() == null ? null : ims.dtomove.vo.lookups.ActionReason.buildLookup(bean.getServiceType());
		this.contractlocation = bean.getContractLocation() == null ? null : ims.dtomove.vo.lookups.ContractLocation.buildLookup(bean.getContractLocation());
		this.cancelreason = bean.getCancelReason() == null ? null : ims.dtomove.vo.lookups.ApptCancelledReason.buildLookup(bean.getCancelReason());
		this.apptstatus = bean.getApptStatus() == null ? null : ims.ccosched.vo.lookups.AppointmentStatus.buildLookup(bean.getApptStatus());
		this.treatmentcategory = bean.getTreatmentCategory() == null ? null : ims.ccosched.vo.lookups.SchedCategory.buildLookup(bean.getTreatmentCategory());
		this.dnareason = bean.getDNAReason() == null ? null : ims.ccosched.vo.lookups.ReasonDNA.buildLookup(bean.getDNAReason());
		this.machinetype = bean.getMachineType() == null ? null : ims.dtomove.vo.lookups.MachineTypes.buildLookup(bean.getMachineType());
		this.scheduletype = bean.getScheduleType() == null ? null : ims.dtomove.vo.lookups.SchedulingType.buildLookup(bean.getScheduleType());
		this.schedulecategory = bean.getScheduleCategory() == null ? null : ims.dtomove.vo.lookups.SchedulingCategory.buildLookup(bean.getScheduleCategory());
		this.intervaltype = bean.getIntervalType() == null ? null : ims.dtomove.vo.lookups.IntervalType.buildLookup(bean.getIntervalType());
		this.locationchar = bean.getLocationChar() == null ? null : ims.dtomove.vo.lookups.LocationCharacteristics.buildLookup(bean.getLocationChar());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.dtomove.vo.beans.DummyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.active = bean.getActive();
		this.priority = bean.getPriority() == null ? null : ims.ccosched.vo.lookups.Priority.buildLookup(bean.getPriority());
		this.specialtycode = bean.getSpecialtyCode() == null ? null : ims.dtomove.vo.lookups.SpecialtyCode.buildLookup(bean.getSpecialtyCode());
		this.servicetype = bean.getServiceType() == null ? null : ims.dtomove.vo.lookups.ActionReason.buildLookup(bean.getServiceType());
		this.contractlocation = bean.getContractLocation() == null ? null : ims.dtomove.vo.lookups.ContractLocation.buildLookup(bean.getContractLocation());
		this.cancelreason = bean.getCancelReason() == null ? null : ims.dtomove.vo.lookups.ApptCancelledReason.buildLookup(bean.getCancelReason());
		this.apptstatus = bean.getApptStatus() == null ? null : ims.ccosched.vo.lookups.AppointmentStatus.buildLookup(bean.getApptStatus());
		this.treatmentcategory = bean.getTreatmentCategory() == null ? null : ims.ccosched.vo.lookups.SchedCategory.buildLookup(bean.getTreatmentCategory());
		this.dnareason = bean.getDNAReason() == null ? null : ims.ccosched.vo.lookups.ReasonDNA.buildLookup(bean.getDNAReason());
		this.machinetype = bean.getMachineType() == null ? null : ims.dtomove.vo.lookups.MachineTypes.buildLookup(bean.getMachineType());
		this.scheduletype = bean.getScheduleType() == null ? null : ims.dtomove.vo.lookups.SchedulingType.buildLookup(bean.getScheduleType());
		this.schedulecategory = bean.getScheduleCategory() == null ? null : ims.dtomove.vo.lookups.SchedulingCategory.buildLookup(bean.getScheduleCategory());
		this.intervaltype = bean.getIntervalType() == null ? null : ims.dtomove.vo.lookups.IntervalType.buildLookup(bean.getIntervalType());
		this.locationchar = bean.getLocationChar() == null ? null : ims.dtomove.vo.lookups.LocationCharacteristics.buildLookup(bean.getLocationChar());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.dtomove.vo.beans.DummyVoBean bean = null;
		if(map != null)
			bean = (ims.dtomove.vo.beans.DummyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.dtomove.vo.beans.DummyVoBean();
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
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("SPECIALTYCODE"))
			return getSpecialtyCode();
		if(fieldName.equals("SERVICETYPE"))
			return getServiceType();
		if(fieldName.equals("CONTRACTLOCATION"))
			return getContractLocation();
		if(fieldName.equals("CANCELREASON"))
			return getCancelReason();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		if(fieldName.equals("TREATMENTCATEGORY"))
			return getTreatmentCategory();
		if(fieldName.equals("DNAREASON"))
			return getDNAReason();
		if(fieldName.equals("MACHINETYPE"))
			return getMachineType();
		if(fieldName.equals("SCHEDULETYPE"))
			return getScheduleType();
		if(fieldName.equals("SCHEDULECATEGORY"))
			return getScheduleCategory();
		if(fieldName.equals("INTERVALTYPE"))
			return getIntervalType();
		if(fieldName.equals("LOCATIONCHAR"))
			return getLocationChar();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public String getActive()
	{
		return this.active;
	}
	public static int getActiveMaxLength()
	{
		return 1;
	}
	public void setActive(String value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.ccosched.vo.lookups.Priority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.ccosched.vo.lookups.Priority value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getSpecialtyCodeIsNotNull()
	{
		return this.specialtycode != null;
	}
	public ims.dtomove.vo.lookups.SpecialtyCode getSpecialtyCode()
	{
		return this.specialtycode;
	}
	public void setSpecialtyCode(ims.dtomove.vo.lookups.SpecialtyCode value)
	{
		this.isValidated = false;
		this.specialtycode = value;
	}
	public boolean getServiceTypeIsNotNull()
	{
		return this.servicetype != null;
	}
	public ims.dtomove.vo.lookups.ActionReason getServiceType()
	{
		return this.servicetype;
	}
	public void setServiceType(ims.dtomove.vo.lookups.ActionReason value)
	{
		this.isValidated = false;
		this.servicetype = value;
	}
	public boolean getContractLocationIsNotNull()
	{
		return this.contractlocation != null;
	}
	public ims.dtomove.vo.lookups.ContractLocation getContractLocation()
	{
		return this.contractlocation;
	}
	public void setContractLocation(ims.dtomove.vo.lookups.ContractLocation value)
	{
		this.isValidated = false;
		this.contractlocation = value;
	}
	public boolean getCancelReasonIsNotNull()
	{
		return this.cancelreason != null;
	}
	public ims.dtomove.vo.lookups.ApptCancelledReason getCancelReason()
	{
		return this.cancelreason;
	}
	public void setCancelReason(ims.dtomove.vo.lookups.ApptCancelledReason value)
	{
		this.isValidated = false;
		this.cancelreason = value;
	}
	public boolean getApptStatusIsNotNull()
	{
		return this.apptstatus != null;
	}
	public ims.ccosched.vo.lookups.AppointmentStatus getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.ccosched.vo.lookups.AppointmentStatus value)
	{
		this.isValidated = false;
		this.apptstatus = value;
	}
	public boolean getTreatmentCategoryIsNotNull()
	{
		return this.treatmentcategory != null;
	}
	public ims.ccosched.vo.lookups.SchedCategory getTreatmentCategory()
	{
		return this.treatmentcategory;
	}
	public void setTreatmentCategory(ims.ccosched.vo.lookups.SchedCategory value)
	{
		this.isValidated = false;
		this.treatmentcategory = value;
	}
	public boolean getDNAReasonIsNotNull()
	{
		return this.dnareason != null;
	}
	public ims.ccosched.vo.lookups.ReasonDNA getDNAReason()
	{
		return this.dnareason;
	}
	public void setDNAReason(ims.ccosched.vo.lookups.ReasonDNA value)
	{
		this.isValidated = false;
		this.dnareason = value;
	}
	public boolean getMachineTypeIsNotNull()
	{
		return this.machinetype != null;
	}
	public ims.dtomove.vo.lookups.MachineTypes getMachineType()
	{
		return this.machinetype;
	}
	public void setMachineType(ims.dtomove.vo.lookups.MachineTypes value)
	{
		this.isValidated = false;
		this.machinetype = value;
	}
	public boolean getScheduleTypeIsNotNull()
	{
		return this.scheduletype != null;
	}
	public ims.dtomove.vo.lookups.SchedulingType getScheduleType()
	{
		return this.scheduletype;
	}
	public void setScheduleType(ims.dtomove.vo.lookups.SchedulingType value)
	{
		this.isValidated = false;
		this.scheduletype = value;
	}
	public boolean getScheduleCategoryIsNotNull()
	{
		return this.schedulecategory != null;
	}
	public ims.dtomove.vo.lookups.SchedulingCategory getScheduleCategory()
	{
		return this.schedulecategory;
	}
	public void setScheduleCategory(ims.dtomove.vo.lookups.SchedulingCategory value)
	{
		this.isValidated = false;
		this.schedulecategory = value;
	}
	public boolean getIntervalTypeIsNotNull()
	{
		return this.intervaltype != null;
	}
	public ims.dtomove.vo.lookups.IntervalType getIntervalType()
	{
		return this.intervaltype;
	}
	public void setIntervalType(ims.dtomove.vo.lookups.IntervalType value)
	{
		this.isValidated = false;
		this.intervaltype = value;
	}
	public boolean getLocationCharIsNotNull()
	{
		return this.locationchar != null;
	}
	public ims.dtomove.vo.lookups.LocationCharacteristics getLocationChar()
	{
		return this.locationchar;
	}
	public void setLocationChar(ims.dtomove.vo.lookups.LocationCharacteristics value)
	{
		this.isValidated = false;
		this.locationchar = value;
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
		if(this.active != null)
			if(this.active.length() > 1)
				listOfErrors.add("The length of the field [active] in the value object [ims.dtomove.vo.DummyVo] is too big. It should be less or equal to 1");
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
	
		DummyVo clone = new DummyVo(this.id, this.version);
		
		clone.active = this.active;
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.ccosched.vo.lookups.Priority)this.priority.clone();
		if(this.specialtycode == null)
			clone.specialtycode = null;
		else
			clone.specialtycode = (ims.dtomove.vo.lookups.SpecialtyCode)this.specialtycode.clone();
		if(this.servicetype == null)
			clone.servicetype = null;
		else
			clone.servicetype = (ims.dtomove.vo.lookups.ActionReason)this.servicetype.clone();
		if(this.contractlocation == null)
			clone.contractlocation = null;
		else
			clone.contractlocation = (ims.dtomove.vo.lookups.ContractLocation)this.contractlocation.clone();
		if(this.cancelreason == null)
			clone.cancelreason = null;
		else
			clone.cancelreason = (ims.dtomove.vo.lookups.ApptCancelledReason)this.cancelreason.clone();
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.ccosched.vo.lookups.AppointmentStatus)this.apptstatus.clone();
		if(this.treatmentcategory == null)
			clone.treatmentcategory = null;
		else
			clone.treatmentcategory = (ims.ccosched.vo.lookups.SchedCategory)this.treatmentcategory.clone();
		if(this.dnareason == null)
			clone.dnareason = null;
		else
			clone.dnareason = (ims.ccosched.vo.lookups.ReasonDNA)this.dnareason.clone();
		if(this.machinetype == null)
			clone.machinetype = null;
		else
			clone.machinetype = (ims.dtomove.vo.lookups.MachineTypes)this.machinetype.clone();
		if(this.scheduletype == null)
			clone.scheduletype = null;
		else
			clone.scheduletype = (ims.dtomove.vo.lookups.SchedulingType)this.scheduletype.clone();
		if(this.schedulecategory == null)
			clone.schedulecategory = null;
		else
			clone.schedulecategory = (ims.dtomove.vo.lookups.SchedulingCategory)this.schedulecategory.clone();
		if(this.intervaltype == null)
			clone.intervaltype = null;
		else
			clone.intervaltype = (ims.dtomove.vo.lookups.IntervalType)this.intervaltype.clone();
		if(this.locationchar == null)
			clone.locationchar = null;
		else
			clone.locationchar = (ims.dtomove.vo.lookups.LocationCharacteristics)this.locationchar.clone();
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
		if (!(DummyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DummyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DummyVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DummyVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.active != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.specialtycode != null)
			count++;
		if(this.servicetype != null)
			count++;
		if(this.contractlocation != null)
			count++;
		if(this.cancelreason != null)
			count++;
		if(this.apptstatus != null)
			count++;
		if(this.treatmentcategory != null)
			count++;
		if(this.dnareason != null)
			count++;
		if(this.machinetype != null)
			count++;
		if(this.scheduletype != null)
			count++;
		if(this.schedulecategory != null)
			count++;
		if(this.intervaltype != null)
			count++;
		if(this.locationchar != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected String active;
	protected ims.ccosched.vo.lookups.Priority priority;
	protected ims.dtomove.vo.lookups.SpecialtyCode specialtycode;
	protected ims.dtomove.vo.lookups.ActionReason servicetype;
	protected ims.dtomove.vo.lookups.ContractLocation contractlocation;
	protected ims.dtomove.vo.lookups.ApptCancelledReason cancelreason;
	protected ims.ccosched.vo.lookups.AppointmentStatus apptstatus;
	protected ims.ccosched.vo.lookups.SchedCategory treatmentcategory;
	protected ims.ccosched.vo.lookups.ReasonDNA dnareason;
	protected ims.dtomove.vo.lookups.MachineTypes machinetype;
	protected ims.dtomove.vo.lookups.SchedulingType scheduletype;
	protected ims.dtomove.vo.lookups.SchedulingCategory schedulecategory;
	protected ims.dtomove.vo.lookups.IntervalType intervaltype;
	protected ims.dtomove.vo.lookups.LocationCharacteristics locationchar;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
