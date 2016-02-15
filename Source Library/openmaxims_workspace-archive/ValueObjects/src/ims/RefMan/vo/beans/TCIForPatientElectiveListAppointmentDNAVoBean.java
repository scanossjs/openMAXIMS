// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class TCIForPatientElectiveListAppointmentDNAVoBean extends ims.vo.ValueObjectBean
{
	public TCIForPatientElectiveListAppointmentDNAVoBean()
	{
	}
	public TCIForPatientElectiveListAppointmentDNAVoBean(ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.currentoutcome = vo.getCurrentOutcome() == null ? null : (ims.RefMan.vo.beans.TCIOutcomeForAppointmentDNAVoBean)vo.getCurrentOutcome().getBean();
		if(vo.getOutcomeHistory() != null)
		{
			this.outcomehistory = new ims.vo.RefVoBean[vo.getOutcomeHistory().size()];
			for(int outcomehistory_i = 0; outcomehistory_i < vo.getOutcomeHistory().size(); outcomehistory_i++)
			{
				this.outcomehistory[outcomehistory_i] = new ims.vo.RefVoBean(vo.getOutcomeHistory().get(outcomehistory_i).getBoId(),vo.getOutcomeHistory().get(outcomehistory_i).getBoVersion());
			}
		}
		this.isactive = vo.getIsActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.currentoutcome = vo.getCurrentOutcome() == null ? null : (ims.RefMan.vo.beans.TCIOutcomeForAppointmentDNAVoBean)vo.getCurrentOutcome().getBean(map);
		if(vo.getOutcomeHistory() != null)
		{
			this.outcomehistory = new ims.vo.RefVoBean[vo.getOutcomeHistory().size()];
			for(int outcomehistory_i = 0; outcomehistory_i < vo.getOutcomeHistory().size(); outcomehistory_i++)
			{
				this.outcomehistory[outcomehistory_i] = new ims.vo.RefVoBean(vo.getOutcomeHistory().get(outcomehistory_i).getBoId(),vo.getOutcomeHistory().get(outcomehistory_i).getBoVersion());
			}
		}
		this.isactive = vo.getIsActive();
	}

	public ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo();
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
	public ims.RefMan.vo.beans.TCIOutcomeForAppointmentDNAVoBean getCurrentOutcome()
	{
		return this.currentoutcome;
	}
	public void setCurrentOutcome(ims.RefMan.vo.beans.TCIOutcomeForAppointmentDNAVoBean value)
	{
		this.currentoutcome = value;
	}
	public ims.vo.RefVoBean[] getOutcomeHistory()
	{
		return this.outcomehistory;
	}
	public void setOutcomeHistory(ims.vo.RefVoBean[] value)
	{
		this.outcomehistory = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}

	private Integer id;
	private int version;
	private ims.RefMan.vo.beans.TCIOutcomeForAppointmentDNAVoBean currentoutcome;
	private ims.vo.RefVoBean[] outcomehistory;
	private Boolean isactive;
}