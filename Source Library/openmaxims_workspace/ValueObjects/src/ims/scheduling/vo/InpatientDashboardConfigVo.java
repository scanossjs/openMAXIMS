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

package ims.scheduling.vo;

/**
 * Linked to core.admin.InpatientDashboardConfig business object (ID: 1004100080).
 */
public class InpatientDashboardConfigVo extends ims.core.admin.vo.InpatientDashboardConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InpatientDashboardConfigVo()
	{
	}
	public InpatientDashboardConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public InpatientDashboardConfigVo(ims.scheduling.vo.beans.InpatientDashboardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.warddeptname = bean.getWardDeptName();
		this.category = bean.getCategory() == null ? null : ims.admin.vo.lookups.WardDeptCategory.buildLookup(bean.getCategory());
		this.wardlocations = ims.core.vo.LocationLiteVoCollection.buildFromBeanCollection(bean.getWardLocations());
		this.isactive = bean.getIsActive();
		this.sequenceno = bean.getSequenceNo();
		this.red = bean.getRed();
		this.green = bean.getGreen();
		this.blue = bean.getBlue();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.InpatientDashboardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.warddeptname = bean.getWardDeptName();
		this.category = bean.getCategory() == null ? null : ims.admin.vo.lookups.WardDeptCategory.buildLookup(bean.getCategory());
		this.wardlocations = ims.core.vo.LocationLiteVoCollection.buildFromBeanCollection(bean.getWardLocations());
		this.isactive = bean.getIsActive();
		this.sequenceno = bean.getSequenceNo();
		this.red = bean.getRed();
		this.green = bean.getGreen();
		this.blue = bean.getBlue();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.InpatientDashboardConfigVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.InpatientDashboardConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.InpatientDashboardConfigVoBean();
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
		if(fieldName.equals("WARDDEPTNAME"))
			return getWardDeptName();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("WARDLOCATIONS"))
			return getWardLocations();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("SEQUENCENO"))
			return getSequenceNo();
		if(fieldName.equals("RED"))
			return getRed();
		if(fieldName.equals("GREEN"))
			return getGreen();
		if(fieldName.equals("BLUE"))
			return getBlue();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWardDeptNameIsNotNull()
	{
		return this.warddeptname != null;
	}
	public String getWardDeptName()
	{
		return this.warddeptname;
	}
	public static int getWardDeptNameMaxLength()
	{
		return 125;
	}
	public void setWardDeptName(String value)
	{
		this.isValidated = false;
		this.warddeptname = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.admin.vo.lookups.WardDeptCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.admin.vo.lookups.WardDeptCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getWardLocationsIsNotNull()
	{
		return this.wardlocations != null;
	}
	public ims.core.vo.LocationLiteVoCollection getWardLocations()
	{
		return this.wardlocations;
	}
	public void setWardLocations(ims.core.vo.LocationLiteVoCollection value)
	{
		this.isValidated = false;
		this.wardlocations = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getSequenceNoIsNotNull()
	{
		return this.sequenceno != null;
	}
	public Integer getSequenceNo()
	{
		return this.sequenceno;
	}
	public void setSequenceNo(Integer value)
	{
		this.isValidated = false;
		this.sequenceno = value;
	}
	public boolean getRedIsNotNull()
	{
		return this.red != null;
	}
	public Integer getRed()
	{
		return this.red;
	}
	public void setRed(Integer value)
	{
		this.isValidated = false;
		this.red = value;
	}
	public boolean getGreenIsNotNull()
	{
		return this.green != null;
	}
	public Integer getGreen()
	{
		return this.green;
	}
	public void setGreen(Integer value)
	{
		this.isValidated = false;
		this.green = value;
	}
	public boolean getBlueIsNotNull()
	{
		return this.blue != null;
	}
	public Integer getBlue()
	{
		return this.blue;
	}
	public void setBlue(Integer value)
	{
		this.isValidated = false;
		this.blue = value;
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
		if(this.warddeptname == null || this.warddeptname.length() == 0)
			listOfErrors.add("Ward/Dept Name is mandatory");
		else if(this.warddeptname.length() > 125)
			listOfErrors.add("The length of the field [warddeptname] in the value object [ims.scheduling.vo.InpatientDashboardConfigVo] is too big. It should be less or equal to 125");
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.wardlocations == null || this.wardlocations.size() == 0)
			listOfErrors.add("Ward Locations are mandatory");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
		if(this.sequenceno == null)
			listOfErrors.add("SequenceNo is mandatory");
		if(this.red == null)
			listOfErrors.add("Red is mandatory");
		if(this.green == null)
			listOfErrors.add("Green is mandatory");
		if(this.blue == null)
			listOfErrors.add("Blue is mandatory");
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
	
		InpatientDashboardConfigVo clone = new InpatientDashboardConfigVo(this.id, this.version);
		
		clone.warddeptname = this.warddeptname;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.admin.vo.lookups.WardDeptCategory)this.category.clone();
		if(this.wardlocations == null)
			clone.wardlocations = null;
		else
			clone.wardlocations = (ims.core.vo.LocationLiteVoCollection)this.wardlocations.clone();
		clone.isactive = this.isactive;
		clone.sequenceno = this.sequenceno;
		clone.red = this.red;
		clone.green = this.green;
		clone.blue = this.blue;
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
		if (!(InpatientDashboardConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InpatientDashboardConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InpatientDashboardConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InpatientDashboardConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.warddeptname != null)
			count++;
		if(this.category != null)
			count++;
		if(this.wardlocations != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.sequenceno != null)
			count++;
		if(this.red != null)
			count++;
		if(this.green != null)
			count++;
		if(this.blue != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected String warddeptname;
	protected ims.admin.vo.lookups.WardDeptCategory category;
	protected ims.core.vo.LocationLiteVoCollection wardlocations;
	protected Boolean isactive;
	protected Integer sequenceno;
	protected Integer red;
	protected Integer green;
	protected Integer blue;
	private boolean isValidated = false;
	private boolean isBusy = false;
}