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

package ims.RefMan.forms.rttmanagement;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{
		if(!form.getGlobalContext().Core.getPatientShortIsNotNull())
			return false;

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Pathways = new PathwaysForms();
			Scheduling = new SchedulingForms();
			RefMan = new RefManForms();
		}
		public final class PathwaysForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PathwaysForms()
			{
				PatientJourneyComments = new LocalFormName(132118);
				PatientJourneyComment = new LocalFormName(132124);
				AdminEvent = new LocalFormName(132123);
				PatientJourneyClock = new LocalFormName(132115);
				PatientPathwaysAwaitingValidationWorklist = new LocalFormName(132125);
				PatientPathwayValidationCompleteDialog = new LocalFormName(132126);
			}
			public final FormName PatientJourneyComments;
			public final FormName PatientJourneyComment;
			public final FormName AdminEvent;
			public final FormName PatientJourneyClock;
			public final FormName PatientPathwaysAwaitingValidationWorklist;
			public final FormName PatientPathwayValidationCompleteDialog;
		}
		public final class SchedulingForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SchedulingForms()
			{
				OutcomeSummaryDialog = new LocalFormName(114127);
			}
			public final FormName OutcomeSummaryDialog;
		}
		public final class RefManForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private RefManForms()
			{
				RTTManagementEditEvent = new LocalFormName(134274);
				ManuallySetRTTClockStatus = new LocalFormName(134264);
				ConfirmReferralNotRTTImpact = new LocalFormName(134290);
				ReferralDetailsDialog = new LocalFormName(134104);
				UpdateRTTStatusDateTime = new LocalFormName(134308);
			}
			public final FormName RTTManagementEditEvent;
			public final FormName ManuallySetRTTClockStatus;
			public final FormName ConfirmReferralNotRTTImpact;
			public final FormName ReferralDetailsDialog;
			public final FormName UpdateRTTStatusDateTime;
		}

		public PathwaysForms Pathways;
		public SchedulingForms Scheduling;
		public RefManForms RefMan;
	}
}
