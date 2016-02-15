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

public class EquipmentVoBean extends ims.vo.ValueObjectBean
{
	public EquipmentVoBean()
	{
	}
	public EquipmentVoBean(ims.core.vo.EquipmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.supplier = vo.getSupplier() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupplier().getBean();
		this.daterequired = vo.getDateRequired() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateRequired().getBean();
		this.datesupplied = vo.getDateSupplied() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSupplied().getBean();
		this.suppliedfor = vo.getSuppliedFor() == null ? null : (ims.vo.LookupInstanceBean)vo.getSuppliedFor().getBean();
		this.loan = vo.getLoan() == null ? null : (ims.vo.LookupInstanceBean)vo.getLoan().getBean();
		this.fundedby = vo.getFundedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getFundedBy().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.inactive = vo.getInactive();
		this.inactivationreason = vo.getInactivationReason();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.EquipmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.supplier = vo.getSupplier() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupplier().getBean();
		this.daterequired = vo.getDateRequired() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateRequired().getBean();
		this.datesupplied = vo.getDateSupplied() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSupplied().getBean();
		this.suppliedfor = vo.getSuppliedFor() == null ? null : (ims.vo.LookupInstanceBean)vo.getSuppliedFor().getBean();
		this.loan = vo.getLoan() == null ? null : (ims.vo.LookupInstanceBean)vo.getLoan().getBean();
		this.fundedby = vo.getFundedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getFundedBy().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.inactive = vo.getInactive();
		this.inactivationreason = vo.getInactivationReason();
	}

	public ims.core.vo.EquipmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.EquipmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.EquipmentVo vo = null;
		if(map != null)
			vo = (ims.core.vo.EquipmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.EquipmentVo();
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
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public ims.vo.LookupInstanceBean getSupplier()
	{
		return this.supplier;
	}
	public void setSupplier(ims.vo.LookupInstanceBean value)
	{
		this.supplier = value;
	}
	public ims.framework.utils.beans.DateBean getDateRequired()
	{
		return this.daterequired;
	}
	public void setDateRequired(ims.framework.utils.beans.DateBean value)
	{
		this.daterequired = value;
	}
	public ims.framework.utils.beans.DateBean getDateSupplied()
	{
		return this.datesupplied;
	}
	public void setDateSupplied(ims.framework.utils.beans.DateBean value)
	{
		this.datesupplied = value;
	}
	public ims.vo.LookupInstanceBean getSuppliedFor()
	{
		return this.suppliedfor;
	}
	public void setSuppliedFor(ims.vo.LookupInstanceBean value)
	{
		this.suppliedfor = value;
	}
	public ims.vo.LookupInstanceBean getLoan()
	{
		return this.loan;
	}
	public void setLoan(ims.vo.LookupInstanceBean value)
	{
		this.loan = value;
	}
	public ims.vo.LookupInstanceBean getFundedBy()
	{
		return this.fundedby;
	}
	public void setFundedBy(ims.vo.LookupInstanceBean value)
	{
		this.fundedby = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public Boolean getInactive()
	{
		return this.inactive;
	}
	public void setInactive(Boolean value)
	{
		this.inactive = value;
	}
	public String getInactivationReason()
	{
		return this.inactivationreason;
	}
	public void setInactivationReason(String value)
	{
		this.inactivationreason = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean type;
	private ims.vo.LookupInstanceBean supplier;
	private ims.framework.utils.beans.DateBean daterequired;
	private ims.framework.utils.beans.DateBean datesupplied;
	private ims.vo.LookupInstanceBean suppliedfor;
	private ims.vo.LookupInstanceBean loan;
	private ims.vo.LookupInstanceBean fundedby;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private Boolean inactive;
	private String inactivationreason;
}