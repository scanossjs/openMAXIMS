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


public class BookTheatreSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BookTheatreSearchCriteriaVo()
	{
	}
	public BookTheatreSearchCriteriaVo(ims.RefMan.vo.beans.BookTheatreSearchCriteriaVoBean bean)
	{
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
		this.service = bean.getService() == null ? null : new ims.core.clinical.vo.ServiceRefVo(new Integer(bean.getService().getId()), bean.getService().getVersion());
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		this.listtype = bean.getListType() == null ? null : ims.scheduling.vo.lookups.ProfileListType.buildLookup(bean.getListType());
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.timerequired = bean.getTimeRequired();
		this.allowoverbook = bean.getAllowOverBook();
		this.multiservicecase = bean.getMultiServiceCase();
		this.nogasessions = bean.getNoGASessions();
		this.theatre = bean.getTheatre() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getTheatre().getId()), bean.getTheatre().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.BookTheatreSearchCriteriaVoBean bean)
	{
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
		this.service = bean.getService() == null ? null : new ims.core.clinical.vo.ServiceRefVo(new Integer(bean.getService().getId()), bean.getService().getVersion());
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		this.listtype = bean.getListType() == null ? null : ims.scheduling.vo.lookups.ProfileListType.buildLookup(bean.getListType());
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.timerequired = bean.getTimeRequired();
		this.allowoverbook = bean.getAllowOverBook();
		this.multiservicecase = bean.getMultiServiceCase();
		this.nogasessions = bean.getNoGASessions();
		this.theatre = bean.getTheatre() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getTheatre().getId()), bean.getTheatre().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.BookTheatreSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.BookTheatreSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.BookTheatreSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getFromDateIsNotNull()
	{
		return this.fromdate != null;
	}
	public ims.framework.utils.Date getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.fromdate = value;
	}
	public boolean getToDateIsNotNull()
	{
		return this.todate != null;
	}
	public ims.framework.utils.Date getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.todate = value;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.clinical.vo.ServiceRefVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.clinical.vo.ServiceRefVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getPrimaryProcedureIsNotNull()
	{
		return this.primaryprocedure != null;
	}
	public ims.vo.interfaces.IGenericItem getPrimaryProcedure()
	{
		return this.primaryprocedure;
	}
	public void setPrimaryProcedure(ims.vo.interfaces.IGenericItem value)
	{
		this.isValidated = false;
		this.primaryprocedure = value;
	}
	public boolean getAdditionalProcedureIsNotNull()
	{
		return this.additionalprocedure != null;
	}
	public ims.vo.interfaces.IGenericItem getAdditionalProcedure()
	{
		return this.additionalprocedure;
	}
	public void setAdditionalProcedure(ims.vo.interfaces.IGenericItem value)
	{
		this.isValidated = false;
		this.additionalprocedure = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.vo.interfaces.IMos getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getListTypeIsNotNull()
	{
		return this.listtype != null;
	}
	public ims.scheduling.vo.lookups.ProfileListType getListType()
	{
		return this.listtype;
	}
	public void setListType(ims.scheduling.vo.lookups.ProfileListType value)
	{
		this.isValidated = false;
		this.listtype = value;
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
	public boolean getTimeRequiredIsNotNull()
	{
		return this.timerequired != null;
	}
	public Integer getTimeRequired()
	{
		return this.timerequired;
	}
	public void setTimeRequired(Integer value)
	{
		this.isValidated = false;
		this.timerequired = value;
	}
	public boolean getAllowOverBookIsNotNull()
	{
		return this.allowoverbook != null;
	}
	public Boolean getAllowOverBook()
	{
		return this.allowoverbook;
	}
	public void setAllowOverBook(Boolean value)
	{
		this.isValidated = false;
		this.allowoverbook = value;
	}
	public boolean getMultiServiceCaseIsNotNull()
	{
		return this.multiservicecase != null;
	}
	public Boolean getMultiServiceCase()
	{
		return this.multiservicecase;
	}
	public void setMultiServiceCase(Boolean value)
	{
		this.isValidated = false;
		this.multiservicecase = value;
	}
	public boolean getNoGASessionsIsNotNull()
	{
		return this.nogasessions != null;
	}
	public Boolean getNoGASessions()
	{
		return this.nogasessions;
	}
	public void setNoGASessions(Boolean value)
	{
		this.isValidated = false;
		this.nogasessions = value;
	}
	public boolean getTheatreIsNotNull()
	{
		return this.theatre != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getTheatre()
	{
		return this.theatre;
	}
	public void setTheatre(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.theatre = value;
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
		if(!(obj instanceof BookTheatreSearchCriteriaVo))
			return false;
		BookTheatreSearchCriteriaVo compareObj = (BookTheatreSearchCriteriaVo)obj;
		if(this.getFromDate() == null && compareObj.getFromDate() != null)
			return false;
		if(this.getFromDate() != null && compareObj.getFromDate() == null)
			return false;
		if(this.getFromDate() != null && compareObj.getFromDate() != null)
			if(!this.getFromDate().equals(compareObj.getFromDate()))
				return false;
		if(this.getToDate() == null && compareObj.getToDate() != null)
			return false;
		if(this.getToDate() != null && compareObj.getToDate() == null)
			return false;
		if(this.getToDate() != null && compareObj.getToDate() != null)
			if(!this.getToDate().equals(compareObj.getToDate()))
				return false;
		if(this.getHospital() == null && compareObj.getHospital() != null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() == null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() != null)
			if(!this.getHospital().equals(compareObj.getHospital()))
				return false;
		if(this.getService() == null && compareObj.getService() != null)
			return false;
		if(this.getService() != null && compareObj.getService() == null)
			return false;
		if(this.getService() != null && compareObj.getService() != null)
			if(!this.getService().equals(compareObj.getService()))
				return false;
		if(this.getPrimaryProcedure() == null && compareObj.getPrimaryProcedure() != null)
			return false;
		if(this.getPrimaryProcedure() != null && compareObj.getPrimaryProcedure() == null)
			return false;
		if(this.getPrimaryProcedure() != null && compareObj.getPrimaryProcedure() != null)
			if(!this.getPrimaryProcedure().equals(compareObj.getPrimaryProcedure()))
				return false;
		if(this.getAdditionalProcedure() == null && compareObj.getAdditionalProcedure() != null)
			return false;
		if(this.getAdditionalProcedure() != null && compareObj.getAdditionalProcedure() == null)
			return false;
		if(this.getAdditionalProcedure() != null && compareObj.getAdditionalProcedure() != null)
			if(!this.getAdditionalProcedure().equals(compareObj.getAdditionalProcedure()))
				return false;
		if(this.getConsultant() == null && compareObj.getConsultant() != null)
			return false;
		if(this.getConsultant() != null && compareObj.getConsultant() == null)
			return false;
		if(this.getConsultant() != null && compareObj.getConsultant() != null)
			if(!this.getConsultant().equals(compareObj.getConsultant()))
				return false;
		if(this.getListType() == null && compareObj.getListType() != null)
			return false;
		if(this.getListType() != null && compareObj.getListType() == null)
			return false;
		if(this.getListType() != null && compareObj.getListType() != null)
			if(!this.getListType().equals(compareObj.getListType()))
				return false;
		if(this.getTheatreType() == null && compareObj.getTheatreType() != null)
			return false;
		if(this.getTheatreType() != null && compareObj.getTheatreType() == null)
			return false;
		if(this.getTheatreType() != null && compareObj.getTheatreType() != null)
			if(!this.getTheatreType().equals(compareObj.getTheatreType()))
				return false;
		if(this.getAnaestheticType() == null && compareObj.getAnaestheticType() != null)
			return false;
		if(this.getAnaestheticType() != null && compareObj.getAnaestheticType() == null)
			return false;
		if(this.getAnaestheticType() != null && compareObj.getAnaestheticType() != null)
			if(!this.getAnaestheticType().equals(compareObj.getAnaestheticType()))
				return false;
		if(this.getTimeRequired() == null && compareObj.getTimeRequired() != null)
			return false;
		if(this.getTimeRequired() != null && compareObj.getTimeRequired() == null)
			return false;
		if(this.getTimeRequired() != null && compareObj.getTimeRequired() != null)
			return this.getTimeRequired().equals(compareObj.getTimeRequired());
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
	
		BookTheatreSearchCriteriaVo clone = new BookTheatreSearchCriteriaVo();
		
		if(this.fromdate == null)
			clone.fromdate = null;
		else
			clone.fromdate = (ims.framework.utils.Date)this.fromdate.clone();
		if(this.todate == null)
			clone.todate = null;
		else
			clone.todate = (ims.framework.utils.Date)this.todate.clone();
		clone.hospital = this.hospital;
		clone.service = this.service;
		clone.primaryprocedure = this.primaryprocedure;
		clone.additionalprocedure = this.additionalprocedure;
		clone.consultant = this.consultant;
		if(this.listtype == null)
			clone.listtype = null;
		else
			clone.listtype = (ims.scheduling.vo.lookups.ProfileListType)this.listtype.clone();
		if(this.theatretype == null)
			clone.theatretype = null;
		else
			clone.theatretype = (ims.scheduling.vo.lookups.TheatreType)this.theatretype.clone();
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticType)this.anaesthetictype.clone();
		clone.timerequired = this.timerequired;
		clone.allowoverbook = this.allowoverbook;
		clone.multiservicecase = this.multiservicecase;
		clone.nogasessions = this.nogasessions;
		clone.theatre = this.theatre;
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
		if (!(BookTheatreSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BookTheatreSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BookTheatreSearchCriteriaVo compareObj = (BookTheatreSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getFromDate() == null && compareObj.getFromDate() != null)
				return -1;
			if(this.getFromDate() != null && compareObj.getFromDate() == null)
				return 1;
			if(this.getFromDate() != null && compareObj.getFromDate() != null)
				retVal = this.getFromDate().compareTo(compareObj.getFromDate());
		}
		if (retVal == 0)
		{
			if(this.getToDate() == null && compareObj.getToDate() != null)
				return -1;
			if(this.getToDate() != null && compareObj.getToDate() == null)
				return 1;
			if(this.getToDate() != null && compareObj.getToDate() != null)
				retVal = this.getToDate().compareTo(compareObj.getToDate());
		}
		if (retVal == 0)
		{
			if(this.getHospital() == null && compareObj.getHospital() != null)
				return -1;
			if(this.getHospital() != null && compareObj.getHospital() == null)
				return 1;
			if(this.getHospital() != null && compareObj.getHospital() != null)
				retVal = this.getHospital().compareTo(compareObj.getHospital());
		}
		if (retVal == 0)
		{
			if(this.getService() == null && compareObj.getService() != null)
				return -1;
			if(this.getService() != null && compareObj.getService() == null)
				return 1;
			if(this.getService() != null && compareObj.getService() != null)
				retVal = this.getService().compareTo(compareObj.getService());
		}
		if (retVal == 0)
		{
			if(this.getPrimaryProcedure() == null && compareObj.getPrimaryProcedure() != null)
				return -1;
			if(this.getPrimaryProcedure() != null && compareObj.getPrimaryProcedure() == null)
				return 1;
			if(this.getPrimaryProcedure() != null && compareObj.getPrimaryProcedure() != null)
				retVal = this.getPrimaryProcedure().compareTo(compareObj.getPrimaryProcedure());
		}
		if (retVal == 0)
		{
			if(this.getAdditionalProcedure() == null && compareObj.getAdditionalProcedure() != null)
				return -1;
			if(this.getAdditionalProcedure() != null && compareObj.getAdditionalProcedure() == null)
				return 1;
			if(this.getAdditionalProcedure() != null && compareObj.getAdditionalProcedure() != null)
				retVal = this.getAdditionalProcedure().compareTo(compareObj.getAdditionalProcedure());
		}
		if (retVal == 0)
		{
			if(this.getConsultant() == null && compareObj.getConsultant() != null)
				return -1;
			if(this.getConsultant() != null && compareObj.getConsultant() == null)
				return 1;
			if(this.getConsultant() != null && compareObj.getConsultant() != null)
				retVal = this.getConsultant().compareTo(compareObj.getConsultant());
		}
		if (retVal == 0)
		{
			if(this.getListType() == null && compareObj.getListType() != null)
				return -1;
			if(this.getListType() != null && compareObj.getListType() == null)
				return 1;
			if(this.getListType() != null && compareObj.getListType() != null)
				retVal = this.getListType().compareTo(compareObj.getListType());
		}
		if (retVal == 0)
		{
			if(this.getTheatreType() == null && compareObj.getTheatreType() != null)
				return -1;
			if(this.getTheatreType() != null && compareObj.getTheatreType() == null)
				return 1;
			if(this.getTheatreType() != null && compareObj.getTheatreType() != null)
				retVal = this.getTheatreType().compareTo(compareObj.getTheatreType());
		}
		if (retVal == 0)
		{
			if(this.getAnaestheticType() == null && compareObj.getAnaestheticType() != null)
				return -1;
			if(this.getAnaestheticType() != null && compareObj.getAnaestheticType() == null)
				return 1;
			if(this.getAnaestheticType() != null && compareObj.getAnaestheticType() != null)
				retVal = this.getAnaestheticType().compareTo(compareObj.getAnaestheticType());
		}
		if (retVal == 0)
		{
			if(this.getTimeRequired() == null && compareObj.getTimeRequired() != null)
				return -1;
			if(this.getTimeRequired() != null && compareObj.getTimeRequired() == null)
				return 1;
			if(this.getTimeRequired() != null && compareObj.getTimeRequired() != null)
				retVal = this.getTimeRequired().compareTo(compareObj.getTimeRequired());
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
		if(this.fromdate != null)
			count++;
		if(this.todate != null)
			count++;
		if(this.hospital != null)
			count++;
		if(this.service != null)
			count++;
		if(this.primaryprocedure != null)
			count++;
		if(this.additionalprocedure != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.listtype != null)
			count++;
		if(this.theatretype != null)
			count++;
		if(this.anaesthetictype != null)
			count++;
		if(this.timerequired != null)
			count++;
		if(this.allowoverbook != null)
			count++;
		if(this.multiservicecase != null)
			count++;
		if(this.nogasessions != null)
			count++;
		if(this.theatre != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.framework.utils.Date fromdate;
	protected ims.framework.utils.Date todate;
	protected ims.core.resource.place.vo.LocationRefVo hospital;
	protected ims.core.clinical.vo.ServiceRefVo service;
	protected ims.vo.interfaces.IGenericItem primaryprocedure;
	protected ims.vo.interfaces.IGenericItem additionalprocedure;
	protected ims.vo.interfaces.IMos consultant;
	protected ims.scheduling.vo.lookups.ProfileListType listtype;
	protected ims.scheduling.vo.lookups.TheatreType theatretype;
	protected ims.clinical.vo.lookups.AnaestheticType anaesthetictype;
	protected Integer timerequired;
	protected Boolean allowoverbook;
	protected Boolean multiservicecase;
	protected Boolean nogasessions;
	protected ims.core.resource.place.vo.LocationRefVo theatre;
	private boolean isValidated = false;
	private boolean isBusy = false;
}