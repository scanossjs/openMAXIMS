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

package ims.RefMan.vo.beans;

public class AdmissionDetailForCodingListVoBean extends ims.vo.ValueObjectBean
{
	public AdmissionDetailForCodingListVoBean()
	{
	}
	public AdmissionDetailForCodingListVoBean(ims.RefMan.vo.AdmissionDetailForCodingListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean)vo.getPasEvent().getBean();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.AdmissionDetailForCodingListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean)vo.getPasEvent().getBean(map);
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
	}

	public ims.RefMan.vo.AdmissionDetailForCodingListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.AdmissionDetailForCodingListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.AdmissionDetailForCodingListVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.AdmissionDetailForCodingListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.AdmissionDetailForCodingListVo();
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
	public ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargedatetime = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}

	private Integer id;
	private int version;
	private ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean dischargedatetime;
	private ims.vo.RefVoBean carecontext;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
}