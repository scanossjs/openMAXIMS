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

package ims.emergency.vo.beans;

public class EDClinicDetailsVoBean extends ims.vo.ValueObjectBean
{
	public EDClinicDetailsVoBean()
	{
	}
	public EDClinicDetailsVoBean(ims.emergency.vo.EDClinicDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.reasonforreferral = vo.getReasonForReferral();
		this.physicaldocumentstobesent = vo.getPhysicalDocumentsToBeSent();
		this.comment = vo.getComment();
		this.specialty = vo.getSpecialty() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getSpecialty().getBean();
		this.edclinicappt = vo.getEDClinicAppt() == null ? null : new ims.vo.RefVoBean(vo.getEDClinicAppt().getBoId(), vo.getEDClinicAppt().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EDClinicDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.reasonforreferral = vo.getReasonForReferral();
		this.physicaldocumentstobesent = vo.getPhysicalDocumentsToBeSent();
		this.comment = vo.getComment();
		this.specialty = vo.getSpecialty() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getSpecialty().getBean(map);
		this.edclinicappt = vo.getEDClinicAppt() == null ? null : new ims.vo.RefVoBean(vo.getEDClinicAppt().getBoId(), vo.getEDClinicAppt().getBoVersion());
	}

	public ims.emergency.vo.EDClinicDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EDClinicDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EDClinicDetailsVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EDClinicDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EDClinicDetailsVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.vo.RefVoBean value)
	{
		this.episode = value;
	}
	public ims.vo.RefVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.vo.RefVoBean value)
	{
		this.attendance = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public String getReasonForReferral()
	{
		return this.reasonforreferral;
	}
	public void setReasonForReferral(String value)
	{
		this.reasonforreferral = value;
	}
	public Boolean getPhysicalDocumentsToBeSent()
	{
		return this.physicaldocumentstobesent;
	}
	public void setPhysicalDocumentsToBeSent(Boolean value)
	{
		this.physicaldocumentstobesent = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.core.vo.beans.ServiceShortVoBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.beans.ServiceShortVoBean value)
	{
		this.specialty = value;
	}
	public ims.vo.RefVoBean getEDClinicAppt()
	{
		return this.edclinicappt;
	}
	public void setEDClinicAppt(ims.vo.RefVoBean value)
	{
		this.edclinicappt = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episode;
	private ims.vo.RefVoBean attendance;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private String reasonforreferral;
	private Boolean physicaldocumentstobesent;
	private String comment;
	private ims.core.vo.beans.ServiceShortVoBean specialty;
	private ims.vo.RefVoBean edclinicappt;
}
