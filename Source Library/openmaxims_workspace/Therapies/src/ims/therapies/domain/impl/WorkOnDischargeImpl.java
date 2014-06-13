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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2250.23637)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.therapies.domain.base.impl.BaseWorkOnDischargeImpl;
import ims.therapies.vo.WorkOnDischargeVo;
import ims.therapies.vo.domain.WorkOnDischargeVoAssembler;
import ims.therapies.workleisuredriving.domain.objects.WorkOnDischarge;

public class WorkOnDischargeImpl extends BaseWorkOnDischargeImpl
{
	/**
	* list Medics
	*/
	public ims.core.vo.HcpCollection listMedics(ims.core.vo.HcpFilter voHcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(voHcpFilter);
	}

	/**
	* get Work on Discharge record for ClinicalContact
	*/
	public ims.therapies.vo.WorkOnDischargeVo get(CareContextRefVo voCareContext)
	{
		if(voCareContext == null)
			throw new CodingRuntimeException("Work on Discharg Filter not provided for get call. ");
		
		String hql = new String("from WorkOnDischarge w where w.careContext.id = :CARECONTEXT_ID and w.isRIE is null order by w.systemInformation.creationDateTime desc ");

		java.util.List list = getDomainFactory().find(hql, "CARECONTEXT_ID", voCareContext.getID_CareContext());

		if (list.size() == 0)
			return null;
		
		
		return WorkOnDischargeVoAssembler.createWorkOnDischargeVoCollectionFromWorkOnDischarge(list).get(0);
	}

	/**
	* saves Work On Discharge record 
	*/
	public void save(ims.therapies.vo.WorkOnDischargeVo voWorkOnDischarge) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if(!voWorkOnDischarge.isValidated())
			throw new DomainRuntimeException("This Work On Discharge has not been validated");
	
		if(voWorkOnDischarge.getID_WorkOnDischarge() == null)
		{
			if(voWorkOnDischarge.getCareContext() != null)
			{
				WorkOnDischargeVo voWorkOnDischargetemp = get(voWorkOnDischarge.getCareContext());
				if(voWorkOnDischargetemp != null)
					throw new DomainRuntimeException("A Work On Discharge record already exists for this CareContext. ");
			}
		}
		DomainFactory factory = getDomainFactory();
		WorkOnDischarge doWorkOnDischarge = WorkOnDischargeVoAssembler.extractWorkOnDischarge(factory, voWorkOnDischarge);
		factory.save(doWorkOnDischarge);
	}

	
}