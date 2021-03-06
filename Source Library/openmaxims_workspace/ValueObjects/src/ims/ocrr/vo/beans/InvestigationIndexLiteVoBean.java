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

package ims.ocrr.vo.beans;

public class InvestigationIndexLiteVoBean extends ims.vo.ValueObjectBean
{
	public InvestigationIndexLiteVoBean()
	{
	}
	public InvestigationIndexLiteVoBean(ims.ocrr.vo.InvestigationIndexLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.orderability = vo.getOrderability() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderability().getBean();
		this.securitylevel = vo.getSecurityLevel() == null ? null : (ims.ocrr.vo.beans.SecurityLevelConfigVoBean)vo.getSecurityLevel().getBean();
		this.timeseriesinstructionsurl = vo.getTimeSeriesInstructionsURL();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.InvestigationIndexLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.orderability = vo.getOrderability() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderability().getBean();
		this.securitylevel = vo.getSecurityLevel() == null ? null : (ims.ocrr.vo.beans.SecurityLevelConfigVoBean)vo.getSecurityLevel().getBean(map);
		this.timeseriesinstructionsurl = vo.getTimeSeriesInstructionsURL();
	}

	public ims.ocrr.vo.InvestigationIndexLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.InvestigationIndexLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.InvestigationIndexLiteVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.InvestigationIndexLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.InvestigationIndexLiteVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getOrderability()
	{
		return this.orderability;
	}
	public void setOrderability(ims.vo.LookupInstanceBean value)
	{
		this.orderability = value;
	}
	public ims.ocrr.vo.beans.SecurityLevelConfigVoBean getSecurityLevel()
	{
		return this.securitylevel;
	}
	public void setSecurityLevel(ims.ocrr.vo.beans.SecurityLevelConfigVoBean value)
	{
		this.securitylevel = value;
	}
	public String getTimeSeriesInstructionsURL()
	{
		return this.timeseriesinstructionsurl;
	}
	public void setTimeSeriesInstructionsURL(String value)
	{
		this.timeseriesinstructionsurl = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean orderability;
	private ims.ocrr.vo.beans.SecurityLevelConfigVoBean securitylevel;
	private String timeseriesinstructionsurl;
}
