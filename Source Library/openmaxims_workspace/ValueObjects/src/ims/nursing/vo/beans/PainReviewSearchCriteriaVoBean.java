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

package ims.nursing.vo.beans;

public class PainReviewSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public PainReviewSearchCriteriaVoBean()
	{
	}
	public PainReviewSearchCriteriaVoBean(ims.nursing.vo.PainReviewSearchCriteriaVo vo)
	{
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
		this.viewtype = vo.getViewType();
		this.assessment = vo.getAssessment() == null ? null : (ims.nursing.vo.beans.PainAssessmentBean)vo.getAssessment().getBean();
		this.findings = vo.getFindings() == null ? null : (ims.nursing.vo.beans.PainAssessmentFindingsBean)vo.getFindings().getBean();
		this.selectedcarecontext = vo.getSelectedCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getSelectedCareContext().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.PainReviewSearchCriteriaVo vo)
	{
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
		this.viewtype = vo.getViewType();
		this.assessment = vo.getAssessment() == null ? null : (ims.nursing.vo.beans.PainAssessmentBean)vo.getAssessment().getBean(map);
		this.findings = vo.getFindings() == null ? null : (ims.nursing.vo.beans.PainAssessmentFindingsBean)vo.getFindings().getBean(map);
		this.selectedcarecontext = vo.getSelectedCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getSelectedCareContext().getBean(map);
	}

	public ims.nursing.vo.PainReviewSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.PainReviewSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.PainReviewSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.PainReviewSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.PainReviewSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}
	public Integer getViewType()
	{
		return this.viewtype;
	}
	public void setViewType(Integer value)
	{
		this.viewtype = value;
	}
	public ims.nursing.vo.beans.PainAssessmentBean getAssessment()
	{
		return this.assessment;
	}
	public void setAssessment(ims.nursing.vo.beans.PainAssessmentBean value)
	{
		this.assessment = value;
	}
	public ims.nursing.vo.beans.PainAssessmentFindingsBean getFindings()
	{
		return this.findings;
	}
	public void setFindings(ims.nursing.vo.beans.PainAssessmentFindingsBean value)
	{
		this.findings = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getSelectedCareContext()
	{
		return this.selectedcarecontext;
	}
	public void setSelectedCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.selectedcarecontext = value;
	}

	private ims.core.vo.beans.CareContextShortVoBean carecontext;
	private Integer viewtype;
	private ims.nursing.vo.beans.PainAssessmentBean assessment;
	private ims.nursing.vo.beans.PainAssessmentFindingsBean findings;
	private ims.core.vo.beans.CareContextShortVoBean selectedcarecontext;
}