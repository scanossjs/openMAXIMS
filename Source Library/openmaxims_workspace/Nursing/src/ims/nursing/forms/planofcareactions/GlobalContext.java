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

package ims.nursing.forms.planofcareactions;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Nursing = new NursingContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}
	public final class NursingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private NursingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPlanOfCareActionsSearchCriteriaIsNotNull()
		{
			return !cx_NursingPlanOfCareActionsSearchCriteria.getValueIsNull(context);
		}
		public ims.nursing.vo.PlanOfCareActionsSearchCriteriaVo getPlanOfCareActionsSearchCriteria()
		{
			return (ims.nursing.vo.PlanOfCareActionsSearchCriteriaVo)cx_NursingPlanOfCareActionsSearchCriteria.getValue(context);
		}
		public void setPlanOfCareActionsSearchCriteria(ims.nursing.vo.PlanOfCareActionsSearchCriteriaVo value)
		{
			cx_NursingPlanOfCareActionsSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingPlanOfCareActionsSearchCriteria = new ims.framework.ContextVariable("Nursing.PlanOfCareActionsSearchCriteria", "_cvp_Nursing.PlanOfCareActionsSearchCriteria");

		private ims.framework.Context context;
	}
	public boolean getPlanOfCareActionsReviewIsNotNull()
	{
		return !cx_PlanOfCareActionsReview.getValueIsNull(context);
	}
	public ims.nursing.vo.PlanOfCareNotingVo getPlanOfCareActionsReview()
	{
		return (ims.nursing.vo.PlanOfCareNotingVo)cx_PlanOfCareActionsReview.getValue(context);
	}
		public void setPlanOfCareActionsReview(ims.nursing.vo.PlanOfCareNotingVo value)
		{
		cx_PlanOfCareActionsReview.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PlanOfCareActionsReview = new ims.framework.ContextVariable("PlanOfCareActionsReview", "_cv_PlanOfCareActionsReview");

	public CoreContext Core;
	public NursingContext Nursing;
}
