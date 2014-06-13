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

package ims.core.vo.beans;

public class InpatientEpisodeVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeVoBean()
	{
	}
	public InpatientEpisodeVoBean(ims.core.vo.InpatientEpisodeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.isonleave = vo.getIsOnLeave();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventVoBean)vo.getPasEvent().getBean();
		this.comments = vo.getComments();
		this.wardstays = vo.getWardStays() == null ? null : vo.getWardStays().getBeanCollection();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
		this.bedno = vo.getBedNo();
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.ismaternityinpatient = vo.getIsMaternityInpatient();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.sourceofadmission = vo.getSourceOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfAdmission().getBean();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.preadmitnumber = vo.getPreAdmitNumber();
		this.readmissiontype = vo.getReadmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReadmissionType().getBean();
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.homeleaves = vo.getHomeLeaves() == null ? null : vo.getHomeLeaves().getBeanCollection();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.extendeddetails = vo.getExtendedDetails() == null ? null : (ims.core.vo.beans.ExtendedAdmissionDetailVoBean)vo.getExtendedDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.InpatientEpisodeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.isonleave = vo.getIsOnLeave();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventVoBean)vo.getPasEvent().getBean(map);
		this.comments = vo.getComments();
		this.wardstays = vo.getWardStays() == null ? null : vo.getWardStays().getBeanCollection();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
		this.bedno = vo.getBedNo();
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.ismaternityinpatient = vo.getIsMaternityInpatient();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.sourceofadmission = vo.getSourceOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfAdmission().getBean();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.preadmitnumber = vo.getPreAdmitNumber();
		this.readmissiontype = vo.getReadmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReadmissionType().getBean();
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.homeleaves = vo.getHomeLeaves() == null ? null : vo.getHomeLeaves().getBeanCollection();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.extendeddetails = vo.getExtendedDetails() == null ? null : (ims.core.vo.beans.ExtendedAdmissionDetailVoBean)vo.getExtendedDetails().getBean(map);
	}

	public ims.core.vo.InpatientEpisodeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.InpatientEpisodeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.InpatientEpisodeVo vo = null;
		if(map != null)
			vo = (ims.core.vo.InpatientEpisodeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.InpatientEpisodeVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public Boolean getIsOnLeave()
	{
		return this.isonleave;
	}
	public void setIsOnLeave(Boolean value)
	{
		this.isonleave = value;
	}
	public ims.core.vo.beans.PasEventVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventVoBean value)
	{
		this.pasevent = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.core.vo.beans.WardStayVoBean[] getWardStays()
	{
		return this.wardstays;
	}
	public void setWardStays(ims.core.vo.beans.WardStayVoBean[] value)
	{
		this.wardstays = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.framework.utils.beans.DateBean getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.estdischargedate = value;
	}
	public String getBedNo()
	{
		return this.bedno;
	}
	public void setBedNo(String value)
	{
		this.bedno = value;
	}
	public ims.vo.LookupInstanceBean getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.vo.LookupInstanceBean value)
	{
		this.admissiontype = value;
	}
	public Boolean getIsMaternityInpatient()
	{
		return this.ismaternityinpatient;
	}
	public void setIsMaternityInpatient(Boolean value)
	{
		this.ismaternityinpatient = value;
	}
	public Boolean getIsChaplainRequired()
	{
		return this.ischaplainrequired;
	}
	public void setIsChaplainRequired(Boolean value)
	{
		this.ischaplainrequired = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfAdmission()
	{
		return this.methodofadmission;
	}
	public void setMethodOfAdmission(ims.vo.LookupInstanceBean value)
	{
		this.methodofadmission = value;
	}
	public String getReasonForAdmission()
	{
		return this.reasonforadmission;
	}
	public void setReasonForAdmission(String value)
	{
		this.reasonforadmission = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfAdmission()
	{
		return this.sourceofadmission;
	}
	public void setSourceOfAdmission(ims.vo.LookupInstanceBean value)
	{
		this.sourceofadmission = value;
	}
	public ims.vo.LookupInstanceBean getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.vo.LookupInstanceBean value)
	{
		this.wardtype = value;
	}
	public String getPreAdmitNumber()
	{
		return this.preadmitnumber;
	}
	public void setPreAdmitNumber(String value)
	{
		this.preadmitnumber = value;
	}
	public ims.vo.LookupInstanceBean getReadmissionType()
	{
		return this.readmissiontype;
	}
	public void setReadmissionType(ims.vo.LookupInstanceBean value)
	{
		this.readmissiontype = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeReadyDate()
	{
		return this.dischargereadydate;
	}
	public void setDischargeReadyDate(ims.framework.utils.beans.DateBean value)
	{
		this.dischargereadydate = value;
	}
	public ims.core.vo.beans.HomeLeaveVoBean[] getHomeLeaves()
	{
		return this.homeleaves;
	}
	public void setHomeLeaves(ims.core.vo.beans.HomeLeaveVoBean[] value)
	{
		this.homeleaves = value;
	}
	public ims.vo.LookupInstanceBean getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientstatus = value;
	}
	public ims.core.vo.beans.ExtendedAdmissionDetailVoBean getExtendedDetails()
	{
		return this.extendeddetails;
	}
	public void setExtendedDetails(ims.core.vo.beans.ExtendedAdmissionDetailVoBean value)
	{
		this.extendeddetails = value;
	}

	private Integer id;
	private int version;
	private Boolean isonleave;
	private ims.core.vo.beans.PasEventVoBean pasevent;
	private String comments;
	private ims.core.vo.beans.WardStayVoBean[] wardstays;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.framework.utils.beans.DateBean estdischargedate;
	private String bedno;
	private ims.vo.LookupInstanceBean admissiontype;
	private Boolean ismaternityinpatient;
	private Boolean ischaplainrequired;
	private ims.vo.LookupInstanceBean methodofadmission;
	private String reasonforadmission;
	private ims.vo.LookupInstanceBean sourceofadmission;
	private ims.vo.LookupInstanceBean wardtype;
	private String preadmitnumber;
	private ims.vo.LookupInstanceBean readmissiontype;
	private ims.framework.utils.beans.DateBean dischargereadydate;
	private ims.core.vo.beans.HomeLeaveVoBean[] homeleaves;
	private ims.vo.LookupInstanceBean patientstatus;
	private ims.core.vo.beans.ExtendedAdmissionDetailVoBean extendeddetails;
}