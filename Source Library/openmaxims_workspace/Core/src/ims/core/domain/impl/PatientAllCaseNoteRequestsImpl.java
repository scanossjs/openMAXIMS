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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.domain.base.impl.BasePatientAllCaseNoteRequestsImpl;
import ims.core.vo.domain.PatientCaseNoteRequestShortVoAssembler;
import ims.core.vo.lookups.CaseNoteRequestStatusCollection;

import java.util.ArrayList;
import java.util.List;

public class PatientAllCaseNoteRequestsImpl extends BasePatientAllCaseNoteRequestsImpl
{
	private static final long serialVersionUID = 1L;

	public ims.core.vo.PatientCaseNoteRequestShortVoCollection listRequests(ims.core.patient.vo.PatientRefVo patient, ims.core.vo.lookups.CaseNoteRequestStatusCollection statuses)
	{
		StringBuilder query = new StringBuilder("SELECT request FROM PatientCaseNoteRequest AS request LEFT JOIN request.patient AS patient ");
		
		query.append("WHERE patient.id = :PAT_ID ");

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("PAT_ID");
		paramValues.add(patient.getID_Patient());
		
		if(statuses != null && statuses.size() > 0)
		{
			query.append(" AND request.requestStatus.id in (");
			query.append(getStatuseId(statuses));
			query.append(") "); 
		}
		
		query.append(" ORDER BY request.requiredByDate ASC");
		
		List requestList = getDomainFactory().find(query.toString(), paramNames, paramValues);
		
		return PatientCaseNoteRequestShortVoAssembler.createPatientCaseNoteRequestShortVoCollectionFromPatientCaseNoteRequest(requestList);
	}

	private String getStatuseId(CaseNoteRequestStatusCollection statuses)
	{
		if(statuses == null)
			return null;
		
		StringBuffer ids = new StringBuffer();
		
		for(int i=0; i<statuses.size(); i++)
		{
			ids.append(ids.length() > 0 ? "," : "");
			ids.append(statuses.get(i).getID());
		}
		
		return ids.toString();
	}
}