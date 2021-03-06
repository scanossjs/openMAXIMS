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

package ims.RefMan.vo;


public class PreAssessmentWorklistSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PreAssessmentWorklistSearchCriteriaVo()
	{
	}
	public PreAssessmentWorklistSearchCriteriaVo(ims.RefMan.vo.beans.PreAssessmentWorklistSearchCriteriaVoBean bean)
	{
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.urgency = bean.getUrgency() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getUrgency());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.breachdatefrom = bean.getBreachDateFrom() == null ? null : bean.getBreachDateFrom().buildDate();
		this.breachdateto = bean.getBreachDateTo() == null ? null : bean.getBreachDateTo().buildDate();
		this.preassessmentrequired = bean.getPreAssessmentRequired();
		this.notfitforsurgery = bean.getNotFitForSurgery();
		this.fitforsurgery = bean.getFitForSurgery();
		this.preassessmentoutcomepending = bean.getPreAssessmentOutcomePending();
		this.waitingfor = ims.clinical.vo.lookups.PreAssessmentInformationRequiredCollection.buildFromBeanCollection(bean.getWaitingFor());
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.addedtoday = bean.getAddedToday();
		this.waitinglist = bean.getWaitingList();
		this.surveillanceplannedlist = bean.getSurveillancePlannedList();
		this.plannedfrom = bean.getPlannedFrom() == null ? null : bean.getPlannedFrom().buildDate();
		this.plannedto = bean.getPlannedTo() == null ? null : bean.getPlannedTo().buildDate();
		this.pastappointment = bean.getPastAppointment();
		this.futureappointment = bean.getFutureAppointment();
		this.patientidentifier = bean.getPatientIdentifier();
		this.patidtype = bean.getPatIdType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getPatIdType());
		this.includeendoscopy = bean.getIncludeEndoscopy();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PreAssessmentWorklistSearchCriteriaVoBean bean)
	{
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.urgency = bean.getUrgency() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getUrgency());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.breachdatefrom = bean.getBreachDateFrom() == null ? null : bean.getBreachDateFrom().buildDate();
		this.breachdateto = bean.getBreachDateTo() == null ? null : bean.getBreachDateTo().buildDate();
		this.preassessmentrequired = bean.getPreAssessmentRequired();
		this.notfitforsurgery = bean.getNotFitForSurgery();
		this.fitforsurgery = bean.getFitForSurgery();
		this.preassessmentoutcomepending = bean.getPreAssessmentOutcomePending();
		this.waitingfor = ims.clinical.vo.lookups.PreAssessmentInformationRequiredCollection.buildFromBeanCollection(bean.getWaitingFor());
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.addedtoday = bean.getAddedToday();
		this.waitinglist = bean.getWaitingList();
		this.surveillanceplannedlist = bean.getSurveillancePlannedList();
		this.plannedfrom = bean.getPlannedFrom() == null ? null : bean.getPlannedFrom().buildDate();
		this.plannedto = bean.getPlannedTo() == null ? null : bean.getPlannedTo().buildDate();
		this.pastappointment = bean.getPastAppointment();
		this.futureappointment = bean.getFutureAppointment();
		this.patientidentifier = bean.getPatientIdentifier();
		this.patidtype = bean.getPatIdType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getPatIdType());
		this.includeendoscopy = bean.getIncludeEndoscopy();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PreAssessmentWorklistSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PreAssessmentWorklistSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PreAssessmentWorklistSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceShortVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceShortVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getUrgencyIsNotNull()
	{
		return this.urgency != null;
	}
	public ims.RefMan.vo.lookups.ReferralUrgency getUrgency()
	{
		return this.urgency;
	}
	public void setUrgency(ims.RefMan.vo.lookups.ReferralUrgency value)
	{
		this.isValidated = false;
		this.urgency = value;
	}
	public boolean getAnaestheticTypeIsNotNull()
	{
		return this.anaesthetictype != null;
	}
	public ims.clinical.vo.lookups.AnaestheticType getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.clinical.vo.lookups.AnaestheticType value)
	{
		this.isValidated = false;
		this.anaesthetictype = value;
	}
	public boolean getBreachDateFromIsNotNull()
	{
		return this.breachdatefrom != null;
	}
	public ims.framework.utils.Date getBreachDateFrom()
	{
		return this.breachdatefrom;
	}
	public void setBreachDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.breachdatefrom = value;
	}
	public boolean getBreachDateToIsNotNull()
	{
		return this.breachdateto != null;
	}
	public ims.framework.utils.Date getBreachDateTo()
	{
		return this.breachdateto;
	}
	public void setBreachDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.breachdateto = value;
	}
	public boolean getPreAssessmentRequiredIsNotNull()
	{
		return this.preassessmentrequired != null;
	}
	public Boolean getPreAssessmentRequired()
	{
		return this.preassessmentrequired;
	}
	public void setPreAssessmentRequired(Boolean value)
	{
		this.isValidated = false;
		this.preassessmentrequired = value;
	}
	public boolean getNotFitForSurgeryIsNotNull()
	{
		return this.notfitforsurgery != null;
	}
	public Boolean getNotFitForSurgery()
	{
		return this.notfitforsurgery;
	}
	public void setNotFitForSurgery(Boolean value)
	{
		this.isValidated = false;
		this.notfitforsurgery = value;
	}
	public boolean getFitForSurgeryIsNotNull()
	{
		return this.fitforsurgery != null;
	}
	public Boolean getFitForSurgery()
	{
		return this.fitforsurgery;
	}
	public void setFitForSurgery(Boolean value)
	{
		this.isValidated = false;
		this.fitforsurgery = value;
	}
	public boolean getPreAssessmentOutcomePendingIsNotNull()
	{
		return this.preassessmentoutcomepending != null;
	}
	public Boolean getPreAssessmentOutcomePending()
	{
		return this.preassessmentoutcomepending;
	}
	public void setPreAssessmentOutcomePending(Boolean value)
	{
		this.isValidated = false;
		this.preassessmentoutcomepending = value;
	}
	public boolean getWaitingForIsNotNull()
	{
		return this.waitingfor != null;
	}
	public ims.clinical.vo.lookups.PreAssessmentInformationRequiredCollection getWaitingFor()
	{
		return this.waitingfor;
	}
	public void setWaitingFor(ims.clinical.vo.lookups.PreAssessmentInformationRequiredCollection value)
	{
		this.isValidated = false;
		this.waitingfor = value;
	}
	public boolean getServicesIsNotNull()
	{
		return this.services != null;
	}
	public ims.core.vo.ServiceShortVoCollection getServices()
	{
		return this.services;
	}
	public void setServices(ims.core.vo.ServiceShortVoCollection value)
	{
		this.isValidated = false;
		this.services = value;
	}
	public boolean getTheatreTypeIsNotNull()
	{
		return this.theatretype != null;
	}
	public ims.scheduling.vo.lookups.TheatreType getTheatreType()
	{
		return this.theatretype;
	}
	public void setTheatreType(ims.scheduling.vo.lookups.TheatreType value)
	{
		this.isValidated = false;
		this.theatretype = value;
	}
	public boolean getAddedTodayIsNotNull()
	{
		return this.addedtoday != null;
	}
	public Boolean getAddedToday()
	{
		return this.addedtoday;
	}
	public void setAddedToday(Boolean value)
	{
		this.isValidated = false;
		this.addedtoday = value;
	}
	public boolean getWaitingListIsNotNull()
	{
		return this.waitinglist != null;
	}
	public Boolean getWaitingList()
	{
		return this.waitinglist;
	}
	public void setWaitingList(Boolean value)
	{
		this.isValidated = false;
		this.waitinglist = value;
	}
	public boolean getSurveillancePlannedListIsNotNull()
	{
		return this.surveillanceplannedlist != null;
	}
	public Boolean getSurveillancePlannedList()
	{
		return this.surveillanceplannedlist;
	}
	public void setSurveillancePlannedList(Boolean value)
	{
		this.isValidated = false;
		this.surveillanceplannedlist = value;
	}
	public boolean getPlannedFromIsNotNull()
	{
		return this.plannedfrom != null;
	}
	public ims.framework.utils.Date getPlannedFrom()
	{
		return this.plannedfrom;
	}
	public void setPlannedFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.plannedfrom = value;
	}
	public boolean getPlannedToIsNotNull()
	{
		return this.plannedto != null;
	}
	public ims.framework.utils.Date getPlannedTo()
	{
		return this.plannedto;
	}
	public void setPlannedTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.plannedto = value;
	}
	public boolean getPastAppointmentIsNotNull()
	{
		return this.pastappointment != null;
	}
	public Boolean getPastAppointment()
	{
		return this.pastappointment;
	}
	public void setPastAppointment(Boolean value)
	{
		this.isValidated = false;
		this.pastappointment = value;
	}
	public boolean getFutureAppointmentIsNotNull()
	{
		return this.futureappointment != null;
	}
	public Boolean getFutureAppointment()
	{
		return this.futureappointment;
	}
	public void setFutureAppointment(Boolean value)
	{
		this.isValidated = false;
		this.futureappointment = value;
	}
	public boolean getPatientIdentifierIsNotNull()
	{
		return this.patientidentifier != null;
	}
	public String getPatientIdentifier()
	{
		return this.patientidentifier;
	}
	public static int getPatientIdentifierMaxLength()
	{
		return 255;
	}
	public void setPatientIdentifier(String value)
	{
		this.isValidated = false;
		this.patientidentifier = value;
	}
	public boolean getPatIdTypeIsNotNull()
	{
		return this.patidtype != null;
	}
	public ims.core.vo.lookups.PatIdType getPatIdType()
	{
		return this.patidtype;
	}
	public void setPatIdType(ims.core.vo.lookups.PatIdType value)
	{
		this.isValidated = false;
		this.patidtype = value;
	}
	public boolean getIncludeEndoscopyIsNotNull()
	{
		return this.includeendoscopy != null;
	}
	public Boolean getIncludeEndoscopy()
	{
		return this.includeendoscopy;
	}
	public void setIncludeEndoscopy(Boolean value)
	{
		this.isValidated = false;
		this.includeendoscopy = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof PreAssessmentWorklistSearchCriteriaVo))
			return false;
		PreAssessmentWorklistSearchCriteriaVo compareObj = (PreAssessmentWorklistSearchCriteriaVo)obj;
		if(this.getProcedure() == null && compareObj.getProcedure() != null)
			return false;
		if(this.getProcedure() != null && compareObj.getProcedure() == null)
			return false;
		if(this.getProcedure() != null && compareObj.getProcedure() != null)
			return this.getProcedure().equals(compareObj.getProcedure());
		return super.equals(obj);
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
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.procedure != null)
		{
			if(!this.procedure.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.services != null)
		{
			if(!this.services.isValidated())
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
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.procedure != null)
		{
			String[] listOfOtherErrors = this.procedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.services != null)
		{
			String[] listOfOtherErrors = this.services.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PreAssessmentWorklistSearchCriteriaVo clone = new PreAssessmentWorklistSearchCriteriaVo();
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		if(this.urgency == null)
			clone.urgency = null;
		else
			clone.urgency = (ims.RefMan.vo.lookups.ReferralUrgency)this.urgency.clone();
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticType)this.anaesthetictype.clone();
		if(this.breachdatefrom == null)
			clone.breachdatefrom = null;
		else
			clone.breachdatefrom = (ims.framework.utils.Date)this.breachdatefrom.clone();
		if(this.breachdateto == null)
			clone.breachdateto = null;
		else
			clone.breachdateto = (ims.framework.utils.Date)this.breachdateto.clone();
		clone.preassessmentrequired = this.preassessmentrequired;
		clone.notfitforsurgery = this.notfitforsurgery;
		clone.fitforsurgery = this.fitforsurgery;
		clone.preassessmentoutcomepending = this.preassessmentoutcomepending;
		if(this.waitingfor == null)
			clone.waitingfor = null;
		else
			clone.waitingfor = (ims.clinical.vo.lookups.PreAssessmentInformationRequiredCollection)this.waitingfor.clone();
		if(this.services == null)
			clone.services = null;
		else
			clone.services = (ims.core.vo.ServiceShortVoCollection)this.services.clone();
		if(this.theatretype == null)
			clone.theatretype = null;
		else
			clone.theatretype = (ims.scheduling.vo.lookups.TheatreType)this.theatretype.clone();
		clone.addedtoday = this.addedtoday;
		clone.waitinglist = this.waitinglist;
		clone.surveillanceplannedlist = this.surveillanceplannedlist;
		if(this.plannedfrom == null)
			clone.plannedfrom = null;
		else
			clone.plannedfrom = (ims.framework.utils.Date)this.plannedfrom.clone();
		if(this.plannedto == null)
			clone.plannedto = null;
		else
			clone.plannedto = (ims.framework.utils.Date)this.plannedto.clone();
		clone.pastappointment = this.pastappointment;
		clone.futureappointment = this.futureappointment;
		clone.patientidentifier = this.patientidentifier;
		if(this.patidtype == null)
			clone.patidtype = null;
		else
			clone.patidtype = (ims.core.vo.lookups.PatIdType)this.patidtype.clone();
		clone.includeendoscopy = this.includeendoscopy;
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
		if (!(PreAssessmentWorklistSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PreAssessmentWorklistSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PreAssessmentWorklistSearchCriteriaVo compareObj = (PreAssessmentWorklistSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getProcedure() == null && compareObj.getProcedure() != null)
				return -1;
			if(this.getProcedure() != null && compareObj.getProcedure() == null)
				return 1;
			if(this.getProcedure() != null && compareObj.getProcedure() != null)
				retVal = this.getProcedure().compareTo(compareObj.getProcedure());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.service != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.urgency != null)
			count++;
		if(this.anaesthetictype != null)
			count++;
		if(this.breachdatefrom != null)
			count++;
		if(this.breachdateto != null)
			count++;
		if(this.preassessmentrequired != null)
			count++;
		if(this.notfitforsurgery != null)
			count++;
		if(this.fitforsurgery != null)
			count++;
		if(this.preassessmentoutcomepending != null)
			count++;
		if(this.waitingfor != null)
			count++;
		if(this.services != null)
			count++;
		if(this.theatretype != null)
			count++;
		if(this.addedtoday != null)
			count++;
		if(this.waitinglist != null)
			count++;
		if(this.surveillanceplannedlist != null)
			count++;
		if(this.plannedfrom != null)
			count++;
		if(this.plannedto != null)
			count++;
		if(this.pastappointment != null)
			count++;
		if(this.futureappointment != null)
			count++;
		if(this.patientidentifier != null)
			count++;
		if(this.patidtype != null)
			count++;
		if(this.includeendoscopy != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 23;
	}
	protected ims.core.vo.ServiceShortVo service;
	protected ims.core.vo.ProcedureLiteVo procedure;
	protected ims.RefMan.vo.lookups.ReferralUrgency urgency;
	protected ims.clinical.vo.lookups.AnaestheticType anaesthetictype;
	protected ims.framework.utils.Date breachdatefrom;
	protected ims.framework.utils.Date breachdateto;
	protected Boolean preassessmentrequired;
	protected Boolean notfitforsurgery;
	protected Boolean fitforsurgery;
	protected Boolean preassessmentoutcomepending;
	protected ims.clinical.vo.lookups.PreAssessmentInformationRequiredCollection waitingfor;
	protected ims.core.vo.ServiceShortVoCollection services;
	protected ims.scheduling.vo.lookups.TheatreType theatretype;
	protected Boolean addedtoday;
	protected Boolean waitinglist;
	protected Boolean surveillanceplannedlist;
	protected ims.framework.utils.Date plannedfrom;
	protected ims.framework.utils.Date plannedto;
	protected Boolean pastappointment;
	protected Boolean futureappointment;
	protected String patientidentifier;
	protected ims.core.vo.lookups.PatIdType patidtype;
	protected Boolean includeendoscopy;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
