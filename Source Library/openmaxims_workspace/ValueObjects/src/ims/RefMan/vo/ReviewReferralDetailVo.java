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

/**
 * Linked to RefMan.ReviewReferralDetail business object (ID: 1096100019).
 */
public class ReviewReferralDetailVo extends ims.RefMan.vo.ReviewReferralDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReviewReferralDetailVo()
	{
	}
	public ReviewReferralDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReviewReferralDetailVo(ims.RefMan.vo.beans.ReviewReferralDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reviewtype = bean.getReviewType() == null ? null : ims.RefMan.vo.lookups.ReviewType.buildLookup(bean.getReviewType());
		this.reasonnotes = bean.getReasonNotes();
		this.revieweddate = bean.getReviewedDate() == null ? null : bean.getReviewedDate().buildDateTime();
		this.reviewedby = bean.getReviewedBy() == null ? null : bean.getReviewedBy().buildVo();
		this.reviewnotes = bean.getReviewNotes();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ReviewReferralDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reviewtype = bean.getReviewType() == null ? null : ims.RefMan.vo.lookups.ReviewType.buildLookup(bean.getReviewType());
		this.reasonnotes = bean.getReasonNotes();
		this.revieweddate = bean.getReviewedDate() == null ? null : bean.getReviewedDate().buildDateTime();
		this.reviewedby = bean.getReviewedBy() == null ? null : bean.getReviewedBy().buildVo(map);
		this.reviewnotes = bean.getReviewNotes();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ReviewReferralDetailVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ReviewReferralDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ReviewReferralDetailVoBean();
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
		if(fieldName.equals("REVIEWTYPE"))
			return getReviewType();
		if(fieldName.equals("REASONNOTES"))
			return getReasonNotes();
		if(fieldName.equals("REVIEWEDDATE"))
			return getReviewedDate();
		if(fieldName.equals("REVIEWEDBY"))
			return getReviewedBy();
		if(fieldName.equals("REVIEWNOTES"))
			return getReviewNotes();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("RECORDINGUSER"))
			return getRecordingUser();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReviewTypeIsNotNull()
	{
		return this.reviewtype != null;
	}
	public ims.RefMan.vo.lookups.ReviewType getReviewType()
	{
		return this.reviewtype;
	}
	public void setReviewType(ims.RefMan.vo.lookups.ReviewType value)
	{
		this.isValidated = false;
		this.reviewtype = value;
	}
	public boolean getReasonNotesIsNotNull()
	{
		return this.reasonnotes != null;
	}
	public String getReasonNotes()
	{
		return this.reasonnotes;
	}
	public static int getReasonNotesMaxLength()
	{
		return 255;
	}
	public void setReasonNotes(String value)
	{
		this.isValidated = false;
		this.reasonnotes = value;
	}
	public boolean getReviewedDateIsNotNull()
	{
		return this.revieweddate != null;
	}
	public ims.framework.utils.DateTime getReviewedDate()
	{
		return this.revieweddate;
	}
	public void setReviewedDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.revieweddate = value;
	}
	public boolean getReviewedByIsNotNull()
	{
		return this.reviewedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getReviewedBy()
	{
		return this.reviewedby;
	}
	public void setReviewedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.reviewedby = value;
	}
	public boolean getReviewNotesIsNotNull()
	{
		return this.reviewnotes != null;
	}
	public String getReviewNotes()
	{
		return this.reviewnotes;
	}
	public static int getReviewNotesMaxLength()
	{
		return 255;
	}
	public void setReviewNotes(String value)
	{
		this.isValidated = false;
		this.reviewnotes = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getRecordingUserIsNotNull()
	{
		return this.recordinguser != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.recordinguser = value;
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
		if(this.reviewtype == null)
			listOfErrors.add("Type is mandatory");
		if(this.reasonnotes != null)
			if(this.reasonnotes.length() > 255)
				listOfErrors.add("The length of the field [reasonnotes] in the value object [ims.RefMan.vo.ReviewReferralDetailVo] is too big. It should be less or equal to 255");
		if(this.reviewnotes != null)
			if(this.reviewnotes.length() > 255)
				listOfErrors.add("The length of the field [reviewnotes] in the value object [ims.RefMan.vo.ReviewReferralDetailVo] is too big. It should be less or equal to 255");
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
	
		ReviewReferralDetailVo clone = new ReviewReferralDetailVo(this.id, this.version);
		
		if(this.reviewtype == null)
			clone.reviewtype = null;
		else
			clone.reviewtype = (ims.RefMan.vo.lookups.ReviewType)this.reviewtype.clone();
		clone.reasonnotes = this.reasonnotes;
		if(this.revieweddate == null)
			clone.revieweddate = null;
		else
			clone.revieweddate = (ims.framework.utils.DateTime)this.revieweddate.clone();
		if(this.reviewedby == null)
			clone.reviewedby = null;
		else
			clone.reviewedby = (ims.core.vo.MemberOfStaffLiteVo)this.reviewedby.clone();
		clone.reviewnotes = this.reviewnotes;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.recordinguser == null)
			clone.recordinguser = null;
		else
			clone.recordinguser = (ims.core.vo.MemberOfStaffLiteVo)this.recordinguser.clone();
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
		if (!(ReviewReferralDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReviewReferralDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReviewReferralDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReviewReferralDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.reviewtype != null)
			count++;
		if(this.reasonnotes != null)
			count++;
		if(this.revieweddate != null)
			count++;
		if(this.reviewedby != null)
			count++;
		if(this.reviewnotes != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.recordinguser != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.RefMan.vo.lookups.ReviewType reviewtype;
	protected String reasonnotes;
	protected ims.framework.utils.DateTime revieweddate;
	protected ims.core.vo.MemberOfStaffLiteVo reviewedby;
	protected String reviewnotes;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.vo.MemberOfStaffLiteVo recordinguser;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
