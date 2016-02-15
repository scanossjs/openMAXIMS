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

package ims.scheduling.domain;

// Generated from form domain impl
public interface SessionDetailsEdit extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listSession
	*/
	public ims.scheduling.vo.SessionShortVoCollection listSession(ims.scheduling.vo.Sch_ProfileRefVo profile, ims.scheduling.vo.DirectoryofServiceRefVo dos, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate);

	// Generated from form domain interface definition
	public ims.scheduling.vo.ProfileLiteVoCollection listProfile(String profileName);

	// Generated from form domain interface definition
	public ims.scheduling.vo.DirectoryOfServiceLiteVoCollection listDos(String dosName);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionVo saveSession(ims.scheduling.vo.SessionVo session, Boolean editingSlots) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionVo getSession(ims.scheduling.vo.SessionShortVo sessionShort);

	// Generated from form domain interface definition
	/**
	* listHcpLite
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLite(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* Lists all roles
	*/
	public ims.admin.vo.AppRoleShortVoCollection listRoles();

	// Generated from form domain interface definition
	/**
	* listProcedureByHcpAndName
	*/
	public ims.core.vo.ProcedureLiteVoCollection listProcedureByHcpAndName(ims.core.resource.people.vo.HcpRefVoCollection hcps, String name);

	// Generated from form domain interface definition
	/**
	* listActivity
	*/
	public ims.core.vo.ActivityLiteVoCollection listActivity();

	// Generated from form domain interface definition
	/**
	* getUsedMins
	*/
	public Integer getUsedMins(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	public Boolean hasSelectedOwnerProcedures(ims.core.resource.people.vo.HcpRefVo ownerId, String procedureList);

	// Generated from form domain interface definition
	/**
	* listNonCancelledAppointmentsForSession - a list of appts that are not cancelled for the session - this is used to validate booking another flexible appt
	*/
	public ims.scheduling.vo.BookingAppointmentLiteVoCollection listNonCancelledAppointmentsForSession(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* getTheatreSession
	*/
	public ims.scheduling.vo.SessionTheatreVo getTheatreSession(ims.scheduling.vo.Sch_SessionRefVo session);
}