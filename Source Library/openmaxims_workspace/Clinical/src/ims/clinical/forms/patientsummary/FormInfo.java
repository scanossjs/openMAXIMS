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

package ims.clinical.forms.patientsummary;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "Clinical";
	}
	public String getFormName()
	{
		return "PatientSummary";
	}
	public int getWidth()
	{
		return 848;
	}
	public int getHeight()
	{
		return 632;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_Clinical.PatientSummary.EpisodeOfCare", "_cv_Clinical.PatientSummary.ClinicalContact", "_cv_Clinical.ReturnToFormMode", "_cv_Clinical.PatientSummary.CareSpell", "_cv_Clinical.UnsavedSOAPINformation", "_cv_Core.ClinicalContactDialogMode", "_cv_Clinical.PatientSummary.PrimaryAssociation", "_cv_Clinical.ReturnToFormName", "_cv_Core.ParentClinContact", "_cv_Core.CareSpellDialogMode", "_cv_Clinical.PatientSummary.CareContext", "_cv_Clinical.IsDiAssociationDialogOpenedFromPatientSummary", "_cv_Core.ClinicalContact", "_cv_Clinical.SelectedPatientProblemFromPatientSummary", "_cv_Clinical.SelectedPatientDiagnosisFromPatientSummary", "_cv_Clinical.SelectedPatientProcedureFromPatientSummary", "_cv_Core.ClinicalNotingMode", "_cv_Clinical.IsDiagnosisRecordUpdated", "_cv_Core.ClinicalNotesShort", "_cv_Clinical.CareContextWithHistory", "_cv_Clinical.EpisodeOfCareWithHistory", "_cv_ICP.Service" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_Clinical.PatientSummary.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[0];
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/Core/patient_info_simple_48.png";
	}
}