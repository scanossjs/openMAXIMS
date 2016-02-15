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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseTTAHistoryDialogImpl;
import ims.clinical.vo.domain.TTAMedicationAndPharmacyForTTAHistoryVoAssembler;
import ims.clinical.vo.domain.TTAMedicationDetailVoAssembler;
import ims.edischarge.vo.TTAMedicationAndPharmacyRefVo;
import ims.edischarge.vo.TTAMedicationDetailRefVoCollection;

import java.util.ArrayList;
import java.util.List;

public class TTAHistoryDialogImpl extends BaseTTAHistoryDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.TTAMedicationAndPharmacyForTTAHistoryVoCollection listTTAforPatient(ims.core.patient.vo.PatientRefVo patient,TTAMedicationAndPharmacyRefVo exlude)
	{
		String hql = "select ttamp from TTAMedicationAndPharmacy as ttamp left join ttamp.patient as pat where (pat.id=:patId ";
		ArrayList<String> paramName = new ArrayList<String>();
		paramName.add("patId");
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(patient.getID_Patient());
		if (exlude!=null)
		{
			hql+=" and ttamp.id <> :exludeId";
			paramName.add("exludeId");
			paramValues.add(exlude.getID_TTAMedicationAndPharmacy());
		}
		hql+=") order by ttamp.systemInformation.creationDateTime asc";
		List<?> dos = getDomainFactory().find(hql,paramName,paramValues);
		if (dos == null || dos.size() == 0)
			return null;
		return TTAMedicationAndPharmacyForTTAHistoryVoAssembler.createTTAMedicationAndPharmacyForTTAHistoryVoCollectionFromTTAMedicationAndPharmacy(dos);
	}

	public ims.clinical.vo.TTAMedicationDetailVoCollection getTTAMedicationsDetails(ims.edischarge.vo.TTAMedicationDetailRefVoCollection meds)
	{
		if (meds == null || meds.size() == 0)
			return null;
		String hql = "select ttamd from TTAMedicationDetail as ttamd where (ttamd.id in ("+getIds(meds)+"))"; 
		List<?> dol = getDomainFactory().find(hql);
		return TTAMedicationDetailVoAssembler.createTTAMedicationDetailVoCollectionFromTTAMedicationDetail(dol);
	}

	private String getIds(TTAMedicationDetailRefVoCollection meds)
	{
		String comma = "";
		String result = "";
		for (int i = 0 ; i < meds.size() ; i++)
		{
			result+=comma+meds.get(i).getID_TTAMedicationDetail();
			comma=" , ";
		}
		return result;
	}

	
}