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

package ims.core.vo;

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientManuallyAssembledVo extends ims.core.patient.vo.PatientRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientManuallyAssembledVo()
	{
	}
	public PatientManuallyAssembledVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientManuallyAssembledVo(ims.core.vo.beans.PatientManuallyAssembledVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.sex = bean.getSex();
		this.displayid = bean.getDisplayID();
		this.hascommunicationchannel = bean.getHasCommunicationChannel();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientManuallyAssembledVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.sex = bean.getSex();
		this.displayid = bean.getDisplayID();
		this.hascommunicationchannel = bean.getHasCommunicationChannel();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientManuallyAssembledVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientManuallyAssembledVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientManuallyAssembledVoBean();
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
		if(fieldName.equals("DOB"))
			return getDob();
		if(fieldName.equals("SURNAME"))
			return getSurname();
		if(fieldName.equals("FORENAME"))
			return getForename();
		if(fieldName.equals("SEX"))
			return getSex();
		if(fieldName.equals("DISPLAYID"))
			return getDisplayID();
		if(fieldName.equals("HASCOMMUNICATIONCHANNEL"))
			return getHasCommunicationChannel();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDobIsNotNull()
	{
		return this.dob != null;
	}
	public ims.framework.utils.PartialDate getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.dob = value;
	}
	public boolean getSurnameIsNotNull()
	{
		return this.surname != null;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public static int getSurnameMaxLength()
	{
		return 255;
	}
	public void setSurname(String value)
	{
		this.isValidated = false;
		this.surname = value;
	}
	public boolean getForenameIsNotNull()
	{
		return this.forename != null;
	}
	public String getForename()
	{
		return this.forename;
	}
	public static int getForenameMaxLength()
	{
		return 255;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getSexIsNotNull()
	{
		return this.sex != null;
	}
	public String getSex()
	{
		return this.sex;
	}
	public static int getSexMaxLength()
	{
		return 255;
	}
	public void setSex(String value)
	{
		this.isValidated = false;
		this.sex = value;
	}
	public boolean getDisplayIDIsNotNull()
	{
		return this.displayid != null;
	}
	public String getDisplayID()
	{
		return this.displayid;
	}
	public static int getDisplayIDMaxLength()
	{
		return 255;
	}
	public void setDisplayID(String value)
	{
		this.isValidated = false;
		this.displayid = value;
	}
	public boolean getHasCommunicationChannelIsNotNull()
	{
		return this.hascommunicationchannel != null;
	}
	public Boolean getHasCommunicationChannel()
	{
		return this.hascommunicationchannel;
	}
	public void setHasCommunicationChannel(Boolean value)
	{
		this.isValidated = false;
		this.hascommunicationchannel = value;
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
	
		PatientManuallyAssembledVo clone = new PatientManuallyAssembledVo(this.id, this.version);
		
		if(this.dob == null)
			clone.dob = null;
		else
			clone.dob = (ims.framework.utils.PartialDate)this.dob.clone();
		clone.surname = this.surname;
		clone.forename = this.forename;
		clone.sex = this.sex;
		clone.displayid = this.displayid;
		clone.hascommunicationchannel = this.hascommunicationchannel;
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
		if (!(PatientManuallyAssembledVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientManuallyAssembledVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientManuallyAssembledVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientManuallyAssembledVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.dob != null)
			count++;
		if(this.surname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.sex != null)
			count++;
		if(this.displayid != null)
			count++;
		if(this.hascommunicationchannel != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.PartialDate dob;
	protected String surname;
	protected String forename;
	protected String sex;
	protected String displayid;
	protected Boolean hascommunicationchannel;
	private boolean isValidated = false;
	private boolean isBusy = false;
}