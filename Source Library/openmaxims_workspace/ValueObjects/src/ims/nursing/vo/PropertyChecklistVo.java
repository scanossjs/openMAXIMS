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

package ims.nursing.vo;

/**
 * Linked to nursing.PropertyChecklist business object (ID: 1009100012).
 */
public class PropertyChecklistVo extends ims.nursing.vo.PropertyChecklistShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PropertyChecklistVo()
	{
	}
	public PropertyChecklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public PropertyChecklistVo(ims.nursing.vo.beans.PropertyChecklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.movementtype = bean.getMovementType() == null ? null : ims.nursing.vo.lookups.MovementType.buildLookup(bean.getMovementType());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.itemsretained = ims.nursing.vo.PropertyItemVoCollection.buildFromBeanCollection(bean.getItemsRetained());
		this.destinationward = bean.getDestinationWard() == null ? null : bean.getDestinationWard().buildVo();
		this.confirminghcp = bean.getConfirmingHCP() == null ? null : bean.getConfirmingHCP().buildVo();
		this.confirmingdatetime = bean.getConfirmingDateTime() == null ? null : bean.getConfirmingDateTime().buildDateTime();
		this.valuables = ims.nursing.vo.ValuableVoCollection.buildFromBeanCollection(bean.getValuables());
		this.othervaluables = bean.getOtherValuables();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PropertyChecklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.movementtype = bean.getMovementType() == null ? null : ims.nursing.vo.lookups.MovementType.buildLookup(bean.getMovementType());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.itemsretained = ims.nursing.vo.PropertyItemVoCollection.buildFromBeanCollection(bean.getItemsRetained());
		this.destinationward = bean.getDestinationWard() == null ? null : bean.getDestinationWard().buildVo(map);
		this.confirminghcp = bean.getConfirmingHCP() == null ? null : bean.getConfirmingHCP().buildVo(map);
		this.confirmingdatetime = bean.getConfirmingDateTime() == null ? null : bean.getConfirmingDateTime().buildDateTime();
		this.valuables = ims.nursing.vo.ValuableVoCollection.buildFromBeanCollection(bean.getValuables());
		this.othervaluables = bean.getOtherValuables();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PropertyChecklistVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PropertyChecklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PropertyChecklistVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("ITEMSRETAINED"))
			return getItemsRetained();
		if(fieldName.equals("DESTINATIONWARD"))
			return getDestinationWard();
		if(fieldName.equals("CONFIRMINGHCP"))
			return getConfirmingHCP();
		if(fieldName.equals("CONFIRMINGDATETIME"))
			return getConfirmingDateTime();
		if(fieldName.equals("VALUABLES"))
			return getValuables();
		if(fieldName.equals("OTHERVALUABLES"))
			return getOtherValuables();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getItemsRetainedIsNotNull()
	{
		return this.itemsretained != null;
	}
	public ims.nursing.vo.PropertyItemVoCollection getItemsRetained()
	{
		return this.itemsretained;
	}
	public void setItemsRetained(ims.nursing.vo.PropertyItemVoCollection value)
	{
		this.isValidated = false;
		this.itemsretained = value;
	}
	public boolean getDestinationWardIsNotNull()
	{
		return this.destinationward != null;
	}
	public ims.core.vo.LocShortVo getDestinationWard()
	{
		return this.destinationward;
	}
	public void setDestinationWard(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.destinationward = value;
	}
	public boolean getConfirmingHCPIsNotNull()
	{
		return this.confirminghcp != null;
	}
	public ims.core.vo.HcpLiteVo getConfirmingHCP()
	{
		return this.confirminghcp;
	}
	public void setConfirmingHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.confirminghcp = value;
	}
	public boolean getConfirmingDateTimeIsNotNull()
	{
		return this.confirmingdatetime != null;
	}
	public ims.framework.utils.DateTime getConfirmingDateTime()
	{
		return this.confirmingdatetime;
	}
	public void setConfirmingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.confirmingdatetime = value;
	}
	public boolean getValuablesIsNotNull()
	{
		return this.valuables != null;
	}
	public ims.nursing.vo.ValuableVoCollection getValuables()
	{
		return this.valuables;
	}
	public void setValuables(ims.nursing.vo.ValuableVoCollection value)
	{
		this.isValidated = false;
		this.valuables = value;
	}
	public boolean getOtherValuablesIsNotNull()
	{
		return this.othervaluables != null;
	}
	public String getOtherValuables()
	{
		return this.othervaluables;
	}
	public static int getOtherValuablesMaxLength()
	{
		return 255;
	}
	public void setOtherValuables(String value)
	{
		this.isValidated = false;
		this.othervaluables = value;
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
		if(this.authoringhcp != null)
		{
			if(!this.authoringhcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ward != null)
		{
			if(!this.ward.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.itemsretained != null)
		{
			if(!this.itemsretained.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.destinationward != null)
		{
			if(!this.destinationward.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.confirminghcp != null)
		{
			if(!this.confirminghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.valuables != null)
		{
			if(!this.valuables.isValidated())
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
		if(this.movementtype == null)
			listOfErrors.add("MovementType is mandatory");
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.authoringhcp == null)
			listOfErrors.add("AuthoringHCP is mandatory");
		if(this.authoringhcp != null)
		{
			String[] listOfOtherErrors = this.authoringhcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ward == null)
			listOfErrors.add("Ward is mandatory");
		if(this.ward != null)
		{
			String[] listOfOtherErrors = this.ward.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.itemsretained != null)
		{
			String[] listOfOtherErrors = this.itemsretained.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.destinationward != null)
		{
			String[] listOfOtherErrors = this.destinationward.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.confirminghcp != null)
		{
			String[] listOfOtherErrors = this.confirminghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.valuables != null)
		{
			String[] listOfOtherErrors = this.valuables.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.othervaluables != null)
			if(this.othervaluables.length() > 255)
				listOfErrors.add("The length of the field [othervaluables] in the value object [ims.nursing.vo.PropertyChecklistVo] is too big. It should be less or equal to 255");
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
	
		PropertyChecklistVo clone = new PropertyChecklistVo(this.id, this.version);
		
		if(this.movementtype == null)
			clone.movementtype = null;
		else
			clone.movementtype = (ims.nursing.vo.lookups.MovementType)this.movementtype.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.HcpLiteVo)this.authoringhcp.clone();
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocShortVo)this.ward.clone();
		clone.carecontext = this.carecontext;
		if(this.itemsretained == null)
			clone.itemsretained = null;
		else
			clone.itemsretained = (ims.nursing.vo.PropertyItemVoCollection)this.itemsretained.clone();
		if(this.destinationward == null)
			clone.destinationward = null;
		else
			clone.destinationward = (ims.core.vo.LocShortVo)this.destinationward.clone();
		if(this.confirminghcp == null)
			clone.confirminghcp = null;
		else
			clone.confirminghcp = (ims.core.vo.HcpLiteVo)this.confirminghcp.clone();
		if(this.confirmingdatetime == null)
			clone.confirmingdatetime = null;
		else
			clone.confirmingdatetime = (ims.framework.utils.DateTime)this.confirmingdatetime.clone();
		if(this.valuables == null)
			clone.valuables = null;
		else
			clone.valuables = (ims.nursing.vo.ValuableVoCollection)this.valuables.clone();
		clone.othervaluables = this.othervaluables;
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
		if (!(PropertyChecklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PropertyChecklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PropertyChecklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PropertyChecklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.carecontext != null)
			count++;
		if(this.itemsretained != null)
			count++;
		if(this.destinationward != null)
			count++;
		if(this.confirminghcp != null)
			count++;
		if(this.confirmingdatetime != null)
			count++;
		if(this.valuables != null)
			count++;
		if(this.othervaluables != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.nursing.vo.PropertyItemVoCollection itemsretained;
	protected ims.core.vo.LocShortVo destinationward;
	protected ims.core.vo.HcpLiteVo confirminghcp;
	protected ims.framework.utils.DateTime confirmingdatetime;
	protected ims.nursing.vo.ValuableVoCollection valuables;
	protected String othervaluables;
	private boolean isValidated = false;
	private boolean isBusy = false;
}