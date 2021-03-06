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

package ims.eas.vo;

/**
 * Linked to EAS.Configuration.ModalityConfig business object (ID: 1114100005).
 */
public class ModalityConfigVo extends ims.eas.configuration.vo.ModalityConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ModalityConfigVo()
	{
	}
	public ModalityConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public ModalityConfigVo(ims.eas.vo.beans.ModalityConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.modality = bean.getModality() == null ? null : ims.ccosched.vo.lookups.Modality.buildLookup(bean.getModality());
		this.energy = bean.getEnergy();
		this.unit = bean.getUnit() == null ? null : ims.ccosched.vo.lookups.Unit.buildLookup(bean.getUnit());
		this.active = bean.getActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.ModalityConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.modality = bean.getModality() == null ? null : ims.ccosched.vo.lookups.Modality.buildLookup(bean.getModality());
		this.energy = bean.getEnergy();
		this.unit = bean.getUnit() == null ? null : ims.ccosched.vo.lookups.Unit.buildLookup(bean.getUnit());
		this.active = bean.getActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.ModalityConfigVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.ModalityConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.ModalityConfigVoBean();
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
		if(fieldName.equals("MODALITY"))
			return getModality();
		if(fieldName.equals("ENERGY"))
			return getEnergy();
		if(fieldName.equals("UNIT"))
			return getUnit();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getModalityIsNotNull()
	{
		return this.modality != null;
	}
	public ims.ccosched.vo.lookups.Modality getModality()
	{
		return this.modality;
	}
	public void setModality(ims.ccosched.vo.lookups.Modality value)
	{
		this.isValidated = false;
		this.modality = value;
	}
	public boolean getEnergyIsNotNull()
	{
		return this.energy != null;
	}
	public Float getEnergy()
	{
		return this.energy;
	}
	public void setEnergy(Float value)
	{
		this.isValidated = false;
		this.energy = value;
	}
	public boolean getUnitIsNotNull()
	{
		return this.unit != null;
	}
	public ims.ccosched.vo.lookups.Unit getUnit()
	{
		return this.unit;
	}
	public void setUnit(ims.ccosched.vo.lookups.Unit value)
	{
		this.isValidated = false;
		this.unit = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
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
		if(this.modality == null)
			listOfErrors.add("Modality is mandatory");
		if(this.energy == null)
			listOfErrors.add("Energy is mandatory");
		if(this.unit == null)
			listOfErrors.add("Unit is mandatory");
		if(this.active == null)
			listOfErrors.add("active is mandatory");
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
	
		ModalityConfigVo clone = new ModalityConfigVo(this.id, this.version);
		
		if(this.modality == null)
			clone.modality = null;
		else
			clone.modality = (ims.ccosched.vo.lookups.Modality)this.modality.clone();
		clone.energy = this.energy;
		if(this.unit == null)
			clone.unit = null;
		else
			clone.unit = (ims.ccosched.vo.lookups.Unit)this.unit.clone();
		clone.active = this.active;
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
		if (!(ModalityConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ModalityConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ModalityConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ModalityConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.modality != null)
			count++;
		if(this.energy != null)
			count++;
		if(this.unit != null)
			count++;
		if(this.active != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.ccosched.vo.lookups.Modality modality;
	protected Float energy;
	protected ims.ccosched.vo.lookups.Unit unit;
	protected Boolean active;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
