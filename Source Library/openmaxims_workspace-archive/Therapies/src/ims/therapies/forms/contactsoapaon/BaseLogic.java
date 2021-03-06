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

package ims.therapies.forms.contactsoapaon;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.ContactSOAPAoN.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.ContactSOAPAoN domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected void clearScreen()
	{
		this.form.textPlan().setValue("");
		this.form.textAnalysis().setValue("");
		this.form.textObjective().setValue("");
		this.form.textSubjective().setValue("");
	}
	protected void populateScreenFromData(ims.clinical.vo.SoapNoteVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.textPlan().setValue(value.getPlanNoteIsNotNull() ? value.getPlanNote(): null);
		this.form.textAnalysis().setValue(value.getAnalysisNoteIsNotNull() ? value.getAnalysisNote(): null);
		this.form.textObjective().setValue(value.getObjectiveNoteIsNotNull() ? value.getObjectiveNote(): null);
		this.form.textSubjective().setValue(value.getSubjectiveNoteIsNotNull() ? value.getSubjectiveNote(): null);
	}
	protected ims.clinical.vo.SoapNoteVo populateDataFromScreen(ims.clinical.vo.SoapNoteVo value)
	{
		if(value == null)
			value = new ims.clinical.vo.SoapNoteVo();

		value.setPlanNote(this.form.textPlan().getValue());
		value.setAnalysisNote(this.form.textAnalysis().getValue());
		value.setObjectiveNote(this.form.textObjective().getValue());
		value.setSubjectiveNote(this.form.textSubjective().getValue());

		return value;
	}
	protected ims.clinical.vo.SoapNoteVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.clinical.vo.SoapNoteVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.ContactSOAPAoN domain;
}
