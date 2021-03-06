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

package ims.ccosched.forms.pattreatmentplanupdate;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.ccosched.domain.PatTreatmentPlanUpdate.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.ccosched.domain.PatTreatmentPlanUpdate domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbSeenAtValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSeenAt().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.SeenAt existingInstance = (ims.ccosched.vo.lookups.SeenAt)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSeenAtLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.SeenAt)
		{
			ims.ccosched.vo.lookups.SeenAt instance = (ims.ccosched.vo.lookups.SeenAt)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSeenAtLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.SeenAt existingInstance = (ims.ccosched.vo.lookups.SeenAt)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSeenAt().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSeenAtLookup()
	{
		this.form.cmbSeenAt().clear();
		ims.ccosched.vo.lookups.SeenAtCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getSeenAt(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSeenAt().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSeenAtLookupValue(int id)
	{
		ims.ccosched.vo.lookups.SeenAt instance = ims.ccosched.vo.lookups.LookupHelper.getSeenAtInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSeenAt().setValue(instance);
	}
	protected final void defaultcmbSeenAtLookupValue()
	{
		this.form.cmbSeenAt().setValue((ims.ccosched.vo.lookups.SeenAt)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.SeenAt.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.SeenAt.TYPE_ID));
	}
	protected final void oncmbWrtSurgeryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbWrtSurgery().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.SurgeryRequired existingInstance = (ims.oncology.vo.lookups.SurgeryRequired)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbWrtSurgeryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.SurgeryRequired)
		{
			ims.oncology.vo.lookups.SurgeryRequired instance = (ims.oncology.vo.lookups.SurgeryRequired)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbWrtSurgeryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.SurgeryRequired existingInstance = (ims.oncology.vo.lookups.SurgeryRequired)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbWrtSurgery().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbWrtSurgeryLookup()
	{
		this.form.cmbWrtSurgery().clear();
		ims.oncology.vo.lookups.SurgeryRequiredCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getSurgeryRequired(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbWrtSurgery().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbWrtSurgeryLookupValue(int id)
	{
		ims.oncology.vo.lookups.SurgeryRequired instance = ims.oncology.vo.lookups.LookupHelper.getSurgeryRequiredInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbWrtSurgery().setValue(instance);
	}
	protected final void defaultcmbWrtSurgeryLookupValue()
	{
		this.form.cmbWrtSurgery().setValue((ims.oncology.vo.lookups.SurgeryRequired)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.SurgeryRequired.class, engine.getFormName().getID(), ims.oncology.vo.lookups.SurgeryRequired.TYPE_ID));
	}
	protected final void oncmbTreatmentIntentValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTreatmentIntent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.TreatmentIntent existingInstance = (ims.ccosched.vo.lookups.TreatmentIntent)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatmentIntentLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.TreatmentIntent)
		{
			ims.ccosched.vo.lookups.TreatmentIntent instance = (ims.ccosched.vo.lookups.TreatmentIntent)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatmentIntentLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.TreatmentIntent existingInstance = (ims.ccosched.vo.lookups.TreatmentIntent)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTreatmentIntent().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatmentIntentLookup()
	{
		this.form.cmbTreatmentIntent().clear();
		ims.ccosched.vo.lookups.TreatmentIntentCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getTreatmentIntent(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTreatmentIntent().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatmentIntentLookupValue(int id)
	{
		ims.ccosched.vo.lookups.TreatmentIntent instance = ims.ccosched.vo.lookups.LookupHelper.getTreatmentIntentInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTreatmentIntent().setValue(instance);
	}
	protected final void defaultcmbTreatmentIntentLookupValue()
	{
		this.form.cmbTreatmentIntent().setValue((ims.ccosched.vo.lookups.TreatmentIntent)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.TreatmentIntent.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.TreatmentIntent.TYPE_ID));
	}
	protected final void oncmbPatientStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPatientStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Status existingInstance = (ims.ccosched.vo.lookups.Status)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatientStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Status)
		{
			ims.ccosched.vo.lookups.Status instance = (ims.ccosched.vo.lookups.Status)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPatientStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Status existingInstance = (ims.ccosched.vo.lookups.Status)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPatientStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatientStatusLookup()
	{
		this.form.cmbPatientStatus().clear();
		ims.ccosched.vo.lookups.StatusCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPatientStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatientStatusLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Status instance = ims.ccosched.vo.lookups.LookupHelper.getStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPatientStatus().setValue(instance);
	}
	protected final void defaultcmbPatientStatusLookupValue()
	{
		this.form.cmbPatientStatus().setValue((ims.ccosched.vo.lookups.Status)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Status.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Status.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.ccosched.domain.PatTreatmentPlanUpdate domain;
}
