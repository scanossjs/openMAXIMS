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

/**
 * Linked to core.clinical.IntraOperativeCareRecord business object (ID: 1072100081).
 */
public class IntraOperativeCareRecordLiteVo extends ims.core.clinical.vo.IntraOperativeCareRecordRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IntraOperativeCareRecordLiteVo()
	{
	}
	public IntraOperativeCareRecordLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public IntraOperativeCareRecordLiteVo(ims.clinical.vo.beans.IntraOperativeCareRecordLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.actualprocedure = bean.getActualProcedure() == null ? null : bean.getActualProcedure().buildVo();
		this.proceduredate = bean.getProcedureDate() == null ? null : bean.getProcedureDate().buildDate();
		this.theatre = bean.getTheatre() == null ? null : bean.getTheatre().buildVo();
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.IntraOperativeCareRecordLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.actualprocedure = bean.getActualProcedure() == null ? null : bean.getActualProcedure().buildVo(map);
		this.proceduredate = bean.getProcedureDate() == null ? null : bean.getProcedureDate().buildDate();
		this.theatre = bean.getTheatre() == null ? null : bean.getTheatre().buildVo(map);
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.IntraOperativeCareRecordLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.IntraOperativeCareRecordLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.IntraOperativeCareRecordLiteVoBean();
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
		if(fieldName.equals("ACTUALPROCEDURE"))
			return getActualProcedure();
		if(fieldName.equals("PROCEDUREDATE"))
			return getProcedureDate();
		if(fieldName.equals("THEATRE"))
			return getTheatre();
		if(fieldName.equals("SURGEON"))
			return getSurgeon();
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
	public boolean getActualProcedureIsNotNull()
	{
		return this.actualprocedure != null;
	}
	public ims.core.vo.PatientProcedureForSurgicalOperationNotesVo getActualProcedure()
	{
		return this.actualprocedure;
	}
	public void setActualProcedure(ims.core.vo.PatientProcedureForSurgicalOperationNotesVo value)
	{
		this.isValidated = false;
		this.actualprocedure = value;
	}
	public boolean getProcedureDateIsNotNull()
	{
		return this.proceduredate != null;
	}
	public ims.framework.utils.Date getProcedureDate()
	{
		return this.proceduredate;
	}
	public void setProcedureDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.proceduredate = value;
	}
	public boolean getTheatreIsNotNull()
	{
		return this.theatre != null;
	}
	public ims.core.vo.LocationLiteVo getTheatre()
	{
		return this.theatre;
	}
	public void setTheatre(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.theatre = value;
	}
	public boolean getSurgeonIsNotNull()
	{
		return this.surgeon != null;
	}
	public ims.core.vo.HcpLiteVo getSurgeon()
	{
		return this.surgeon;
	}
	public void setSurgeon(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.surgeon = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.actualprocedure == null)
			listOfErrors.add("ActualProcedure is mandatory");
		if(this.proceduredate == null)
			listOfErrors.add("ProcedureDate is mandatory");
		if(this.theatre == null)
			listOfErrors.add("Theatre is mandatory");
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
	
		IntraOperativeCareRecordLiteVo clone = new IntraOperativeCareRecordLiteVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.actualprocedure == null)
			clone.actualprocedure = null;
		else
			clone.actualprocedure = (ims.core.vo.PatientProcedureForSurgicalOperationNotesVo)this.actualprocedure.clone();
		if(this.proceduredate == null)
			clone.proceduredate = null;
		else
			clone.proceduredate = (ims.framework.utils.Date)this.proceduredate.clone();
		if(this.theatre == null)
			clone.theatre = null;
		else
			clone.theatre = (ims.core.vo.LocationLiteVo)this.theatre.clone();
		if(this.surgeon == null)
			clone.surgeon = null;
		else
			clone.surgeon = (ims.core.vo.HcpLiteVo)this.surgeon.clone();
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
		if (!(IntraOperativeCareRecordLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IntraOperativeCareRecordLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IntraOperativeCareRecordLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IntraOperativeCareRecordLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.actualprocedure != null)
			count++;
		if(this.proceduredate != null)
			count++;
		if(this.theatre != null)
			count++;
		if(this.surgeon != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.PatientProcedureForSurgicalOperationNotesVo actualprocedure;
	protected ims.framework.utils.Date proceduredate;
	protected ims.core.vo.LocationLiteVo theatre;
	protected ims.core.vo.HcpLiteVo surgeon;
	private boolean isValidated = false;
	private boolean isBusy = false;
}