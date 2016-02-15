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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo;


public class PIDBarOncologyManualVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PIDBarOncologyManualVo()
	{
	}
	public PIDBarOncologyManualVo(ims.clinical.vo.beans.PIDBarOncologyManualVoBean bean)
	{
		this.diagnosisid = bean.getDiagnosisId();
		this.diagnosisdesc = bean.getDiagnosisDesc();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.hcpname = bean.getHCPName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PIDBarOncologyManualVoBean bean)
	{
		this.diagnosisid = bean.getDiagnosisId();
		this.diagnosisdesc = bean.getDiagnosisDesc();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.hcpname = bean.getHCPName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PIDBarOncologyManualVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PIDBarOncologyManualVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PIDBarOncologyManualVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getDiagnosisIdIsNotNull()
	{
		return this.diagnosisid != null;
	}
	public Integer getDiagnosisId()
	{
		return this.diagnosisid;
	}
	public void setDiagnosisId(Integer value)
	{
		this.isValidated = false;
		this.diagnosisid = value;
	}
	public boolean getDiagnosisDescIsNotNull()
	{
		return this.diagnosisdesc != null;
	}
	public String getDiagnosisDesc()
	{
		return this.diagnosisdesc;
	}
	public static int getDiagnosisDescMaxLength()
	{
		return 255;
	}
	public void setDiagnosisDesc(String value)
	{
		this.isValidated = false;
		this.diagnosisdesc = value;
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
	}
	public boolean getHCPNameIsNotNull()
	{
		return this.hcpname != null;
	}
	public String getHCPName()
	{
		return this.hcpname;
	}
	public static int getHCPNameMaxLength()
	{
		return 255;
	}
	public void setHCPName(String value)
	{
		this.isValidated = false;
		this.hcpname = value;
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
		if(!(obj instanceof PIDBarOncologyManualVo))
			return false;
		PIDBarOncologyManualVo compareObj = (PIDBarOncologyManualVo)obj;
		if(this.getDiagnosisId() == null && compareObj.getDiagnosisId() != null)
			return false;
		if(this.getDiagnosisId() != null && compareObj.getDiagnosisId() == null)
			return false;
		if(this.getDiagnosisId() != null && compareObj.getDiagnosisId() != null)
			return this.getDiagnosisId().equals(compareObj.getDiagnosisId());
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
	
		PIDBarOncologyManualVo clone = new PIDBarOncologyManualVo();
		
		clone.diagnosisid = this.diagnosisid;
		clone.diagnosisdesc = this.diagnosisdesc;
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		clone.hcpname = this.hcpname;
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
		if (!(PIDBarOncologyManualVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PIDBarOncologyManualVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PIDBarOncologyManualVo compareObj = (PIDBarOncologyManualVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDiagnosisId() == null && compareObj.getDiagnosisId() != null)
				return -1;
			if(this.getDiagnosisId() != null && compareObj.getDiagnosisId() == null)
				return 1;
			if(this.getDiagnosisId() != null && compareObj.getDiagnosisId() != null)
				retVal = this.getDiagnosisId().compareTo(compareObj.getDiagnosisId());
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
		if(this.diagnosisid != null)
			count++;
		if(this.diagnosisdesc != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.enddate != null)
			count++;
		if(this.hcpname != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected Integer diagnosisid;
	protected String diagnosisdesc;
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date enddate;
	protected String hcpname;
	private boolean isValidated = false;
	private boolean isBusy = false;
}