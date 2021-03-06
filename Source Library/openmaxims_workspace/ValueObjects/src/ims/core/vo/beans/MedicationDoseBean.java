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

package ims.core.vo.beans;

public class MedicationDoseBean extends ims.vo.ValueObjectBean
{
	public MedicationDoseBean()
	{
	}
	public MedicationDoseBean(ims.core.vo.MedicationDose vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dose = vo.getDose();
		this.whentaken = vo.getWhenTaken();
		this.adminroute = vo.getAdminRoute() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdminRoute().getBean();
		this.duration = vo.getDuration();
		this.durationunits = vo.getDurationUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getDurationUnits().getBean();
		this.doseunit = vo.getDoseUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDoseUnit().getBean();
		this.admintimes = vo.getAdminTimes() == null ? null : vo.getAdminTimes().getBeanCollection();
		this.dosestarthcp = vo.getDoseStartHcp() == null ? null : (ims.core.vo.beans.HcpBean)vo.getDoseStartHcp().getBean();
		this.dosestartdate = vo.getDoseStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDoseStartDate().getBean();
		this.isstopped = vo.getIsStopped();
		this.isstoppeddate = vo.getIsStoppedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getIsStoppedDate().getBean();
		this.isstoppedhcp = vo.getIsStoppedHcp() == null ? null : (ims.core.vo.beans.HcpBean)vo.getIsStoppedHcp().getBean();
		this.isstoppedreason = vo.getIsStoppedReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getIsStoppedReason().getBean();
		this.isstoppedreasontext = vo.getIsStoppedReasonText();
		this.iscopied = vo.getIsCopied();
		this.commencedbytype = vo.getCommencedByType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCommencedByType().getBean();
		this.stoppedbytype = vo.getStoppedByType() == null ? null : (ims.vo.LookupInstanceBean)vo.getStoppedByType().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.comment = vo.getComment();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.MedicationDose vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dose = vo.getDose();
		this.whentaken = vo.getWhenTaken();
		this.adminroute = vo.getAdminRoute() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdminRoute().getBean();
		this.duration = vo.getDuration();
		this.durationunits = vo.getDurationUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getDurationUnits().getBean();
		this.doseunit = vo.getDoseUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDoseUnit().getBean();
		this.admintimes = vo.getAdminTimes() == null ? null : vo.getAdminTimes().getBeanCollection();
		this.dosestarthcp = vo.getDoseStartHcp() == null ? null : (ims.core.vo.beans.HcpBean)vo.getDoseStartHcp().getBean(map);
		this.dosestartdate = vo.getDoseStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDoseStartDate().getBean();
		this.isstopped = vo.getIsStopped();
		this.isstoppeddate = vo.getIsStoppedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getIsStoppedDate().getBean();
		this.isstoppedhcp = vo.getIsStoppedHcp() == null ? null : (ims.core.vo.beans.HcpBean)vo.getIsStoppedHcp().getBean(map);
		this.isstoppedreason = vo.getIsStoppedReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getIsStoppedReason().getBean();
		this.isstoppedreasontext = vo.getIsStoppedReasonText();
		this.iscopied = vo.getIsCopied();
		this.commencedbytype = vo.getCommencedByType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCommencedByType().getBean();
		this.stoppedbytype = vo.getStoppedByType() == null ? null : (ims.vo.LookupInstanceBean)vo.getStoppedByType().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.comment = vo.getComment();
	}

	public ims.core.vo.MedicationDose buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.MedicationDose buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.MedicationDose vo = null;
		if(map != null)
			vo = (ims.core.vo.MedicationDose)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.MedicationDose();
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
	public String getDose()
	{
		return this.dose;
	}
	public void setDose(String value)
	{
		this.dose = value;
	}
	public String getWhenTaken()
	{
		return this.whentaken;
	}
	public void setWhenTaken(String value)
	{
		this.whentaken = value;
	}
	public ims.vo.LookupInstanceBean getAdminRoute()
	{
		return this.adminroute;
	}
	public void setAdminRoute(ims.vo.LookupInstanceBean value)
	{
		this.adminroute = value;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.duration = value;
	}
	public ims.vo.LookupInstanceBean getDurationUnits()
	{
		return this.durationunits;
	}
	public void setDurationUnits(ims.vo.LookupInstanceBean value)
	{
		this.durationunits = value;
	}
	public ims.vo.LookupInstanceBean getDoseUnit()
	{
		return this.doseunit;
	}
	public void setDoseUnit(ims.vo.LookupInstanceBean value)
	{
		this.doseunit = value;
	}
	public java.util.Collection getAdminTimes()
	{
		return this.admintimes;
	}
	public void setAdminTimes(java.util.Collection value)
	{
		this.admintimes = value;
	}
	public void addAdminTimes(java.util.Collection value)
	{
		if(this.admintimes == null)
			this.admintimes = new java.util.ArrayList();
		this.admintimes.add(value);
	}
	public ims.core.vo.beans.HcpBean getDoseStartHcp()
	{
		return this.dosestarthcp;
	}
	public void setDoseStartHcp(ims.core.vo.beans.HcpBean value)
	{
		this.dosestarthcp = value;
	}
	public ims.framework.utils.beans.DateBean getDoseStartDate()
	{
		return this.dosestartdate;
	}
	public void setDoseStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.dosestartdate = value;
	}
	public Boolean getIsStopped()
	{
		return this.isstopped;
	}
	public void setIsStopped(Boolean value)
	{
		this.isstopped = value;
	}
	public ims.framework.utils.beans.DateBean getIsStoppedDate()
	{
		return this.isstoppeddate;
	}
	public void setIsStoppedDate(ims.framework.utils.beans.DateBean value)
	{
		this.isstoppeddate = value;
	}
	public ims.core.vo.beans.HcpBean getIsStoppedHcp()
	{
		return this.isstoppedhcp;
	}
	public void setIsStoppedHcp(ims.core.vo.beans.HcpBean value)
	{
		this.isstoppedhcp = value;
	}
	public ims.vo.LookupInstanceBean getIsStoppedReason()
	{
		return this.isstoppedreason;
	}
	public void setIsStoppedReason(ims.vo.LookupInstanceBean value)
	{
		this.isstoppedreason = value;
	}
	public String getIsStoppedReasonText()
	{
		return this.isstoppedreasontext;
	}
	public void setIsStoppedReasonText(String value)
	{
		this.isstoppedreasontext = value;
	}
	public Boolean getIsCopied()
	{
		return this.iscopied;
	}
	public void setIsCopied(Boolean value)
	{
		this.iscopied = value;
	}
	public ims.vo.LookupInstanceBean getCommencedByType()
	{
		return this.commencedbytype;
	}
	public void setCommencedByType(ims.vo.LookupInstanceBean value)
	{
		this.commencedbytype = value;
	}
	public ims.vo.LookupInstanceBean getStoppedByType()
	{
		return this.stoppedbytype;
	}
	public void setStoppedByType(ims.vo.LookupInstanceBean value)
	{
		this.stoppedbytype = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}

	private Integer id;
	private int version;
	private String dose;
	private String whentaken;
	private ims.vo.LookupInstanceBean adminroute;
	private Integer duration;
	private ims.vo.LookupInstanceBean durationunits;
	private ims.vo.LookupInstanceBean doseunit;
	private java.util.Collection admintimes;
	private ims.core.vo.beans.HcpBean dosestarthcp;
	private ims.framework.utils.beans.DateBean dosestartdate;
	private Boolean isstopped;
	private ims.framework.utils.beans.DateBean isstoppeddate;
	private ims.core.vo.beans.HcpBean isstoppedhcp;
	private ims.vo.LookupInstanceBean isstoppedreason;
	private String isstoppedreasontext;
	private Boolean iscopied;
	private ims.vo.LookupInstanceBean commencedbytype;
	private ims.vo.LookupInstanceBean stoppedbytype;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private String comment;
}
