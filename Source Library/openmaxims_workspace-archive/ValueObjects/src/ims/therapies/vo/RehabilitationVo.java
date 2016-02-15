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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.Rehabilitation business object (ID: 1019100008).
 */
public class RehabilitationVo extends ims.therapies.vo.RehabilitationShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RehabilitationVo()
	{
	}
	public RehabilitationVo(Integer id, int version)
	{
		super(id, version);
	}
	public RehabilitationVo(ims.therapies.vo.beans.RehabilitationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.rehabactivity = ims.therapies.vo.RehabilitationActivityVoCollection.buildFromBeanCollection(bean.getRehabActivity());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.RehabilitationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.rehabactivity = ims.therapies.vo.RehabilitationActivityVoCollection.buildFromBeanCollection(bean.getRehabActivity());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.RehabilitationVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.RehabilitationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.RehabilitationVoBean();
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
		if(fieldName.equals("REHABACTIVITY"))
			return getRehabActivity();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRehabActivityIsNotNull()
	{
		return this.rehabactivity != null;
	}
	public ims.therapies.vo.RehabilitationActivityVoCollection getRehabActivity()
	{
		return this.rehabactivity;
	}
	public void setRehabActivity(ims.therapies.vo.RehabilitationActivityVoCollection value)
	{
		this.isValidated = false;
		this.rehabactivity = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.rehabactivity != null)
		{
			if(!this.rehabactivity.isValidated())
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
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.authoringcp == null)
			listOfErrors.add("Authoring HCP is mandatory");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("Authoring Date Time is mandatory");
		if(this.rehabactivity == null || this.rehabactivity.size() == 0)
			listOfErrors.add("Rehab Activity is mandatory");
		if(this.rehabactivity != null)
		{
			String[] listOfOtherErrors = this.rehabactivity.validate();
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
	
		RehabilitationVo clone = new RehabilitationVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.rehabactivity == null)
			clone.rehabactivity = null;
		else
			clone.rehabactivity = (ims.therapies.vo.RehabilitationActivityVoCollection)this.rehabactivity.clone();
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
		if (!(RehabilitationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RehabilitationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		RehabilitationVo compareObj = (RehabilitationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getClinicalContact() == null && compareObj.getClinicalContact() != null)
				return -1;
			if(this.getClinicalContact() != null && compareObj.getClinicalContact() == null)
				return 1;
			if(this.getClinicalContact() != null && compareObj.getClinicalContact() != null)
				retVal = this.getClinicalContact().compareTo(compareObj.getClinicalContact());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.rehabactivity != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.therapies.vo.RehabilitationActivityVoCollection rehabactivity;
	private boolean isValidated = false;
	private boolean isBusy = false;
}