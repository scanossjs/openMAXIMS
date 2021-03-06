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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;
import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseAmendAttendanceTimesDialogImpl;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.TrackingForTimeAmendmentsVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.domain.TrackingForTimeAmendmentsVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class AmendAttendanceTimesDialogImpl extends BaseAmendAttendanceTimesDialogImpl
{
	private static final long serialVersionUID = 1L;

	public TrackingForTimeAmendmentsVo save(TrackingForTimeAmendmentsVo tracking) throws ims.domain.exceptions.StaleObjectException
	{
		if(tracking == null)
			throw new CodingRuntimeException("Cannot save a null TrackingForTimeAmendmentsVo.");
		
		if(!tracking.isValidated())
			throw new CodingRuntimeException("TrackingForTimeAmendmentsVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		Tracking doTracking = TrackingForTimeAmendmentsVoAssembler.extractTracking(factory, tracking);
		
		//WDEV-20089 - MAXIMS.10.1.2
		doTracking.getAttendance().getCareContext().setStartDateTime(doTracking.getAttendance().getRegistrationDateTime());
		doTracking.getEpisode().getEpisodeOfCare().setStartDate(doTracking.getAttendance().getRegistrationDateTime());
		doTracking.getEpisode().getEpisodeOfCare().getCareSpell().setStartDate(doTracking.getAttendance().getRegistrationDateTime());
		doTracking.getAttendance().getCareContext().setEndDateTime(doTracking.getAttendance().getDischargeDateTime());
		
		factory.save(doTracking);
		
		return TrackingForTimeAmendmentsVoAssembler.create(doTracking);
	}

	public TrackingForTimeAmendmentsVo getTracking(TrackingRefVo tracking)
	{
		if(tracking == null || tracking.getID_Tracking() == null)
			return null;
		
		return TrackingForTimeAmendmentsVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, tracking.getID_Tracking()));
	}
}
