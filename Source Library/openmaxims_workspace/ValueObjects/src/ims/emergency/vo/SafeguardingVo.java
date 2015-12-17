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

package ims.emergency.vo;

/**
 * Linked to emergency.Safeguarding business object (ID: 1086100046).
 */
public class SafeguardingVo extends ims.emergency.vo.SafeguardingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SafeguardingVo()
	{
	}
	public SafeguardingVo(Integer id, int version)
	{
		super(id, version);
	}
	public SafeguardingVo(ims.emergency.vo.beans.SafeguardingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.nameofotheradultsinhouse = bean.getNameOfOtherAdultsInHouse();
		this.socialworkers = bean.getSocialWorkers();
		this.comments = bean.getComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.SafeguardingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.nameofotheradultsinhouse = bean.getNameOfOtherAdultsInHouse();
		this.socialworkers = bean.getSocialWorkers();
		this.comments = bean.getComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.SafeguardingVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.SafeguardingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.SafeguardingVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("NAMEOFOTHERADULTSINHOUSE"))
			return getNameOfOtherAdultsInHouse();
		if(fieldName.equals("SOCIALWORKERS"))
			return getSocialWorkers();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getNameOfOtherAdultsInHouseIsNotNull()
	{
		return this.nameofotheradultsinhouse != null;
	}
	public String getNameOfOtherAdultsInHouse()
	{
		return this.nameofotheradultsinhouse;
	}
	public static int getNameOfOtherAdultsInHouseMaxLength()
	{
		return 500;
	}
	public void setNameOfOtherAdultsInHouse(String value)
	{
		this.isValidated = false;
		this.nameofotheradultsinhouse = value;
	}
	public boolean getSocialWorkersIsNotNull()
	{
		return this.socialworkers != null;
	}
	public String getSocialWorkers()
	{
		return this.socialworkers;
	}
	public static int getSocialWorkersMaxLength()
	{
		return 500;
	}
	public void setSocialWorkers(String value)
	{
		this.isValidated = false;
		this.socialworkers = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.nameofotheradultsinhouse != null)
			if(this.nameofotheradultsinhouse.length() > 500)
				listOfErrors.add("The length of the field [nameofotheradultsinhouse] in the value object [ims.emergency.vo.SafeguardingVo] is too big. It should be less or equal to 500");
		if(this.socialworkers != null)
			if(this.socialworkers.length() > 500)
				listOfErrors.add("The length of the field [socialworkers] in the value object [ims.emergency.vo.SafeguardingVo] is too big. It should be less or equal to 500");
		if(this.comments != null)
			if(this.comments.length() > 500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.emergency.vo.SafeguardingVo] is too big. It should be less or equal to 500");
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
	
		SafeguardingVo clone = new SafeguardingVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
		clone.nameofotheradultsinhouse = this.nameofotheradultsinhouse;
		clone.socialworkers = this.socialworkers;
		clone.comments = this.comments;
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
		if (!(SafeguardingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SafeguardingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SafeguardingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SafeguardingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.nameofotheradultsinhouse != null)
			count++;
		if(this.socialworkers != null)
			count++;
		if(this.comments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected String nameofotheradultsinhouse;
	protected String socialworkers;
	protected String comments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}