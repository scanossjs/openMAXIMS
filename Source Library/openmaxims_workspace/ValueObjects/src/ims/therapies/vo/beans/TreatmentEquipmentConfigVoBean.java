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

package ims.therapies.vo.beans;

public class TreatmentEquipmentConfigVoBean extends ims.vo.ValueObjectBean
{
	public TreatmentEquipmentConfigVoBean()
	{
	}
	public TreatmentEquipmentConfigVoBean(ims.therapies.vo.TreatmentEquipmentConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.model = vo.getModel();
		this.serialnumber = vo.getSerialNumber();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.description = vo.getDescription();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.TreatmentEquipmentConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.model = vo.getModel();
		this.serialnumber = vo.getSerialNumber();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.description = vo.getDescription();
	}

	public ims.therapies.vo.TreatmentEquipmentConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.TreatmentEquipmentConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.TreatmentEquipmentConfigVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.TreatmentEquipmentConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.TreatmentEquipmentConfigVo();
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
	public String getModel()
	{
		return this.model;
	}
	public void setModel(String value)
	{
		this.model = value;
	}
	public String getSerialNumber()
	{
		return this.serialnumber;
	}
	public void setSerialNumber(String value)
	{
		this.serialnumber = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}

	private Integer id;
	private int version;
	private String model;
	private String serialnumber;
	private ims.vo.LookupInstanceBean type;
	private String description;
}